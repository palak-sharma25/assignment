import java.util.Scanner;

public class Palindrom {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string:");
		String test = sc.nextLine();
		System.out.println(test+findShortestLengthMissingString(test));
	}

	private static String findShortestLengthMissingString(String test) {

		String shortestString = "";
		for(int i = 0;i< test.length(); i++){
			if(!isPalindrom(test.substring(i))){
				shortestString = test.charAt(i) + shortestString;
			}
			else{
				break;
			}
		}
		return shortestString;
	}

	private static boolean isPalindrom(String test) {
		for(int i=0, j=test.length() -1 ;i<test.length();i++,j--){
			if(test.charAt(i) != test.charAt(j)){
				return false;
			}
		}
		return true;
	}
}
