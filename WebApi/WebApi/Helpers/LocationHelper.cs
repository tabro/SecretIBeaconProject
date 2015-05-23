namespace WebApi.Helpers
{
    using System;

    public class LocationHelper
    {
        public struct PrecisePoint
        {
            public decimal X { get; set; }
            public decimal Y { get; set; }
        }

        public static decimal DistanceTo(PrecisePoint origin, PrecisePoint destination)
        {
            return (decimal)Math.Sqrt((double)((destination.X - origin.X) * (destination.X - origin.X) + (destination.Y - origin.Y) * (destination.Y - origin.Y)));
        }

        public static PrecisePoint TrilaterateThreePoints(PrecisePoint position1, PrecisePoint position2, PrecisePoint position3, decimal distance1, decimal distance2, decimal distance3)
        {
            var w = distance1 * distance1 - distance2 * distance2 - position1.X * position1.X - position1.Y * position1.Y + position2.X * position2.X + position2.Y * position2.Y;
            var z = distance2 * distance2 - distance3 * distance3 - position2.X * position2.X - position2.Y * position2.Y +
                position3.X * position3.X + position3.Y * position3.Y;

            var x = (w * (position3.Y - position2.Y) - z * (position2.Y - position1.Y)) / (2 * ((position2.X - position1.X) * (position3.Y - position2.Y) - (position3.X - position2.X) * (position2.Y - position1.Y)));
            var y = (w - 2 * x * (position2.X - position1.X)) / (2 * (position2.Y - position1.Y));

            //y2 er en anden måling af y for at nedsætte fejlmargen.
            var y2 = (z - 2 * x * (position3.X - position2.X)) / (2 * (position3.Y - position2.Y));

            //brug gennemsnittet af y og y2 som den nye y.
            y = (y + y2) / 2;

            return new PrecisePoint()
            {
                X = x,
                Y = y
            };
        }
    }
}