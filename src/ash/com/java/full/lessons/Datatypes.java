package ash.com.java.full.lessons;

public class Datatypes {
	
	
	public static void main(String[] args) {
		/*
		String searchMe = "This is a long string to search from";
		String subString = "from";
		boolean isFound = false;
		int max = searchMe.length();
		System.out.println("1. maximum iteration for search : "+max);
		int startingPosition = 0;
		int endingPosition = 0;
		
		search:
		for(int i = 0; i < max; i++) {
			int n = subString.length();
			int j = i;
			int k = 0;
			while(n-- != 0) {
				if(searchMe.charAt(j++) != subString.charAt(k++)) {
					continue search; 
				} else
					endingPosition = j;
			}
			isFound = true;
			if(isFound)
				startingPosition = i;
			break search;
		}
	
		System.out.println(isFound ? "found it; starting pos : "
				+ startingPosition + ", ending pos : " + endingPosition
				: "didn't find");*/
		
		int aNumber = 3;
		
		if (aNumber >= 0) {
		    if (aNumber == 0)
		        System.out.println("first string");
		} else 
		    	System.out.println("second string");
		System.out.println("third string");
	}
}
