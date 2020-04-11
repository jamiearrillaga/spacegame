import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;

public class Boss
{
		int x;
		int y;
		Color brown;
		Color black;
		Color white;
		Color purple;
		int timer;
		int move;
		int height;
		int width;
		boolean visible;
		int count; 
		int countD;
		
		public Boss(int x, int y)
		{
			this.x = x;
			this.y = y;
			this.visible = true;
			
			brown = new Color(102,51,0);
			black = new Color(0,0,0);
			white = new Color(255,255,255);
			purple = new Color(60,0,100);
			height = 175;
			width = 70;
		}
		
		public void drawMe(Graphics g)
		{	
			if( visible )
			{
				g.setColor(brown);
				g.fillOval(x+50-45,y+105-30,60,90);
				g.fillOval(x+45-45,y+50-30,70,70);
				g.fillOval(x+40-45,y+45-30,20,20);
				g.fillOval(x+100-45,y+45-30,20,20);
				g.fillOval(x+55-45,y+180-30,20,20);
				g.fillOval(x+85-45,y+180-30,20,20);
				g.fillOval(x+45-45,y+135-30,20,20);			
				g.fillOval(x+95-45,y+135-30,20,20);   
				g.setColor(black);
				g.fillOval(x+75-45, y+90-30,10,10);
				g.fillOval(x+65-45, y+75-30,7,7);
				g.fillOval(x+85-45, y+75-30,7,7);
				g.setColor(white);
				g.drawOval(x+30-45,y+27-30,100,100);
				g.setColor(purple);
				g.fillOval(x+30-45,y+155-30,100,55);
			}
		}
		
		public void move()
		{
			
			if(y<50)
				y = 50;
			
			if(y>350)
				y = 350;
			
			if(move==1)
				y+=4;
			
			if(move==2)
				x-=3;
			
			if(move==3)
				y-=4;
			
			if(move==4){}
			
			timer++;
			
			if (timer==20)
			{
				move = (int)(Math.random()*4+1);
				timer=0;
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
			if (visible)
				return x;
			return -100;
		}
		 
		public int getY()
		{
			return y;
		}
		
		public void bLives()
		{
			count++;	
		}
		
		
		public void checkCollision(Projectile p)
		{
			int pX = p.getX();
			int pY = p.getY();
			int pWidth = p.getWidth();
			int pHeight = p.getHeight();	
	
			if(visible)
			{
				if( pX + pWidth >= x && pX <= x+width  
					&& pY + pHeight >= y && pY <= y+height)
				{	
					if(p.checkVisibility() == false)
						count++;
					p.setVisible(false);  
					
				}
				
				if(count == 3)
				{	
					visible = false;
				}	
			}
		}
		

		public void checkL(Ship s)
		{
			int sX = s.getX();
			int sY = s.getY();
			int sWidth = s.getWidth();
			int sHeight = s.getHeight();
			
			if( sX + sWidth >= x && sX <= x+width  
				&& sY + sHeight >= y && sY <= y+height || x==-33 )
			{ 	
				s.lives();
				this.x = 850;
				s.Reset(); 
			}
		}
		
	   
		
}
