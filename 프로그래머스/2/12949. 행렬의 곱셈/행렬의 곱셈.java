

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int common = arr1[0].length;
        int[][] answer= new int[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                // 한개의 원소 구하기
                for(int k=0; k<common; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}