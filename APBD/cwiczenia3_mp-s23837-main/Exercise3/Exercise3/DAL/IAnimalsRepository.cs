using Exercise3.Model;
using Exercise3.Model.DTO;

namespace Exercise3.DAL;

public interface IAnimalsRepository
{
    // Task<Animal> GetAnimalAsync();
    
    Task<IEnumerable<Animal>> GetAnimalsAsync(string? orderBy);

    Task AddAnimalAsync(AnimalPOST animalPost);

    Task<Animal> UpdateAnimalAsync(int ID, AnimalPUT animalPut);

    Task<bool> DoesExist(int ID);
    
    Task DeleteAnimalAsync(int ID);
}