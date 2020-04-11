import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;

public class Enemy
{
	int x;
	int y;
    Color red;
    Color black;
	int move;
	int timer;
	int width;
	int height;
	boolean visible;
	int count;
	
	public Enemy()
    {
        x = 700;
        y = (int)(Math.random()*500);
		red = new Color(255,0,0);
        black = new Color(0,0,0);
        width = 50;
		height = 60;
		this.visible = true;
		
     }
	
	public void drawMe(Graphics g)
    {
		if( visible )
        {
			g.setColor(red);
			int[] xArray = new int[4];
			int[] yArray = new int[4];
			xArray[0] = x-20;
			yArray[0] = y+50;  
			xArray[1] = x+60-20;
			yArray[1] = y-30+50;
			xArray[2] = x+50-20;
			yArray[2] = y+50;
			xArray[3] = x+60-20;
			yArray[3] = y+30+50;
			g.fillPolygon(xArray, yArray, 4);
			
			g.setColor(black);
			xArray = new int[4];
			yArray = new int[4];
			xArray[0] = x+2-20;
			yArray[0] = y+50;
			xArray[1] = x+25-20;
			yArray[1] = y-10+50;
			xArray[2] = x+22-20;
			yArray[2] = y+50;
			xArray[3] = x+25-20;
			yArray[3] = y+10+50;
			g.fillPolygon(xArray, yArray, 4);
        
		}
		
		
		else
			x=1000;
    }
    
    public void move()
    {
		
		if(y<50)
            y = 50;
		
		if(y>500)
            y = 500;
        
		if(move==1)
			y+=2;
		
		if(move==2)
			x--;
		
		if(move==3)
			y-=2;
		
		if(move==4){}
			
		
		timer++;
		
		if (timer==20)
		{
			move = (int)(Math.random()*4+1);
			timer=0;
		}
		
    }
    
    public void reset()
    {
    	x=700;
    	visible = true;
    }
    
    public int getX()
    {
    	return this.x;
    }
    
    public boolean checkVisibility()
    {
    	if(visible==false)
    		return true;
    	return false;
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
    
	public void checkCollision(Projectile p)
    {
        int pX = p.getX();
        int pY = p.getY();
        int pWidth = p.getWidth();
        int pHeight = p.getHeight();
		
        if(p.checkVisibility()==false)
        {
        	if( pX + pWidth >= x && pX <= x+width  
        		&& pY + pHeight >= y && pY <= y+height  )
        	{   
        		p.setVisible(false);
        		visible = false;  
        	}
        }
    }
    
    public void setVisible(boolean visibleInput)
    {
        this.visible = visibleInput;
    }
    
    public void checkL(Ship s)
    {
        int sX = s.getX();
        int sY = s.getY();
        int sWidth = s.getWidth();
        int sHeight = s.getHeight();
		
        if(visible)
        {
			if( sX + sWidth >= x && sX <= x+width  
				&& sY + sHeight >= y && sY <= y+height || x==10 )
			{ 	
				s.lives();
				this.x = 850;
				s.Reset(); 
			}
        }
    }
}


