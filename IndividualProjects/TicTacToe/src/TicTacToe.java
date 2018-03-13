/*
Title: Tic-Tac-Toe Game
Created: March 3, 2018
Last Edited: pending...
Author: Zane Walker
Changes:
See Below...
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class TicTacToe implements ActionListener 
{
    
    final String VERSION = "1.0";
    //Setting up ALL the variables
    JFrame window = new JFrame("Tic-Tac-Toe " + VERSION);

    JMenuBar menuMain = new JMenuBar();
    JMenuItem menuNewGame = new JMenuItem("\tNew Game"),
    menuInstruction = new JMenuItem("\tInstructions"),
    menuExit = new JMenuItem("\tExit"),
    menuAbout = new JMenuItem("\tAbout");

    JButton button1v1 = new JButton("Player vs Player"),
    button1vCPU = new JButton("Player vs CPU"),
    buttonBack = new JButton("<--back");
    JButton buttonEmpty[] = new JButton[10];

    JPanel panelNewGame = new JPanel(),
    panelNorth = new JPanel(),
    panelSouth = new JPanel(),
    panelTop = new JPanel(),
    panelBottom = new JPanel(),
    panelPlayingField = new JPanel();
    JLabel lblTitle = new JLabel("Tic-Tac-Toe");
    JTextArea txtMessage = new JTextArea();
    

    final int winCombo[][] = new int[][] 
    {
        {1, 2, 3}, {1, 4, 7}, {1, 5, 9},
        {4, 5, 6}, {2, 5, 8}, {3, 5, 7},
        {7, 8, 9}, {3, 6, 9}
        /*Horizontal Wins*/ /*Vertical Wins*/ /*Diagonal Wins*/
    };
    
    final int X = 412, Y = 268, color = 190;
    boolean inGame = false;
    boolean win = false;
    boolean buttonEmptyClicked = false;
    String message;
    int turn = 1;
    int wonNumber1 = 1, wonNumber2 = 1, wonNumber3 = 1;

    public TicTacToe() 
        {   //Setting game properties and layout and sytle...
            //Setting window properties:
        window.setSize(X, Y);
        window.setLocation(450, 260);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting Panel layouts and properties
        panelNewGame.setLayout(new GridLayout(2, 1, 2, 10));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        panelNorth.setBackground(new Color(color - 20, color - 20, color - 20));
        panelSouth.setBackground(new Color(color, color, color));

        panelTop.setBackground(new Color(color, color, color));
        panelBottom.setBackground(new Color(color, color, color));

        panelTop.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNewGame.setBackground(new Color(color, color, color));

        //Adding menu items to menu bar
        menuMain.add(menuNewGame);
        menuMain.add(menuInstruction);
        menuMain.add(menuAbout);
        menuMain.add(menuExit);//---- > Menu Bar Complete

        //Adding buttons to NewGame panel
        panelNewGame.add(button1v1);
        panelNewGame.add(button1vCPU);

        //Adding Action Listener to all the Buttons and Menu Items
        menuNewGame.addActionListener(this);
        menuExit.addActionListener(this);
        menuInstruction.addActionListener(this);
        menuAbout.addActionListener(this);
        button1v1.addActionListener(this);
        button1vCPU.addActionListener(this);
        buttonBack.addActionListener(this);

        //Setting up the playing field
        panelPlayingField.setLayout(new GridLayout(3, 3, 2, 2));
        panelPlayingField.setBackground(Color.black);
        for(int i =1 ; i <= 9; i++) 
        {
            buttonEmpty[i] = new JButton();
            buttonEmpty[i].setBackground(new Color(220, 220, 220));
            buttonEmpty[i].addActionListener(this);
            panelPlayingField.add(buttonEmpty[i]);
        }
        //Adding everything needed to panelNorth and panelSouth
        panelNorth.add(menuMain);
        panelSouth.add(lblTitle);

        //Adding to window and Showing window
        window.add(panelNorth, BorderLayout.NORTH);
        window.add(panelSouth, BorderLayout.CENTER);
        window.setVisible(true);
    }

