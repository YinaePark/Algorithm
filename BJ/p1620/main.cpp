#include <iostream>
#include <string>
#include <map>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);


    int n, m;
    cin >> n >> m;

    map<string, int> pocketMon;
    vector<string> pocketMon2;

    for(int i=1; i<=n; i++){
        string name;
        cin >> name;
        pocketMon.insert({name, i});
        pocketMon2.push_back(name);
    }

    for(int i=0; i<m; i++){
        string target;
        cin >> target;
        // 문자열일 경우
        if(!atoi(target.c_str())){
            cout << pocketMon[target] << "\n";
        }
        // 숫자일 경우
        else{
            int idx = stoi(target);
            cout << pocketMon2[idx - 1] << "\n";
        }
    }

}
