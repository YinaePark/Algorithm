#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

bool strCompare(const string &a, const string &b){
    if(a.length() < b.length()){
        return true;
    }
    else if(a.length() > b.length()){
        return false;
    }
    else{
        if(a < b) return true;
        else return false;
    }
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    vector<string> str;
    string s;
    

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s;
        str.push_back(s);
    }

    sort(str.begin(), str.end(), strCompare);

    for(size_t i=0; i<str.size(); i++){
        if(i == 0 || (i>0 && str[i] != str[i-1])){
            cout << str[i] << "\n";

        }
    }

}
