using System.Data.SqlClient;
using Exercise3.Model;
using Exercise3.Model.DTO;

namespace Exercise3.DAL;


public class AnimalsRepository : IAnimalsRepository
{
    private readonly string _connectionString;

    public AnimalsRepository(IConfiguration configuration)
    {
            _connectionString = configuration.GetConnectionString("Default")
                ?? throw new ArgumentNullException(nameof(configuration));
    }

    public async Task<IEnumerable<Animal>> GetAnimalsAsync(string? orderBy)
    {
        if (orderBy is null) orderBy = "Name";

        var query = $"SELECT * FROM Animal ORDER BY {orderBy}";
        
        using (SqlConnection connection = new SqlConnection(_connectionString))
        {
            SqlCommand command = new SqlCommand(query, connection);
            command.Parameters.Add(new SqlParameter("@orderBy", orderBy));
            
            await connection.OpenAsync();
            SqlDataReader reader = await command.ExecuteReaderAsync();

            List<Animal> animals = new List<Animal>();
            while (reader.Read())
            {
                animals.Add(new Animal()
                {
                    ID = (int)reader["ID"],
                    Name = (string)reader["Name"],
                    Description = (string)reader["Description"],
                    Category = (string)reader["Category"],
                    Area = (string)reader["Area"]
                });
            }
            return  animals;
            
        }
    }

    public async Task AddAnimalAsync(AnimalPOST animalPost)
    {
        var query = $"INSERT INTO [dbo].[Animal] ([ID], [Name], [Description], [Category], [Area]) VALUES (@ID, @Name, @Description, @Category, @Area)";


        using (SqlConnection connection = new SqlConnection(_connectionString))
        {
            SqlCommand command = new SqlCommand(query, connection);
            command.Parameters.AddWithValue("@ID", animalPost.ID);
            command.Parameters.AddWithValue("@Name", animalPost.Name);
            command.Parameters.AddWithValue("@Description", animalPost.Description);
            command.Parameters.AddWithValue("@Category", animalPost.Category);
            command.Parameters.AddWithValue("@Area", animalPost.Area);
            
            await connection.OpenAsync();
            await command.ExecuteNonQueryAsync();
        }
    }

    public async Task<bool> DoesExist(int ID)
    {
        using (SqlConnection connection = new SqlConnection(_connectionString))
        {   
            SqlCommand command = new SqlCommand();
            command.Connection = connection;
            command.CommandText = $"SELECT * FROM Animal WHERE ID = {ID}";
            
            await connection.OpenAsync();
            SqlDataReader reader = await command.ExecuteReaderAsync();
            return reader.HasRows;
        }
    }

    public async Task<Animal> UpdateAnimalAsync(int ID, AnimalPUT animalPut)
    {
        var query = $"UPDATE [dbo].[Animal] SET Name = @Name, Description = @Description, Category = @Category, Area = @Area WHERE ID = @ID";

        var animal = new  Animal()
        {
            ID = ID,
            Name = animalPut.Name,
            Description = animalPut.Description,
            Category = animalPut.Category,
            Area = animalPut.Area
        };
        
        using (SqlConnection connection = new SqlConnection(_connectionString))
        {
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@ID", animal.ID);
                command.Parameters.AddWithValue("@Name", animal.Name);
                command.Parameters.AddWithValue("@Description", animal.Description);
                command.Parameters.AddWithValue("@Category", animal.Category);
                command.Parameters.AddWithValue("@Area", animal.Area);
                
                await  connection.OpenAsync();
                await command.ExecuteNonQueryAsync();
                
                return animal;
        }
    }
    
    public async Task DeleteAnimalAsync(int ID)
    {
        string query = $"DELETE FROM [dbo].[Animal] WHERE ID = @ID";

        using (SqlConnection connection = new SqlConnection(_connectionString))
        {
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.Add(new SqlParameter("@ID", ID));
                
                await connection.OpenAsync();
                await command.ExecuteNonQueryAsync();
        }
    }
}