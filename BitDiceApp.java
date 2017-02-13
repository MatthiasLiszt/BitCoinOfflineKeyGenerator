
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Class BitDiceApp - write a description of the class here
 * 
 * @author Matthias Liszt 
 * @version 0.0joseph 
 */

/*
 * currently this BitDiceApp helps to create a 240 bit seed which is used to create 
 * the Bitcoin private key. The first 16 bits are then set to zero to have a full 256 bit
 * number , which is required. The bitcoin random seed does not support the full 256 bit
 * random seed range ( see bitcoin wiki ) , and even 16 bit less isn't that much compared
 * with the full random key. Also note that there are far less possible public keys, 
 * because the bitcoin public keys are much shorter than the private ones. 
 * 
 */
class BitDiceApp implements ActionListener
{
    JFrame f;
    JTextField t,t2,t3;
    JButton b1,b2,b3,b4,b5,b06;
    
    static int n=0; 
    String seed="";
    
    // instance variables - replace the example below with your own
    private int x;
    
    
    public BitDiceApp()
    { f=new JFrame("BitCoin Dice Key Generator");
      t=new JTextField();  
      t2=new JTextField();
      t3=new JTextField();
      b1=new JButton("1");
      b2=new JButton("2");
      b3=new JButton("3");
      b4=new JButton("4");
      b5=new JButton("5");
      b06=new JButton("6");
      
      t.setBounds(30,30,450,30);
      t2.setBounds(30,60,450,30);
      t3.setBounds(30,300,450,30);
      b1.setBounds(40,240,50,40);
      b2.setBounds(110,240,50,40);
      b3.setBounds(180,240,50,40);
      b4.setBounds(40,170,50,40);
      b5.setBounds(110,170,50,40);
      b06.setBounds(180,170,50,40);
      
      f.add(b1);
      f.add(b2);
      f.add(b3);
      f.add(b4);
      f.add(b5);
      f.add(b06);
      f.add(t);
      f.add(t2);
      f.add(t3);
      
      f.setLayout(null);
      f.setVisible(true);
      f.setSize(500,500);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setResizable(true);
      
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      b4.addActionListener(this);
      b5.addActionListener(this);
      b06.addActionListener(this);
      
    }
     
    /**
     * Called by the browser or applet viewer to inform this JApplet that it 
     * should start its execution. It is called after the init method and 
     * each time the JApplet is revisited in a Web page. 
     */
    public void start()
    {
        // provide any code requred to run each time 
        // web page is visited
    }

    /** 
     * Called by the browser or applet viewer to inform this JApplet that
     * it should stop its execution. It is called when the Web page that
     * contains this JApplet has been replaced by another page, and also
     * just before the JApplet is to be destroyed. 
     */
    public void stop()
    {
        // provide any code that needs to be run when page
        // is replaced by another page or before JApplet is destroyed 
    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        // simple text displayed on applet
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 100);
        g.setColor(Color.black);
        g.drawString("BitCoin Offline KeyGenerator for 4 dices", 20, 20);
        g.setColor(Color.blue);
        g.drawString("created by Matthias Liszt with BlueJ", 20, 40);
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy. 
     */
    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }


    /**
     * Returns information about this applet. 
     * An applet should override this method to return a String containing 
     * information about the author, version, and copyright of the JApplet.
     *
     * @return a String representation of information about this JApplet
     */
    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title: BitCoin Offline Generator   \nAuthor: Matthias Liszt  \nA ";
    }
    
    public static void main(String...s)
    {
        new BitDiceApp();
    }
    public void actionPerformed(ActionEvent e)
    { 
      String s;  
           
      if(e.getSource()==b1){t.setText(t.getText().concat("1"));}
      if(e.getSource()==b2){t.setText(t.getText().concat("2"));}
      if(e.getSource()==b3){t.setText(t.getText().concat("3"));}
      if(e.getSource()==b4){t.setText(t.getText().concat("4"));}
      if(e.getSource()==b5){t.setText(t.getText().concat("5"));}
      if(e.getSource()==b06){t.setText(t.getText().concat("0"));}   
      
      s=t.getText();
      
      if(s.length()==4)
       {
        t.setText("");
        s=ThrowBin(s);
        if(s!="false")
         {t2.setText(t2.getText().concat(s));}
       }
    }    
    public String ThrowBin(String m)
    {int xx,a1=0,a2=0,a3=0,a4=0,ii,jj;
     String rr="false",rx;
     
     xx=Integer.parseInt(m);   
     a1=xx/1000;
     xx=xx-a1*1000;
     a2=xx/100;
     xx=xx-a2*100;
     a3=xx/10;
     xx=xx-a3*10;
     a4=xx;
     ii=a4+a3*6+a2*36+a1*36*6;
    
     
     if(ii<1024)
      {rr="";
       if((ii/1024)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/512)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/256)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/128)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/64)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/32)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/16)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/8)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/4)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/2)==1){rr=rr+"1";}else{rr=rr+"0";}   
       if((ii/1)==1){rr=rr+"1";}else{rr=rr+"0";}   
       n=n+1;
       seed=seed+rr;
       if(n<24)
        {t3.setText(Integer.toString(n));}
       else 
        {t3.setText("seed created successfully");
         
         rx="0000000000000000"; // 16 times zero
                   
         t3.setText("conversion step 1 accomplished"); 
         
         seed=rx+seed; 
         System.out.print(seed);
                  
         t3.setText(seed); 
         
         t3.setText(B2Hex(seed));
         System.out.print("hex="+B2Hex(seed));
        }
      }
     
     return rr;
    }    
    
    
    public String B2Hex(String m)
    {int ii,hv;
     String rx="",HexMap="0123456789abcdef";
     char c;
     
     for(ii=0;ii<256;ii=ii+4)
      {hv=0;
       if(m.charAt(ii+0)=='1'){hv=hv+8;}
       if(m.charAt(ii+1)=='1'){hv=hv+4;}
       if(m.charAt(ii+2)=='1'){hv=hv+2;}
       if(m.charAt(ii+3)=='1'){hv=hv+1;}
       c=HexMap.charAt(hv);   
       rx=rx+c;
          
      }    
     return rx; 
    } 
    
 }


