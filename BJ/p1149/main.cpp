#include <iostream>
#include <algorithm>
#include <limits.h>

using namespace std;

int dp[1000][3];


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, rNum, gNum, bNum;
    cin >> n >> dp[0][0] >> dp[0][1] >> dp[0][2];
    
    for(int i=1; i<n; i++){
        cin >> rNum >> gNum >> bNum;
        dp[i][0] = min(dp[i-1][1]+rNum, dp[i-1][2]+rNum);
        dp[i][1] = min(dp[i-1][0]+gNum, dp[i-1][2]+gNum);
        dp[i][2] = min(dp[i-1][1]+bNum, dp[i-1][0]+bNum);

    }
    
    int minCost = min({dp[n-1][0], dp[n-1][1], dp[n-1][2]});
    cout << minCost << "\n";

}