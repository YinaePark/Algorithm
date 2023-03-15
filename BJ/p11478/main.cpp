#include <iostream>
#include <string>
#include <set>
#include <algorithm>


using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    string str;
    cin >> str;
    int strLen = str.length();

    set<string> subString;

    // i : substr 길이
    for(int i=1; i<=strLen; i++){
        // j : substr 시작 idx
        for(int j=0; j<=strLen - i; j++){
            subString.insert(str.substr(j, i));
        }
    }

    cout << subString.size() << "\n";
}
