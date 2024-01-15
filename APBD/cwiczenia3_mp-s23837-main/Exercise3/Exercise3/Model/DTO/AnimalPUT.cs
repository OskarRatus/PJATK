namespace Exercise3.Model.DTO;

public class AnimalPUT
{
    public string Name { get; set; } = string.Empty;
    public string? Description { get; set; } = null;
    public string Category { get; set; } = string.Empty;
    public string Area { get; set; } = string.Empty;
}