//-------------------START OF ACTION PERFORMED CLASS-------------------------//

    public void actionPerformed(ActionEvent click) 
    {
        Object source = click.getSource();
        for(int i = 1; i <= 9; i++) 
        {
            if(source == buttonEmpty[i] && turn  < 10) 
            {
                buttonEmptyClicked = true;
                if(!(turn % 2 == 0))
                    buttonEmpty[i].setText("X");
                else
                    buttonEmpty[i].setText("O");
                    buttonEmpty[i].setEnabled(false);
                    panelPlayingField.requestFocus();
                    turn++;
            }
        }
        if(buttonEmptyClicked) 
        {
            checkWin();
            buttonEmptyClicked = false;
        }
        if(source == menuNewGame) 
        {
            clearPanelSouth();
            panelSouth.setLayout(new GridLayout(2, 1, 2, 5));
            panelTop.add(panelNewGame);
            panelBottom.add(buttonBack);
            panelSouth.add(panelTop);
            panelSouth.add(panelBottom);

        }
        else if(source == button1v1) 
        {
            if(inGame) 
            {
                int option = JOptionPane.showConfirmDialog(null, "If you start a new game," +
                    "your current game will be lost..." + "\n" +
                    "Are you sure you want to continue?",
                    "Quit Game?" ,JOptionPane.YES_NO_OPTION);

                if(option == JOptionPane.YES_OPTION) 
                {
                    inGame = false;
                }
            }
            if(!inGame) 
            {
                buttonEmpty[wonNumber1].setBackground(new Color(220, 220, 220));
                buttonEmpty[wonNumber2].setBackground(new Color(220, 220, 220));
                buttonEmpty[wonNumber3].setBackground(new Color(220, 220, 220));
                turn = 1;
                for(int i=1; i <10; i++) 
                {
                    buttonEmpty[i].setText("");
                    buttonEmpty[i].setEnabled(true);
                }
                win = false;
                showGame();

            }
        }
        else if(source == button1vCPU) 
        {
            JOptionPane.showMessageDialog(null, "Coming Soon!!");
        }
        else if(source == menuExit) 
        {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
            "Exit Game", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION)
                System.exit(0);
        }
        else if(source == menuInstruction || source == menuAbout) 
        {
            clearPanelSouth();
            String message = "";
            txtMessage.setBackground(new Color(color, color, color));
            if(source == menuInstruction) 
            {
                message = "Instructions:\n\n" +
                "Your goal is to be the first player to get 3 X's or O's in a\n" +
                "row. (horizontally, diagonally, or vertically)";
            } 
            else 
            {
                message = "About:\n\n" +
                "Title: Tic-Tac-Toe\n" +
                "Author: Zane Walker\n" +
                "Version: " + VERSION + "\n";
            }
            txtMessage.setEditable(false);
            txtMessage.setText(message);
            panelSouth.setLayout(new GridLayout(2, 1, 2, 5));
            panelTop.add(txtMessage);
            panelBottom.add(buttonBack);
            panelSouth.add(panelTop);
            panelSouth.add(panelBottom);
        }
        else if(source == buttonBack) 
        {
            if(inGame)
                showGame();
            else 
            {
                clearPanelSouth();
                panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
                panelNorth.setVisible(true);
                panelSouth.add(lblTitle);
            }
        }
        panelSouth.setVisible(false);
        panelSouth.setVisible(true);
    }

//-------------------END OF ACTION PERFORMED CLASS-------------------------//

/*
----------------------------------
Start of all the other methods. |
----------------------------------
*/
    
    public void showGame() 
    {   // Shows the Playing Field
        // *IMPORTANT*- Does not start out brand new (meaning just shows what it had before)
        clearPanelSouth();
        inGame = true;
        panelSouth.setLayout(new BorderLayout());
        panelSouth.add(panelPlayingField, BorderLayout.CENTER);
        panelPlayingField.requestFocus();
    }

    public void checkWin() 
    {   // checks if there are 3 symbols in a row vertically, diagonally, or horizontally.
        // then shows a message and disables buttons.
        for(int i = 0; i < 7; i++) 
        {
            if
            (
                !buttonEmpty[winCombo[i][0]].getText().equals("") &&
                buttonEmpty[winCombo[i][0]].getText().equals(buttonEmpty[winCombo[i][1]].getText()) &&
                // if {1 == 2 && 2 == 3}
                buttonEmpty[winCombo[i][1]].getText().equals(buttonEmpty[winCombo[i][2]].getText())
/*
The way this checks the if someone won is:
First: it checks if the buttonEmpty[x] is not equal to an empty string- x being the array number
inside the multi-dementional array winCombo[checks inside each of the 7 sets][the first number]
Secong: it checks if buttonEmpty[x] is equal to buttonEmpty[y]- x being winCombo[each set][the first number]
y being winCombo[each set the same as x][the second number] (So basically checks if the first and
second number in each set is equal to each other)
Third: it checks if buttonEmtpy[y] is eual to buttonEmpty[z]- y being the same y as last time and z being
winCombo[each set as y][the third number]
Conclusion: So basically it checks if it is equal to the buttonEmpty is equal to each set of numbers
*/
            ) 
            {
                win = true;
                wonNumber1 = winCombo[i][0];
                wonNumber2 = winCombo[i][1];
                wonNumber3 = winCombo[i][2];
                buttonEmpty[wonNumber1].setBackground(Color.white);
                buttonEmpty[wonNumber2].setBackground(Color.white);
                buttonEmpty[wonNumber3].setBackground(Color.white);
                break;
            }
        }
        if(win || (!win && turn > 9)) 
        {
            if(win) 
            {
                if(turn % 2 == 0)
                    message = "X has won!";
                else
                    message = "O has won!";
                    win = false;
            } 
            else if(!win && turn > 9) 
            {
                message = "Both players have tied!\nBetter luck next time.";
            }
            JOptionPane.showMessageDialog(null, message);
            for(int i = 1; i <= 9; i++) 
            {
                buttonEmpty[i].setEnabled(false);
            }
        }
    }

    public void clearPanelSouth() 
    {   //Removes all the possible panels
        //that panelSouth, panelTop, panelBottom
        //could have.
        panelSouth.remove(lblTitle);
        panelSouth.remove(panelTop);
        panelSouth.remove(panelBottom);
        panelSouth.remove(panelPlayingField);
        panelTop.remove(panelNewGame);
        panelTop.remove(txtMessage);
        panelBottom.remove(buttonBack);
    }

    public static void main(String[] args) 
    {
        new TicTacToe();// Calling the class construtor.
    }
}
/*
Changes:
1.0- changes below: Stable
0.9- added back button, added comments.
0.8- added dynamic win message.
0.7- added game function- game playable.
0.6- changed menu layout.
0.5- basic functions with menu and nice GUI.
*/
 