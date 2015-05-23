namespace WebApi.Models
{
    using System;

    public class User
    {
        public int Id { get; set; }

        public string Name { get; set; }

        public int Age { get; set; }

        public DateTime EnteredShopAt { get; set; }
    }
}