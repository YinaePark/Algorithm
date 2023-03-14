#include <iostream>
#include <string>
#include <set>
#include <algorithm>


using namespace std;

set<int> makeSubtraction(set<int> a, set<int> b){
    set<int> sub;
    for(auto iter = a.begin(); iter != a.end(); iter++){
        int num = *iter;
        if(b.find(num) == b.end()){
            sub.insert(num);
        }
    }
    return sub;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b;
    cin >> a >> b;
    set<int> A, B, subAB, subBA, symmDif;

    for(int i=0; i<a; i++){
        int num;
        cin >> num;
        A.insert(num);
    }
        for(int i=0; i<b; i++){
        int num;
        cin >> num;
        B.insert(num);
    }

    subAB = makeSubtraction(A, B);
    subBA = makeSubtraction(B, A);
    set_union(subAB.begin(), subAB.end(), subBA.begin(), subBA.end(), inserter(symmDif, symmDif.begin()));

    cout << symmDif.size() << "\n";

}
