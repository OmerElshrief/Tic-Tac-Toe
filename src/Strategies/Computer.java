/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import GUI.Game;
import GUI.panel;
import Objects.XO;
import Observers.Observer;
import Observers.WinObserver;
import State.Empty;
import State.OState;
import State.XState;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Computer implements Player
{
Observer observer;
    private Game game;
    private panel[] p1;
    private static Computer computer;
   

    private Computer()
    { observer = WinObserver.GeInstance();
        game = Game.getInstance();
        p1 = game.getP1();
    }
    
    public static Computer GetInstance()
    {
        if(computer == null)
            computer = new Computer();
        return computer;
    }

    public int Evaluate()
    {
        //Cheking all Rows for win
        for (int i = 0; i < 7; i += 3)
        {
            if (p1[i].getState().CheckState() == p1[i + 1].getState().CheckState() && p1[i + 1].getState().CheckState() == p1[i + 2].getState().CheckState())
            {
                if (p1[i].getState().CheckState() == "O")
                {
                    return +10;
                }
                if (p1[i].getState().CheckState() == "X")
                {
                    return -10;
                }
                return 0;
            }
           
        }
        //checking all Columns for win
        for (int i = 0; i < 3; i++)
        {
            if (p1[i].getState().CheckState() == p1[i + 3].getState().CheckState() && p1[i].getState().CheckState() == p1[i + 6].getState().CheckState())
            {
                if (p1[i].getState().CheckState() == "O")
                {
                    return +10;
                }
                if (p1[i].getState().CheckState() == "X")
                {
                    return -10;
                }
            }
        }

        //checking Diagonals
        if (p1[0].getState().CheckState() == p1[4].getState().CheckState() && p1[0].getState().CheckState() == p1[8].getState().CheckState())
        {
            if (p1[0].getState().CheckState() == "O")
            {
                return +10;
            }
            if (p1[0].getState().CheckState() == "X")
            {
                return -10;
            }
        }

        if (p1[2].getState().CheckState() == p1[4].getState().CheckState() && p1[2].getState().CheckState() == p1[6].getState().CheckState())
        {
            if (p1[2].getState().CheckState() == "O")
            {
                return +10;
            }
            if (p1[2].getState().CheckState() == "X")
            {
                return 0-10;
            }
        }

        return 0;
    }

    //checking if there is anymoves left in the game
    public boolean IsAnymoves()
    {
        for (int i = 0; i < 9; i++)
        {
            if (p1[i].getState().CheckState() == "Empty")
            {
                return true;
            }
        }
        return false;
    }

    public int Attack(int depth, boolean computerTurn)
    {

        int score = Evaluate();
        //if the COmputer has won the game
        if (score == 10)
        {
            return score-depth;
        }
        else
        //if the Computer has lost
        if (score == -10)
        {  // System.err.println("lose" + score);
            return score + depth;
        }
        else
        //draw
        if (IsAnymoves()==false)
        {
            return 0;
        }

        int bestScore = -1000;
        
        if(computerTurn)
        {
            for (int i = 0; i < 9; i++)
        {
            if (p1[i].getState().CheckState() == "Empty")
            {
                p1[i].setState(OState.GetInstance());
                bestScore = Math.max(bestScore, Attack(depth +1,!computerTurn));
                
                p1[i].setState(Empty.GetInstance());

            }

        }
        return bestScore;
        }
        else
        {
          bestScore = 1000;
        for (int i = 0; i < 9; i++)
        {
            if (p1[i].getState().CheckState() == "Empty")
            {
                p1[i].setState(XState.GetInstance());
                bestScore = Math.min(bestScore, Attack(depth+1,!computerTurn));
                
                p1[i].setState(Empty.GetInstance());

            }

        }

        return bestScore;
    }
        

        

    }
    
    public int Defense(int depth)
    {
        int score = Evaluate();
        //if the COmputer has won the game
        if (score == 10)
        {
            return score-depth;
        }
        //if the Computer has lost
        if (score == -10)
        {// System.err.println(score);
             return 10;
        }

        //draw
        if (!IsAnymoves())
        {
            return 0;
        }

        int bestScore = 1000;
        for (int i = 0; i < 9; i++)
        {
            if (p1[i].getState().CheckState() == "Empty")
            {
                p1[i].setState(XState.GetInstance());
                bestScore = Math.min(bestScore, Defense(depth+1));
               // System.err.println(depth);
                p1[i].setState(Empty.GetInstance());

            }

        }

        return bestScore;
    }

    @Override
    public void Play(panel panel) 
    {
        
        XO xo = new XO();
       int bestMove = -1000;
       int moveValue = 0;
       int panelIndex = 0;
      
        for (int i = 0; i < 9; i++)
        {
            if (p1[i].getState().CheckState() == "Empty")
            {
                p1[i].setState(OState.GetInstance());
                moveValue = Attack(0,false);
               
                p1[i].setState(Empty.GetInstance());

            
            if (moveValue > bestMove)
        {
                panelIndex = i;
                bestMove = moveValue;
        }
           
        }
        }
        System.err.println(bestMove);
        try
        {
            
            p1[panelIndex].getGraphics().drawImage(xo.GetO(), 5, 5, p1[panelIndex]);
           
            System.err.println("Computer played");
            p1[panelIndex].setState(OState.GetInstance());
            game.setPlayer(Player1.GetInstance());
            observer.Notify();
        } catch (IOException ex)
        {
            Logger.getLogger(Computer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String check()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
