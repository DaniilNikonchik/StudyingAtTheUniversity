using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    ///противоядие 
    /// </summary>
    class Antidote : Spell
    {
        public Antidote() : base() 
        {
        
        }

        public override void ImplementMagic(Wizard wiz,Person target)
        {
            if (wiz.state != State.парализован && wiz.state != State.мёртв && target.state != State.мёртв &&
                wiz.current_mana >= min_mana && target.state == State.отравлен)
            {
                wiz.current_mana -= min_mana;
                if (target.current_health >= target.max_health / 10)
                    target.state = State.нормальное;
                else
                    target.state = State.ослаблен;
            }
            else
            {
                throw new PersonException("Требования к заклинанию: автор заклинания и цель должны быть живыми, автор не должен быть парализован, " +
                                           "цель должна быть отравлена, минимальное кол-во маны у" +
                                             " автора: " + min_mana.ToString());
            }
        }
    }
}
