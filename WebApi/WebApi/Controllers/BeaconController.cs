using System;
using System.Collections.Generic;
using System.Web.Http;

namespace WebApi.Controllers
{
    public class BeaconController : ApiController
    {
        [HttpPost]
        [Route("Beacon")]
        public dynamic Post(IEnumerable<Beacon> data)
        {
            return new List<dynamic>
            {
                new
                {
                    Name = "Pussy Wagon",
                    Image = "http://vignette4.wikia.nocookie.net/killbill/images/7/7c/Pussy-wagon-uma.jpg/revision/latest?cb=20110428111659"
                }
            };
        }
    }

    public class Beacon
    {
        public Guid Id1 { get; set; }
        public int Id2 { get; set; }
        public int Id3 { get; set; }
        public double Range { get; set; }
    }
}