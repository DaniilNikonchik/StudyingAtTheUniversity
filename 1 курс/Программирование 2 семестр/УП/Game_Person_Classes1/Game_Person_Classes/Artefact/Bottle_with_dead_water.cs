using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    /// Бутылки с мертвой водой
    /// </summary>
    abstract class Bottle_with_dead_water : Artefact
    {
        /// <summary>
        /// количество восстановления маны
        /// </summary>
        protected int mana_regen { get; set; }


        public Bottle_with_dead_water(Person hero) : base(hero)
        {
            renewability = false;
            power = 1;
        }
        public override void ImplementMagic(Person target)
        {
            if (target is Wizard)
            {
                if (hero.state != State.парализован && hero.state != State.мёртв && target.state != State.мёртв)
                {
                    if (power != 0)
                    {
                        (target as Wizard).current_mana += mana_regen;
                        power = 0;
                    }
                    else
                        throw new ArtefactException("Бутылка пуста");
                }
                else
                    throw new ArtefactException("Владелец артефакта и цель должны быть живыми, автор не должен быть парализован.");
            }
            else
            {
                throw new ArtefactException("Цель должна быть магом!");
            }
        }
    }
    class Big_Bottle_with_dead_water : Bottle_with_dead_water
    {
        public Big_Bottle_with_dead_water(Person hero) : base(hero)
        {
            mana_regen = 50;
        }
    }
    class Medium_Bottle_with_dead_water : Bottle_with_dead_water
    {
        public Medium_Bottle_with_dead_water(Person hero) : base(hero)
        {
            mana_regen = 25;
        }
    }
    class Small_Bottle_with_dead_water : Bottle_with_dead_water
    {
        public Small_Bottle_with_dead_water(Person hero) : base(hero)
        {
            mana_regen = 10;
        }
    }
}
