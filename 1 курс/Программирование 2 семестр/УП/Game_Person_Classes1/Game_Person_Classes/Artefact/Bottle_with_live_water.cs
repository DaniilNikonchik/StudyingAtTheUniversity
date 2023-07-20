using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    /// Бутылки с живой водой
    /// </summary>
    abstract class Bottle_with_live_water : Artefact
    {
        /// <summary>
        /// количетво восстановленных hp
        /// </summary>
        protected int health_regen{ get; set; }

        public Bottle_with_live_water(Person hero) : base(hero)
        {
            renewability = false;
            power = 1;
        }

        

        public override void ImplementMagic(Person target)
        {
            if (hero.state != State.парализован && hero.state != State.мёртв && target.state != State.мёртв)
            {
                if (power != 0)
                {
                    target.current_health += health_regen;
                    power = 0;
                }
                else
                    throw new ArtefactException("Бутылка пуста");
            }
            else
                throw new ArtefactException("Владелец артефакта и цель должны быть живыми, автор не должен быть парализован.");
        }
    }
    class Big_Bottle_with_live_water : Bottle_with_live_water
    {
        public Big_Bottle_with_live_water(Person hero) : base(hero)
        {
            health_regen = 50;
        }
    }
    class Medium_Bottle_with_live_water : Bottle_with_live_water
    {
        public Medium_Bottle_with_live_water(Person hero) : base(hero)
        {
            health_regen = 25;
        }
    }
    class Small_Bottle_with_live_water : Bottle_with_live_water
    {
        public Small_Bottle_with_live_water(Person hero) : base(hero)
        {
            health_regen = 10;
        }
    }
}
