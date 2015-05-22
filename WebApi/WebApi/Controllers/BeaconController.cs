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
                    Name = "Fed Bil",
                }
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