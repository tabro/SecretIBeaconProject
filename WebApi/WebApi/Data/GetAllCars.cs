﻿using System;
using System.Collections.Generic;
using System.Runtime.InteropServices.WindowsRuntime;
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
                    Make = "Audi",
                    Model = "R8",
                    Image = "http://vignette4.wikia.nocookie.net/killbill/images/7/7c/Pussy-wagon-uma.jpg/revision/latest?cb=20110428111659",
                    Price = "Cheap for you my friend",
                    Beacon = new Beacon()
                    {
                        Id1 = Guid.Parse("39ed98ff-2900-441a-802f-9c398fc199d2"),
                        Id2 = 0,
                        Id3 = 0,
                    }
                },
                new Car
                {
                    Make = "Bmw",
                    Model = "520i",
                    Price = "100.000",
                    Image = "http://www.lamarihuana.com/wp-content/uploads/2012/05/funny-aeroplane-car.jpg",
                    Beacon = new Beacon()
                    {
                        Id1 = Guid.Parse("a7ae2eb7-1f00-4168-b99b-a749bac1ca64"),
                        Id2 = 1,
                        Id3 = 2,
                    }
                },
                new Car
                {
                    Make = "Bmw",
                    Model = "520i",
                    Price = "100.000",
                    Image = "http://www.lamarihuana.com/wp-content/uploads/2012/05/funny-aeroplane-car.jpg",
                    Beacon = new Beacon()
                    {
                        Id1 = Guid.Parse("f7826da6-4fa2-4e98-8024-bc5b71e0893e"),
                        Id2 = 3173,
                        Id3 = 28060,
                    }
                },
                new Car
                {
                    Make = "Bmw",
                    Model = "520i",
                    Price = "100.000",
                    Image = "http://hindimazza.com/wp-content/uploads/2015/04/car.jpg",
                    Beacon = new Beacon()
                    {
                        Id1 = Guid.Parse("b9407f30-f5f8-466e-aff9-25556b57fe6d"),
                        Id2 = 29902,
                        Id3 = 48895,
                    }
                },
                new Car
                {
                    Make = "Bmw",
                    Model = "520i",
                    Price = "100.000",
                    Image = "https://33.media.tumblr.com/tumblr_llnjvfdYU71qkoepxo1_500.gif",
                    Beacon = new Beacon()
                    {
                        Id1 = Guid.Parse("b9407f30-f5f8-466e-aff9-25556b57fe6d"),
                        Id2 = 21235,
                        Id3 = 42821,
                    }
                },
                new Car
                {
                    Make = "Bmw",
                    Model = "520i",
                    Price = "100.000",
                    Image = "http://funnystack.com/wp-content/uploads/2015/01/Funny-Car-34.jpg",
                    Beacon = new Beacon()
                    {
                        Id1 = Guid.Parse("f7826da6-4fa2-4e98-8024-bc5b71e0893e"),
                        Id2 = 48832,
                        Id3 = 34852,
                    }
                },
                new Car
                {
                    Make = "Bmw",
                    Model = "520i",
                    Price = "100.000",
                    Image = "http://files.sharenator.com/funny_car_pictures_11-s500x389-16620.jpg",
                    Beacon = new Beacon()
                    {
                        Id1 = Guid.Parse("f7826da6-4fa2-4e98-8024-bc5b71e0893e"),
                        Id2 = 50270,
                        Id3 = 26174,
                    }
                },
                new Car
                {
                    Make = "Bmw",
                    Model = "520i",
                    Price = "100.000",
                    Image = "http://www.lamarihuana.com/wp-content/uploads/2012/05/funny-aeroplane-car.jpg",
                    Beacon = new Beacon()
                    {
                        Id1 = Guid.Parse("b9407f30-f5f8-466e-aff9-25556b57fe6d"),
                        Id2 = 19313,
                        Id3 = 44274,
                    }
                },
            };
        }  
    }
}