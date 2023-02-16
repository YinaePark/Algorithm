#include <iostream>

using namespace std;

int main() {
    int n, _3kgWeight, _5kgWeight, _3kgCnt, _5kgCnt;
    int totalCnt = -1;
    cin >> n;

    _5kgCnt = n/5;    

    while(_5kgCnt >= 0){
        _5kgWeight = _5kgCnt * 5;
        _3kgWeight = n - _5kgWeight;
        if(_3kgWeight % 3 == 0){
            _3kgCnt = _3kgWeight / 3;
            totalCnt = _3kgCnt + _5kgCnt;
            break;
        }
        _5kgCnt--;

    }

    cout << totalCnt << endl;

}

