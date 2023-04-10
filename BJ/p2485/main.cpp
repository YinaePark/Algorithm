#include <iostream>
#include <vector>

using namespace std;

int gcd(int a, int b){
    int large = a > b ? a : b;
    int small = a < b ? a : b;

    if(!small) return large;
    else return gcd(small, large%small);
}

int lcm(int a, int b){
    return a * b / gcd(a,b);
}


int multipleGcd(vector<int> arr, int n){
    int num1 = arr[0];
    int gcdNum;
    for(int i=1; i<n; i++){
        gcdNum = gcd(num1, arr[i]);
        num1 = gcdNum;
    }
    return num1;
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int num, coord, firstCoord;
    vector<int> colonnade;
    cin >> num;
    cin >> firstCoord;

    for(int i=1; i<num; i++){
        cin >> coord;
        colonnade.push_back(coord - firstCoord);
    }

    int gcdNum = multipleGcd(colonnade, num-1);

    cout << colonnade[num-2]/gcdNum - num + 1 << "\n";

}
