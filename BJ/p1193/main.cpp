#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int groupNumerator = 0; 
    int tmpSum = 0;

    while(n > tmpSum){
        groupNumerator++;
        tmpSum += groupNumerator;
    }

    int remain = tmpSum - n;
    int denominator, numerator;

    if(groupNumerator%2){
        denominator = groupNumerator;
        numerator = 1;
        for(int i=0; i<remain; i++){
            numerator++;
            denominator--;
        }
    }
    else{
        denominator = 1;
        numerator = groupNumerator;
        for(int i=0; i<remain; i++){
            numerator--;
            denominator++;
        }
    }
    cout << numerator << "/" << denominator << endl;

}