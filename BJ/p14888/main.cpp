#include <iostream>
#include <vector>
#include <algorithm>
#include <limits.h>

using namespace std;

long long int minNum = LLONG_MAX;
long long int maxNum = LLONG_MIN;
int n; 
// +, -, x, / 
int op[4];
vector<int> nums;

void dfs(int depth, long long int result){
    if(depth == n-1){
        minNum = min(result, minNum);
        maxNum = max(result, maxNum);
        return;
    }


        if(op[0] > 0){
            op[0]--;
            dfs(depth+1, result + nums[depth+1]);
            op[0]++;
        }
        if(op[1] > 0){
            op[1]--;
            dfs(depth+1, result - nums[depth+1]);
            op[1]++;
        }
        if(op[2] > 0){
            op[2]--;
            dfs(depth+1, result * nums[depth+1]);
            op[2]++;
        }
        if(op[3] > 0){
            op[3]--;
            dfs(depth+1, result / nums[depth+1]);
            op[3]++;
        }
    


}

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i=0; i<n; i++){
        int num;
        cin >> num;
        nums.push_back(num);
    }
    for(int i=0; i<4; i++){
        cin >> op[i];
    }

    dfs(0, nums[0]);
    cout << maxNum << "\n" << minNum << "\n";

}