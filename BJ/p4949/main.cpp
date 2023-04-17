#include <iostream>
#include <stack>
#include <string>


using namespace std;


void VPS(string str){
    

    int len = str.length();
    stack<int> stack;

    for(int i=0; i<len; i++){
        if(str[i] == '('){
            stack.push(0);
        }
        else if(str[i] == ')'){
            if(stack.empty() || stack.top() == 1){
                cout << "no" << "\n";
                return;
            }
            stack.pop();
        }
        else if(str[i] == '['){
            stack.push(1);
        }
        else if(str[i] == ']'){
            if(stack.empty() || stack.top() == 0){
                cout << "no" << "\n";
                return;
            }
            stack.pop();
        } 

    }

    if(stack.empty()){
        cout << "yes" << "\n";
        return;
    } 
    cout << "no" << "\n";
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
    string str;



    while(str.compare(".") != 0){

        getline(cin, str);
        if (str.compare(".") == 0) break;
        VPS(str);


    }


}
