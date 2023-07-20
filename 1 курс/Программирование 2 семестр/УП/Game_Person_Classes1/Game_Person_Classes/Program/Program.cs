using System;
using System.Collections.Generic;
using System.Threading;
using System.Linq;

namespace Game_Person_Classes
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, Race> race_array = new Dictionary<string, Race>()
            {
                { "человек" , Race.человек },
                { "гном", Race.гном },
                { "эльф", Race.эльф },
                { "орк", Race.орк },
                { "гоблин", Race.гоблин }
            };

            Dictionary<string, Gender> gender_array = new Dictionary<string, Gender>()
            {
                { "м", Gender.мужской },
                { "ж", Gender.женский }
            };

            List<Person> persons = new List<Person>();

            try
            {

                Console.WriteLine("```````````````````````````````Мы рады приветствовать Вас в тестировании нашей игры!```````````````````````````````\n");
                Console.WriteLine("Для того чтобы приступить к тестированию игры,необходимо создать 2 персонажа,\n" +
                                  "выберите пожалуйста один из предложенных вариантов :\n"+
                                  "1 - Создать своих персонажей\n" +
                                  "2 - Воспользоваться заранее созданными персонажами\n" +
                                  "Ваш Выбор (1 или 2) : ");
                string answ = Console.ReadLine();
                while (!answ.Equals("1") && !answ.Equals("2"))
                {
                    Console.WriteLine("Проверьте введенные данные! Попробуйте еще раз!");
                    answ = Console.ReadLine();
                }

                Wizard wizard;
                Person person;

                Spell[] array_of_spells;
                Artefact[] array_of_artefacts;
                Artefact[] artefacts_of_person;
                Artefact[] artefacrs_of_wizard;
                

//////////////////////////////////////////////////////////   СОЗДАНИЕ СВОИХ ПЕРСОНАЖЕЙ    /////////////////////////////////////////////////////// 
                if (answ.Equals("1"))
                {
                    //////////////////////////////////////      ПЕРВЫЙ ПЕРСОНАЖ           //////////////////////////////////////////////////////
                    Console.WriteLine("\n");
                    Console.WriteLine("/////////////////////////   СОЗДАНИЕ СВОИХ ПЕРСОНАЖЕЙ   /////////////////////////\n");
                    Console.WriteLine("Ну что ж,приступим к созданию собственных персонажей!\n"+
                                       "Порядок ввода данных для вашего первого персонажа:\n"+
                                       "1) Имя персонажа\n"+
                                       "2) Возраст персонажа\n"+
                                       "3) Доступные рассы персонажа: человек, гном, эльф, орк, гоблин\n"+
                                       "4) Пол : м , ж\n"+
                                       "Пожалуйста ,введите выбранные данные через пробел в виде : Имя Возраст Расса Пол\n");
 
                    string[] enter_data = Console.ReadLine().Split(' ');
                    while (!race_array.ContainsKey(enter_data[2]) || !gender_array.ContainsKey(enter_data[3]) || !Int32.TryParse(enter_data[1], out int temp))
                    {
                        Console.Write("Проверьте данные! Введите заново: ");
                        enter_data = Console.ReadLine().Split(' ');
                    }
                    person = new Person(enter_data[0], Int32.Parse(enter_data[1]), race_array[enter_data[2]], gender_array[enter_data[3]]);

                    //////////////////////////////////////      ВТОРОЙ ПЕРСОНАЖ           //////////////////////////////////////////////////////

                    Console.WriteLine("\n");
                    Console.WriteLine("Поздравляем !Первый персонаж создан!\n"+
                                      "Теперь создадим второго персонажа,который будет еще и обладать магией!!!\n"+
                                      "По такому же принципу,как вы вводили данные первого персонажа,введите и для второго :\n");

                    enter_data = Console.ReadLine().Split(' ');
                    while (!race_array.ContainsKey(enter_data[2]) || !gender_array.ContainsKey(enter_data[3]) || !Int32.TryParse(enter_data[1], out int temp))
                    {
                        Console.Write("Проверьте данные! Введите заново: ");
                        enter_data = Console.ReadLine().Split(' ');
                    }
                    wizard = new Wizard(enter_data[0], Int32.Parse(enter_data[1]), race_array[enter_data[2]], gender_array[enter_data[3]]);

                    array_of_artefacts = new Artefact[10] {
                        new Medium_Bottle_with_live_water(person), new Small_Bottle_with_live_water(person), new Big_Bottle_with_live_water(person),
                        new Staff_Lightning(person, 30), new Frog_Decoction(person), new Poisonous_Saliva(person, 50),
                        new Vasilisk_Eye(person), new Medium_Bottle_with_dead_water(person), new Big_Bottle_with_dead_water(person),
                        new Small_Bottle_with_dead_water(person)
                    };

                    artefacts_of_person = new Artefact[10] {
                        new Medium_Bottle_with_live_water(person), new Small_Bottle_with_live_water(person), new Big_Bottle_with_live_water(person),
                        new Staff_Lightning(person, 30), new Frog_Decoction(person), new Poisonous_Saliva(person, 50),
                        new Vasilisk_Eye(person), new Medium_Bottle_with_dead_water(person), new Big_Bottle_with_dead_water(person),
                        new Small_Bottle_with_dead_water(person)
                    };

                    artefacrs_of_wizard = new Artefact[10] {
                        new Medium_Bottle_with_live_water(wizard), new Small_Bottle_with_live_water(wizard), new Big_Bottle_with_live_water(wizard),
                        new Staff_Lightning(wizard, 30), new Frog_Decoction(wizard), new Poisonous_Saliva(wizard, 50),
                        new Vasilisk_Eye(wizard), new Medium_Bottle_with_dead_water(wizard), new Big_Bottle_with_dead_water(wizard),
                        new Small_Bottle_with_dead_water(wizard)
                    };

                    array_of_spells = new Spell[6] { new Add_Health(), new Heal(), new Antidote(), new Revive(),
                        new Armor(5000), new Die_Off()
                    };
                    Console.WriteLine("Поздравляем,персонаж,обладающий магией создан!\n\n");


                    Console.WriteLine("/////////////////////////   ИНФОРМАЦИЯ О СОЗДАННЫХ ПЕРСОНАЖАХ   /////////////////////////\n");
       
                    Console.WriteLine("\t\t\t\n{0}\n{1}\n\n", person, wizard);


                    Console.WriteLine("/////////////////////////            АРТЕФАКТЫ               /////////////////////////\n");

                    
                    Console.WriteLine("Ознакомьтесь со списком возможных артефактов: ");
                    for (int i = 0; i < 10; ++i)
                    {
                        Console.WriteLine("{0}. {1}", i + 1, array_of_artefacts[i].GetType().ToString().Split('.')[1]);
                    }
                    Console.WriteLine("\n");

                    Console.WriteLine("Введите номера артефактов, которые хотите добавить персонажу {0} через пробел(например, 1 5 9)", person.name);
                    var artefacts_to_add = from symb in Console.ReadLine().Split(' ')
                                      where Int32.Parse(symb) < 11
                                      select (Int32.Parse(symb) - 1);
                    foreach (int i in artefacts_to_add)
                    {
                        person.PickUpArtefact(artefacts_of_person[i]);
                    }
                    Console.WriteLine("Ну что ж , {0} обзавелся(-ась) некоторыми артефактами и теперь инвентарь персонажа выглядит следующим образом: ", person.name);
                    int k = 0;
                    foreach (Artefact item in person.inventory)
                    {
                        Console.WriteLine((++k).ToString() + ". " + item.GetType().ToString().Split('.')[1]);
                    }


                    Console.WriteLine("\n");
                    Console.WriteLine("Не будем забывать и про персонажа по имени {0}!!!!!", wizard.name);
                    Console.WriteLine("Давайте и для него аналогичным способом введем номера артефактов : ");
                    artefacts_to_add = from symb in Console.ReadLine().Split(' ')
                                  where Int32.Parse(symb) < 11
                                  select (Int32.Parse(symb) - 1);
                    foreach (int i in artefacts_to_add)
                    {
                        wizard.PickUpArtefact(artefacrs_of_wizard[i]);
                    }
                    Console.WriteLine("Ну что ж,теперь и {0} имеет за в арсенале парочку артефактов!Давайте взглянем на них :\n ",wizard.name);
                    k = 0;
                    foreach (Artefact item in wizard.inventory)
                    {
                        Console.WriteLine((++k).ToString() + ". " + item.GetType().ToString().Split('.')[1]);
                    }
                    Console.WriteLine("\n");
                    Console.WriteLine("/////////////////////////              ЗАКЛИНАНИЯ              /////////////////////////\n");
                    Console.WriteLine("Теперь выберите заклинания для персонажа,владеющего магией по имени {0}, из списка заклинаний:",wizard.name);
                    k = 0;
                    for (int i = 0; i < 6; ++i)
                    {
                        Console.WriteLine((++k).ToString() + ". " + array_of_spells[i].GetType().ToString().Split('.')[1]);
                    }
                    Console.WriteLine("Теперь введите номера заклинаний, которым вы хотите обучить волшебника : ");
                    artefacts_to_add = from num in Console.ReadLine().Split(' ')
                                  where Int32.Parse(num) < 7
                                  select (Int32.Parse(num) - 1);
                    foreach (int i in artefacts_to_add)
                    {
                        wizard.LearnSpell(array_of_spells[i]);
                    }
                    Console.WriteLine("Ура! Волшибник {0} теперь владеет следующими заклинаниями :",wizard.name);
                    k = 0;
                    foreach (Spell sp in wizard.spells_book)
                    {
                        Console.WriteLine((++k).ToString() + ". " + sp.GetType().ToString().Split('.')[1]);
                    }
                    Console.WriteLine("/////////////////////////          СОЗДАНИЕ ПЕРСОНАЖЕЙ ЗАВЕРШЕНО УСПЕШНО       /////////////////////////");
                }
                else
                {
                    //////////////////////////////////////////////////////////   СОЗДАНИЕ ПЕРСОНАЖЕЙ ПО УМОЛЧАНИЮ    ///////////////////////////////////////////////////////
                   

                    person = new Person("Макар", 33, Race.человек, Gender.мужской);
                    wizard = new Wizard("Лиза", 77, Race.эльф, Gender.женский);

                    array_of_artefacts = new Artefact[10] {
                        new Medium_Bottle_with_live_water(person), new Small_Bottle_with_live_water(person), new Big_Bottle_with_live_water(person),
                        new Staff_Lightning(person, 30), new Frog_Decoction(person), new Poisonous_Saliva(person, 50),
                        new Vasilisk_Eye(person), new Medium_Bottle_with_dead_water(person), new Big_Bottle_with_dead_water(person),
                        new Small_Bottle_with_dead_water(person)
                    };

                    array_of_spells = new Spell[6] { new Add_Health(), new Heal(), new Antidote(), new Revive(),
                        new Armor(5000), new Die_Off()
                    };

                    foreach (Spell sp in array_of_spells)
                    {
                        wizard.LearnSpell(sp);
                    }
                    foreach (Artefact art in array_of_artefacts)
                    {
                        wizard.PickUpArtefact(art);
                    }
                    foreach (Artefact art in array_of_artefacts)
                    {
                        person.PickUpArtefact(art);
                    }
                    Console.WriteLine("/////////////////////////   ИНФОРМАЦИЯ О СОЗДАННЫХ ПЕРСОНАЖАХ   /////////////////////////\n\n");

                    Console.WriteLine("\t\t\t\n{0}\n{1}", person, wizard);

                    Console.WriteLine("/////////////////////////           АРТЕФАКТЫ           /////////////////////////\n");

                    Console.WriteLine("\n");
                    Console.WriteLine("Инвентарь обоих персонажей выглядит следующим образом: ");
                    int k = 0;
                    foreach (Artefact art in wizard.inventory)
                    {
                        Console.WriteLine((++k).ToString() + ". " + art.GetType().ToString().Split('.')[1]);
                    }

                    Console.WriteLine("\n/////////////////////////        ЗАКЛИНАНИЯ      /////////////////////////\n");

                    Console.WriteLine("Волшебник по имени {0} обучен следующим заклинаниям: ",wizard.name);
                    k = 0;
                    foreach (Spell sp in wizard.spells_book)
                    {
                        Console.WriteLine((++k).ToString() + ". " + sp.GetType().ToString().Split('.')[1]);
                    }

                }

                Console.WriteLine("\n\n/////////////////////////      ТЕСТИРОВАНИЕ ВОЗМОЖНОСТЕЙ ПЕРСОНАЖЕЙ      /////////////////////////\n");
                bool active = true;
                while (active)
                {
                    Console.WriteLine( "Выберите номер действия,которое хотите совершить :\n"+
                                       "1 - Управлять персонажем {0}\n"+
                                       "2 - Управлять персонажем {1}\n" +
                                       "3 - Завершить тестирование", person.name, wizard.name);
                    Console.WriteLine("Ваш выбор : ");
                    int choice = Int32.Parse(Console.ReadLine());
                    Console.WriteLine("\n\n");

                    switch (choice)
                    {
                        case 1://управлять первым персонажем

                            Console.WriteLine("Напомним вам список артефактов,которыми обладает {0}: ",person.name);
                            person.ShowInventory();
                            Console.WriteLine("\n");


                            Console.WriteLine("Выберите номер действия,которое хотите делать с артефактом :\n" +
                                      "1 - Использовать артефакт\n" +
                                      "2 - Выбросить артефакт\n" +
                                      "3 - Передать артефакт другому персонажу");
                            Console.WriteLine("Ваш выбор : ");
                            string command_to_action = Console.ReadLine();
                            string command_to_target;

                            while (command_to_action != "1" && command_to_action != "2" && command_to_action != "3")
                            {
                                Console.WriteLine("Неправильный ввод, повторите.");
                                command_to_action = Console.ReadLine();
                            }


                            Console.WriteLine("\n");
                            switch (command_to_action)
                            {
                                case "1": //Использовать артефакт

                                    Console.WriteLine("Выберите номер действия,которое хотите cделать :\n" +
                                                      "1 - Использовать артефакт на персонаже {0}\n" +
                                                      "2 - Использовать артефакт на персонаже {1}\n", person.name, wizard.name);
                                   
                                    command_to_target = Console.ReadLine();
                                    while (command_to_target != "1" && command_to_target != "2")
                                    {
                                        Console.WriteLine("Неправильный ввод, повторите попытку.");
                                        command_to_target = Console.ReadLine();
                                    }
                                    Console.WriteLine("\n");
                                    Console.WriteLine("Введите номер артефакта, который хотите применить :");
                                    int number;
                                    number = Int32.Parse(Console.ReadLine()) - 1;
                                    while (number < 0 || number >= person.inventory.Count)
                                    {
                                        Console.WriteLine("Неправильный ввод, повторите попытку.");
                                        number = Int32.Parse(Console.ReadLine()) - 1;
                                    }
                                    int value = 0; ;
                                    if (person.inventory[number].renewability == true)
                                    {
                                        Console.WriteLine("\n");
                                        Console.WriteLine("Введите силу применения артефакта");
                                        value = Int32.Parse(Console.ReadLine());
                                        while (value < 0)
                                        {
                                            Console.WriteLine("Неправильный ввод, повторите попытку.");
                                            value = Int32.Parse(Console.ReadLine());
                                        }
                                    }
                                    switch (command_to_target)
                                    {
                                        case "1": // Использовать артефакт на персонаже person

                                            if (person.inventory[number].renewability == true)
                                            {
                                                person.Implement_of_artefact(person, number, value);
                                            }
                                            else
                                            {
                                                person.Implement_of_artefact(person, number);
                                            }
                                            break;

                                        case "2": // Использовать артефакт на персонаже wizard

                                            if (person.inventory[number].renewability == true)
                                            {
                                                person.Implement_of_artefact(wizard, number, value);
                                            }
                                            else
                                            {
                                                person.Implement_of_artefact(wizard, number);
                                            }
                                            break;
                                    }

                                    Console.WriteLine("/////////////////////////  ТЕКУЩАЯ ИНФОРМАЦИЯ О ПЕРСОНАЖАХ  /////////////////////////\n\n");

                                    Console.WriteLine("\t\t\t\n{0}\n{1}\n\n", person, wizard);

                                    break;

                                case "2":  //Выбросить артефакт

                                    person.ThrowTheArtefact();
                                    Console.WriteLine("Текущий список артефактов персонажа : ");
                                    int counter = 0;
                                    foreach (Artefact item in person.inventory)
                                    {
                                        Console.WriteLine((++counter).ToString() + ". " + item.GetType().ToString().Split('.')[1]);
                                    }

                                    break;

                                case "3":  //Передать артефакт другому персонажу 

                                    person.GiveTheArtefact(wizard);
                                    counter = 0;
                                    Console.WriteLine("\t\tИнвентарь персонажа {0}", wizard.name);
                                    foreach (Artefact item in wizard.inventory)
                                    {
                                        Console.WriteLine((++counter).ToString() + ". " + item.GetType().ToString().Split('.')[1]);
                                    }
                                    Console.WriteLine("\n\n");
                                   
                                    break;
                            }
                            break;


                        case 2: //управлять вторым персонажем

                            int k = 0;
                            Console.WriteLine("Список заклинаний волшебника {0} выглядит следующим образом: ", wizard.name);
                            foreach (Spell sp in wizard.spells_book)
                            {
                                Console.WriteLine((++k).ToString() + ". " + sp.GetType().ToString().Split('.')[1]);
                            }
                            Console.WriteLine("Выберите заклинание, которое хотите использовать: ");
                            int number_of_spell = Int32.Parse(Console.ReadLine()) - 1;
                            while (number_of_spell >= wizard.spells_book.Count || number_of_spell < 0)
                            {
                                Console.WriteLine("Неверный ввод! Введите ещё раз: ");
                                number_of_spell = Int32.Parse(Console.ReadLine()) - 1;
                            }
                            Spell sp_to_implement = wizard.spells_book[number_of_spell];
                            int spell_power = Int32.MinValue;
                            if (sp_to_implement.GetType().ToString().Split('.')[1].Equals("AddHealth"))
                            {
                                Console.WriteLine("Введите силу заклинания: ");
                                spell_power = int.Parse(Console.ReadLine());
                                while (spell_power < 1)
                                {
                                    Console.WriteLine("Неверный ввод! Введите заново: ");
                                    spell_power = int.Parse(Console.ReadLine());
                                }
                            }
                            Console.WriteLine("Выберите номер действия,которое хотите cделать :\n" +
                                                     "1 - Использовать заклинание на персонаже {0}\n" +
                                                     "2 - Использовать заклинание на персонаже {1}\n", person.name, wizard.name);
                            
                            int currenr_answer = int.Parse(Console.ReadLine());
                            while (currenr_answer > 2 || currenr_answer < 1)
                            {
                                Console.WriteLine("Неверный ввод! Введите ещё раз: ");
                                currenr_answer = Int32.Parse(Console.ReadLine());
                            }
                            switch (currenr_answer)
                            {
                                case 1:
                                    if (spell_power == Int32.MinValue)
                                        wizard.ImplementSpell(sp_to_implement.GetType().ToString().Split('.')[1], person);
                                    else
                                        wizard.ImplementSpell(sp_to_implement.GetType().ToString().Split('.')[1], person, spell_power);
                                    break;
                                case 2:
                                    if (spell_power == Int32.MinValue)
                                        wizard.ImplementSpell(sp_to_implement.GetType().ToString().Split('.')[1], wizard);
                                    else
                                        wizard.ImplementSpell(sp_to_implement.GetType().ToString().Split('.')[1], wizard, spell_power);
                                    break;
                            }
                            Console.WriteLine("\n\n/////////////////////////  ТЕКУЩАЯ ИНФОРМАЦИЯ О ПЕРСОНАЖАХ   /////////////////////////\n\n");

                            Console.WriteLine(person); Console.WriteLine(wizard);
                           
                            break;


                        case 3:  //Завершить тестирование

                            active = false;
                            Console.WriteLine("Тестирование завершено.");
                            break;
                    }

                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Ошибка: " + ex.Message);
            }


        }
    }
}
