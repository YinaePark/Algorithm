#include <iostream>
#include <algorithm>
#include <vector>
#include <limits.h>

using namespace std;

int statusSum = 0;  // 전체 status
int selectedStatus = 0; // selected status
int nonSelecStatus = 0;
int minDifference = INT_MAX;
int n;

int testCnt = 0;

vector<int> selected;    
vector<int> unselected;
vector<bool> visited;

int status[400];
bool playerStatus[20] = {false, };


void calculateSelectedStatus(){
    int player1, player2;
    for(int i=0; i<n; i++){
        if(playerStatus[i]){
            player1 = playerStatus[i];
        }
        else continue;
        for(int j=0; j<n; j++){
            if(playerStatus[i]){
                player2 = playerStatus[j];
                selectedStatus += status[player1 * n + player2];
                }
            
        }
    }
}

void calculateUnselecStatus(){
    int player1, player2;
    for(int i=0; i<n; i++){
        if(!playerStatus[i]){
            player1 = playerStatus[i];
        }
        else continue;
        for(int j=0; j<n; j++){
            if(!playerStatus[i]){
                player2 = playerStatus[j];
                nonSelecStatus += status[player1 * n + player2];
                }
            
        }
    }

    // for(int i=0; i<n; i++){
    //     unselected.push_back(i);
    // }
    // for(int i=0; i<n/2; i++){
    //     unselected.erase(unselected.begin() + selected[i]);
    // }
    // for(int i=0; i<n/2; i++){
    //     int player1 = unselected[i];
    //     for(int j=0; j<n/2; j++){
    //         int player2 = unselected[j];
    //         nonSelecStatus += status[player1 * n + player2];
    //     }
    // }
}


// depth == selected에 넣을 선수의 수
void dfs(int least, int depth){
    if(depth == n/2){
        // teamStatus 계산
        calculateSelectedStatus();
        calculateUnselecStatus();

        //TEST
        testCnt++;
        cout << "!!!!!!!!!!!!!!!!!!!!!!test: " << testCnt << endl;
        for(int i=0; i<n; i++){
            if(playerStatus[i]) cout << "THIS IS SELECTED " << playerStatus[i] << endl;
            else cout << "THIS IS UnSELECTED " << playerStatus[i] << endl;


        }
                    cout << selectedStatus << " and.. " << nonSelecStatus << endl;

        minDifference = min(minDifference, abs(nonSelecStatus - selectedStatus));
        selectedStatus = 0;
        nonSelecStatus = 0;
        return;
    }
    for(int i=least; i<n; i++){
        if(!visited[i]){
            visited.push_back(i);
            playerStatus[i] = true;
            dfs(least+1, depth+1);
            playerStatus[i] = false;
            visited.pop_back();
        }
    }


}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;

    // visited 초기화
    for(int i=0; i<n; i++){
        visited.push_back(false);
    }

    // status 입력
    for(int i=0; i<n*n; i++){
        cin >> status[i];
        statusSum += status[i];
    }

    dfs(0, 0);
    cout << minDifference << "\n";

}