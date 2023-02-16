#include <iostream>
#include <cmath>

using namespace std;

int residentNumber(int floorNum, int roomNum){

    if(floorNum == 0){
        return roomNum;
    }

    int sum = 0;
    for(int i=1; i<=roomNum; i++){
        sum += residentNumber(floorNum-1, i);
    }
    return sum;
}

int main() {
    int t;
    cin >> t;
    for(int i=0; i<t; i++){
        int floorNum, roomNum;
        cin >> floorNum >> roomNum;
        cout << residentNumber(floorNum, roomNum) << endl;
    }

}

