/* This class provides methods to perform various operations on strings and numbers
   Owner name: Sahil Murtuza
   Date: 17-09-2025
*/
import java.util.Scanner;

public class StringNumberProcessor{

    private static final String[] belowTwenty = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy","Eighty", "Ninety"};

	// this methods count the frequency of character
    public String frequency(String userString){
        String resultString="";
        int i=0;
        while(i<userString.length()){
            char currentCharacter=userString.charAt(i);
            int countCharactert=1;
            while (i+1<userString.length()&&userString.charAt(i)==userString.charAt(i+1)){
                countCharactert++;
                i++;
            }
            resultString=resultString+currentCharacter+countCharactert;
            i++;
        }
        return resultString;
    }

	// This method find the longest substring without repeating character
    public int substring(String userString){
        int maxLength=0;
        for (int i=0;i<userString.length();i++){
            String tempString="";
            for (int j=i;j<userString.length();j++){
                char currentCharacter=userString.charAt(j);
                if (tempString.indexOf(currentCharacter)!=-1){
                    break;
                } else {
                    tempString=tempString+currentCharacter;
                    if (tempString.length()>maxLength){
                        maxLength=tempString.length();
                    }
                }
            }
        }
        return maxLength;
    }

	// Convert the number to words
    public String wordConverter(int number) {
        String result="";
        if (number<0) {
            result="Minus ";
            number=-number;
        }
        if (number>=0&&number<20) {
            result=result+belowTwenty[number];
        } else if(number<100){
            int tenDigit=number/10;
            int unitDigit=number%10;
            result=result+tens[tenDigit];
            if(unitDigit!=0){
                result=result+" "+belowTwenty[unitDigit];
            }
        } else if(number<1000) {
            int hundredDigit=number/100;
            int unitDigit=number%100;
            result = result+belowTwenty[hundredDigit]+" hundred";
            if (unitDigit!=0){
                result=result+" ";
                if(unitDigit<20) {
                    result=result+belowTwenty[unitDigit];
                }
				else{
                    int tenDigit=unitDigit/10;
                    int unitDigit1=unitDigit%10;
                    result=result+tens[tenDigit];
                    if(unitDigit1!=0){
                        result=result+" "+belowTwenty[unitDigit1];
                    }
                }
            }
        }
        return result;
    }

	// Expand the character based on the following digit
    public String expand(String userString){
    String resultString="";
    int i=0;
    while(i<userString.length()){
        char currentChar=userString.charAt(i);

        if (!Character.isDigit(currentChar)){
            resultString+=currentChar;
            i++;
            int repeatCount=0;
			// Now check the next character is digit and then calculate the repeat count
            while(i<userString.length()&&Character.isDigit(userString.charAt(i))){
                repeatCount=repeatCount*10+(userString.charAt(i)-'0');
                i++;
            }
            if(repeatCount>0){
                // Repeat the currentChar 
                for(int j=1;j<repeatCount;j++){
                    resultString+=currentChar;
                }
            }
        }else {
            i++; // Skip the index if the digits comes befor the character
        }
    }

    return resultString;
}

		
	// Checks if a given number is prime or not
    public String prime(int number){
        if(number<=1){
            return "Not a prime Number";
        }
        for(int i=2;i<=Math.sqrt(number);i++) {
            if(number%i==0){
                return "Not a prime Number";
            }
        }
        return "Prime Number";
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringNumberProcessor t1=new StringNumberProcessor();
        int choice;

        do{
            System.out.println("\n----- Menu -----");
            System.out.println("1. Frequency of characters");
            System.out.println("2. Longest substring without repeating characters");
            System.out.println("3. Convert number to words");
            System.out.println("4. Expand string based on digits");
            System.out.println("5. Check if a number is prime");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            while(!sc.hasNextInt()) {
                System.out.println("Enter integer value");
                sc.nextLine();
                System.out.print("Enter your choice: ");
            }
            choice=sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice){
                case 1:
                    System.out.print("Enter the string for frequency: ");
                    String freqInput=sc.nextLine();
                    System.out.println("Result: "+t1.frequency(freqInput));
                    break;

                case 2:
                    System.out.print("Enter the string for longest substring: ");
                    String substrInput=sc.nextLine();
                    System.out.println("Result: "+t1.substring(substrInput));
                    break;

                case 3:
                    int num;
                    do {
                        System.out.print("Enter the number below 1000: ");
                        while (!sc.hasNextInt()){
                            System.out.println("Enter integer value");
                            sc.nextLine();
                            System.out.print("Enter the number below 1000: ");
                        }
                        num=sc.nextInt();
                        sc.nextLine();
                        if (num>=1000) {
                            System.out.println("Enter the number below 1000");
                        }
                    }while (num>=1000);
                    System.out.println("Result: "+t1.wordConverter(num));
                    break;

                case 4:
                    System.out.print("Enter the string with digits to expand: ");
                    String expandInput=sc.nextLine();
                    System.out.println("Result: "+t1.expand(expandInput));
                    break;
                case 5:
                    int primeNum;
                    do {
                        System.out.print("Enter the number to check prime: ");
                        while(!sc.hasNextInt()){
                            System.out.println("Enter integer value");
                            sc.nextLine();
                        }
                        primeNum=sc.nextInt();
                        sc.nextLine();
                        if(primeNum<=0){
                            System.out.println("Enter some positive value");
                        }
                    } while (primeNum <= 0);
                    System.out.println("Result: "+t1.prime(primeNum));
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice !=6);
        sc.close();
    }
}
