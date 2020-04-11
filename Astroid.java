import java.awt.Color;
import java.awt.Graphics;
public class Astroid
{
	int x;
    int y;
    Color grey;
    Color black;
	
	public Astroid()
    {
        x = (int)(Math.random()*800);
        y = (int)(Math.random()*600);
        grey = new Color(150,150,150);
        black = new Color(220,220,220);
	}
	
	public void drawMe(Graphics g)
    { 
    	g.setColor(grey);
    	g.fillOval(x,y,30,30);
    	g.setColor(black);
    	g.fillOval(x+5,y+5,5,5);
    	g.fillOval(x+15,y+10,3,3);
    	g.fillOval(x+10,y+15,7,7);
	}
	
	public void move()
	{
		if (x<0)
			x = 800;
		
		else
			x -= 3;
	}
	
}