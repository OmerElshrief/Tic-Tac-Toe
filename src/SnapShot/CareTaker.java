/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnapShot;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Cina marCina
 */
public class CareTaker
{
 static CareTaker caretaker;
    private CareTaker()
    {
    }
    public static CareTaker getInstance()
    {
        if (caretaker == null) caretaker = new CareTaker();
        return caretaker;
        
    }
    LinkedList<Memento> mementos =new LinkedList<Memento>();
    static int i=0 ;
    public void addMemento(Memento memento)
    {
       if(mementos.add(memento)) System.err.println("addedd to memento");
    }
    public Memento getMemento()
    { 
      
        Memento x = mementos.removeLast();
        System.err.println("poped");
       return x;
       
    }
}
