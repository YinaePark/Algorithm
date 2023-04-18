#include <iostream>
#include <cmath>

using namespace std;


void cantor(int n){
    if(n==0){
        cout << "-";
        return;
    }


    cantor(n-1);
    for(int i=0; i<pow(3, n-1); i++){
        cout << " ";
    }
    cantor(n-1);
}


int main() {
 
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    while(cin >> n){
        cantor(n);
        cout << "\n";
    }


}