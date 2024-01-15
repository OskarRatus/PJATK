using Microsoft.AspNetCore.Mvc;
using Exercise3.DAL;
using Exercise3.Model.DTO;

namespace Exercise3.Controllers;


[ApiController]
[Route("api/[Controller]")]
public class AnimalsController : Controller
{
    private readonly IAnimalsRepository _animalsRepository;

    public AnimalsController(IAnimalsRepository animalsRepository)
    {
        _animalsRepository = animalsRepository;
    }

    
    [HttpGet]
    public async Task<IActionResult> GetAnimals(string orderBy = "name")
    {
        if (!new List<string> { "id", "name", "description", "category", "area" }.Contains(orderBy.ToLower())) return BadRequest(new { message = "Invalid order by value" });

        return Ok(await _animalsRepository.GetAnimalsAsync(orderBy));
    }

    [HttpPost]
    public async Task<IActionResult> AddAnimal([FromBody] AnimalPOST animal)
    {
        if (await _animalsRepository.DoesExist(animal.ID)) return Conflict();
        
        if (!ModelState.IsValid) return BadRequest(ModelState);

        await _animalsRepository.AddAnimalAsync(animal);
        return Created("api/animals", animal);
    }

    [HttpPut("{animalID}")]
    public async Task<IActionResult> UpdateAnimal(string animalID, [FromBody] AnimalPUT animal)
    {
        if (!ModelState.IsValid) return BadRequest(ModelState);
        
        if (!await _animalsRepository.DoesExist(Int32.Parse(animalID))) return NotFound();
        
        return Ok(await _animalsRepository.UpdateAnimalAsync(int.Parse(animalID), animal));
    }


    [HttpDelete("{animalID}")]
    public async Task<IActionResult> DeleteAnimal(string animalID)
    {
        if (!await _animalsRepository.DoesExist(int.Parse(animalID))) return NotFound();
        
        await _animalsRepository.DeleteAnimalAsync(int.Parse(animalID));
        return Ok();
    }

}