package Objects;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class XO
{
    BufferedImage X ;
    BufferedImage O ;
//generate X-Y using FlyWeight.
    public XO() 
    {
        try
        {
            O = ImageIO.read(getClass().getResource("/O2.png"));
            X = ImageIO.read(getClass().getResource("/X2.png"));
        } catch (IOException ex)
        {
            Logger.getLogger(XO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public BufferedImage GetO() throws IOException
    {
              
        return O;
    }
    public BufferedImage GetX() throws IOException
    {
        
        
        return X;
    }
    
    
}
