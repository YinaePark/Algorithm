#include <iostream>
#include <algorithm>

using namespace std;

int dp[500][500];
int newLine[500];
int maxSum = 0;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n >> dp[0][0];
    for(int i=1; i<n; i++){

        for(int j=0; j<=i; j++){
            cin >> newLine[j];
        }
        dp[i][0] = dp[i-1][0] + newLine[0];
        dp[i][i] = dp[i-1][i-1] + newLine[i];
        if(n==2) break;
        for(int j=1; j<i; j++){
            dp[i][j] = max(dp[i-1][j-1] + newLine[j], dp[i-1][j] + newLine[j]);
        }
    }

    for(int i=0; i<n; i++){
        maxSum = max(maxSum, dp[n-1][i]);
    }
    cout << maxSum << "\n";


}