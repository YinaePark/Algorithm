#include <iostream>
#include <algorithm>

using namespace std;


// 0 : 1개 1: 2개
int dp[301];
int stair[301];
int continueNum = 1;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n; 
    cin >> n;

    for(int i=1; i<=n; i++){
        cin >> stair[i];
    }

    dp[1] = stair[1];
    dp[2] = stair[2] + stair[1];
    dp[3] = max(stair[1], stair[2]) + stair[3];

    if(n < 4){
        cout << dp[n] << "\n";
        return 0;
    }


    int curr=3;
    while(curr <= n){
        dp[curr] = max(dp[curr-2]+stair[curr], stair[curr-1]+stair[curr]+dp[curr-3]);
        curr++;
    }
    cout << dp[n] << endl;

    
 
}