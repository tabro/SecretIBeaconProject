namespace WebApi.Models
{
    public class CarFinance
    {
        public int MonthlyPayment { get; set; }

        public int DownPayment { get; set; }

        public decimal Aaop { get; set; }

        public int Period { get; set; }

        public bool YourCarIsDownPayment { get; set; }
    }
}