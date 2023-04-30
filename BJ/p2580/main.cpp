#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int board[9][9];
int blankCoord[81];
int blankNum = 0;
bool endPoint = false;

bool possible(int num, int cursor){
    int x = cursor % 9;
    int y = cursor / 9;

    for(int i=0; i<9; i++){
        if(board[y][i] == num || board[i][x] == num){
            return false;  

        }
    }

    int startX = x/3 * 3;
    int startY = y/3 * 3;
    
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            if(board[startY+i][startX+j] == num){
                return false;
            } 
        }
    }
    return true;
}

void printBoard(){
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            cout << board[i][j] << " ";
        }
        cout << '\n';
    }

}

void sudoku(int depth){
    if(depth == blankNum){
        endPoint = true;
        return;
    } 

    int cursor = blankCoord[depth];
    int x = cursor % 9;
    int y = cursor / 9;

    for(int i=1; i<10; i++){
        if(possible(i,cursor)){
            board[y][x] = i;
            sudoku(depth+1);
            if(endPoint) return;
        }
        
        board[y][x] = 0;
    }

    
}

void test(){
    board[0][0] = 123;
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);


    int num;
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            cin >> num;
            board[i][j] = num;

            if(num == 0){
                blankCoord[blankNum] = i*9 + j;
                blankNum++;
            }
        }
    }

    sudoku(0);
    printBoard();
    
}