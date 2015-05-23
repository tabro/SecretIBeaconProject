using System;
using System.Collections.Generic;
using WebApi.Controllers;
using WebApi.Models;

namespace WebApi.Data
{
    public class GetAllCars
    {
        public List<Car> Get()
        {
            return new List<Car>
            {
                new Car
                {
                    Make = "Volkswagen",
                    Model = "Passat",
                    Image = "http://hindimazza.com/wp-content/uploads/2015/04/car.jpg",
                    Price = "90.000",
                    Beacon = new Beacon
                    {
                        Id1 = Guid.Parse("f7826da6-4fa2-4e98-8024-bc5b71e0893e"),
                        Id2 = 42875,
                        Id3 = 31081,
                    },
                    Cons = new List<string>
                    {
                        "Timing belt needs change! (Est. 7.800 kr)",
                        "Diesel is not recommended with your drive pattern",
                        "Increased fuel cost compared to currect 'Volvo Amazone' (Est. 537 kr/month)"
                    },
                    Pros = new List<string>
                    {
                        "Low cost of maintenance"  
                    },
                    CarFinance = new CarFinance()
                    {
                        MonthlyPayment = 2000,
                        DownPayment = 15000,
                        Aaop = 6.98M,
                        YourCarIsDownPayment = true,
                        Period = 60
                    },
                    CarLease = new CarLease
                    {
                        MonthlyPayment = 1500,
                        DownPayment = 10000,
                        Period = 36
                    }
                },
                new Car
                {
                    Make = "Bmw",
                    Model = "520i",
                    Price = "100.000",
                    Image = "http://acidcow.com/pics/20130920/funny_car_themed_photos_01.jpg",
                    Beacon = new Beacon()
                    {
                        Id1 = Guid.Parse("f7826da6-4fa2-4e98-8024-bc5b71e0893e"),
                        Id2 = 53489,
                        Id3 = 24650,
                    },
                    Cons = new List<string>
                    {
                        "Variant has low userrating"
                    },
                    Pros = new List<string>
                    {
                        "Improved fuel economy compared to current 'Volvo Amazone' (Est. 225 kr/month)"
                    },
                    CarFinance = new CarFinance
                    {
                        MonthlyPayment = 2500,
                        DownPayment = 20000,
                        Aaop = 7.55M,
                        YourCarIsDownPayment = false,
                        Period = 84
                    },
                    CarLease = new CarLease
                    {
                        MonthlyPayment = 1500,
                        DownPayment = 12000,
                        Period = 24
                    }
                },
                //new Car
                //{
                //    Make = "Tesla",
                //    Model = "P85D",
                //    Price = "100.000",
                //    Image = "https://latestmsgs.files.wordpress.com/2010/09/funny-car_1024x768.jpg",
                //    Beacon = new Beacon()
                //    {
                //        Id1 = Guid.Parse("f7826da6-4fa2-4e98-8024-bc5b71e0893e"),
                //        Id2 = 3173,
                //        Id3 = 28060,
                //    },
                //    Cons = new List<string>
                //    {
                //        ""
                //    },
                //    Pros = new List<string>
                //    {
                //        ""
                //    }
                //},
                //new Car
                //{
                //    Make = "Bmw",
                //    Model = "520i",
                //    Price = "100.000",
                //    Image = "http://hindimazza.com/wp-content/uploads/2015/04/car.jpg",
                //    Beacon = new Beacon()
                //    {
                //        Id1 = Guid.Parse("b9407f30-f5f8-466e-aff9-25556b57fe6d"),
                //        Id2 = 29902,
                //        Id3 = 48895,
                //    },
                //    Cons = new List<string>
                //    {
                //        "Variant has low userrating"
                //    }

                //},
                //new Car
                //{
                //    Make = "Bmw",
                //    Model = "520i",
                //    Price = "100.000",
                //    Image = "https://33.media.tumblr.com/tumblr_llnjvfdYU71qkoepxo1_500.gif",
                //    Beacon = new Beacon()
                //    {
                //        Id1 = Guid.Parse("b9407f30-f5f8-466e-aff9-25556b57fe6d"),
                //        Id2 = 21235,
                //        Id3 = 42821,
                //    }
                //},
                //new Car
                //{
                //    Make = "Bmw",
                //    Model = "520i",
                //    Price = "100.000",
                //    Image = "http://www.topcarpicture.com/wp-content/uploads/2013/08/funny-cars-pictures.jpg",
                //    Beacon = new Beacon()
                //    {
                //        Id1 = Guid.Parse("f7826da6-4fa2-4e98-8024-bc5b71e0893e"),
                //        Id2 = 48832,
                //        Id3 = 34852,
                //    }
                //},
                //new Car
                //{
                //    Make = "Bmw",
                //    Model = "520i",
                //    Price = "100.000",
                //    Image = "http://files.sharenator.com/funny_car_pictures_11-s500x389-16620.jpg",
                //    Beacon = new Beacon()
                //    {
                //        Id1 = Guid.Parse("f7826da6-4fa2-4e98-8024-bc5b71e0893e"),
                //        Id2 = 50270,
                //        Id3 = 26174,
                //    }
                //},
                //new Car
                //{
                //    Make = "Bmw",
                //    Model = "520i",
                //    Price = "100.000",
                //    Image = "http://funnystack.com/wp-content/uploads/2014/04/Funny-Car-Graphics-152.jpg",
                //    Beacon = new Beacon()
                //    {
                //        Id1 = Guid.Parse("b9407f30-f5f8-466e-aff9-25556b57fe6d"),
                //        Id2 = 19313,
                //        Id3 = 44274,
                //    }
                //},
            };
        }  
    }
}