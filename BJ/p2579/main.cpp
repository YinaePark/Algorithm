#include <iostream>
#include <algorithm>

using namespace std;


// 0 : 1개 1: 2개
int dp[301][2];
int stair[301];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    int continueCnt = 0;
    int maxSum = 0;
    cin >> n;

    for(int i=1; i<=n; i++){
        cin >> stair[i];
    }

    dp[1][0] = dp[1][1] = stair[1];
    if(n == 1){
        cout << dp[1][0] << "\n";
        return 0;
    }
    int curr=2;
    while(curr <= n){
        dp[curr-1]
        if(n==2) break;
    }
    
 
}