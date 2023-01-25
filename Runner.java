package Tic_Tac_Toe_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class TicTacToe extends JFrame implements ActionListener
{
    JLabel heading,clockLabel;
    Font font = new Font("",Font.BOLD,40);
    JPanel mainPanel;

    JButton[] btns = new JButton[9];


    // game instance variable

    int[] gameChances = {2,2,2,2,2,2,2,2,2};
    int activePlayer = 0;

    int wps[][] = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };
    int winner = 2;

    boolean gameOver = false;

    TicTacToe()
    {
        System.out.println("Running.....");
        setTitle("My tic tac toe game");
        setLocation(500,100);
        setSize(650,650);
        ImageIcon icon = new ImageIcon("image/a.png");
        setIconImage(icon.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        setVisible(true);
    }

    private void createGUI()
    {
        this.getContentPane().setBackground(Color.decode("#d4b159"));
        this.setLayout(new BorderLayout());

        //creating heading on North
        heading = new JLabel("Tic Tac Toe");
        heading.setFont(font);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.white);

        this.add(heading,BorderLayout.NORTH);

        //creating object of JLabel for Clock
        clockLabel = new JLabel("Clock");
        clockLabel.setFont(font);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setForeground(Color.white);

        this.add(clockLabel,BorderLayout.SOUTH);

        Thread t = new Thread()
        {
            public void run()
            {
                try
                {
                    while (true)
                    {
                        String dateTime = new Date().toLocaleString();

                        clockLabel.setText(dateTime);

                        Thread.sleep(1000);
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        t.start();

        // creating main Panel
        mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(3,3));

        for (int i=1;i<=9;i++)
        {
            JButton btn = new JButton();
           // btn.setIcon(new ImageIcon("src/image/o.png"));
            btn.setBackground(Color.decode("#dea516"));
            btn.setFont(font);
            mainPanel.add(btn);
            btns[i-1] = btn;
            btn.addActionListener(this);
            btn.setName(String.valueOf(i-1));
        }
        this.add(mainPanel,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton currentButton = (JButton) e.getSource();

        String nameStr = currentButton.getName();

        int name = Integer.parseInt(nameStr.trim());

        if (gameOver)
        {
            JOptionPane.showMessageDialog(this,"Game Over..");
            return;

        }

        if (gameChances[name]==2)
        {
            if (activePlayer==1)
            {
                currentButton.setIcon(new ImageIcon("image/1.png"));

                gameChances[name] = activePlayer;
                activePlayer=0;
            }else
            {
                currentButton.setIcon(new ImageIcon("image/o.png"));

                gameChances[name] = activePlayer;
                 activePlayer = 1;
            }

            // find the Winner.....

            for (int[] temp: wps)
            {
                if ((gameChances[temp[0]] == gameChances[temp[1]]) && (gameChances[temp[1]] == gameChances[temp[2]]) && (gameChances[temp[2]] != 2))
                {
                    winner = gameChances[temp[0]];
                    gameOver = true;
                    JOptionPane.showMessageDialog(null,"Player " +winner+ "has won the game...");
                    int i = JOptionPane.showConfirmDialog(this,"do you want to play more??");
                    if (i==0)
                    {
                        this.setVisible(false);
                        new TicTacToe();
                    } else if (i==1)
                    {
                        System.exit(34256 );
                    }else
                    {

                    }

                    System.out.println(i);
                    break;
                }
            }
            // draw logic....

            int c =0;

            for (int x:gameChances)
            {
                if (x==2)
                {
                    c++;
                    break;
                }
            }
            if (c==0 && gameOver==false)
            {
                JOptionPane.showMessageDialog(null,"Its draw...");

                int i = JOptionPane.showConfirmDialog(this,"Play more??");
                if (i==0)
                {
                    this.setVisible(false);

                    new TicTacToe();
                } else if (i==1) {
                    System.exit(2313);
                }else {

                }
                gameOver = true;
            }
        }else
        {
            JOptionPane.showMessageDialog(this,"Position already Occupied...");
        }
    }
}
public class Runner
{
    public static void main(String[] args)
    {
        TicTacToe tic = new TicTacToe();
    }
}
