#include <iostream>

using namespace std;

int main() {
    int n;
    int cnt = 0;
    cin >> n;

    for(int i=0; i<n; i++){
        int num;
        bool isPrimeNum = true;
        cin >> num;
        if(num < 2) continue;
        for(int j=2; j<num; j++){
            if(num%j == 0){
                isPrimeNum = false;
                break;
            } 
        }
        if(isPrimeNum) cnt++;
        
    }

    cout << cnt << endl;

}