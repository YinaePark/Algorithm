#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int n;
int cnt = 0;
// 체스판의 가로줄을 한 묶음으로 치고, 
// 각각의 y좌표에 해당하는 x좌표

int XperY[16] = {0,};


bool possible(int y){
    for(int j=0; j<y; j++){
            // 공격 가능
        if(XperY[y] == XperY[j] || abs(XperY[y] -XperY[j]) == y-j){
            return false;
        }
        // 공격 불가능하면 탐색 종료  
    }
    return true;
}

// 현재 탐색 중인 y의 좌표 : (i, y)
// 현재 탐색보다 윗칸의 좌표 : (XperY[j], j) (이때, j = 0 ~ y)

void nQueen(int y){
    if(n == y){
        cnt++;
        return;
    }

    for(int i=0; i<n; i++){
        XperY[y] = i;
        if(possible(y)) nQueen(y+1);

    }
}


int main(){

    cin >> n;

    for(int i=0; i<n; i++){
        XperY[0] = i;
        nQueen(1);
    }
    cout << cnt << '\n';

}