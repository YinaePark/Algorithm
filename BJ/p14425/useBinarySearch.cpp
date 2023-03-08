/* binary search 사용 : 시간초과
 * compare 시간
 */

#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

bool binarySearch(string targetStr, vector<string> sStr, int startIdx, int endIdx){
    if(startIdx > endIdx) return false;
    int midIdx = (startIdx + endIdx) / 2;

    if(sStr[midIdx].compare(targetStr) == 0) 
        return true;
    else if(sStr[midIdx].compare(targetStr) < 0) 
        return binarySearch(targetStr, sStr, midIdx+1, endIdx);
    else
        return binarySearch(targetStr, sStr, startIdx, midIdx-1);

}

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int n, m;
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
        if(binarySearch(str, sStr, 0, n-1)){
            cnt++;
        }
    }

    cout << cnt << "\n";

}

