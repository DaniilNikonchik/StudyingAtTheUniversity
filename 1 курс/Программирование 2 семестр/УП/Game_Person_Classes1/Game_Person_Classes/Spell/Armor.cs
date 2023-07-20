using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    /// броня
    /// </summary>
    class Armor : Spell
    {
        Person target;
        Thread god_mode;
        int power;


        public Armor(int power) : base()
        {
            min_mana = 50;
            this.power = power;
        }

        public override void ImplementMagic(Wizard wiz,Person person)
        {
            target = person;
            if (wiz.state != State.парализован && wiz.state != State.мёртв && target.state != State.мёртв && wiz.current_mana >= min_mana)
            {
                god_mode = new Thread(GodModeOn);
                god_mode.Start();
            }
            else
            {
                throw new PersonException("Требования к заклинанию: автор заклинания и цель должны быть живыми, автор не должен быть парализован," +
                                          " минимальное кол-во маны у" +
                                          " автора: " + min_mana.ToString());
            }
        }

        private void GodModeOn()
        {
            State target_state = target.state;
            target.state = State.НЕУЯЗВИМ;
            Thread.Sleep(power);
            target.state = target_state;
        }
    }
}
