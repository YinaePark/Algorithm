#include <iostream>
#include <string>

using namespace std;

bool checkGroupWord(string word){
    bool alphabets[26] = {false,};
    int idx = word[0] - 97;
    alphabets[idx] = true;

    for(size_t i=1; i<word.length(); i++){
        if(word[i] != word[i-1]){
            idx = word[i] - 97;
            if(alphabets[idx]){
                return false;
            }
            else{
                alphabets[idx] = true;
            }
        }
        

    }
    return true;
}

int main() {
    string word;
    int n;
    int cnt = 0;

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> word;
        if(checkGroupWord(word)){
            cnt++;
        } 
    }
    cout << cnt << endl;

}