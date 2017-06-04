package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ActionAnimation {  
	private static ActionAnimation ActionAnimation;  
    private Image image;  
    private JDialog jg;  
    private boolean running=false;
    
    public static void instanceInit() throws FileNotFoundException, IOException{  
        if (ActionAnimation == null) {  
        	ActionAnimation = new ActionAnimation();  
        }  
    }  
    public static ActionAnimation getInstance(boolean alwaysOnTop) throws FileNotFoundException, IOException {  
        if (ActionAnimation == null) {  
        	ActionAnimation = new ActionAnimation();  
        }  
        ActionAnimation.jg.setAlwaysOnTop(alwaysOnTop);  
        ActionAnimation.setVisible(true);  
        new Thread(new Runnable(){
        	@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			try {
    				Thread.sleep(3000);
    				ActionAnimation.running=false;
    				ActionAnimation.jg.dispose();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
        	
        	
        	
        }).start();
        return ActionAnimation;  
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
        if (ActionAnimation != null) {  
ActionAnimation.setVisible(false);  
        }  
    }  
    public void setVisible(boolean b){  
        jg.setVisible(b);  
    }  
    
    public int getHeight() throws FileNotFoundException, IOException{
    	BufferedImage bimg1 = ImageIO.read(new File("image/trap.gif"));

    	return bimg1.getHeight();
        
    }
    
    public int getWidth() throws FileNotFoundException, IOException{
    	BufferedImage bimg = ImageIO.read(new File("image/trap.gif"));
        return bimg.getWidth();
    }
    
    public boolean checkRunning(){
    	if(this.running!=true){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    public void setRunning(boolean running){
    	this.running=running;
    }
    

  
    public ActionAnimation() throws FileNotFoundException, IOException {  
        
    	image = Toolkit.getDefaultToolkit().createImage("image/trap.gif"); 
        jg = new JDialog();  
        jg.setSize(getWidth(),getHeight());  
        jg.setLayout(new BorderLayout());  
        jg.add(getJPanel(), BorderLayout.CENTER);  
        jg.setLocationRelativeTo(null); 
    
    

    }
}  