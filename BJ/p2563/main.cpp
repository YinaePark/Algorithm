#include <iostream>

using namespace std;

int main() {
    bool paper[100][100] = {false};
    int n, width, height;
    int cnt = 0;

    cin >> n;
    for(int k=0; k<n; k++){
        cin >> width >> height;
        for(int i=width; i<width+10; i++){
            for(int j=height; j<height+10; j++){
                paper[i][j] = true;
            }
        }
    }


    for(int i=0; i<100; i++){
        for(int j=0; j<100; j++){
            if(paper[i][j]) cnt++;
        }
    }

    cout << cnt << endl;

}