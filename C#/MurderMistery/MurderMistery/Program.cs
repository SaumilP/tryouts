using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MurderMistery
{
    class Program
    {
        static void Main(string[] args)
        {
            IWeapon weapon = new Poison();
            ICommunicate communcate = new Communicate();
            Butler butler = new Butler(weapon, communcate);

            butler.Speak("Please drink this, Sir!");
            butler.Kill("The young man");

            Console.ReadKey();
        }
    }
}
