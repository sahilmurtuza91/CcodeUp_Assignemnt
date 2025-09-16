/* This class helps us to find the length of longest substring without repeating characters.
   Class Owner: Sahil Murtuza
   Date: 16-09-2025
*/
import java.util.Scanner;
public class Longest_Substring{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String s=sc.nextLine(); // Assigning user input to s
		s.close();
		Longest_Substring l=new Longest_Substring(); // creating object
		System.out.println(l.maxLenSubstring(s)); // call the method to find maxLenSubstring
		
	}
	// Method to find the length of longest substring without repeating characters
	public int maxLenSubstring(String s){
		int maxlen=0;
		for(int i=0; i<s.length(); i++){
			String s1=""; //Temporary substring starting at index
			for(int j=i; j<s.length(); j++){
				char currentchar=s.charAt(j);
				
				// Checking the current character that is present in the s1 string or not
				if(s1.indexOf(currentchar)!=-1){
					break; // if repeated character found then stop incrementing the s1
				}
				else{
					s1=s1+currentchar; // Append current character to the s1 string
					maxlen=Math.max(maxlen,s1.length());  // find the maximum length
				}
			}
		}
		return maxlen; // return maximum length
	}
}