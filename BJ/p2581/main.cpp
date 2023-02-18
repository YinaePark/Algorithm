#include <iostream>

using namespace std;

int main() {
    int start, end, minPrime, primeSum=0, primeCnt=0;

    cin >> start >> end;

    if(start < 2){
        start = 2;
    }
    
    for(int num=end; num>=start; num--){
        bool isPrimeNum = true;

        for(int j=2; j<num; j++){
            if(num%j == 0){
                isPrimeNum = false;
                break;
            }
        }
        if(isPrimeNum){
            primeCnt++;
            primeSum += num;
            minPrime = num;
        }
    }

    if(!primeCnt) cout << -1 << endl;
    else{
        cout << primeSum << "\n" << minPrime << endl;
    }

}