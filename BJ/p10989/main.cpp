#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    vector<int> arr;

    int countArr[10001];
    fill_n(countArr, 10001, 0);


    cin >> n;
    for(int i=0; i<n; i++){
        int num;
        cin >> num;
        countArr[num] += 1;
    }

    for(size_t i=0; i<10001; i++){
        if(countArr[i] != 0){
            for(int j=0; j<countArr[i]; j++){
                cout << i << "\n";
            }
        }

    }

    


}
