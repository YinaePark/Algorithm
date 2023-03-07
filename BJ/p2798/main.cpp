#include <iostream>
#include <vector>
#include <algorithm>
#include <limits.h>

using namespace std;

int blackJack(int m, int n, vector<int> cards){
    int closestSum = 0;
    int closestDist = INT_MAX;
    int cardNum1 = n-3;
    int cardNum2 = n-2;
    int cardNum3 = n-1;

    while(true){
        int sum = cards[cardNum1] + cards[cardNum2] + cards[cardNum3];
        
        if((m-sum) < closestDist && (m-sum)>=0){
            closestDist = m-sum;
            closestSum = sum;
        }
        if(cardNum1 > 0) cardNum1--;
        else if(cardNum2 > 1){
            cardNum2--;
            cardNum1 = cardNum2 - 1;
        }
        else if(cardNum3 > 2){
            cardNum3--;
            cardNum2 = cardNum3 - 1;
            cardNum1 = cardNum2 - 1;

        }
        else break;
    }
    return closestSum;
}

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> cards;

    for(int i=0; i<n; i++){
        int card;
        cin >> card;
        cards.push_back(card);
    }
    sort(cards.begin(), cards.end());


    cout << blackJack(m, n, cards) << endl;
    
}
