#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {

    string text;
    size_t maxLength = 0;
    char texts[5][15];
    fill(&texts[0][0], &texts[4][15], 0);

    for(int i=0; i<5; i++){
        cin >> text;
        for(size_t j=0; j<text.length(); j++){
            texts[i][j] = text[j];
        }
        if(text.length() > maxLength){
            maxLength = text.length();
        }
    }

    for(size_t j=0; j<maxLength; j++){
        for(int i=0; i<5; i++){
            if(texts[i][j] != 0){
                cout << texts[i][j];
            }
        }
    }
    cout << endl;

}