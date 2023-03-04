#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool compare(pair<int, string> a, pair<int, string> b){
    return a.first < b.first;
}

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    
    vector<pair<int, string> > memberInfo;



    
    for(int i=0; i<n; i++){
        int x;
        cin >> x;
        string y;
        cin>> y;

        memberInfo.push_back(pair<int, string>(x, y));
    }

    stable_sort(memberInfo.begin(), memberInfo.end(), compare);
    for(int i=0; i<n; i++){
        cout << memberInfo[i].first << " " << memberInfo[i].second << "\n";
    }



}

