using System.ComponentModel.DataAnnotations;

namespace Exercise3.Model.DTO;

public class AnimalPOST
{
    [Required]
    public int ID { get; set; }

    [Required]
    [MaxLength(200, ErrorMessage = "Name cannot be longer than 200 chars")]
    public string Name { get; set; } = string.Empty;

    [Required]
    [MaxLength(200, ErrorMessage = "Description cannot be longer than 200 chars")]
    public string? Description { get; set; } = null;
    
    [Required]
    [MaxLength(200, ErrorMessage="Category cannot be longer than 200 chars")]
    public string Category { get; set; } = string.Empty;
    
    [Required]
    [MaxLength(200, ErrorMessage="Area cannot be longer than 200 chars")]
    public string Area { get; set; } = string.Empty;
}