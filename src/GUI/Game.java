/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Objects.XO;
import SnapShot.CareTaker;
import State.Empty;
import State.OState;
import State.OnePlayer;
import State.OnePlayerEasy;

import State.State;
import State.TwoPlayers;
import Strategies.Computer;
import Strategies.ComputerAttacker;
import Strategies.Player;
import Strategies.Player1;
import Strategies.Player2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Cina marCina
 */
public class Game
{
 
    public panel[] p11 = new panel[9];
    List<panel> p1 = new ArrayList<panel>();

    public void setP1(ArrayList p1)
    {
        this.p1 = p1;
    }
    JFrame main = new JFrame();

    public panel[] getP1()
    {
        for(int i=0;i<9;i++)
        {
            p11[i]=p1.get(i);
        }
        return   p11;
    }
    
     public ArrayList<panel> getP11()
    {
       
        return   (ArrayList<panel>) p1;
    }
     
    static Game game;
    BufferedImage o;

    private Game()
    {
        p1 = new ArrayList<panel>();
    }
    public  State gameState;
    private  Player player; 
    private panel main2;
    
   private JLabel label;
    
    public  void setPlayer(Player player)
           
    {
       
        this.player = player;
    }

    public Player getPlayer()
    {
        return player;
    }

    public panel getMain2()
    {
        return main2;
    }
    
   
   public void startGame(State newgameState) throws IOException 
   {   main2 = new panel();
       this.gameState = newgameState;
       GridLayout  g = new GridLayout();
       g.setColumns(3);
       g.setRows(3);
       g.setHgap(20);
       g.setVgap(20);
       AbsoluteLayout l = new AbsoluteLayout();
       o=ImageIO.read(getClass().getResource("/board3.png"));
       label = new JLabel();
       label.setSize(20,20);
       main.setSize(400,600);
       main.setLayout(null);
       main2.setLayout(g);
       main2.setState(OState.GetInstance());
     //main.add(constructjMenu());
        main2.setBounds(0, 0, 400, 400);
        main.add(main2);
        JPanel p2 = new JPanel();
     FlowLayout f = new FlowLayout();
     f.setAlignment(FlowLayout.LEFT);
     p2.setLayout(f);
     p2.setBounds(0, 400, 400, 600);
     p2.setBackground(Color.BLACK);
     JButton start = new JButton("Start new Game");
     JButton undo = new JButton("Undo");
     JButton onePlayer = new JButton("One Player");
     JButton twoPlayer = new JButton ("Two Players");
     JButton low = new JButton ("Lower Dificulty");
     low.setEnabled(false);
     start.addMouseListener(new MouseListener(){
       @Override
       public void mouseClicked(MouseEvent me)
       {  Graphics g;
              
          
            for(int i=0;i<9;i++)
            { 
                g=p1.get(i).getGraphics();
               g.setColor(Color.WHITE); 
               g.fillRect(0,0,p1.get(i).getWidth(),p1.get(i).getHeight());
                p1.get(i).setState(Empty.GetInstance());
                main2.getGraphics().drawImage(o, 0, 0,main2.getWidth(),main2.getHeight(), main2);
                player = Player1.GetInstance();
              
            }       
          
           
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
   });
       
       undo.addMouseListener(new MouseListener(){
       @Override
       public void mouseClicked(MouseEvent me)
       {Undo();
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
     );
       
        onePlayer.addMouseListener(new MouseListener(){
       @Override
       public void mouseClicked(MouseEvent me)
       {
         gameState = new OnePlayer();
             low.setEnabled(true); 
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
     );
         twoPlayer.addMouseListener(new MouseListener(){
       @Override
       public void mouseClicked(MouseEvent me)
       { gameState = new TwoPlayers();
       low.setEnabled(false);
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
     );
          low.addMouseListener(new MouseListener(){
       @Override
       public void mouseClicked(MouseEvent me)
       { 
           gameState = new OnePlayerEasy();
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
     );
          
     p2.add(start);
     p2.add(undo);
     p2.add(onePlayer);
     p2.add(twoPlayer);
     p2.add(low);
     p2.add(label);
     main.add(p2);
    
     
    
       for(int i=0;i<9;i++)
       {  
           p1.add(new panel());
           System.out.println(i);
        //   p1.set(i, new panel());
           p1.get(i).setOpaque(false);
         
           main2.add(p1.get(i));
         
       }
           
      
       
       main2.setBackground(Color.WHITE);
      
        main.setDefaultCloseOperation(3);
        main.setVisible(true);
        
        game = this;
        player = Player1.GetInstance();
//        player.Play(null);
           main2.paint(main2.getGraphics());
            main2.getGraphics().drawImage(o, 0, 0,main2.getWidth(),main2.getHeight(), main2);
              BufferedImage b =ImageIO.read(getClass().getResource("/main.png")); 
      //  p2.getGraphics().drawImage(b, 0, 0,p2.getWidth(),p2.getHeight(), p2);
           
   }
   
   public static Game getInstance()
   {
       if(game == null) game = new Game();
       return game;
   }
   
   public static void main(String[] args) throws IOException
    {
       Game f = Game.getInstance();
       f.startGame(new OnePlayer());
       
       
    }

    
    public void Undo()
    {   Graphics g;
        CareTaker c =  CareTaker.getInstance()  ;
        panel O =  p1.get(p1.indexOf(c.getMemento().getBoard()));
        O.setState(Empty.GetInstance());
        Graphics gr = O.getGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0,O.getWidth()-50 , O.getHeight() -50);
       if(player.check() == "Player1")
           player= Player2.GetInstance();  
       else
            if(player.check() == "Player2")
           player= Player1.GetInstance();    
       
           
        }
    
    private JMenuBar constructjMenu()
    {
        JMenuBar bar = new JMenuBar();
        JMenu Game = new JMenu("Game");
        JMenuItem item = new JMenuItem("New Game");
        JMenuItem undo = new JMenuItem("Undo");
        Game.add(undo);
        bar.add(Game);
       
        undo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {Undo();
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        }  );
         return bar;
    }
}
