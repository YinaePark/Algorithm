#include <iostream>
#include <vector>

using namespace std;


vector<int> selected;
vector<bool> visited; // 모두 false로 초기화

void dfs(int depth, int start, int n, int r){
    if(depth == r){
        for(int i=0; i<r; i++){
           cout << selected[i]+1 << " ";
        }
        cout << "\n";
        return;
    }
    
    for(int i=start; i<n; i++){
        if(!visited[i]){
            selected.push_back(i);
            visited[i] = true;
            dfs(depth+1, i+1, n, r);
            visited[i] = false;
            selected.pop_back();
        }
    }

    


}


using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, r;

    cin >> n >> r;

    for(int i=0; i<n; i++){
        visited.push_back(false);
    }
    
    
    dfs(0, 0, n, r);


    
}


