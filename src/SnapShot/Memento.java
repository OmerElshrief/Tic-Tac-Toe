/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnapShot;

import GUI.panel;

/**
 *
 * @author Cina marCina
 */
public class Memento
{
private panel  p1;

public Memento(panel p1)
{
    this.p1=p1;
}

public panel getBoard()
{
    return p1;
}
}

