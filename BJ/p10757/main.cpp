#include <iostream>
#include <string>
#include <algorithm>

using namespace std;


int main() {
    string a, b, result;
    int a_num, b_num;
    int sum_num = 0;

    cin >> a >> b;
    if(b.length() > a.length()){
        string tmp = a;
        a = b;
        b = tmp;        
    }
    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    for(size_t i=0; i<a.length(); i++){
        a_num = a[i] - 48;
        b_num = i<b.length() ? b[i] - 48 : 0;

        sum_num += a_num + b_num;
        result = result.append(to_string(sum_num%10));

        if(sum_num >= 10){
            sum_num = 1;
        }
        else{
            sum_num = 0;
        }
    }
    if(sum_num == 1) result = result.append("1");

    reverse(result.begin(), result.end());
    cout << result << endl;


}
