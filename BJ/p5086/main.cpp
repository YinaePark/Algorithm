#include <iostream>

using namespace std;

int main() {
    int a=1, b=1;

    while(true){
        cin >> a >> b;
        if(!a && !b) break;

        if(a%b == 0){
            cout << "multiple" << endl;
        }
        else if(b%a == 0){
            cout << "factor" << endl;
        }
        else{
            cout << "neither" << endl;
        }
    }

}