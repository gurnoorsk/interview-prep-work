package tictactoe;

import java.util.List;
import java.util.Random;

public class TicTacToe implements Game,Board {

    List<User> users;

    int [][] board;
    int x;
    int y;

    int id;


    public TicTacToe(int x,int y,List<User> users){
        this.board = new int [x][y];
        this.x = x;
        this.y = y;
        this.id = new Random(1000).nextInt();
        this.users = users;
    }

    @Override
    public void move(int x, int y,Object marker) {
        this.board[x][y] = Integer.valueOf(marker.toString());
    }

    @Override
    public int[][] getBoard() {
        return  board;
    }


    @Override
    public void printState() {

    }

    @Override
    public void evaluateBoard() {
        // write check logic
        for(int i=0;i<x;i++){

            int marker = board[0][i];
            // check down
            int count=0;

            for(int j=0;j<y;j++){
                if(board[j][i] == marker){
                    count ++;

                }else{
                    break;
                }
            }

            if(count == x){
                System.out.println("Game over. User wins");
                break;
            }

            count = 0;

            if(i==0 || i==x-1){
                // check diagonal
                if(i==0){
                    for(int j=i;j<x;j++){
                        if(board[j][j]==marker){
                            System.out.println("Game over. User wins");
                        }
                    }
                }else{
                    for(int j=x-1;j>=0;j--){

                    }
                }

            }
        }
    }


    @Override
    public Integer getId() {
        return id;
    }
}
