import java.util.*;
class Solution {
    /*
    한명이라도 거리두기안지키면 0
    모든 응시자에 대해 bfs로 거리가 2인 점을 다 탐색하기(마지막1명은 안해도되긴하는데..)
    맨해튼거리2 => 4방향으로 2씩이거나 대각선
    */
    // 0~3: 무조건안됨, 
    // 4~7(2칸): 0~3에 파티션있으면 괜찮음,
    // 8~11(대각선): 양쪽에 파티션있으면 괜찮음
    
    static int[] moveX = {0,0,-1,1, 0,0,-2,2, 1,1,-1,-1};
    static int[] moveY = {-1,1,0,0, -2,2,0,0, 1,-1,1,-1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            answer[i] = bfs(places[i]);
        }
        return answer;
    }
    
    
    public int bfs(String[] strs){
        char[][] map = new char[5][5];
        for(int i=0; i<5; i++){
            map[i] = strs[i].toCharArray();
        }
            
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[i][j] == 'P'){
                    // System.out.println("현재위치: " + j + " " + i);
                    for(int d=0; d<12; d++){
                        int nx = j+moveX[d];
                        int ny = i+moveY[d];
                        if(nx<0 || ny<0 || nx>=5 || ny>=5){
                            continue;
                        }
                        
                        if(map[ny][nx] == 'P'){
                            
                            
                            // 1칸씩 붙어있으면
                            if(d<4){
                                return 0;
                            }
                                
                            // 2칸씩이면 ? 
                            if(d<8){
                                int cx = j+moveX[d-4];
                                int cy = i+moveY[d-4];
                                if(map[cy][cx] != 'X'){
                                    // System.out.println("현재위치는 : " + nx+  " " + ny+ "맨해튼우ㅣ배 : " + cx + " " + cy);
                                    return 0;
                                } 
                                continue;
                            } 
                            
                            // 8:1,3 9:0,3 10:1,2 11:0,2
                            int cx1 = 0;
                            int cx2 = 0;
                            int cy1 = 0;
                            int cy2 = 0;
                            if(d==8){
                                cx1 = j+moveX[1];
                                cx2 = j+moveX[3];
                                cy1 = i+moveY[1];
                                cy2 = i+moveY[3];
                            }else if(d==9){
                                cx1 = j+moveX[0];
                                cx2 = j+moveX[3];
                                cy1 = i+moveY[0];
                                cy2 = i+moveY[3];
                            }else if(d==10){
                                cx1 = j+moveX[1];
                                cx2 = j+moveX[2];
                                cy1 = i+moveY[1];
                                cy2 = i+moveY[2];
                            }else if(d==11){
                                cx1 = j+moveX[0];
                                cx2 = j+moveX[2];
                                cy1 = i+moveY[0];
                                cy2 = i+moveY[2];
                            }
                            
                            if(cx1<0 || cy1<0 || cx1>=5 || cy1>=5
                              || cx2<0 || cy2<0 || cx2>=5 || cy2>=5){
                                continue;
                                }
                            if(map[cy1][cx1] != 'X'){
                                // System.out.println("방향: " + d + "현재위치는 : " + nx+  " " + ny+ "맨해튼우ㅣ배 : " + cx1 + " " + cy1);

                                return 0;
                            } 
                            if(map[cy2][cx2] != 'X'){
                                // System.out.println("방향: " + d + "현재위치는 : " + nx+  " " + ny+ "맨해튼우ㅣ배 : " + cx2 + " " + cy2);
                                return 0;
                            } 

                            
                        }
                        
                    }
                }
            }
        }
        
        return 1;
    }
}