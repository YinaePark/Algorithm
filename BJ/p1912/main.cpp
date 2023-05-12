#include <iostream>
#include <algorithm>
#include <limits.h>

using namespace std;

int arr[100000] = {0,};
int dp[100000] = {0, };
int maximum;

// arr[n]까지의 최대 부분합을 arr[n]에 저장
void maxSum(int n){
    dp[0] = maximum = arr[0];
    for(int i=1; i<n; i++){
        dp[i] = max(dp[i-1]+arr[i], arr[i]);
        if(maximum < dp[i]) maximum = dp[i];
    }
    
}


int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    maxSum(n);
    cout << maximum << "\n";

}