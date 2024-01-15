using System.Net;
using HtmlAgilityPack;
using System.Net.Http;
using System.Text.RegularExpressions;

namespace ConsoleApp1;

public class Program
{
    public static async Task Main(string[] args)
    {
        if (args.Length != 1)
        {
            throw new ArgumentNullException();
        }

        string uriString = args[0];
        
        if (!Uri.IsWellFormedUriString(uriString, UriKind.Absolute))
        {
            throw new ArgumentException("Niepoprawny url");
        }

        await Crawler(uriString);
    }
    private static async Task Crawler(string URL)
    {
        try
        {
            var httpClient = new HttpClient();
            string html = await httpClient.GetStringAsync(URL);

            string pat = @"\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}\b";
            Regex reg = new Regex(pat);

            var matches = reg.Matches(html);

            if (matches.Count == 0)
            {
                throw new Exception("Nie znaleziono adresów email");
            }
            
            var uniqe = new HashSet<string>();
            foreach (Match match in matches)
            {
                uniqe.Add(match.Value);
            }

            foreach (string str in uniqe)
            {
                Console.WriteLine(str);
            }
        }
        catch (Exception e)
        {
            throw new Exception("Błąd w czasie pobierania strony");
        }
    }
}