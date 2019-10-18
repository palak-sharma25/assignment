
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SendMail {

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter no of friends");
		int num = sc.nextInt();
		String[][] friendsArray = new String[num][num];

		for(int i = 0; i< num; i++){

			System.out.println("Enter friends");
			friendsArray[i][0]  = sc1.nextLine();

			System.out.println("Enter comma separated list of friends");
			friendsArray[i][1]= sc1.nextLine();
		}
		System.out.println("Enter email adress");
		String emailAddress  = sc1.nextLine();

		System.out.println("Enter message");
		String message  = sc1.nextLine();

		sendMail(emailAddress, message, friendsArray);

	}

	static void sendMail(String emailAddress, String message, String[][] friendsArray){
		Set<String> recievers =  new HashSet<>();

		addReceivers(emailAddress, friendsArray, recievers,emailAddress);
		sendMail(recievers, message);
	}

	private static void sendMail(Set<String> recievers, String message) {

		recievers.stream().forEach(System.out::println);// and send mail with message

	}

	private static void addReceivers(String emailAddress, String[][] friendsArray, Set<String> recievers, String originalSender) {
		for(int i =0; i< friendsArray.length ; i++){
			if(emailAddress.equalsIgnoreCase(friendsArray[i][0])){
				String[] friends = friendsArray[i][1].split(",");
				for(int j =0; j<friends.length ; j++){
					if(!recievers.contains(friends[j]) && !friends[j].equalsIgnoreCase(originalSender)){
						recievers.add(friends[j]);
						addReceivers(friends[j],friendsArray,recievers, originalSender);
					}
				}
				break;
			}
		}
	}
}
