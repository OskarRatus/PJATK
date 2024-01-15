using Excercise5.Data;
using Excercise5.Models;
using Excercise5.Models.DTO;
using Microsoft.EntityFrameworkCore;

namespace Excercise5.Services;

public interface ITripService
{
    Task<IEnumerable<Trip>> GetTripsWithAdditionalData();

    Task<IEnumerable<TripWithAdditionalData>> GetTripsWithAdditionalData2();

    Task<bool> doesTripExist(string idTrip);

}
public class TripService : ITripService
{

    private readonly DbEx5Context _context;

    public TripService(DbEx5Context context)
    {
        _context = context;
    }
    
    public async Task<IEnumerable<Trip>> GetTripsWithAdditionalData()
    {
        
        
        return await _context.Trips
            .Include(e => e.IdCountries)
            .Include(e => e.ClientTrips)
            .ThenInclude(e => e.IdClientNavigation)
            .ToListAsync();
    }

    public async Task<IEnumerable<TripWithAdditionalData>> GetTripsWithAdditionalData2()
    {

        var trips = await _context.Trips
            .OrderByDescending(e => e.DateFrom)
            .Select(e => new TripWithAdditionalData
        {
            Description = e.Description,
            Countries = e.IdCountries
                .Select(c => new CountryName{ Name = c.Name}),
            Clients = e.ClientTrips.Select(c => new ClientName{FirstName = c.IdClientNavigation.FirstName, LastName = c.IdClientNavigation.LastName}),

        }).ToListAsync();

        return trips;
    }

    public async Task<bool> doesTripExist(string idTrip)
    {
        var trip = await _context.Trips
            .FirstOrDefaultAsync(c => c.IdTrip == Int32.Parse(idTrip));

        return trip is not null;
    }
}