#include <iostream>

int main() {
    int a, b;
    while(std::cin >> a >> b){
        std::cout << a+b << std::endl;
    }
}


/*

    while(true){
        std::cin >> a >> b;
        if(std::cin.eof()) break;
        std::cout << a+b << std::endl;
    }

*/