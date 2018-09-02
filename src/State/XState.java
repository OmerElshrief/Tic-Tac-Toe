/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author Cina marCina
 */
public class XState implements PanelState
{

     static XState xState;
    private XState()
    {
        
        
    }
    public static XState GetInstance()
    {
       if(xState == null)
           xState = new XState();
       return xState;
         
    }
    @Override
    public String CheckState()
    {
        return "X";
    }
    
}
