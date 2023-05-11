#include <iostream>


using namespace std;

int fibArr[41];
int dynamicCnt = 0;
int recurCnt = 0;

int recursiveFib(int n){
    if(n==1 || n==2){
        recurCnt++;
        return 1;
    } 
    else return recursiveFib(n-1) + recursiveFib(n-2);
}


int dynamicFib(int n){
    fibArr[1] = fibArr[2] = 1;
    for(int i=3; i<=n; i++){
        fibArr[i] = fibArr[i-1] + fibArr[i-2];
        dynamicCnt++;
    }
    return fibArr[n];
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    dynamicFib(n);
    recursiveFib(n);
    cout << recurCnt << " " << dynamicCnt << "\n";
    
}