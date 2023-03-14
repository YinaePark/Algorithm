#include <iostream>
#include <string>
#include <set>
#include <algorithm>


using namespace std;


int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    set<string> noHear;
    set<string> noHearSee;

    for(int i=0; i<n; i++){
        string name;
        cin >> name;        

        noHear.insert(name);
    
    }
    for(int i=0; i<m; i++){
        string name;
        cin >> name;   

        // 이름 이미 존재
        if(noHear.find(name) != noHear.end()){
            noHearSee.insert(name);
        }
    }

    cout << noHearSee.size() << "\n";
    for(auto iter = noHearSee.begin(); iter != noHearSee.end(); iter++){
        cout << *iter << "\n";

    }
}
