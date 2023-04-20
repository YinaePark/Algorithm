#include <iostream>
#include <string>
#include <vector>
#include <utility>

using namespace std;

int moveCnt = 0;
vector<pair<int, int>> v;

void move(int start, int end){
    moveCnt++;
    v.push_back({start, end});
}


void hanoi(int n, int start, int end, int waypoint){
    if(n==1){
        move(start, end);
        return;
    }

    hanoi(n-1, start, waypoint, end);
    move(start, end);
    hanoi(n-1, waypoint, end, start);

}


using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);




    int k;
    cin >> k;

    hanoi(k, 1, 3, 2);
    cout << moveCnt << '\n';
    for(long unsigned int i=0; i<v.size(); i++){
        cout << v[i].first << " " << v[i].second << '\n';
    }

    

    
}


