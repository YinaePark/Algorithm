#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int numOfRoom = 0;
    int tmpSum = 1;

    while(n > tmpSum){
        numOfRoom++;
        tmpSum += (6 * numOfRoom);
    }
    cout << numOfRoom+1 << endl;

}