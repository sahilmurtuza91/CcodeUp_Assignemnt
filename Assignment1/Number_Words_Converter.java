/* This class helps us to convery the digit to words.
   Class Owner: Sahil Murtuza
   Date: 16-09-2025
*/
import java.util.Scanner;

public class Number_Words_Converter{
	// Array to store words for numbers from 0 to 19
	private static final String[] belowTwenty = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

	// Array to store words for tens multiples from 20 onwards
    private static final String[] tens= {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Entre the number");
		int num=0;
		
		// checking for the correct user input
		while(true){
            if(sc.hasNextInt()){
                num=sc.nextInt();
				if(num<1000){
					break;
				}
				else{
                    System.out.println("Enter the number bellow 1000");
                }
            }else{
                System.out.println("Enter integer value");
                sc.nextLine(); // consume invalid input
            }
        }
        sc.close();
		
		// Creating Object
		Number_Words_Converter n=new Number_Words_Converter();
		// Call the method to print the number into words
		n.numberToWord(num);
		
	}
	public void numberToWord(int num){
		 // Handle negative numbers by printing minus
		if(num<0){
			System.out.print("Minus ");
			num=-num;
		}
		 // Handle the number between 0 to 19 by using array
		if(num>=0 && num<20){
			System.out.println(belowTwenty[num]);
		}
		// handle numble between 20 to 99 using array
		else if(num<100){
			int tenDigit=num/10;  //Obtain tens place
			int unitDigit=num%10; //Obtain units place
			if(unitDigit==0){
				System.out.println(tens[tenDigit]);
			}
			else{
				System.out.println(tens[tenDigit]+" "+belowTwenty[unitDigit]);
			}
		}
		// handle number between 100 t0 999
		else if(num<1000){
			int hundredDigit=num/100;  //Obtain hundreds place
			int unitDigit=num%100;
			if(unitDigit==0){
				System.out.println(belowTwenty[hundredDigit]+" hundred");
			}
			else if(unitDigit<20){
				System.out.println(belowTwenty[hundredDigit]+" hundred "+belowTwenty[unitDigit]);
			}
			else{
				int tenDigit=unitDigit/10;
				int unitDigit1=unitDigit%10;
				if(unitDigit==0){
                    System.out.println(belowTwenty[hundredDigit]+" Hundred "+tens[tenDigit]);
                }
                else{
                    System.out.println(belowTwenty[hundredDigit]+" Hundred "+tens[tenDigit]+" "+belowTwenty[unitDigit1]);
                }
			}
		}
	}
	
}