package Tic_Tac_Toe_Game;

 class TicTacToe_
{
    char[][] board;

    public TicTacToe_()
    {
        board = new char[3][3];
        intialiseBoard();
    }
    void intialiseBoard()
    {
        for (int i=0; i< board.length; i++)
        {
            for (int j=0; j<board[i].length; j++)
            {
                board[i][j] = ' ';
            }
        }
    }
    void displayBoard()
    {
        System.out.println("-------------");
        for (int i=0; i< board.length; i++)
        {
            System.out.print("| ");
            for (int j=0; j<board[i].length; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    void displayMark(int row, int col, char mark)
    {
        if (row>=0 && row<=2 && col>=0 && col<=2)
        {
            board[row][col] = mark;
        }
        else
        {
            System.out.println("Invalid Position");
        }
    }
    boolean CheckColWin()
    {
        for (int j=0;j<=2;j++)
        {
            if ( board[0][j] != ' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
            {
                return true;
            }
        }
        return false;
    }
    boolean CheckRowWin()
    {
        for (int i=0;i<=2;i++)
        {
            if (board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
            {
                return true;
            }
        }
        return false;
    }
    boolean CheckDiaWin()
    {
        if(board[0][0] != ' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]==board[1][1] && board[1][1]==board[2][0])
        {
            return true;
        }
        return false;
    }
}

public class Launch_Game {
    public static void main(String[] args)
    {
        TicTacToe_ t = new TicTacToe_();
        t.displayBoard();
        t.displayMark(0,0,'X');
        t.displayBoard();
    }
}
