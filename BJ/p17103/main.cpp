#include <iostream>
#include <cmath>

using namespace std;

bool isPrime[1000001];

void Eratos(){
    isPrime[0] = false;
    isPrime[1] = false;

    for(int i=2; i<1000; i++){
        if(isPrime[i]){
            for(int j=i*i; j<1000001; j += i){
                isPrime[j] = false;
            }
        }
    }
}

int goldbach(int n){
    int cnt=0;
    for(int i=2; i<=n/2; i++){
        if(isPrime[i] && isPrime[n-i]){
            cnt++;
        }
    }
    return cnt;
}



int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    fill_n(isPrime, 1000001, true);
    Eratos();

    int T, n;
    cin >> T;
    for(int i=0; i<T; i++){
        cin >> n;
        cout << goldbach(n) << '\n';
    }

}
