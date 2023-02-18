#include <iostream>

using namespace std;

bool isPrime(int n){
    if(n<2) return false;
    for(int i=2; i<n; i++){
        if(n%i == 0) return false;
    }
    return true;
}

void primeFactorization(int n){
    if(n == 1) return;
    
    if(isPrime(n)){
        cout << n << endl;
        return;
    }
    for(int i=2; i<=n; i++){
        if(isPrime(i) && n%i == 0){
            cout << i << endl;
            primeFactorization(n/i);
            break;
        }
    }
}

int main() {
    int n;

    
    cin >> n;
    primeFactorization(n);

}