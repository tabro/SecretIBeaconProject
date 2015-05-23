using System.Collections.Generic;
using WebApi.Controllers;

namespace WebApi.Models
{
    public class Car
    {
        public string Make { get; set; }

        public string Model { get; set; }

        public string Price { get; set; }

        public string Image { get; set; }

        public Beacon Beacon { get; set; }
        public List<string> Cons { get; set; }
        public List<string> Pros { get; set; }

        public CarOffer CarOffer { get; set; }
    }
}