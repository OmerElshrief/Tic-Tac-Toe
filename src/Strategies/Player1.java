/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import GUI.Game;
import GUI.panel;
import Objects.XO;
import Observers.DrawObserver;
import Observers.Observer;
import Observers.WinObserver;
import SnapShot.CareTaker;
import SnapShot.Memento;
import State.OState;
import State.XState;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cina marCina
 */
public class Player1 implements Player
{
    private Observer observer;
    private Game game;
    static Player1 player1;
    private CareTaker caretaker;
    private Player1()
            
    {
        caretaker = CareTaker.getInstance();
       game = Game.getInstance();
       observer=WinObserver.GeInstance();
        
    }
    public static Player1 GetInstance()
    {
       if(player1 == null)
           player1 = new Player1();
       return player1;
         
    }

    @Override
    public void Play(panel panel)
    {
       XO XO = new XO();
     
        try
        {
           if(panel.getState().CheckState()=="Empty")
           {  
               panel.getGraphics().drawImage(XO.GetX(), 5, 5, panel);
               panel.setState(XState.GetInstance());
            
            if(game.gameState.checkState()=="2Players")
                game.setPlayer(Player2.GetInstance());
            else
                if(game.gameState.checkState()=="OnePlayerEasy")
                    ComputerAttacker.GetInstance().Play(panel);
            else
                    if(game.gameState.checkState()=="1Player")
                Computer.GetInstance().Play(panel);
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Player1.class.getName()).log(Level.SEVERE, null, ex);
        }
         caretaker.addMemento(new Memento(panel)); 
        observer.Notify();
        Observer drawObserver =  DrawObserver.GeInstance();
        drawObserver.Notify();
        
    }
    public String check()
    {
        return "Player1";
    }
    
}
