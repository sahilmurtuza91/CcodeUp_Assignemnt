/* This class helps us check whether a given number is prime or not.
   Class Owner: Sahil Murtuza
   Date: 16-09-2025
*/

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = 0;

        // Input validation loop ensures user enters a positive integer
        while(true){
            if(sc.hasNextInt()){
                n=sc.nextInt();
                if(n>0){  // checking for the positive integer
                    break;
                }else{
                    System.out.println("Enter some positive value");
                }
            }else{
                System.out.println("Enter integer value");
                sc.nextLine(); // consume invalid input
            }
        }
        sc.close();
        Task_3 t=new Task_3();
        t.CheckPrime(n); // Call CheckPrime method to check if n is prime or not
    }

    // Method to check whether n is a prime number or not
    public void CheckPrime(int n){
        int count=0;

        if(n==1){
            System.out.println("Not a prime Number");
            return;
        }

        for(int i=2;i<=Math.sqrt(n);i++) {
            if (n%i==0) {
                count=1;
            }
        }

        if(count==0){
            System.out.println("Prime Number");
        }else{
            System.out.println("Not a prime Number");
        }
    }
}
