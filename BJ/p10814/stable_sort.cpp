// 클래스 벡터 특정 변수 기준 정렬
// stable_sort를 사용(compare 함수는 bool 함수, 멤버 함수 x) -> 정답


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


        
};

bool compare(memberInfo a, memberInfo b) {
    return a.showAge() < b.showAge();
}

void memberInfo::printInfo() {
    cout << age << " " << name << "\n";
}



int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
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

    stable_sort(members.begin(), members.end(), compare);
    for(int i=0; i<n; i++){
        members[i].printInfo();
    }



}

