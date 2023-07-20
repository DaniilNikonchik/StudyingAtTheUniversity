using System;
using System.Collections.Generic;
using System.Text;

namespace Game_Person_Classes
{
    class Wizard : Person
    {
        protected int _current_mana;
        public int max_mana { get; protected set; } = 250;
        public List<Spell> spells_book = new List<Spell>();

        public int current_mana
        {
            get
            {
                return _current_mana;
            }
            set
            {
                if (value < 0)
                    _current_mana = 0;
                else if (value > max_mana)
                    _current_mana = max_mana;
                else
                    _current_mana = value;
            }
        }

        public Wizard(string name, int age, Race race, Gender gender) : base(name, age, race, gender)
        {
            current_mana = 100;
        }

        public void LearnSpell(Spell spell)
        {
            if (spells_book.Contains(spell))
                throw new PersonException("Персонаж уже обучен данному заклинанию!");
            else
                spells_book.Add(spell);
        }

        public void ImplementSpell(string spell_name,Person target = null, int value = Int32.MinValue)
        {
            bool spell_found = false;
            foreach (Spell sp in spells_book)
            {
                var test = sp.GetType().ToString().Split('.')[1];
                if (sp.GetType().ToString().Split('.')[1].CompareTo(spell_name) == 0)
                {
                    if (value == Int32.MinValue)
                    {
                        sp.ImplementMagic(this,target);
                    }
                    else if (value != Int32.MinValue && target == null)
                    {
                        sp.ImplementMagic(this,value);
                    }
                    else
                    {
                        sp.ImplementMagic(this,target, value);
                    }
                    spell_found = true;
                    break;
                }
            }
            if (!spell_found)
            {
                throw new PersonException("Персонаж не имеет данного заклинания");
            }
        }

        public void ForgetSpell(string spell_name)
        {
            spell_name = "Person_of_the_game." + spell_name;
            bool spell_found = false;
            foreach (Spell sp in spells_book)
            {
                if (sp.GetType().ToString().CompareTo(spell_name) == 0)
                {
                    spell_found = true;
                    spells_book.Remove(sp);
                    break;
                }
            }
            if (!spell_found)
                throw new Exception("Персонаж не знает данное заклинание!");
        }

        public override string ToString()
        {
            string s = base.ToString() + "\nмаксимальная мана: " + max_mana + "\t\tтекущая мана: " + current_mana;
            return s;
        }

        public void AddMaxHealth(Person target)
        {
            while (current_mana > 1 && target.current_health < target.max_health)
            {
                current_mana -= 2;
                ++target.current_health;
            }
        }
    }
}
