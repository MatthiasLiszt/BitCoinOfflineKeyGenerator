import java.security.MessageDigest;

/**
 * Write a description of class SHA256hash here.
 * 
 * @author  Matthias Liszt
 * @version 0.0joseph
 */
public class SHA256hash
{
    // instance variables - replace the example below with your own
    private int x;
    static String iSeed;

    /**
     * Constructor for objects of class SHA256hash
     */
    public SHA256hash(String m)
    {
        // initialise instance variables
        x = 0;
        iSeed=m;
        
    }

    public static String exe(String m)throws Exception
    {byte[] o;
     int i;
     char c;
     MessageDigest md;
     
     //System.out.print("SHA256...");
     
     md = MessageDigest.getInstance("SHA-256"); 
     md.update(m.getBytes());
     o=md.digest();
     
     String r=new String(o);
     
     // normalizes to 32 characters or 256 bits - in case it might be shorter
     c=0;
     while(r.length()<32)
      {r=c+r;}
     
     System.out.print("iSe@");
     return r;
    }    
    
    public static byte[] exec(byte[] m)throws Exception
    {byte[] o;
     int i;
     char c;
     MessageDigest md;
     
     //System.out.print("SHA256...");
     
     md = MessageDigest.getInstance("SHA-256"); 
     md.update(m);
     o=md.digest();
           
          
     System.out.print("iSeC@");
     return o;
    }    
}
