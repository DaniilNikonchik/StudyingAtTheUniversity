using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    /// оживить
    /// </summary>
    class Revive : Spell
    {
        public Revive() : base()
        {
            min_mana = 150;
        }

        public override void ImplementMagic(Wizard wiz,Person target)
        {
            if (target != wiz)
            {
                if (wiz.state != State.парализован && wiz.state != State.мёртв && target.state == State.мёртв && wiz.current_mana >= min_mana)
                {
                    wiz.current_mana -= 150;
                    target.current_health = ((target.max_health / 100) >= 1) ? (target.max_health / 100) : (target.max_health / 100 + 1);
                    //НАПРИМЕР, ЕСЛИ МАКС. ЗДОРОВЬЕ 70, ТОГДА 70/100 = 0
                }
                else
                {
                    throw new PersonException("Требования к заклинанию: автор заклинания должен быть живыми, автор не должен быть парализован," +
                                              " цель должна быть мертва, минимальное кол-во маны у" +
                                              " автора: " + min_mana.ToString());
                }
            }
            else
            {
                throw new PersonException("Цель не может быть автором заклинания!");
            }

        }
    }
}
