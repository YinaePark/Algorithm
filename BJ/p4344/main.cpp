#include <iostream>
#include <stdio.h>
using namespace std;

int main() {
    int c, n;
    double score_avg;
    int score_sum = 0;
    int great_student = 0;

    cin >> c;
    for(int i=0; i<c; i++){
        score_sum = 0;
        great_student = 0;
        cin >> n;
        int scores[n];
        for(int j=0; j<n; j++){
            cin >> scores[j];
            score_sum += scores[j];
        }
        score_avg = score_sum / n;
        for(int j=0; j<n; j++){
            if(score_avg < scores[j]){
                great_student++;
            }
        }
        printf("%.3f%%\n", double(great_student)/n*100);

    }


}
