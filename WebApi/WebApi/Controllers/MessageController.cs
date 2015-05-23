using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace WebApi.Controllers
{
    public class MessageController : ApiController
    {
        public static List<string> Storage = new List<string>();
            
        [HttpPost]
        [Route("Message")]
        public void Post(string message)
        {
             Storage.Add(message);
        }

        [HttpGet]
        [Route("Message")]
        public string Get()
        {
            var message = Storage.FirstOrDefault();
            Storage.Clear();

            return message;
        }
    }
}