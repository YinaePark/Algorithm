#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int n, x;
    vector<int> xs;
    vector<int> sortedXs;

    cin >> n;
    
    for(int i=0; i<n; i++){
        cin >> x;
        xs.push_back(x);
        sortedXs.push_back(x);
    }

    //copy(xs.begin(), xs.end(), sortedXs.begin());
    sort(sortedXs.begin(), sortedXs.end());

    // 중복제거: n + log n
    sortedXs.erase(unique(sortedXs.begin(), sortedXs.end()), sortedXs.end());



    for(int i=0; i<n; i++){
        cout << lower_bound(sortedXs.begin(), sortedXs.end(), xs[i]) - sortedXs.begin() << " ";
    }
    cout << endl;

}


    //중복제거: n * n
    // int prevX = sortedXs[0];
    // int idx = n;
    // for(int i=1; i<idx; i++){
    //     if(prevX == sortedXs[i]){

    //         sortedXs.erase(sortedXs.begin() + i);
    //         idx--;
    //         i--;
    //     }
    //     else
    //         prevX = sortedXs[i];
    // }