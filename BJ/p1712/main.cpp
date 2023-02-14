#include <iostream>

using namespace std;

int main() {
    long long int a, b, c;
    cin >> a >> b >> c;

    if(b>=c) cout << -1 << endl;

    else{
        cout << a/(c-b) + 1 << endl;
    }
}