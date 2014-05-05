using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MurderMistery
{
    public class Poison : IWeapon
    {
        public void UseWeaponOn(string target)
        {
            Console.WriteLine(string.Format("{0} is killed by poisoning.", target));
        }
    }
}
