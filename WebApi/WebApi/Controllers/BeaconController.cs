using System;
using System.Collections.Generic;
using System.Linq;
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
            data = data ?? new List<Beacon>();

            data = data.Where(b => b.Range <= 3);

            var filteredCars = new GetAllCars().Get().Where(c => data.Any(b => b.Equals(c.Beacon))).ToList();

            var result = new List<Car>();
            foreach (var d in data.OrderBy(b => b.Range))
            {
                var car = filteredCars.SingleOrDefault(c => c.Beacon.Equals(d));
                if (car != null)
                {
                    car.Beacon.Range = d.Range;
                    result.Add(car);
                }
            }

            return result;
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
        protected bool Equals(Beacon other)
        {
            return Id1.Equals(other.Id1) && Id2 == other.Id2 && Id3 == other.Id3;
        }

        public override int GetHashCode()
        {
            unchecked
            {
                var hashCode = Id1.GetHashCode();
                hashCode = (hashCode*397) ^ Id2;
                hashCode = (hashCode*397) ^ Id3;
                return hashCode;
            }
        }

        public Guid Id1 { get; set; }
        public int Id2 { get; set; }
        public int Id3 { get; set; }
        public double Range { get; set; }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((Beacon) obj);
        }
    }
}