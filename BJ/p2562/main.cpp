#include <iostream>

int main() {
    int max, n;
    int max_idx = 1;
    std::cin >> n;
    max = n;

    for (int i=2; i<=9; i++){
        std::cin >> n;
        if(n>max){
            max = n;
            max_idx = i;
        } 
    }

    std::cout << max << '\n' << max_idx << std::endl;

}
