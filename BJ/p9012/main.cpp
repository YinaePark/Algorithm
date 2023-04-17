#include <iostream>
#include <stack>
#include <string>


using namespace std;


void VPS(string str, int n){
    stack<bool> stack;
    for(int i=0; i<n; i++){
        if(str[i] == '('){
            stack.push(true);
        }
        else if(str[i] == ')'){
            if(stack.empty()){
                cout << "NO" << "\n";
                return;
            }
            stack.pop();
        }
    }
    if(stack.empty()){
        cout << "YES" << "\n";
        return;
    } 
    cout << "NO" << "\n";
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    

    int T;
    cin >> T;

    for(int i=0; i<T; i++){
        string str;
        cin >> str;
        VPS(str, str.length());
    }


}
