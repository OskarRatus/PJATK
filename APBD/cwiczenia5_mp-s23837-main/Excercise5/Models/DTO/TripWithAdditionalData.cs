namespace Excercise5.Models.DTO;

public class TripWithAdditionalData
{
    public string Name { get; set; } = null!;
    public string Description { get; set; } = null!;

    public DateTime DateFrom { get; set; }

    public DateTime DateTo { get; set; }

    public int MaxPeople { get; set; }

    public IEnumerable<CountryName> Countries { get; set; } = new List<CountryName>();

    public IEnumerable<ClientName> Clients { get; set; } = new List<ClientName>();

}