import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
 
public class Projectile
{
    int x;
    int y;
     
    int width;
    int height;
     
    Color green;
    boolean visible;
 
     
    public Projectile(int x, int y)
    { 
        this.x = x;
        this.y = y;
          
        this.width = 20;
        this.height = 3;
         
        this.green = new Color(0,255,0);
        this.visible = false;
    }
     

    public void drawMe(Graphics g)
    {
        if( visible )
        {
            g.setColor(green);
            g.fillRect(x+60,y+20,width,height);
        }
              
    }
	
    public boolean checkVisibility()
    {
    	if(visible==false)
    		return true;
    	return false;
    }
    
	 public int getX()
    {
        return this.x;
    }
     
    public int getY()
    {
        return this.y;
    }
     
    public int getWidth()
    {
        return width;
    }
     
    public int getHeight()
    {
        return height;
    }
     
     
    public void moveRight()
    {
        if( visible )
		{
			x += 10;   
         
			if( x > 800)
			{
				visible = false;
				x=50;
			}
        }
         
    }
     
	public void setVisible(boolean visibleInput)
    {
        this.visible = visibleInput;
    }
     
    public void moveTo(int x, int y)
    {
        if( visible == false)
        {
            this.x = x;
            this.y = y;
        }
    }
     
    public boolean getVisible()
    {
        return this.visible;
    }
     
}
