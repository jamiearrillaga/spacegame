import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.net.URL;
 
public class Screen extends JPanel implements KeyListener
{
    Enemy2[] e2;
    BufferedImage buffered;
    Projectile p1;
    BossProjectile bp;
    Ship s1;
    Color dBlue;
    Star[] star;
    Boss boss;
    Enemy[] enemy;
	Astroid[] astroid;
	Planet[] planet;
	int level = 1;
	Color white;
	Color black;
	Color pink;
	private int x = 100;
    private int y = 100;
   	private BufferedImage oneImg;
   	private BufferedImage twoImg;
 	private BufferedImage threeImg;
 	int count;
    int countL;
 	Color neonGreen;
 	boolean up;
 	boolean down;
 	int alive;
 	String go = "";
    int w;
    int h;
    String b = "";
 	
    public Screen()
    {	
    	  	
    	try
        {
            oneImg = ImageIO.read(new File("space1.png"));
            twoImg = ImageIO.read(new File("space2.png"));
            threeImg = ImageIO.read(new File("space3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
       star = new Star[50];
       for(int i=0; i < star.length; i++)
       {
           star[i] = new Star();
       }
	   
       astroid = new Astroid[50];
       for(int i=0; i < astroid.length; i++)
       {
           astroid[i] = new Astroid();
       }
       
       planet = new Planet[50];
       for(int i=0; i < astroid.length; i++)
       {
           planet[i] = new Planet();
       }
       	
	   enemy = new Enemy[3];
	   for(int i=0; i < enemy.length; i++)
	   {
		   enemy[i] = new Enemy();
	   }
       
       
	   e2 = new Enemy2[5];
	   for(int i=0; i < e2.length; i++)
	   {
		   e2[i] = new Enemy2();
	   }
      
      
        s1 = new Ship(50,300);
        p1 = new Projectile(50,300); 	   
        boss = new Boss(750,200);
        bp = new BossProjectile(600,300);
       
        dBlue = new Color(0,0,90);
        white = new Color(255,255,255);
        black = new Color(0,0,0);
        pink = new Color(255,0,255);
        neonGreen = new Color(32, 238, 29);
        //sets keylistener
        setFocusable(true);
        addKeyListener(this);
    }
 
    public Dimension getPreferredSize() 
    {
        //Sets the size of the panel
        return new Dimension(800,600);
    }
    
    public void paintComponent(Graphics g) 
    {
            super.paintComponent(g);
     
        //Create Buffered
        if( buffered == null )
        {
            buffered = (BufferedImage)(createImage( getWidth(), getHeight() ) );
        }
         
        //Create a temporary graphics buffered to draw
        Graphics gBuff = buffered.createGraphics();
     
        //Clear everything
        //This draws the white box
       
		
        if(level == 1)
		{
			
			gBuff.drawImage(oneImg, -150, 0, null);
			
			for(Star each : star )
			{
				each.drawMe(gBuff);
			}
			
			for(Enemy each : enemy )
			{
				each.drawMe(gBuff);
				each.checkL(s1);
			}
				
			Font font = new Font("Comic Sans MS", Font.PLAIN, 50);
			gBuff.setFont(font);
			gBuff.setColor(white);
			gBuff.drawString("level: "+level, 620, 	70);
		}
        
		if(level==2)
		{	
			gBuff.drawImage(twoImg, 0, 0, null);
			
			for(Astroid each : astroid )
			{
				each.drawMe(gBuff);
			}
			
			for(Enemy2 each : e2 )
			{
				each.drawMe(gBuff);
				each.checkL(s1);
			}
			
			Font font = new Font("Comic Sans MS", Font.PLAIN, 50);
			gBuff.setFont(font);
			gBuff.setColor(white);
			gBuff.drawString("level: "+level, 500, 	100);
		}
      
		
		if(level==3)
		{	
			gBuff.drawImage(threeImg, 0, 0, null);
			
			for(Planet each : planet )
			{
				each.drawMe(gBuff);
			}
			
			bp.drawMe(gBuff);
			boss.drawMe(gBuff);
			boss.checkL(s1);
			
			Font font = new Font("Comic Sans MS", Font.PLAIN, 50);
			gBuff.setFont(font);
			gBuff.setColor(white);
			gBuff.drawString("level: "+level, 495, 	100);
		}
		
        p1.drawMe(gBuff);
        s1.drawMe(gBuff);
        
        g.drawImage(buffered, 0, 0, null);
        
       if(level==4)
		{			
			g.setColor(white);
			g.fillRect(0,0,800,600);
			Font font = new Font("Comic Sans MS", Font.PLAIN, 180);
			g.setFont(font);
			g.setColor(neonGreen);
			g.drawString("Winner!!!", 10, 350);
			
			count++; 
			if(count%100 > 60)
			{	
				g.setColor(white);
				g.fillRect(0,0,800,600);
			}	
		}	
		
		if(s1.getLives()<=0)
		{
			g.setColor(black);
			g.fillRect(0,0,w,h);
			Font font = new Font("Comic Sans MS", Font.PLAIN, 120);
			g.setFont(font);
			g.setColor(pink);
			g.drawString(go, 150, 300);
			font = new Font("Comic Sans MS", Font.PLAIN, 20);
			g.setFont(font);
			g.drawString(b, 250, 500);
			
			w = 800;
			h = 600;
			go = "You Lose";
			b = "press backspace to play again";
			
		}
		
    } 
    
    
 
    public void animate()
    {
         
        while(true)
        {
            //wait for .01 second
            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
             
			if( p1.getVisible() )
            {
                p1.moveRight();
            }
         
            
            if(up)	
            	s1.moveUp();  
            
             if(down)	
            	s1.moveDown(); 
            
            
          
           if(level == 1)
		   {
				for(Enemy each : enemy )
				{
					each.checkCollision(p1);
					
					if(enemy[0].checkVisibility()==true && enemy[1].checkVisibility()==true
						&& enemy[2].checkVisibility()==true)
						level=2;
					
					each.move();
				}
			
				for(Star each : star )
				{
					each.move();
				}  
		   }
		   
		   
		   if(level == 2)
		   {
			   for(Astroid each : astroid )
				{
					each.move();
				}
           
				for(Enemy2 each : e2 )
				{
					each.checkCollision(p1);
					
					if(e2[0].checkVisibility()==true && e2[1].checkVisibility()==true
						&& e2[2].checkVisibility()==true&& e2[3].checkVisibility()==true
						&& e2[4].checkVisibility()==true)
						level=3;
					
					each.move();	
				}
		   }
		   
		   if(level == 3)
		   {
			   for(Planet each : planet )
				{
					each.move();
					//each.stop();
				}   
		   	   
		   	    bp.setX( boss.getX() );         
				bp.setY( boss.getY() );
				bp.setVisible(true);
				bp.moveLeft();  
				boss.move();
				boss.checkCollision(p1);
				bp.checkBC(s1);		
				if(boss.checkVisibility()==true )
				{
					level=4;
				}
		   }
		   
            repaint();
        }
 
    }
     
    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {
 
 
        //key code
        //http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes
 
        if (e.getKeyCode()==38)//Up Arrow
        {
            s1.moveUp();        
        }
        else if (e.getKeyCode()==40)//Down Arrow
        {
            s1.moveDown();   
        }
        else if(e.getKeyCode() == 32) //Spacebar
        {
            p1.moveTo( s1.getX(), s1.getY() );
            p1.setVisible(true);
        }
        
        if (e.getKeyCode()==75)//k
        {
           level++;    
        }
       
        if(s1.getLives()<=0)
       	{
			if (e.getKeyCode()==8)//b
			{
				w = 0;
				h = 0;
				go = "";
				b = "";
			
				this.level = 1;
				s1.setLives(3);
				
				for(Enemy each : enemy)
				{
					each.reset();
				}
				
				for(Enemy2 each : e2)
				{
					each.reset();
				}
			}
		}
        
        repaint();
 
    }
 
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}

