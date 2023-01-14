#include <iostream>
#include <string>
#include <algorithm> // std::fill

using namespace std;

int main() {

    int alphabets[26];
    int idx;
    string word;
    cin >> word;
    fill(alphabets, alphabets+26, -1);

    for(size_t i=0; i<word.size(); i++){
        idx = word[i];
        if(alphabets[idx-97] < 0){
            alphabets[idx-97] = i;
        }
    }
    
    for(int i=0; i<26; i++){
        cout << alphabets[i] << " ";
    }

}
