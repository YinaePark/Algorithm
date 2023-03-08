
#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;



int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int n, m;
    vector<string> testStr;
    vector<string> sStr;
    int cnt = 0;

    cin >> n >> m;

    for(int i=0; i<n; i++){
        string str;
        cin >> str;
        sStr.push_back(str);
    }
    sort(sStr.begin(), sStr.end());

    for(int i=0; i<m; i++){
        string str;
        cin >> str;
        if(binary_search(sStr.begin(), sStr.end(), str)){
            cnt++;
        }
    }

    cout << cnt << "\n";

}

