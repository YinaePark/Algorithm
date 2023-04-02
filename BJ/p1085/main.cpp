#include <iostream>
#include <cmath>


using namespace std;

int main() {
    int x, y, w, h;

    cin >> x >> y >> w >> h;

    int result = (abs(x-w)<x ? abs(x-w) : x) < (abs(y-h)<y ? abs(y-h) : y) ? (abs(x-w)<x ? abs(x-w) : x) : (abs(y-h)<y ? abs(y-h) : y);
    cout << result << endl;
}
