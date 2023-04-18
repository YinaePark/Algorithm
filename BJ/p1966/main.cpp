#include <iostream>
#include <queue>
#include <set>
#include <vector>
#include <algorithm>

using namespace std;



int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, N, M;
    cin >> T;

    for(int i=0; i<T; i++){

        int pri;
        cin >> N >> M;

        queue<pair<int, int>> q;
        priority_queue<int> pq;

        for(int j=0; j<N; j++){
            cin >> pri;
            q.push({j, pri});
            pq.push(pri);

        }



        int cnt = 1;

        while(!q.empty()){

            // 높은 우선순위일 때
            if(q.front().second == pq.top()){
                // 찾는 doc이면 중지
                if(q.front().first == M){
                cout << cnt << "\n";
                break;
                }
                q.pop();
                pq.pop();
                cnt++;

            }
            // 낮은 우선순위면 지우고 다시 push
            else{
                q.push(q.front());
                q.pop();
            }

        
        }
    }




    


}