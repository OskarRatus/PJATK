using Excercise5.Data;
using Excercise5.Models;
using Excercise5.Models.DTO;
using Excercise5.Services;
using Microsoft.AspNetCore.Mvc;

namespace Excercise5.Controllers;

[Route("api/[controller]")]
[ApiController]
public class TripsController : Controller
{
    private readonly ITripService _tripService;
    private readonly IClientService _clientService;
    private readonly IClientTripService _clientTripService;

    public TripsController(ITripService tripService, IClientService clientService, IClientTripService clientTripService)
    {
        _tripService = tripService;
        _clientService = clientService;
        _clientTripService = clientTripService;
    }
    
    
    [HttpGet]
    public async Task<IActionResult> GetTrips()
    {

        var trips = await _tripService.GetTripsWithAdditionalData2();

        return Ok(trips);
    }
    
    [HttpDelete("/api/clients/{IdClient}")]
    public async Task<IActionResult> DeleteClient(int IdClient)
    {
        if (!await _clientService.doesClientExist(IdClient)) return BadRequest("Client does not exist");

        if (await _clientService.isClientTripEmpty(IdClient)) return BadRequest("Cannot delete client with assigned trips");

        await _clientService.DeleteClient(IdClient);

        return Ok();
    }

    [HttpPost("/api/trips/{idTrip}/clients")]
    public async Task<IActionResult> AddClientTrip([FromBody] ClientTripPOST clientTripPOST, string idTrip)
    {
        if (!ModelState.IsValid) return BadRequest(ModelState);
        
        if (!await _tripService.doesTripExist(idTrip)) return NotFound("Trip does not exits");

        await _clientTripService.AddClientTripAsync(clientTripPOST);
        
        return Ok();
    }
}