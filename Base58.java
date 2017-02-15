
import java.math.*;

/**
 * Write a description of class Base58 here.
 * 
 * @author Matthias Liszt
 * @version 0.0joseph
 */
public class Base58
{
    // instance variables - replace the example below with your own
    private int x;
    static String    hexIn="800C28FCA386C7A227600B2FE50B7CAE11EC86D3BF1FBE471BE89827E19D72AA1D507A5B8D";
    BigInteger bI;
    static char[] b58tab="123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();

    /**
     * Constructor for objects of class Base58
     */
    public Base58()
    {
        // initialise instance variables
        x = 0;
    }

    static public BigInteger H2bInt(String m)
    {BigInteger b;     
     int ii,o;
          
     b=BigInteger.valueOf(0);
     
     b=new BigInteger(m,16);
             
     return b;   
    }    
    
    static public String encode(BigInteger a)
    {BigInteger y,k;
     String rx="",m="";   
     int i,j=1;
               
     k=new BigInteger("58");   
     
          
     while(j!=0)
      {y=a.mod(k);   
       i=y.intValue();
       rx=rx+b58tab[i];
       a=a.divide(k);
       j=a.intValue();
      }
     
     rx=rx+"@";
                        
     for(i=rx.length()-2;i>=0;--i)
      {m=m+rx.charAt(i);
      }
     
     rx=m;        
     return rx;
    }
    
    // for testing only .,. 
    public static void main(String[] args)
    {BigInteger n;
     String m;   
        
     n=H2bInt(hexIn);   
     m=encode(n);
     System.out.print("WIF="+m); 
    }    
 
}
