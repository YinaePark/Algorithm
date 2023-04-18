#include <iostream>
#include <deque>
#include <set>
#include <vector>
#include <algorithm>

using namespace std;


int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    deque<int> dq;
    int N, M;
    int cnt = 0;

    cin >> N >> M;

    for(int i=1; i<=N; i++){
        dq.push_back(i);
    }

    for(int i=0; i<M; i++){
        int target, targetIdx;
        int dqLen = dq.size();

        cin >> target;

        
        // targetIdx 구하기
        for(int k=0; k<dqLen; k++){
            if(dq[k] == target){
                targetIdx = k;
                break;
            }
        }

        int rightShift = dqLen-targetIdx;
        int leftShift = targetIdx;

        // right 연산이 더 빠름
        if(leftShift > rightShift){
            for(int j=0; j<rightShift; j++){
                dq.push_front(dq.back());
                dq.pop_back();
            }
            cnt += rightShift;
            dq.pop_front();
        }
        // left 연산이 더 빠름
        else{
            for(int j=0; j<leftShift; j++){
                dq.push_back(dq.front());
                dq.pop_front();
            }
            cnt += leftShift;
            dq.pop_front();


        }

        
    }
    cout << cnt << '\n';

 
}