import java.awt.Color;
import java.awt.Graphics;
 
public class BossProjectile
{
    int x;
    int y;
    int timer;
    int width;
    int height;
    int move;
    Color gold;
    Color white;
    Color blue;
    boolean visible;
     
    public BossProjectile(int x, int y)
    { 
        this.x = x;
        this.y = y;
          
        this.width = 60;
        this.height = 35;
         
        gold = new Color(255,215,0);
        white = new Color(255,255,255);
        blue = new Color(125,160,255);
        this.visible = false;
    }
     

    public void drawMe(Graphics g)
    {
        if( visible==true )
        {
        	g.setColor(blue);
			g.fillOval(x-5,y+50+30,40,40);
			
            g.setColor(gold);
            g.fillOval(x-60+width, y-40+30+60+height, 60, 30);
       	    int []xArray = new int[5];
       	    int []yArray = new int[5];
			xArray[0] = x-10+60+20;
			yArray[0] = y+60+30;  
			xArray[1] = x-5+60;
			yArray[1] = y+75+30;
			xArray[2] = x-10+60+20;
			yArray[2] = y+90+30;
			xArray[3] = x+2+60+10;
			yArray[3] = y+80+30;
			xArray[4] = x+2+60+10;
			yArray[4] = y+70+30;
			g.fillPolygon(xArray, yArray, 5);
			
			g.setColor(white);
			g.drawOval(x-5,y+50+30,43,40);
		}
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
	 
    public void moveLeft()
    {
    	if( move == 1){} 
    	
		if( move == 0 )
        {
            x-=6;
        }
         
        if( x < -150)
        {
            visible = false;
        }   
		
		timer++;
		
		if (timer==20)
		{
			move = 0;
			timer=0;
		}
		
    }
     
    public void setX(int x)
    {
        if( visible == false)
        {
            this.x = x;
        }
    }
    
    public void setY(int y)
    {
        if( visible == false)
        {
            this.y = y;
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
    
    public void ball()
    {
    	x = -100;
    	move = 1;
    }
    
    public void checkBC(Ship s)
    {
        int sX = s.getX()-70;
        int sY = s.getY()-90;
        int sWidth = s.getWidth();
        int sHeight = s.getHeight();
		
		if( sX + sWidth >= x && sX <= x+width  
            && sY + sHeight >= y && sY <= y+height  )
        {
        	s.Reset();
            visible=false;
            s.lives();
        }
       
    }
     
}
