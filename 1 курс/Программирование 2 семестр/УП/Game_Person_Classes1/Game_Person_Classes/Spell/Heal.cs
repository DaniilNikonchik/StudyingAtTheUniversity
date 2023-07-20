using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    /// вылечить
    /// </summary>
    class Heal : Spell
    {
        public Heal() : base()
        {
            min_mana = 20;
        }

        public override void ImplementMagic(Wizard wiz,Person target)
        {
            if (wiz.state != State.парализован && wiz.state != State.мёртв && target.state != State.мёртв &&
                wiz.current_mana >= min_mana && target.state == State.болен)
            {
                wiz.current_mana -= min_mana;
                if (target.current_health >= target.max_health / 10)
                    target.state = State.нормальное;
                else
                    target.state = State.ослаблен;
            }
            else
            {
                throw new PersonException("Требования к заклинанию: автор заклинания и цель должны быть живыми, минимум маны у автора: " + min_mana.ToString()
                                            + ", цель " +
                                         "должна иметь состояние \"болен\", автор не должен быть парализован!!");
            }
        }
    }
}
