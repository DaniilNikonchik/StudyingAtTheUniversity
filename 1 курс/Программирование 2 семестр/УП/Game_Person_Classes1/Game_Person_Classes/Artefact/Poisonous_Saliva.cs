using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Game_Person_Classes
{
    /// <summary>
    /// Ядовитая слюна
    /// </summary>
    class Poisonous_Saliva : Artefact
    {
        public Poisonous_Saliva(Person hero, int power) : base(hero)
        {
            this.power = power;
            renewability = true;
        }
        private Person target;
        private int damage;
        private Thread thread;
        public override void ImplementMagic(Person target)
        {
            throw new ArtefactException("Для использования этого артефакта нужен параметр с кол-вом урона!");
        }

        public override void ImplementMagic(Person target, int damage)
        {
            this.target = target;
            this.damage = damage;
            if (hero.state != State.парализован && hero.state != State.мёртв && target.state != State.мёртв)
            {
                if (target.state != State.НЕУЯЗВИМ)
                {
                    if (power != 0)
                    {
                        target.state = State.отравлен;
                        thread = new Thread(minus_hp);
                        thread.Start();
                    }
                    else
                        throw new ArtefactException("Ядовитая слюна закончилась");
                }
                else
                    throw new ArtefactException("Цель неуязвима!");
            }
            else
                throw new ArtefactException("Владелец артефакта и цель должны быть живыми, автор не должен быть парализован.");
        }
        private void minus_hp()
        {
            int i = 0;
            while (i < 3 && target.state != State.мёртв && power != 0 && target.state == State.отравлен)
            {
                i++;
                if (damage > power)
                    damage = power;
                target.current_health -= damage;
                power -= damage;

                if (target.state != State.мёртв && target.state != State.НЕУЯЗВИМ && power != 0 && target.state == State.отравлен)
                    Thread.Sleep(1000);
            }

            //изменение состояния(в зависимости от того ,сколько HP осталось у target)
            double percent_target_current_health = target.current_health / (double)target.max_health * 100;
            if (percent_target_current_health < 10)
                target.state = State.ослаблен;
            if (percent_target_current_health >= 10)
                target.state = State.нормальное;
        }
    }
}
