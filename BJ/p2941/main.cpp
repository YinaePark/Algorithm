#include <iostream>
#include <string>

using namespace std;

int main() {
    string word;
    int count = 0;
    cin >> word;

    for(size_t i=0; i<word.length(); i++){
        if(word[i] == '-')  continue;
        else if(i != 0 && word[i] == 'j' && (word[i-1] == 'l' || word[i-1] == 'n')) continue;
        else if(word[i] == '='){
            if(i > 1 && word[i-1]=='z' && word[i-2]=='d') count -= 2;
            else continue;
        }
        count++;
    }
    cout << count << endl;

}
