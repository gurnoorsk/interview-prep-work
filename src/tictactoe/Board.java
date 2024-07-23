package tictactoe;

public interface Board {
    public void move(int x,int y,Object marker);
    public int [][] getBoard();

    public void printState();

    public void evaluateBoard();


}
