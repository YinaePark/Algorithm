#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);


    map<int, int> SGsCard;
    int n, m;

    cin >> n;
    for(int i=0; i<n; i++){
        // key가 존재

        int key;
        cin >> key;
        if(SGsCard.find(key) != SGsCard.end()){
            SGsCard[key] = SGsCard[key] + 1;
        }
        else{
            SGsCard.insert({key, 1});
        }
    }
    
    cin >> m;
    for(int i=0; i<m; i++){
        int key;
        cin >> key;

        // key가 존재
        if(SGsCard.find(key) != SGsCard.end()){
            cout << SGsCard[key] << " ";
        }
        else{
            cout << "0 ";
        }
    }

    cout << "\n";


}
