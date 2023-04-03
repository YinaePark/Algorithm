#include <iostream>

using namespace std;

int gcd(int a, int b){
    if(!b) return a;
    else return gcd(b, a%b);
}

int lcm(int a, int b){
    int gcdNum = a > b ? gcd(a,b) : gcd(b,a);

    return a * b / gcdNum;
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    for(int i=0; i<n; i++){
        int a, b;
        cin >> a >> b;
        cout << lcm(a, b) << '\n';
    }


}
