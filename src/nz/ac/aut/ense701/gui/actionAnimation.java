package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class actionAnimation {  
	private static actionAnimation actionAnimation;  
    private Image image;  
    private JDialog jg;  
    
    
    public static void instanceInit() throws FileNotFoundException, IOException{  
        if (actionAnimation == null) {  
        	actionAnimation = new actionAnimation();  
        }  
    }  
    public static actionAnimation getInstance(boolean alwaysOnTop) throws FileNotFoundException, IOException {  
        if (actionAnimation == null) {  
        	actionAnimation = new actionAnimation();  
        }  
        actionAnimation.jg.setAlwaysOnTop(alwaysOnTop);  
        actionAnimation.setVisible(true);  
        new Thread(new Runnable(){
        	@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			try {
    				Thread.sleep(3000);
    				actionAnimation.jg.dispose();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
        	
        	
        	
        }).start();
        return actionAnimation;  
    }  
  
    private JPanel getJPanel() {  
        JPanel jp = new JPanel() {  
       
        
  
            @Override  
            protected void paintComponent(Graphics g) {  
                // TODO Auto-generated method stub  
                super.paintComponent(g);  
                g.drawImage(image, 0, 0, this);  
            }  
  
        };  
        
        
        return jp;  
    }  
  
    public static void closeWindow() {  
        if (actionAnimation != null) {  
actionAnimation.setVisible(false);  
        }  
    }  
    public void setVisible(boolean b){  
        jg.setVisible(b);  
    }  
    
    public int getHeight() throws FileNotFoundException, IOException{
    	BufferedImage bimg1 = ImageIO.read(new File(".\\image\\gif.gif"));

    	return bimg1.getHeight();
        
    }
    
    public int getWidth() throws FileNotFoundException, IOException{
    	BufferedImage bimg = ImageIO.read(new File(".\\image\\gif.gif"));
        return bimg.getWidth();
    }


  
    public actionAnimation() throws FileNotFoundException, IOException {  
        
    	image = Toolkit.getDefaultToolkit().createImage(actionAnimation.class.getResource("/gif.gif")); 
        jg = new JDialog();  
        jg.setSize(getWidth(),getHeight());  
        jg.setLayout(new BorderLayout());  
        jg.add(getJPanel(), BorderLayout.CENTER);  
        jg.setLocationRelativeTo(null); 
    
    

    }
}  