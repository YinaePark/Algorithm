#include <iostream>

using namespace std;

int reverse3DigitNum(int num){
    return ((num%10) * 100 + (num%100)/10 * 10 + num/100);
}


int main() {
    int a, b;
    cin >> a >> b;

    reverse3DigitNum(a)>reverse3DigitNum(b)? cout << reverse3DigitNum(a): cout << reverse3DigitNum(b);
    cout << "\n";
}

