using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    /// Посох "Молния"
    /// </summary>
    class Staff_Lightning : Artefact
    {
        public Staff_Lightning(Person hero, int power) : base(hero)
        {
            this.power = power;
            renewability = true;
        }
        public override void ImplementMagic(Person target)
        {
            throw new ArtefactException("Для использования этого артефакта нужен параметр с кол-вом урона!");
        }
        public override void ImplementMagic(Person target, int damage)
        {
            if (hero.state != State.парализован && hero.state != State.мёртв && target.state != State.мёртв)
            {
                if (target.state != State.НЕУЯЗВИМ)
                {
                    if (power != 0)
                    {
                        if (damage > power)
                            damage = power;

                        target.current_health -= damage;
                        power -= damage;
                    }
                    else
                        throw new ArtefactException("Бесполезно. Мощность посоха равна нулю.");
                }
                else
                    throw new ArtefactException("Цель неузявима");
            }
            else
                throw new ArtefactException("Владелец артефакта и цель должны быть живыми, автор не должен быть парализован.");
        }

    }
}
