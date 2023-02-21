#include <iostream>

using namespace std;

int main() {
    int col=0, row=0, num;
    int max = -1;

    for(int i=1; i<10; i++){
        for(int j=1; j<10; j++){
            cin >> num;
            if(max<num){
                max = num;
                row = i;
                col = j;
            }

        }
    }
    cout << max << endl;
    cout << row << " " << col << endl;
}