namespace Excercise5.Models.DTO;

public class ClientTripPOST
{
    public string FirstName { get; set; } = null!;

    public string LastName { get; set; } = null!;
    
    public string Email { get; set; } = null!;

    public string Telephone { get; set; } = null!;
    public string Pesel { get; set; } = null!;
    
    public int IdTrip { get; set; }
    
    public string Name { get; set; } = null!;
    
    public DateTime? PaymentDate { get; set; }

    public DateTime RegisteredAt { get; set; } = DateTime.Now;

}