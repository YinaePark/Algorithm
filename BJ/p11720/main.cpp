#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    int sum=0;
    string numbers;
    cin >> n >> numbers;

    for(size_t i=0; i<size_t(n); i++){
        sum += numbers[i]-48;

    }
    
    cout << sum << endl;
}

/* string의 한 글자에 인덱스로 접근하면 char형
 * char형 -> int로 변환하려면 아스키코드 값을 빼주면 됨
 */


/* 처음 접근 방식 *
 * string 전체를 int로 변환한 후
 * 10씩 나눠가며 자리수를 더함 -> int 범위를 뛰어넘음
 * 변수를 unsigned int로 설정할 경우 범위 안 넘어서 
 * 이 방식으로 해결 가능
 */
