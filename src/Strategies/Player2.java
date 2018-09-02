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
public class Player2 implements Player
{
Game game;
    private Observer observer ;
     static Player2 player2;
     CareTaker caretaker;
    private Player2()
    {
        caretaker = CareTaker.getInstance();
        
        observer =  WinObserver.GeInstance();
       game = Game.getInstance();
        
    }
    public static Player2 GetInstance()
    {
       if(player2 == null)
           player2 = new Player2();
       return player2;
         
    }
    
    @Override
    public void Play(panel panel)
    {
       XO XO = new XO();
     
        try
        {
           if(panel.getState().CheckState()=="Empty")
           { 
            panel.getGraphics().drawImage(XO.GetO(), 5, 5, panel);
            panel.setState(OState.GetInstance());
            
            game.setPlayer(Player1.GetInstance());
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
        return "Player2";
    }
}