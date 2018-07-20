package ash.com.junk.serialize.deserialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializing {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Data data = new Data("fuck life");
		 try
	        {   
	            //Saving of object in a file
	            FileOutputStream file = new FileOutputStream("data.ser");
	            // Method for serialization of object
	            ObjectOutputStream out = new ObjectOutputStream(file);
	            out.writeObject(data);
	            out.flush();
	            out.close();
	            System.out.println("Object has been serialized");
	        }
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	        }
	}
}
