using System.Net.Http.Headers;
using System.Web.Http;

namespace WebApi.Controllers
{
    public class LoanOfferController : ApiController
    {
        [HttpGet]
        [Route("Loanoffer")]
        public dynamic Get()
        {
            return new
            {
                Name = "SMS Loansharks",
                MonthlyCost = 3197,
                DurationInMonths = 48,
                Prepayment = 12000,
            };
        }
    }
}