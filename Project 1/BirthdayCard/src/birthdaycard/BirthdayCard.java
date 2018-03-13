package birthdaycard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Project 1: Greeting Card
 *
 * Animates a [Happy Birthday for My Sister]
 *
 * @author Pluska
 * @author [Zane Walker]
 */
@SuppressWarnings("serial")
public class BirthdayCard extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 16; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your drawings
	 * coordinates should be relative to this offset value.
         * a yOffset can be added for vertical movement
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
         * Increase or decrease to change the speed
	 */
	private int stepSize = 3;
	/**
	 * The background color
	 */
	private final Color BACKGROUND_COLOR = new Color(0, 255, 255);
        /**
	 * initialize width
	 */
        private int width;

         /**
	 * initialize height
	 */
	private int height; 
        
         /**
	 * initialize g as type Graphics2D.  
         * Necessary for using setStroke()
	 */
        Graphics2D g;
        
        /**
	 * Draws (and refreshes) the scene at each animation step.
	 * 
	 * @param g0 Graphics context
	 */
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
        @Override
	public void paintComponent(Graphics g0)
	{       
                //assigns graphics object to g
		g = (Graphics2D) g0;
                
                width = getWidth();// panel width
                height = getHeight();//panel height
                offset();
                
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Double wide = screenSize.getWidth();
                Double tall = screenSize.getHeight();
                g.scale(width / wide * 2.3, height / tall * 2);
                
                //calls the background method
		background();
                //calls the square method
                bottom();
                msg();
                //square();
                cake();
                archincake();
                decorate();
                candal();
                fire();
                balloon();
                
                // TODO: Use width, height, and xOffset to create additional methdos
                // that draw scalable objects at different positions on the screen
                //Makes the animation smoother.  Do not modify.
		Toolkit.getDefaultToolkit().sync();
	}
         /**
	 * Draws a green square that moves left to right across the screen
         * Replace with your own object
	 */
        int mWidth = 40;
         public void msg(){
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, mWidth)); 
                g.drawString("Happy Birthday Cleo!", 80, 70); 
                
            int a = 25;
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, a)); 
                g.drawString("You are the best sister ever!", 115, 100);
         }
         
         public void bottom(){
           
             g.setColor(Color.DARK_GRAY);
             g.fillOval(150,310, 300, 70);
         }
         public void cake(){
             g.setColor(Color.MAGENTA);
             g.fillRect(185,230,230,110);
        }
           // public void square(){
            //    int squareSide = height/5;
		//int squareY = height/2 - squareSide/2;
		//g.setColor(Color.WHITE);
		//g.fillRect(squareY, xOffset, squareSide, squareSide);
           // }
         public void archincake(){
             g.setColor(Color.blue);
             g.drawArc(183, 235, 232, 60, 190, 160);
             g.setColor(Color.RED);
             g.drawArc(183, 270, 232, 60, 190, 160);
             g.setColor(Color.MAGENTA);
             g.fillArc(183, 304, 232, 60, 190, 160);
             g.setColor(Color.PINK);
             g.fillOval(185, 200, 230, 60);
             g.setColor(Color.BLACK);
             g.drawArc(183, 200, 232, 60, 190, 160);
         }
         
         public void decorate(){
             g.setColor(Color.YELLOW);
             g.fillOval(190,269,10,15);
             g.setColor(Color.YELLOW);
             g.fillOval(220,279,10,15);
             g.setColor(Color.YELLOW);
             g.fillOval(250,284,10,15);
             g.setColor(Color.YELLOW);
             g.fillOval(280,287,10,15);
             g.setColor(Color.YELLOW);
             g.fillOval(310,286,10,15);
             g.setColor(Color.YELLOW);
             g.fillOval(340,284,10,15);
             g.setColor(Color.YELLOW);
             g.fillOval(370,279,10,15);
             g.setColor(Color.YELLOW);
             g.fillOval(400,269,10,15);
             g.setColor(Color.BLUE);
             g.fillOval(190,305,10,15);
             g.setColor(Color.BLUE);
             g.fillOval(220,315,10,15);
             g.setColor(Color.BLUE);
             g.fillOval(250,320,10,15);
             g.setColor(Color.BLUE);
             g.fillOval(280,323,10,15);
             g.setColor(Color.BLUE);
             g.fillOval(310,322,10,15);
             g.setColor(Color.BLUE);
             g.fillOval(340,320,10,15);
             g.setColor(Color.BLUE);
             g.fillOval(370,315,10,15);
             g.setColor(Color.BLUE);
             g.fillOval(400,305,10,15);
         }
         
        public void candal(){
            g.setColor(new Color( 34, 172, 99));
            g.fillRect(250,190,15,40);
            g.setColor(new Color( 34, 172, 99));
            g.fillRect(290,170,15,70);
            g.setColor(new Color( 34, 172, 99));
            g.fillRect(330,190,15,40);
        }
        
        int r1,g1,b1;
        public void fire(){
            r1 = 255;
            g1 = (int) (Math.random()*255+1);
            b1 = 0;
            
            g.setColor(new Color(r1,g1,b1));
        g.fillOval(253,170,10,20);
        g.fillOval(292,150,10,20);
        g.fillOval(332,170,10,20);
        }
        
        public void balloon(){
            g.setColor(Color.black);
            g.drawLine(70, xOffset + 85, 70, xOffset + 400);
            g.setColor(Color.black);
            g.drawLine(520, xOffset + 85, 520, xOffset + 400);
            g.setColor(Color.ORANGE);
            g.fillOval(24, xOffset + 70, 100, 125);
            g.setColor(Color.ORANGE);
            g.fillOval(474, xOffset + 70, 100, 125);
        }
           

        
         /**
	 * Fill the graphics page with the background color.
	 */
         public void background(){
                g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width*100 , height*100);
            
        }
        
         /**
	 * Calculate the new xOffset position of the moving object.
	 */
        public void offset(){
            xOffset  = (xOffset + stepSize) % width;
            
        }
         
           
        
        
        
        
        //TODO:  Create additional methods
        


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Greeting Card");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BirthdayCard());
		frame.pack();
		frame.setVisible(true);
	}
       
	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public BirthdayCard()
	{

		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

    

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
        
	}
}
