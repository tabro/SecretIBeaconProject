using System;
using System.Collections.Generic;
using System.Web.Http;
using WebApi.Data;

namespace WebApi.Controllers
{
    using Models;

    public class BeaconController : ApiController
    {
        [HttpPost]
        [Route("Beacon")]
        public IEnumerable<Car> Post(IEnumerable<Beacon> data)
        {
            return new GetAllCars().Get();
        }

        [HttpGet]
        [Route("CarDetails")]
        public dynamic Get(Guid id)
        {
            return new
            {
                FuelType = "Gasolin",
                Kml = "20.3",
                FinanceOffer = "3000"
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