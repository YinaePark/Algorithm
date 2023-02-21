#include <iostream>

// memset 쓰고 싶은데 include path 에러 생김

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

// n*m array allocation
    int** sumArr = new int*[n];
    for(int i=0; i<n; i++){
        sumArr[i] = new int[m];
    }
// n*m array initialization
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            sumArr[i][j] = 0;
        }
    }

    int elem;

// input A, B
    for(int k=0; k<2; k++){    
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cin >> elem;
                sumArr[i][j] += elem;
            }
        }
    }

// print A+B   
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cout << sumArr[i][j] << " ";
        }
        cout << endl;
    }


// n*m array deallocation
    for(int i=0; i<n; i++){
        delete[] sumArr[i];
    }
    delete[] sumArr;
}
