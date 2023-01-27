#include <iostream>

using namespace std;

int main() {
    string str;
    int cnt=0;

    while(true){
        cin >> str;
        if(cin.eof()) break;
        cnt++; 
    }
    cout << cnt << endl;
}


/*
 * while(cin >> str){}
 */