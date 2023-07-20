using System;
using System.Collections.Generic;
using System.Text;

namespace Game_Person_Classes
{
    class PersonException : Exception
    {
        public PersonException(string message): base(message){ }
    }

    enum Gender{ мужской,женский}

    enum Race{человек, гном, эльф, орк, гоблин}

    enum State{ нормальное,ослаблен,болен,отравлен,парализован, мёртв, НЕУЯЗВИМ}

    class Person : IComparable
    {

        public string name { get; }

        public int age { get; }

        public Gender gender { get; }

        public State state { get; set; }

        public int max_health { get; protected set; }

        /// <summary>
        /// текущее здоровье
        /// </summary>
        protected int _current_health;

        /// <summary>
        /// не автоматически реализуемое свойство текущего здоровья
        /// </summary>
        public int current_health
        {
            get { return _current_health; }
            set
            {
                if (value < 0)
                    _current_health = 0;
                else if (value > max_health)
                    _current_health = max_health;
                else
                    _current_health = value;

                //описание состояния
                if (_current_health == 0)
                    state = State.мёртв;
                else if (state == State.ослаблен || state == State.нормальное)
                {
                    double current_percent = _current_health / (double)max_health * 100;
                    if (current_percent < 10)
                        state = State.ослаблен;

                    else if (current_percent >= 10)
                        state = State.нормальное;
                }
            }
        }

        public int expirience { get; }

        private static int next_ID = 0;

        public int ID { get; }

        public Race race { get; }

        public bool ability_to_move { get; set; }

        public bool ability_to_talk { get; set; }

        /// <summary>
        /// инвентарь(артефакты персонажа)
        /// </summary>
        public List<Artefact> inventory = new List<Artefact>();

        public void PickUpArtefact(Artefact artefact)
        {
            inventory.Add(artefact);
        }
        public void ShowInventory()
        {
            if (inventory.Count != 0)
            {
                for (int i = 0; i < inventory.Count; i++)
                {
                    string str = inventory[i].ToString().Substring(19);
                    if (inventory[i].renewability == true)
                        Console.WriteLine("{0}. {1} {2}", (i + 1), str, inventory[i].power.ToString());
                    else
                        Console.WriteLine("{0}. {1}", (i + 1), str);
                }
            }
            else
                Console.WriteLine("Инвентарь пуст.");
        }
        public void ThrowTheArtefact()
        {
            if (inventory.Count != 0)
            {
                Console.WriteLine("Введите номер артефакта, который хотите выбросить?");
                ShowInventory();
                int number;
                number = Int32.Parse(Console.ReadLine()) - 1;
                if (number < 0 || number >= inventory.Count)
                    throw new PersonException("Неверный номер артефакта.");
                else
                    inventory.RemoveAt(number);
            }
            else
                throw new PersonException("Инвентарь пуст!");
        }

        public void Implement_of_artefact(Person target, int number, int value = Int32.MinValue)
        {
            if (inventory.Count != 0)
            {
                if (inventory[number].renewability == true)
                    inventory[number].ImplementMagic(target, value);
                else
                {
                    inventory[number].ImplementMagic(target);
                    inventory.RemoveAt(number);
                }
            }
            else
                throw new PersonException("Инвентарь пуст!");
        }
        public void GiveTheArtefact(Person Target)
        {
            if (Target == this)
                throw new PersonException("Нельзя передать самому себе.");
            else
            {
                if (inventory.Count != 0)
                {
                    Console.WriteLine("Введите номер артефакта, который хотите передать?");
                    ShowInventory();
                    int number;
                    number = Int32.Parse(Console.ReadLine()) - 1;
                    if (number < 0 || number >= inventory.Count)
                        throw new PersonException("Неверный номер артефакта.");
                    else
                    {
                        Target.PickUpArtefact(inventory[number]);
                        inventory.RemoveAt(number);
                    }
                }
                else
                    throw new PersonException("Инвентарь пуст!");

            }
        }

        /// <summary>
        /// конструктор
        /// </summary>
        public Person(string name, int age, Race race, Gender gender)
        {

            this.race = race;
            this.name = name;
            this.ID = ++next_ID;
            this.ability_to_move = true;
            this.ability_to_talk = true;
            this.age = age;
            this.max_health = 100;
            this.current_health = 100;
            this.expirience = 0;
            this.gender = gender;
        }

        /// <summary>
        /// Сравнение персонажей по опыту
        /// </summary>
        public int CompareTo(object obj)
        {
            if (!(obj is Person))
                throw new PersonException("object is not a Person of the game");
            Person otherPerson = (Person)obj;
            if (this.expirience < otherPerson.expirience)
                return -1;
            if (this.expirience > otherPerson.expirience)
                return 1;
            return 0;
        }

        public override string ToString()
        {
            string s = "\n--------- Имя: " + name + "\tраса: " + race.ToString() + "\tпол: " + gender.ToString() + "\tвозраст: " + age.ToString() + "\nтекущее здоровье: "
                + current_health.ToString() + "\t максимальное здоровье: " + max_health.ToString() + "\tсостояние: " + state.ToString()
                + "\nвозможность говорить: " + ability_to_talk.ToString() + "\tвозможность двигаться: " + ability_to_move.ToString()
                + "\nкол-во опыта: " + expirience.ToString() + "\t\tid: " + ID.ToString();
            return s;
        }

    }
}
