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

    long long int a, b;
    cin >> a >> b;
    long long int lcmNum = lcm(a, b);

    cout << lcmNum;

}
