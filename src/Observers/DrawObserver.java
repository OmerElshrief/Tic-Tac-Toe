/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observers;

import GUI.Game;
import GUI.panel;
import Strategies.GameOver;

 
public class DrawObserver implements Observer
{
     Game game;
     panel[] panels;
    static DrawObserver drawObserver;
    private DrawObserver()
    {
        game= Game.getInstance();
        panels =  game.getP1();
    }
    
    
    public static DrawObserver GeInstance()
    {
        
        if(drawObserver == null)
            drawObserver = new DrawObserver();
                    return drawObserver;
    }

    
    @Override
    public void Notify()
    {
      
//    for(int i=0;i<9;i+=2)
//    {
//        if(panels[i].getState().CheckState()=="Empty"||panels[i+2].getState().CheckState()=="Empty"|| panels[i+4].getState().CheckState()=="Empty"|| panels[i+6].getState().CheckState()=="Empty")
//            System.err.println("TIEEEEE");
//        game.setPlayer(GameOver.GetInstance());
//    }
//

    }
     
     
}
