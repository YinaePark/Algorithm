#include <iostream>
#include <deque>
#include <sstream>
#include <string>

using namespace std;


int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;

    cin >> T;
    for(int i=0; i<T; i++){
        string inst;
        int n;
        string arrStr;
        deque<int> dq;

        cin >> inst >> n >> arrStr;

        // 대괄호 자르기
        arrStr = arrStr.substr(1, arrStr.length()-2);

        // , 기준으로 숫자 슬라이싱해서 dq에 push
        string strBuf;
        istringstream iss(arrStr);
        while(getline(iss, strBuf, ',')){
            int intBuf = stoi(strBuf);
            dq.push_back(intBuf);
        }

        // 명령어 해석
        bool isForward = true;
        bool isError = false;
        int instNum = inst.length();

    
        for(int j=0; j<instNum; j++){
            if(inst[j] == 'R'){
                isForward = !isForward;
            }
            else if(inst[j] == 'D'){
                if(dq.empty()){
                    cout << "error" << '\n';
                    isError = true;
                    break;
                }
                if(isForward){
                    dq.pop_front();
                } 
                else{
                    dq.pop_back();
                }
            }
        }

        if(!isError){
            cout << "[";
            if(!dq.empty()){
                if(isForward){
                    for(long unsigned int j=0; j<dq.size() - 1; j++){
                        cout << dq[j] << ",";
                    }
                    cout << dq[dq.size()-1];
                }
                else{
                    for(long unsigned int j=dq.size() - 1; j>0; j--){
                        cout << dq[j] << ",";
                    }
                    cout << dq[0];

                }

            }
            

            cout << "]" << '\n';

        }

    }

    
}