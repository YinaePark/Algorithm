#include <iostream>
#include <string>
#include <algorithm>
#include <set>

using namespace std;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    set<string, greater<string>> existingPeople;

    cin >> n;
    for(int i=0; i<n; i++){
        string name, status;
        cin >> name >> status;
        if(!status.compare("enter")){
            existingPeople.insert(name);
        }

        else{
            existingPeople.erase(name);
        }


    }

    for(auto name: existingPeople){
        cout << name << "\n";
    }

    


}
