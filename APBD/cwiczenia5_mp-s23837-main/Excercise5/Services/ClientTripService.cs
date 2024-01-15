using Excercise5.Data;
using Excercise5.Models;
using Excercise5.Models.DTO;
using Microsoft.EntityFrameworkCore;

namespace Excercise5.Services;

public interface IClientTripService
{
    Task AddClientTripAsync(ClientTripPOST clientTripPost);
}

public class ClientTripService : IClientTripService
{
    private readonly DbEx5Context _context;

    public ClientTripService(DbEx5Context context)
    {
        _context = context;
    }
    
    public async Task AddClientTripAsync(ClientTripPOST clientTripPost)
    {
        // get or create client client
        var client = await _context.Clients.FirstOrDefaultAsync(c => c.Pesel == clientTripPost.Pesel);
        if (client == null)
        {
            var maxIdClient = await _context.Clients.MaxAsync(c => c.IdClient);
            client = new Client
            {
                IdClient = maxIdClient+1,
                FirstName = clientTripPost.FirstName,
                LastName = clientTripPost.LastName,
                Email = clientTripPost.Email,
                Telephone = clientTripPost.Telephone,
                Pesel = clientTripPost.Pesel
            };
            await _context.Clients.AddAsync(client);
        }

        // get trip
        var trip = await _context.Trips.FirstOrDefaultAsync(e => e.IdTrip == clientTripPost.IdTrip);

        // create new ClientTrip
        var clientTrip = new ClientTrip
        {
            IdClient = client.IdClient,
            IdTrip = trip.IdTrip,
            PaymentDate = clientTripPost.PaymentDate,
            IdClientNavigation = client,
            IdTripNavigation = trip,
            RegisteredAt = DateTime.Today

        };

        await _context.ClientTrips.AddAsync(clientTrip);

        await _context.SaveChangesAsync();
    }
}