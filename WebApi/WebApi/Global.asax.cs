using System.Net.Http.Formatting;
using System.Reflection;
using System.Web;
using System.Web.Http;
using DbUp;
using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;

namespace WebApi
{
    public class WebApiApplication : HttpApplication
    {
        protected void Application_Start()
        {
            //const string connectionString = "Server=(local)\\SqlExpress; Database=IBeacon; Trusted_connection=true"; ;
            const string connectionString = "Server=tcp:f1whc0l097.database.windows.net,1433;Database=IBeacon;User ID=auktioneridanmark@f1whc0l097;Password=Homer666;Trusted_Connection=False;Encrypt=True;Connection Timeout=30;"; ;

            var upgrader =
                DeployChanges.To
                    .SqlDatabase(connectionString)
                    .WithScriptsEmbeddedInAssembly(Assembly.GetExecutingAssembly())
                    .LogToConsole()
                    .Build();

            var result = upgrader.PerformUpgrade();

            if (!result.Successful)
            {
            }

            GlobalConfiguration.Configuration.Formatters.Clear();
            GlobalConfiguration.Configuration.Formatters.Add(new JsonMediaTypeFormatter());
            GlobalConfiguration.Configuration.Formatters.JsonFormatter.SerializerSettings.Formatting = Formatting.Indented;
            GlobalConfiguration.Configuration.Formatters.JsonFormatter.SerializerSettings.ContractResolver = new CamelCasePropertyNamesContractResolver();
            GlobalConfiguration.Configure(WebApiConfig.Register);


        }
    }
}
