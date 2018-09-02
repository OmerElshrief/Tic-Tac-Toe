/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import GUI.Game;
import GUI.panel;
import Observers.WinObserver;

/**
 *
 * @author Cina marCina
 */
public class GameOver implements Player
{
 static GameOver player1;
    private GameOver()
    {
       
        
    }
    public static GameOver GetInstance()
    {
       if(player1 == null)
           player1 = new GameOver();
       return player1;
         
    }
    @Override
    public void Play(panel panel)
    {
        
    }

    @Override
    public String check()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
