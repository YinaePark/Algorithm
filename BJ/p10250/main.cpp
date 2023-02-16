#include <iostream>
#include <cmath>

using namespace std;

int hotelRoomNumber(int h, int w, int n){
    int floorNum, distanceNum;
    floorNum = n%h? n%h: h;
    distanceNum = ceil((float)n/h);
    return floorNum * 100 + distanceNum;
}

int main() {
    int t;
    cin >> t;
    for(int i=0; i<t; i++){
        int h, w, n;
        cin >> h >> w >> n;
        cout << hotelRoomNumber(h, w, n) << endl;
    }

}

/*
 * h로 나누어떨어질 때 예외처리
*/