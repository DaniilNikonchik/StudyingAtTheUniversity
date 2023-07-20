using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    /// Декокт из лягушачьих лапок
    /// </summary>
    class Frog_Decoction : Artefact
    {
        public Frog_Decoction(Person hero) : base(hero)
        {
            power = 1;
            renewability = false;
        }
        public override void ImplementMagic(Person target)
        {
            if (hero.state != State.парализован && hero.state != State.мёртв && target.state != State.мёртв)
            {
                if (power != 0)
                {

                    double percent_of_current_health = target.current_health / (double)target.max_health * 100;

                    if (percent_of_current_health < 10)
                        target.state = State.ослаблен;
                    if (percent_of_current_health >= 10)
                        target.state = State.нормальное;

                    power = 0;
                }
                else
                    throw new ArtefactException("Отвара нет!");
            }
            else
                throw new ArtefactException("Владелец артефакта и цель должны быть живыми, автор не должен быть парализован.");
        }
    }
}
