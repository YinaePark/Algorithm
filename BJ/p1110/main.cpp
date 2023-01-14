#include <iostream>

int main() {
    int n, old_n, tmp_n;
    int new_n = -1;
    int cnt=0;

    std::cin >> n;
    old_n = n;

    while(n != new_n){
        if(old_n < 10) tmp_n = old_n;
        else{
           tmp_n = old_n / 10 + old_n % 10;
        }
        new_n = (old_n%10)*10 + tmp_n%10;
        old_n = new_n;
        cnt++;
    }
    std::cout << cnt << std::endl;
}
