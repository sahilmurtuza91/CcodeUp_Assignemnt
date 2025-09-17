/* This class helps us to count the frequencies of character and append it.
   Class Owner: Sahil Murtuza
   Date: 16-09-2025
*/

import java.util.Scanner;

public class Character_Frequency{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);  // Scanner to read input
		System.out.println("Enter the string");
		String s=sc.nextLine();  // Input string
		StringBuilder s1 = new StringBuilder(); // To store result
		int i=0;
		while(i<s.length()){
			char current = s.charAt(i);  // Current character
			int count=1;
			while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){  // Count repeated characters
				count++;
				i++;
			}
			s1.append(current);  // Append character
			s1.append(count);  // Append frequency
			i++;  // Move to next character
		}
		System.out.println(s1);  // Print result
	}
}