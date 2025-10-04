#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int alp, int cop, vector<vector<int>> problems) {
    int answer = 0;
    int maxCo=cop, maxAl=alp;
    for (int i=0; i<problems.size(); i++) //모든 문제를 풀기 위한 알고력 코딩력
    {
        maxAl=max(maxAl,problems[i][0]);
        maxCo=max(maxCo,problems[i][1]);        
    }
    vector<vector<int>>DP(maxAl+1,vector<int>(maxCo+1,30000));
    DP[alp][cop]=0; // 초기 위치 
    for (int i=alp; i<=maxAl; i++)
    {
        for (int j=cop; j<=maxCo; j++)
        {
            // co, al +1하는 경우
            if (i<maxAl)
            {
                DP[i+1][j]=min(DP[i+1][j],DP[i][j]+1);                
            }
            if (j<maxCo)
            {
                DP[i][j+1]=min(DP[i][j+1],DP[i][j]+1);                
            }
            for (int k=0; k<problems.size(); k++)
            {
                if (i>=problems[k][0] && j>=problems[k][1])
                {
                    int pAl=min(maxAl,i+problems[k][2]);
                    int pCo=min(maxCo,j+problems[k][3]);
                    DP[pAl][pCo]=min(DP[pAl][pCo],DP[i][j]+problems[k][4]);
                }                
            }      
        }
    }
    return DP[maxAl][maxCo];
}