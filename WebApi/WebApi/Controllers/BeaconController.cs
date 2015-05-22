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
                    Image = "http://vignette4.wikia.nocookie.net/killbill/images/7/7c/Pussy-wagon-uma.jpg/revision/latest?cb=20110428111659",
                    Price = "Cheap for you my friend"
                },
                new Car
                {
                    Make = "Bmw",
                    Model = "520i",
                    Price = "100.000",
                    Image = "http://www.lamarihuana.com/wp-content/uploads/2012/05/funny-aeroplane-car.jpg"
                }
            };
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