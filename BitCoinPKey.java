import java.security.MessageDigest;
import java.math.*;

/**
 * Write a description of class BitCoinPKey here.
 * 
 * This is supposed to create the BitCoin Privat Key from the Seed - 
 * a 256 bit long number from a 240 bit seed. 
 * 
 * @author Matthias Liszt
 * @version 0.01
 */
public class BitCoinPKey
{
    // instance variables - replace the example below with your own
    private int x;
    String iSeed;

    /**
     * Constructor for objects of class BitCoinPKey
     */
    public BitCoinPKey(String seed)
    {
        // initialise instance variables
        x = 0;
        
        iSeed=seed;
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
    
    public String H2String(String m)
    {int ii,qq;
     String rx="";
     char c;
     
     for(ii=0;ii<m.length();ii=ii+2)
      {String q=m.substring(ii,ii+2);
       qq=Integer.parseInt(q,16);   
       rx=rx+(char)qq;   
      }    
     return rx; 
    }    
    
    
    public String String2Hex(String m)
    {int ii,qq,i;
     String rx="",HexMap="0123456789abcdef";
     char c;
     
     for(ii=0;ii<m.length();++ii)
      {i=m.charAt(ii)/16;
       c=(char)i;   
       rx=rx+HexMap.charAt(c);   
       i=m.charAt(ii)%16;
       c=(char)i;
       rx=rx+HexMap.charAt(c);   
      
      }
     return rx; 
    }    
    
    public String S2Hex(String arg) 
    {
     return String.format("%32x", new BigInteger(1, arg.getBytes()));
    }
    
    // Hex String to binary array 
    public static byte[] H2bA(String m) 
    {byte[] data;
     int oo,u;
     
     data = new byte[m.length() / 2];
     
     //System.out.print("-H2bA-");
        
     for (int i = 0; i < m.length(); i=i+2) 
       {oo = ((Character.digit(m.charAt(i), 16) * 16)+(Character.digit(m.charAt(i+1), 16)));
        
        data[i/2]=0;
        for(int j=0;j<oo;++j){++data[i/2];}
        //System.out.print(Integer.toHexString(oo));
        u=(int)data[i/2]&255;
        //System.out.print(Integer.toHexString(u));
       }
     return data;
    }
    
    //technical details for this function on http://en.bitcoin.it/wiki/Wallet_import_format
    // input is a Hex String 
    public String pKeyGen(String m)
    {String rx="",pp;
     SHA256hash a; 
     int l,u;
     Base58 p;
     byte[] b,b1,b2;
     BigInteger bI;
     
     a=new SHA256hash(m);
             
     m="80"+B2Hex(m);   
     //System.out.print("s1="+m);
     //h=H2String(m);
     
     b = new byte[33]; 
     b1 = new byte[32];
     b2 = new byte[32];
     
     b=H2bA(m);
     
     try{b1=a.exec(b);}catch(Exception e){}
     try{b2=a.exec(b1);}catch(Exception e){}
     
       
     for(int i=0;i<4;++i)
      {u=(int)b2[i]&255;
       if(u>15)
        {m=m+Integer.toHexString(u);}     
       else 
        {m=m+"0"+Integer.toHexString(u);}
      }  
          
     //System.out.print("s4="+m); 
                     
     p=new Base58();
     bI=p.H2bInt(m);
     rx=p.encode(bI);
     
     //System.out.print("WIF="+rx);
    
     return rx;
    }    
}
