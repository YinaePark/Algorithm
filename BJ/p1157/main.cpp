#include <iostream>
#include <stdio.h>
#include <string>

using namespace std;

int main() {
    string word;
    int alphabets[26] = {};
    int alphabets_idx;
    int max_idx=0;
    bool max_overlap=false;

    cin >> word;

    for(size_t i=0; i<word.size(); i++){
        if(word[i] >= 97){
            alphabets_idx = word[i] - 97;
        }
        else{
            alphabets_idx = word[i] - 65;
        }
        alphabets[alphabets_idx]++;
        // printf("IDX is..... %d %d\n", word[i], alphabets_idx);
    }
    for(int i=0; i<26; i++){
        if(alphabets[i] == alphabets[max_idx]){
            max_overlap=true;
        }
        else if(alphabets[i] > alphabets[max_idx]){
            max_idx = i;
            max_overlap=false;
        }
    }

    if(max_overlap==true){
        cout << "?" << endl;
    }
    else{
        printf("%c\n", max_idx+65);
    }

}