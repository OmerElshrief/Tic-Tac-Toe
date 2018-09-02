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
public class OState implements PanelState
{
 static OState oState;
    private OState()
    {
        
        
    }
    public static OState GetInstance()
    {
       if(oState == null)
           oState = new OState();
       return oState;
         
    }
    @Override
    public String CheckState()
    {
        return "O";
        }
    
}
