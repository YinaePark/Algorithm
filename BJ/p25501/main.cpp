#include <iostream>
#include <string>
#include <algorithm>
#include <cstring>

using namespace std;


int recursion(const char *s, int l, int r, int *cnt){
    *cnt = *cnt + 1;

    if(l >= r) return 1;
    else if(s[l] != s[r]) return 0;
    else return recursion(s, l+1, r-1, cnt);
    
    
}

int isPalindrome(const char *s, int *cnt){
    return recursion(s, 0, strlen(s)-1, cnt);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    for(int i=0; i<n; i++){
        string str;
        int cnt = 0;
        cin >> str;
        int ispali = isPalindrome(str.c_str(), &cnt);
        cout << ispali << " " << cnt << "\n";
    }

    

}
