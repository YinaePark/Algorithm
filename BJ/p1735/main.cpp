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

    int num1, num2, den1, den2, resultNum, resultDen;
    cin >> num1 >> den1 >> num2 >> den2;

    resultDen = lcm(den1, den2);
    resultNum = resultDen/den1 * num1 + resultDen/den2 * num2;

    int tmp = resultNum > resultDen? gcd(resultNum, resultDen) : gcd(resultDen, resultNum);
    cout << resultNum / tmp << " " << resultDen / tmp << "\n";

}
