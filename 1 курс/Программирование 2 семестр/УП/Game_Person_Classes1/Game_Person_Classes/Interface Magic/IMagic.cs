using System;
using System.Collections.Generic;
using System.Text;

namespace Game_Person_Classes
{
    interface IMagic
    {
        // реализация магии (как я понял по умолчанию эти методы выводят на консоль информацию)
        public void ImplementMagic();
        public void ImplementMagic(Person target);
        public void ImplementMagic(Person target, int value);
        public void ImplementMagic(int value);
        public void ImplementMagic(Wizard wiz, Person target, int value);
        public void ImplementMagic(Wizard wiz, Person target);
    }
}
