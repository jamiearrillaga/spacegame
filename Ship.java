import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.net.URL;

public class Ship
{
    int x;
    int y;
    int width;
    int height;
    Color blue;
    Color grey;
    boolean visible; 
    int lives =3;
    Color white;
    Color black;
    String go = "";
    int w;
    int h;
    Color pink;
    String b = "";
    boolean die = false;
    
    public Ship(int x, int y)
    {
         
        this.x = x;
        this.y = y;
         
        this.width = 80;
        this.height = 40;
         
        this.blue = new Color(210,240,255);
        this.white = new Color(255,255,255);
        this.grey = new Color(0,153,76);
        this.black = new Color(0,0,0);
        this.visible = true;
        this.pink = new Color(255,0,255);
    }
     
    public void Reset()
    {
    	this.y = 300;	
    }
    
    public void drawMe(Graphics g)
    {
       if (visible)
       {	  
       	    Color red = new Color(255,0,0);
			g.setColor(grey);
			g.fillOval(x-20,y,width,height);
			
			g.setColor(blue);
			g.fillOval(x,y-10,width-40,height-5);
			
			
		}	
			Font font = new Font("Comic Sans MS", Font.PLAIN, 25);
			g.setFont(font);
			g.setColor(white);
			g.drawString("lives: "+lives, 50, 570);			
			
    }
    
    public int getLives()
    {
    	return lives;	
    }
    
    public void moveUp()
    {
        y-=15;
        if(y<=10)
        	y=10;
    }
     
    public void moveDown()
    {
        y+=15;
        if(y>=560)
        	y=560;
    }
     
    public int getX()
    {
        return x;
    }
     
    public int getY()
    {
        return y;
    }
   
    public int getWidth()
    {
        return width;
    }
     
    public int getHeight()
    {
        return height;
    }
    
    public void checkBC(BossProjectile b)
    {
        int bX = b.getX();
        int bY = b.getY();
        int bWidth = b.getWidth();
        int bHeight = b.getHeight();
		
		if( bX+80 + bWidth >= x && bX+80 <= x+width  
            && bY+100 + bHeight >= y && bY+100 <= y+height  )
        {
            b.setVisible(false);
            visible=false;
        }
       
    }
    
    
   public void lives()
   {
   		lives--;   
   }
   
   public void setLives(int alive)
   {
   	   lives = alive;
   }
    
    
}
