using Excercise5.Data;
using Microsoft.AspNetCore.Http.HttpResults;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Excercise5.Services;

public interface IClientService
{
    Task DeleteClient(int IdClient);
    Task<bool> isClientTripEmpty(int IdClient);

    Task<bool> doesClientExist(string Pesel);
    Task<bool> doesClientExist(int IdClient);

}


public class ClientService : IClientService
{

    private readonly DbEx5Context _context;

    public ClientService(DbEx5Context context)
    {
        _context = context;
    }
    
    public async Task DeleteClient(int IdClient)
    {
        var client = await _context.Clients
            .Include(c => c.ClientTrips)
            .FirstOrDefaultAsync(c => c.IdClient == IdClient);

        _context.Clients.Remove(client);
        await _context.SaveChangesAsync();
    }

    public async Task<bool> isClientTripEmpty(int IdClient)
    {
        var client = await _context.Clients
            .Include(e => e.ClientTrips)
            .FirstOrDefaultAsync(e => e.IdClient == IdClient);

        return client.ClientTrips.Any();
    }

    public async Task<bool> doesClientExist(string Pesel)
    {
        var client = await _context.Clients.FirstOrDefaultAsync(c => c.Pesel == Pesel);

        return client is not null;
    }

    public async Task<bool> doesClientExist(int IdClient)
    {
        var client = await _context.Clients.FirstOrDefaultAsync(c => c.IdClient == IdClient);

        return client is not null;
    }
}