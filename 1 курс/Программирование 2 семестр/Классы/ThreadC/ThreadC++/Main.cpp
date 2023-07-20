#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <thread>
#include <mutex>

using namespace std;
using namespace chrono;

mutex mtx;
class MomDad {
private:
    string message;
    int repeats;
    int timeLag;
public:
    static int total; //Общее количество повторений

    MomDad(string aMessage, int aRepeats, int atimeLag) {
        Set_Message(std::move(aMessage));
        Set_Repeats(aRepeats);
        Set_TimeLag(atimeLag);
    }
    MomDad() {
        message = "Test";
        repeats = 1;
        timeLag = 1000;
    }
    void Set_Message(string aMessage) {
        message = std::move(aMessage);
    }
    void Set_TimeLag(int atimeLag) {
        timeLag = atimeLag;
    }
    void Set_Repeats(int aRepeats) {
        repeats = aRepeats;
    }
    void Set() {
        this_thread::sleep_for(chrono::milliseconds(timeLag));
        while (repeats != 0 && total != 0) {
            mtx.lock();
            cout << "-------------------------------------------------------------------" << endl;
            cout << "ID треда: " << this_thread::get_id() << " | " << "Задержка: " << timeLag << " мс" << " | " << "Сообщение: " << message << endl;
            cout << "-------------------------------------------------------------------" << endl;
            repeats--;
            mtx.unlock();
            total--;
            this_thread::sleep_for(chrono::milliseconds(timeLag));
        }
    }
};
int MomDad::total = 10; //Общее количество повторений

void delete_vector(vector<thread>& v);
int main() {
    setlocale(LC_ALL, "RUS");

    int menu;
    cout << "******************************************************" << endl;
    cout << "*            Выберите действие:                      *" << endl;
    cout << "*            1 - использовать созданные объекты      *" << endl;
    cout << "*            2 - создать свои объекты                *" << endl;
    cout << "******************************************************" << endl;
    cin >> menu;
    if (menu == 1) {
        MomDad mom("Это мама!", 1, 1000);
        MomDad dad("Это папа!", 2, 2000);
        MomDad parents("Это мы, родители!", 3, 3000);
        mom.Set();
        dad.Set();
        parents.Set();
    }
    else if (menu == 2) {
        vector<thread> th;
        int n;
        cout << "******************************************************" << endl;
        cout << "*            Введите общее число потоков:            *" << endl;
        cout << "******************************************************" << endl;
        cin >> n;

        auto* tmp = new MomDad[n];
        int* timeLag = new int[n];
        int* repeats = new int[n];
        auto* message = new string[n];
        for (int i = 0; i < n; i++) {
            cout << "------------------------------------------------------" << endl;
            cout << "Введите сообщение №" << i + 1 << ": " << endl;
            cin >> message[i];
            cout << "Сколько раз необходимо вывести сообщение?" << endl;
            cin >> repeats[i];
            cout << "Введите величину задержки (в милисекундах): " << endl;
            cin >> timeLag[i];
            cout << "------------------------------------------------------" << endl;
            tmp[i] = MomDad(message[i], repeats[i], timeLag[i]);
        }
        for (int i = 0; i < n; i++) {
            th.emplace_back(&MomDad::Set, tmp[i]);
        }
        for (int i = 0; i < n; i++) {
            if (th[i].joinable())
                th[i].join();
        }
        delete_vector(th);
        delete[] tmp;
        delete[] repeats;
        delete[] timeLag;
        delete[] message;
    }
    else {
        cout << "Такого параметра не существует";
    }
    return 0;
}

void delete_vector(vector<thread>& v) {
    while (!v.empty()) {
        auto it = v.begin();
        v.erase(it);
    }
}



