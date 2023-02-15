#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int a, b, v, day;
    cin >> a >> b >> v;

    day = ceil((double)(v-b)/(a-b));
    cout << day << endl;
    

}