using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MurderMistery
{
    public class Butler
    {
        private IWeapon _weapon;
        private ICommunicate _communicate;

        public Butler(IWeapon weapon, ICommunicate communicate)
        {
            _weapon = weapon;
            _communicate = communicate;
        }

        public Butler(IWeapon weapon)
            : this(weapon, new Communicate())
        { }

        public void Kill(string target)
        {
            _weapon.UseWeaponOn(target);
        }

        public void Speak(string phrase)
        {
            _communicate.Speak(phrase);
        }
    }
}
