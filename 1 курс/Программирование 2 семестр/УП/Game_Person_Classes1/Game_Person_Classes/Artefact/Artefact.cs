using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    abstract class Artefact : IMagic
    {
        /// <summary>
        /// возобновляемость
        /// </summary>
        public bool renewability;

        /// <summary>
        /// мощность артефакта
        /// </summary>
        public int power { get; protected set; }

        protected Person hero;

        public Artefact(Person hero)
        {
            this.hero = hero;
        }

        //методы реализации магии ,наследованные от IMagic
        public virtual void ImplementMagic() { }

        public virtual void ImplementMagic(Person target, int value) { }

        public virtual void ImplementMagic(int value) { }

        public virtual void ImplementMagic(Person target) { }

        public virtual void ImplementMagic(Wizard wiz, Person target, int value) { }

        public virtual void ImplementMagic(Wizard wiz, Person target) { }
    }

    class ArtefactException : Exception
    {
        public ArtefactException(string message) : base(message)
        {

        }
    }
}
