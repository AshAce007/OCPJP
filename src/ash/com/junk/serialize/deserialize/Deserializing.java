package ash.com.junk.serialize.deserialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializing {
	public static void main(String[] args) {
	        try
	        {   
	            // Reading the object from a file
	            FileInputStream file = new FileInputStream("data.ser");
	            ObjectInputStream in = new ObjectInputStream(file);
	             
	            // Method for deserialization of object
	            Data outputObject = (Data)in.readObject();
	             
	            in.close();
	            file.close();
	              
	            System.out.println("Object has been deserialized ");
	            System.out.println("str : "+outputObject.str);
	        
	        }
	         
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	        }
	         
	        catch(ClassNotFoundException ex)
	        {
	            System.out.println("ClassNotFoundException is caught");
	        }
	}
}
