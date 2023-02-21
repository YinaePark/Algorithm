#include <iostream>
#include <cmath>

using namespace std;

bool isPrime[10001];

void Eratos(){
    isPrime[0] = false;
    for(int i=2; i<101; i++){
        if(isPrime[i]){
            for(int j=i*i; j<10001; j += i){
                isPrime[j] = false;
            }
        }
    }
}


int GoldbachPartition(int n){
    for(int i=n/2; i>1; i--){
        if(isPrime[i] && isPrime[n-i]){
            return i;
        } 
    }
    return 0;
}

int main() {
    fill_n(isPrime, 10001, true);
    Eratos();

    int t, n, GoldbachNum;
    cin >> t;
    for(int i=0; i<t; i++){
        cin >> n;
        GoldbachNum = GoldbachPartition(n);
        cout << GoldbachNum << " " << n-GoldbachNum << endl;
        
    }
}
