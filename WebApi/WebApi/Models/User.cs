namespace WebApi.Models
{
    using System;

    public class User
    {
        public int Id { get; set; }

        public string Name { get; set; }

        public int Age { get; set; }

        public DateTime EnteredShopAt { get; set; }

        public string RegNr { get; set; }

        public int OwnCarKm { get; set; }

        public int MaxMonthlyPayment { get; set; }

        public int DrivingPattern { get; set; }

        public int KmPerYear { get; set; }

        public int PreferredInterestType { get; set; }
    }
}