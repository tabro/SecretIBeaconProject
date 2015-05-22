using System;
using System.Collections.Generic;
using System.Web.Http;

namespace WebApi.Controllers
{
    using Models;

    public class BeaconController : ApiController
    {
        [HttpPost]
        [Route("Beacon")]
        public IEnumerable<Car> Post(IEnumerable<Beacon> data)
        {
            return new List<Car>
            {
                new Car
                {
                    Make = "Audi",
                    Model = "R8",
                    Picture = null,
                    Price = "Cheap for you my friend"
                };
            };
        }
    }

    public class Beacon
    {
        public Guid Id1 { get; set; }
        public int Id2 { get; set; }
        public int Id3 { get; set; }
    }
}