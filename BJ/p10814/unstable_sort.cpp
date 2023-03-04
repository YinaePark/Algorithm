// 클래스 벡터 특정 변수 기준 정렬
// < operator와 sort를 사용함 > 틀린 답으로 나옴
// sort: 퀵 정렬, 속도는 빠르나 순서 보장 x
// stable_sort: 머지 정렬, 순서 보장 o


#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class memberInfo {
    private:
        int age;
        string name;
    public: 
        memberInfo(int a, string n) {age = a; name = n;}
        int showAge() const {
            return age;
        }
        void printInfo();

        bool operator < (memberInfo &memberinfo){
            return this->age < memberinfo.age;
        }
        
};

void memberInfo::printInfo() {
    cout << age << " " << name << "\n";
}



int main() {
    int n;
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;

    vector<memberInfo> members;
    
    for(int i=0; i<n; i++){
        int x;
        cin >> x;
        string y;
        cin>> y;

        memberInfo member(x, y);
        members.push_back(member);

    }

    stable_sort(members.begin(), members.end());
    for(int i=0; i<n; i++){
        members[i].printInfo();
    }



}

/* 1)
 * age, sorted_age를 만들어서 sorted_age에 해당하는 idx로 name에 접근
 * -> n^2
 *
 * 2)
 * class 이용 후 정렬
 * 
 * 3)
 * vector<pair<int, int>>
 */