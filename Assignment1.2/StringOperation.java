/* This class provides methods to perform various operations on strings.
   Owner name: Sahil Murtuza
   Date: 19-09-2025
*/
import java.util.Scanner;

public class StringOperation {

    private String currentString = ""; // This is used to track the string

    // This methods help us to append string to another string
    public void append(String newString) {
        currentString = currentString + newString;
    }

    // Replace all occurrences of one string with the other string
    public void replace(String a, String b) {
        String result = "";
        int i = 0;
        while (i < currentString.length()) {
            boolean match = true;
            if (i + a.length() <= currentString.length()) {
                for (int j = 0; j < a.length(); j++) {
                    if (currentString.charAt(i + j) != a.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            } else {
                match = false;
            }

            if (match) {
                result = result + b;
                i = i + a.length();
            } else {
                result = result + currentString.charAt(i);
                i++;
            }
        }
        currentString = result;
    }

    // This method helps us to Sort the characters alphabetically
    public String sort() {
        char[] arr = new char[currentString.length()];
        for (int i = 0; i < currentString.length(); i++) {
            arr[i] = currentString.charAt(i);
        }

        // using the bubble sort to sort the string alphabetically
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
        }
        currentString = result;
        return currentString;
    }

    // This method helps in reversing the strings
    public String reverse() {
        String result = "";
        for (int i = currentString.length() - 1; i >= 0; i--) {
            result = result + currentString.charAt(i);
        }
        currentString = result;
        return currentString;
    }

    //Count words in the sentence
    public int countWords() {
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < currentString.length(); i++) {
            char c = currentString.charAt(i);
            if (c != ' ' && !inWord) {
                count++;
                inWord = true;
            } else if (c == ' ') {
                inWord = false;
            }
        }
        return count;
    }

    //Check palindrome
    public boolean isPalindrome() {
        int left = 0;
        int right = currentString.length() - 1;
        while (left < right) {
            if (currentString.charAt(left) != currentString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // This method Splice the string
    public String splice(int start, int end) {
        if (start < 0 || end > currentString.length() || start > end) {
            return "Invalid range";
        }
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + currentString.charAt(i);
        }
        currentString = result;
        return currentString;
    }

    // Split 
    public String[] split(String delimiter) {
        int parts = 1;
        for (int i = 0; i <= currentString.length() - delimiter.length(); i++) {
            boolean match = true;
            for (int j = 0; j < delimiter.length(); j++) {
                if (currentString.charAt(i + j) != delimiter.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                parts++;
                i += delimiter.length() - 1;
            }
        }

        String[] result = new String[parts];
        int index = 0;
        String temp = "";
        for (int i = 0; i < currentString.length();) {
            boolean match = true;
            if (i + delimiter.length() <= currentString.length()) {
                for (int j = 0; j < delimiter.length(); j++) {
                    if (currentString.charAt(i + j) != delimiter.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            } else {
                match = false;
            }

            if (match) {
                result[index++] = temp;
                temp = "";
                i += delimiter.length();
            } else {
                temp = temp + currentString.charAt(i);
                i++;
            }
        }
        result[index] = temp;
        return result;
    }

    // Maximum repeating character
    public char maxRepeatingCharacter() {
        int[] freq = new int[256];
        for (int i = 0; i < currentString.length(); i++) {
            freq[currentString.charAt(i)]++;
        }
        int max = 0;
        char result = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                result = (char) i;
            }
        }
        return result;
    }

    //  Shift string 
    public String shift(int n) {
        if (currentString.length() == 0){
			return currentString;
		}
        n = n % currentString.length();
        String left = "";
        String right = "";
        for (int i = 0; i < n; i++) {
            left = left + currentString.charAt(i);
        }
        for (int i = n; i < currentString.length(); i++) {
            right = right + currentString.charAt(i);
        }
        currentString = right + left;
        return currentString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringOperation t1 = new StringOperation();

        System.out.print("Enter initial string: ");
        t1.currentString = sc.nextLine();

        int choice;
        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Append");
            System.out.println("2. Replace");
            System.out.println("3. Sort");
            System.out.println("4. Reverse");
            System.out.println("5. Count Words");
            System.out.println("6. Check Palindrome");
            System.out.println("7. Splice");
            System.out.println("8. Split");
            System.out.println("9. Max Repeating Character");
            System.out.println("10. Shift String");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Enter integer value");
                sc.nextLine();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String newStr = sc.nextLine();
                    t1.append(newStr);
                    System.out.println("Result: " + t1.currentString);
                    break;
                case 2:
                    System.out.print("Enter string to replace: ");
                    String a = sc.nextLine();
                    System.out.print("Enter replacement: ");
                    String b = sc.nextLine();
                    t1.replace(a, b);
                    System.out.println("Result: " + t1.currentString);
                    break;
                case 3:
                    System.out.println("Sorted: " + t1.sort());
                    break;
                case 4:
                    System.out.println("Reversed: " + t1.reverse());
                    break;
                case 5:
                    System.out.println("Word Count: " + t1.countWords());
                    break;
                case 6:
                    System.out.println("Palindrome: " + t1.isPalindrome());
                    break;
                case 7:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter end index: ");
                    int end = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Spliced: " + t1.splice(start, end));
                    break;
                case 8:
                    System.out.print("Enter delimiter: ");
                    String del = sc.nextLine();
                    String[] parts = t1.split(del);
                    System.out.print("Split result: ");
                    for (int i = 0; i < parts.length; i++) {
                        System.out.print(parts[i] + " | ");
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.println("Max Repeating Character: " + t1.maxRepeatingCharacter());
                    break;
                case 10:
                    System.out.print("Enter shift amount: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Shifted: " + t1.shift(n));
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 11);
        sc.close();
    }
}
