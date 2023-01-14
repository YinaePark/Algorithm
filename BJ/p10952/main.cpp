#include <iostream>

int main() {
    int a, b;
    while(true){
        std::cin >> a >> b;
        if(a==0 && b==0)
            break;
        std::cout << a+b << std::endl;
    }
}