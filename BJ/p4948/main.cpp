#include <iostream>
#include <cmath>

using namespace std;

bool isPrime[250000];

void Eratos(){
    isPrime[0] = false;
    for(int i=2; i<500; i++){
        if(isPrime[i]){
            for(int j=i*i; j<250000; j += i){
                isPrime[j] = false;
            }
        }
    }
}


int BertrandPostulate(int n){
    int cnt = 0;
    for(int i=n+1; i<=2*n; i++){
        if(isPrime[i]) cnt++;
    }
    return cnt;
}

int main() {
    fill_n(isPrime, 250000, true);
    Eratos();
    while(true){
        int n;
        cin >> n;
        if(!n) break;
        cout << BertrandPostulate(n) << endl;
    }
}
