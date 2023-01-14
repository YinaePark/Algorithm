#include <iostream>
using namespace std;

int main() {
    int n;
    int score = 0;
    int partial_sq = 0;
    string line;

    cin >> n;
    getline(cin, line);

    for(int i=0; i<n; i++){
        getline(cin, line);
        for(size_t j=0; j<line.size(); j++){
            if(line[j] == 'O'){
                partial_sq++;
                score += partial_sq;
            }
            else{
                partial_sq = 0;
            } 
        }
        cout << score << endl;
        score = 0;
        partial_sq = 0;

    }  

}


