#include <iostream>
#include <string>

using namespace std;

int alphabetToSecond(char c){
    int seconds;

    switch(c){
        case 65:
        case 66:
        case 67:
            seconds = 3;
            break;
        case 68:
        case 69:
        case 70:
            seconds = 4;
            break;
        case 71:
        case 72:
        case 73:
            seconds = 5;
            break;
        case 74:
        case 75:
        case 76:
            seconds = 6;
            break;
        case 77:
        case 78:
        case 79:
            seconds = 7;
            break;
        case 80:
        case 81:
        case 82:
        case 83:
            seconds = 8;
            break;
        case 84:
        case 85:
        case 86:
            seconds = 9;
            break;
        case 87:
        case 88:
        case 89:
        case 90:
            seconds = 10;
            break;

    }
    return seconds;
}

int main() {
    string word;
    int totalTime = 0;
    cin >> word;
    

    for(size_t i=0; i<word.length(); i++){
        totalTime += alphabetToSecond(word[i]);
    }
    cout << totalTime << endl;
}
