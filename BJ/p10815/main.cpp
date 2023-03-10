#include <iostream>
#include <set>
#include <algorithm>


using namespace std;


int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    set<int> cards;

    cin >> n;
    for(int i=0; i<n; i++){
        int card;
        cin >> card;
        cards.insert(card);
    }
    
    cin >> m;
    for(int i=0; i<m; i++){
        int card;
        cin >> card;
        if(cards.find(card) == cards.end()) cout << "0 ";
        else cout << "1 ";
    }
    cout << "\n";

}
