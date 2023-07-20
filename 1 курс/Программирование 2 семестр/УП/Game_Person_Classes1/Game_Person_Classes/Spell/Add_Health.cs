using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    ///  добавить здоровье
    /// </summary>
    class Add_Health : Spell
    {
        public Add_Health() : base() 
        {
        
        }

        public override void ImplementMagic(Wizard wiz ,Person target, int value_of_hp)
        {
            if (wiz.state != State.парализован && wiz.state != State.мёртв && target.state != State.мёртв)
            {
                int effect = 0;
                while (wiz.current_mana >= 2 && target.current_health < target.max_health && effect < value_of_hp)
                {
                    ++effect;
                    wiz.current_mana -= 2;
                    target.current_health += 1;
                }
            }
            else
            {
                throw new PersonException("Автор заклинания и цель должны быть живыми, автор не должен быть парализован!");
            }
        }
    }
}
