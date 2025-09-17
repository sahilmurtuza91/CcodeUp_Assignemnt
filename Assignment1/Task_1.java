/* This class helps in expanding each character by repeating it according to the digit that follows.
   Class Owner: Sahil Murtuza
   Date: 16-09-2025
*/

import java.util.Scanner;

public class Task_1{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);  // Scanner to read input
		System.out.println("Enter the string with digit to expand it's character");
		String s=sc.nextLine();  // Input string
		
		StringBuilder s1 = new StringBuilder();  // To store result
		
		
			for(int i=0; i<s.length(); i++){  // Iterate over each charac  
				if(Character.isDigit(s.charAt(i))){  // If current char is a digit
					int n=Character.getNumericValue(s.charAt(i));  // Convert char to number
					if(i==0){  // If digit is at the start, skip
						continue;
					}
					
					for(int j=0; j<n; j++){  // Repeat previous character 'n' times
					s1.append(s.charAt(i-1));
					}
					
				}
			}
			if(!Character.isDigit(s.charAt(s.length() - 1))){  // If last char is not digit, append it
			s1.append(s.charAt(s.length() - 1));
			}

			if(s1.length()==0){  // If result is empty, print original string
				System.out.println(s);
			}
			else{
				System.out.println(s1);
			}
		
		
	}		
}
