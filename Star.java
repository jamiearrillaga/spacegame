import java.awt.Color;
import java.awt.Graphics;
public class Star
{
	int x;
    int y;
    Color yellow;
    
	
	public Star()
    {
        x = (int)(Math.random()*800);
        y = (int)(Math.random()*600);
        yellow = new Color(255,255,0);
	}
	
	public void drawMe(Graphics g)
    { 
    	g.setColor(yellow);
    	g.fillOval(x,y,4,4);
    
	}
	
	public void move()
	{
		if (x<0)
		{
			x = 800;
			y = (int)(Math.random()*800);
		}
		
		else
			x -= 5;
	}
	
}
