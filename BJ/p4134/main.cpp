#include <iostream>
#include <cmath>

using namespace std;

bool isPrime(long long int n){
    if(n < 2) return false;
    if(n == 2) return true;

    int sqrtN = sqrt(n);
    for(int i=2; i< sqrtN+1; i++){
        if(n % i == 0) return false;
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    for(int i=0; i<n; i++){
        long long int num;
        cin >> num;
        while(isPrime(num) == false){
            num++;
        }
        cout << num << '\n';
        
    }

}