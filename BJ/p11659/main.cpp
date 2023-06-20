#include <iostream>
#include <vector>

using namespace std;

int main(){

    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<int> arr;
    int n, m, num;
    cin >> n >> m;

    cin >> num;
    arr.push_back(num);
    for(int i=0; i<n-1; i++){
        cin >> num;
        arr.push_back(num + arr[i]);
    }

    int start, end;
    for(int i=0; i<m; i++){
        cin >> start >> end;
        if(start == 1) cout << arr[end-1] << "\n";
        else{
            cout << arr[end-1] - arr[start-2] << "\n";
        }
    }

}