
package GUI;

import State.Empty;
import State.PanelState;

import State.State;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
public class panel extends JPanel
{

 
    protected void paintComponent(Graphics g)
    {
     super.paintComponents(g);
    // paint(g);
     
    
    }

    
    public PanelState getState()
    {
        return state;
    }
   
    PanelState state; 
    public panel()
    {
       
        super();
        this.addMouseListener(new ClickEvent());
        state = Empty.GetInstance();
    }

    public void setState(PanelState state)
    {
        this.state = state;
    }
   
    public void play()
    { Game game = Game.getInstance();
       game.getPlayer().Play(this);
        
    }
 
    
    
    public class ClickEvent implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent me)
        {
       play();
        
        }

        @Override
        public void mousePressed(MouseEvent me)
        {
          }

        @Override
        public void mouseReleased(MouseEvent me)
        {
        }

        @Override
        public void mouseEntered(MouseEvent me)
        {
        }

        @Override
        public void mouseExited(MouseEvent me)
        {
        }
        
    }
    
}
