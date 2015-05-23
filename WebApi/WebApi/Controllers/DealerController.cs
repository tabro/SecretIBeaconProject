namespace WebApi.Controllers
{
    using System;
    using System.Collections.Generic;
    using System.Runtime.CompilerServices;
    using System.Web.Http;
    using Models;

    public class DealerController : ApiController
    {
        [HttpGet]
        [Route("dealer/users")]
        public IEnumerable<User> GetUsers()
        {
            return new List<User>
            {
                new User
                {
                    Id = 1,
                    Name = "Mr. Nilson",
                    Age = 45,
                    EnteredShopAt = new DateTime(2015, 05, 23, 11, 19, 33)
                },
                new User
                {
                    Id = 2,
                    Name = "Yoda",
                    Age = 900,
                    EnteredShopAt = new DateTime(2015, 05, 23, 11, 14, 33)
                }
            };
        }

        [HttpGet]
        [Route("dealer/userinfo")]
        public dynamic GetUserInfo(int id)
        {
            return new
            {
                Name = "Hr. Nilson",
                Age = "45",
                Cars = new List<Car>
                {
                    new Car
                    {
                        Make = "Bmw",
                        Model = "520i",
                        Price = "100.000",
                        Image = "http://www.lamarihuana.com/wp-content/uploads/2012/05/funny-aeroplane-car.jpg",
                        Beacon = new Beacon()
                        {
                            Id1 = Guid.NewGuid(),
                            Id2 = 1,
                            Id3 = 2,
                        }

                    }
                }
            };

        }
    }
}