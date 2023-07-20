using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    /// отомри
    /// </summary>
    class Die_Off : Spell
    {
        public Die_Off() : base()
        {
            min_mana = 85;
        }

        public override void ImplementMagic( Wizard wiz,Person target)
        {
            if (wiz.state != State.парализован && wiz.state != State.мёртв && target.state != State.мёртв &&
                wiz.current_mana >= min_mana && target.state == State.парализован)
            {
                target.state = State.ослаблен;
                target.current_health = ((target.max_health / 100) >= 1) ? (target.max_health / 100) : (target.max_health / 100 + 1);

                wiz.current_mana -= min_mana;
            }
            else
            {
                throw new PersonException("Требования к заклинанию: автор заклинания и цель должны быть живыми, автор не должен быть парализован," +
                                        " цель должна быть парализована, минимальное кол-во маны у" +
                                         " автора: " + min_mana.ToString());
            }
        }
    }
}
