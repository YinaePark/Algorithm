#include <iostream>

using namespace std;

int fibonacci(int n){
    if(n==0) return 0;
    if(n==1) return 1;
    return fibonacci(n-1) + fibonacci(n-2);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    cout << fibonacci(n) << "\n";

}
