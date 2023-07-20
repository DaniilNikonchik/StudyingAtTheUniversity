using System;
using System.Collections.Generic;
using System.Text;

namespace Game_Person_Classes
{
    abstract class Spell : IMagic
    {
        public int min_mana { get; protected set; }
        public bool need_say { get; protected set; }
        public bool need_move { get; protected set; }

        //protected Wizard actor;

        //public Spell(Wizard w)
        //{
        //    actor = w;
        //}

        public Spell() { }

        public virtual void ImplementMagic() { }

        public virtual void ImplementMagic(Person target, int value) { }

        public virtual void ImplementMagic(int value) { }

        public virtual void ImplementMagic(Person target) { }

        public virtual void ImplementMagic(Wizard wiz, Person target, int value) { }

        public virtual void ImplementMagic(Wizard wiz, Person target) { }

    }
}
