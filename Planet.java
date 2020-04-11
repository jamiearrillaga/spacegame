import java.awt.Color;
import java.awt.Graphics;
public class Planet
{
	int x;
    int y;
    Color blue;
    Color grey;
    boolean move=true;
	
	public Planet()
    {
        x = (int)(Math.random()*800);
        y = (int)(Math.random()*600);
        blue = new Color(153,255,255);
        grey = new Color(200,200,200);
	}
	
	public void stop()
	{
		move = false;
	}
	
	public void drawMe(Graphics g)
    { 
    	g.setColor(blue);
    	g.fillOval(x,y,30,30);
    	g.setColor(grey);
    	g.drawOval(x-5,y+10,40,10);
    	g.setColor(blue);
    	g.fillOval(x,y+5,30,10);
    
	}
	
	public void move()
	{
		if(move)
		{
			if (x<-20)
			{
				x = 800;
				y = (int)(Math.random()*800);
			}
			
			else
				x-=3;
		}
	}
	
}
