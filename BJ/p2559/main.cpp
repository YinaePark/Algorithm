#include <iostream>
#include <vector>
#include <limits.h>

using namespace std;

int main(){

    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, k, num;
    cin >> n >> k;
    vector<int> arr;
    
    cin >> num;
    arr.push_back(num);
    for(int i=0; i<n-1; i++){
        cin >> num;
        arr.push_back(num+arr[i]);
    }

    int maxSum = INT_MIN;
    int idx = k-1;
    while(idx<n){
        if(idx == k-1){
            maxSum = max(maxSum, arr[idx]);
        }
        else{
            maxSum = max(maxSum, arr[idx] - arr[idx - k]);
        }
        idx++;
    }


    cout << maxSum << "\n";

}