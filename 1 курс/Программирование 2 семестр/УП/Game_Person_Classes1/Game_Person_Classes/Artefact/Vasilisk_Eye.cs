using System;
using System.Collections.Generic;
using System.Text;

namespace Game_Person_Classes
{
    class Vasilisk_Eye : Artefact
    {
        public Vasilisk_Eye(Person hero) : base(hero)
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
                    power = 0;
                    target.state = State.парализован;
                    target.ability_to_move = false;
                }
                else
                    throw new ArtefactException("Глаз используется только один раз!");
            }
            else
                throw new ArtefactException("Владелец артефакта и цель должны быть живыми, автор не должен быть парализован.");
        }
    }
}
