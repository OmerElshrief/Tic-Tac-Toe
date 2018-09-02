/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import GUI.panel;

/**
 *
 * @author Cina marCina
 */
public class Empty implements PanelState
{

    static Empty empty;
    private Empty()
    {
        
        
    }
    public static Empty GetInstance()
    {
       if(empty == null)
           empty = new Empty();
       return empty;
         
    }
    @Override
    public String CheckState()
    {
   return "Empty";
    }

    
    
    
}
