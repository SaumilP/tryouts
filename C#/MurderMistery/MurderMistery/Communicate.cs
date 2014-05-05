using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MurderMistery
{
    public class Communicate : ICommunicate
    {
        public void Speak(string phrase)
        {
            Console.WriteLine(phrase);
        }
    }
}
