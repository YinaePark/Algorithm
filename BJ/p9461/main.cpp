#include <iostream>

using namespace std;

long long int dp[101] = {0,};

void initializeDP(){
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    dp[5] = 2;
    dp[6] = 3;
}

long long int DP(int n){
    if(dp[n]) return dp[n];
    dp[n] = DP(n-5) + DP(n-1);
    return dp[n];
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    initializeDP();
    int T, n;
    cin >> T;
    for(int i=0; i<T; i++){
        cin >> n;
        cout << DP(n) << "\n";
    }

}