/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observers;

import GUI.Game;
import GUI.panel;
import SnapShot.CareTaker;
import SnapShot.Memento;
import Strategies.GameOver;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class WinObserver implements Observer
        
{
    CareTaker caretaker =  CareTaker.getInstance();
    Game game;
    ArrayList<panel> p1;
     panel main;
    static WinObserver winObserver;
    private WinObserver()
    {
       game=Game.getInstance();
       
       main = game.getMain2()  ;
       
    }
    
    
    public static WinObserver GeInstance()
    {
        if(winObserver == null)
            winObserver = new WinObserver();
                    return winObserver;
    }
    @Override
    public void Notify()
            
    {    
          Graphics2D c = (Graphics2D) main.getGraphics();
       p1=   (ArrayList) game.getP11();
       c.setStroke(new BasicStroke(7));
        for (int i = 0; i < 7; i += 3)
        {
            //checking rows
            if(p1.get(i).getState().CheckState()!="Empty")
            {  if (p1.get(i).getState().CheckState() == p1.get(i + 1).getState().CheckState() && p1.get(i + 1).getState().CheckState() == p1.get(i + 2).getState().CheckState())
            {
                if (p1.get(i).getState().CheckState() == "O")
                {  
                   
                  c.drawLine(p1.get(i).getX()+10, p1.get(i).getY()+20, p1.get(i+2).getX()+p1.get(i+2).getWidth()-20, p1.get(i+2).getY()+20);
                    System.err.println("O Wins");
                       game.setPlayer(GameOver.GetInstance());
                }
                if (p1.get(i).getState().CheckState() == "X")
                {
                    c.drawLine(p1.get(i).getX()+10, p1.get(i).getY()+20, p1.get(i+2).getX()+p1.get(i+2).getWidth()-20, p1.get(i+2).getY()+20);
                    System.err.println("X Wins");
                       game.setPlayer( GameOver.GetInstance());
                }
               
            }
           
        }
        }
        //checking all Columns for win
        for (int i = 0; i < 3; i++)
        {
            if(p1.get(i).getState().CheckState()!="Empty")
            if (p1.get(i).getState().CheckState() == p1.get(i + 3).getState().CheckState() && p1.get(i).getState().CheckState() == p1.get(i + 6).getState().CheckState())
            {
                if (p1.get(i).getState().CheckState() == "O")
                {
                    c.drawLine(p1.get(i).getX()+30, p1.get(i).getY()+10, p1.get(i+6).getX()+30, p1.get(i+6).getY()+ p1.get(i+6).getHeight()-20);
                                      game.setPlayer(GameOver.GetInstance());
                    System.err.println("O Wins");
                }
                if (p1.get(i).getState().CheckState() == "X")
                {
                    c.drawLine(p1.get(i).getX()+30, p1.get(i).getY()+10, p1.get(i+6).getX()+30, p1.get(i+6).getY()+ p1.get(i+6).getHeight()-20);
game.setPlayer(GameOver.GetInstance());
System.err.println("X Wins");
                }
            }
        }

        //checking Diagonals
        if(p1.get(0).getState().CheckState()!="Empty")
        if (p1.get(0).getState().CheckState() == p1.get(4).getState().CheckState() && p1.get(0).getState().CheckState().equals(p1.get(8).getState().CheckState()))
        {
            if (p1.get(0).getState().CheckState() == "O")
            {
                c.drawLine(p1.get(0).getX()+10, p1.get(0).getY()+10, p1.get(8).getX()+p1.get(8).getWidth(), p1.get(8).getY()+ p1.get(8).getHeight()-10);
           game.setPlayer(GameOver.GetInstance());
            }
            if (p1.get(0).getState().CheckState() == "X")
            {
               c.drawLine(p1.get(0).getX()+10, p1.get(0).getY()+10, p1.get(8).getX()+p1.get(8).getWidth(), p1.get(8).getY()+ p1.get(8).getHeight()-10);
          game.setPlayer(GameOver.GetInstance());
            }
        }
        if(p1.get(2).getState().CheckState()!="Empty")
        if (p1.get(2).getState().CheckState() == p1.get(4).getState().CheckState() && p1.get(2).getState().CheckState() == p1.get(6).getState().CheckState())
        {
            if ("O".equals(p1.get(2).getState().CheckState()))
            { 
                c.drawLine(p1.get(2).getX()+p1.get(2).getWidth(), p1.get(2).getY()-10, p1.get(6).getX()+5, p1.get(6).getY()+ p1.get(6).getHeight()-10);
          game.setPlayer(GameOver.GetInstance());
                System.err.println("O Wins");
            }
            if (p1.get(2).getState().CheckState() == "X")
            { c.drawLine(p1.get(2).getX()+p1.get(2).getWidth(), p1.get(2).getY()-10, p1.get(6).getX()+5, p1.get(6).getY()+ p1.get(6).getHeight()-10);
          game.setPlayer(GameOver.GetInstance());
                System.err.println("X Wins");
            }
        }

       
        
        
    }
    }
    

