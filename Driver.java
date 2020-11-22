import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

//This program uses serialization and a menu system to 
//present users with options to add information to a file, retrieve it, and display it. 
//Author: Vanesa Serrano


public class Driver {

	public static void main(String[] args) {
		//variables
		int selection; 
		
		//data input
		Scanner kb = new Scanner (System.in);
		
		//menu
		ArrayList <person> dataArray = new ArrayList<>();
		
		//do-while loop to display menu
		do {
			System.out.println("\t 1. Add information into a file");
			System.out.println("\t 2. Retreive information from a file and display it");
			System.out.println("\t 3. Delete information");
			System.out.println("\t 4. Update information");
			System.out.println("\t 5. Exit");
			
			selection = kb.nextInt();
			
			//case switch
			switch(selection) {
			case 1: 
				try {
					FileOutputStream outFile; //open file output stream
					outFile = new FileOutputStream("data.bin"); //creates file 
					ObjectOutputStream objectStream = new ObjectOutputStream(outFile); //open object stream
					
					//request information from user
					kb.nextLine();
					System.out.println("Enter your name: ");
					String name = kb.nextLine();
					//kb.nextLine();
					
					System.out.println("Enter your phone number: ");
					String phoneNum = kb.nextLine();
					
					System.out.println("Enter your date of birth: ");
					String dob = kb.nextLine();
					
					System.out.println("Enter your email address: ");
					String email = kb.nextLine();
					
					//add information to array list
					dataArray.add(new person (name, phoneNum, dob, email));
					
					//add information from array list to file
					objectStream.writeObject(dataArray);
					
					//close files
					outFile.close();
					objectStream.close();
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}	
				break;
			case 2: 
				try {
					FileInputStream inFile; //open file output stream
					inFile = new FileInputStream("data.bin"); //creates file 
					ObjectInputStream objectStream = new ObjectInputStream(inFile); //open object stream
					
					try {
						dataArray = (ArrayList)objectStream.readObject();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
					//close files
					inFile.close();
					objectStream.close();
					
					//display information in array list
					for (int i = 0; i < dataArray.size(); i++) {
			            System.out.println(dataArray.get(i));
					}
					System.out.println("");
						
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}	
				break;
			case 3: 
				try {
					FileOutputStream outFile; //open file output stream
					outFile = new FileOutputStream("data.bin"); //creates file 
					ObjectOutputStream objectStream = new ObjectOutputStream(outFile); //open object stream
					
					//display information in array list
					for (int i = 0; i < dataArray.size(); i++) {
			            System.out.println("Entry #" + (i)+ " " + dataArray.get(i));
					}
					System.out.println("");
					
					//ask user to choose file to delete
					System.out.println("Which entry would you like to delete?");
					int key = kb.nextInt();
					
					dataArray.remove(key);
					
					//add information from array list to file
					objectStream.writeObject(dataArray);
					
					//close files
					outFile.close();
					objectStream.close();
					
					//display information in array list
					System.out.println("Remaining items: ");
					for (int i = 0; i < dataArray.size(); i++) {
			            System.out.println("Entry #" + (i)+ " " + dataArray.get(i));
					}
					System.out.println("");
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}	
				break;
			case 4: 
				try {
					FileOutputStream outFile; //open file output stream
					outFile = new FileOutputStream("data.bin"); //creates file 
					ObjectOutputStream objectStream = new ObjectOutputStream(outFile); //open object stream
					
					//display information in array list
					for (int i = 0; i < dataArray.size(); i++) {
			            System.out.println("Entry #" + (i)+ " " + dataArray.get(i));
					}
					System.out.println("");
					
					//ask user to choose file to delete
					System.out.println("Which entry would you like to update?");
					int key = kb.nextInt();
					
					//request information from user
					kb.nextLine();
					System.out.println("Enter your name: ");
					String name = kb.nextLine();
					dataArray.get(key).setName(name);
					
					System.out.println("Enter your phone number: ");
					String phoneNum = kb.nextLine();
					dataArray.get(key).setPhoneNum(phoneNum);
					
					System.out.println("Enter your date of birth: ");
					String dob = kb.nextLine();
					dataArray.get(key).setDob(dob);
					
					System.out.println("Enter your email address: ");
					String email = kb.nextLine();
					dataArray.get(key).setEmail(email);
					
					//add information from array list to file
					objectStream.writeObject(dataArray);
					
					//close files
					outFile.close();
					objectStream.close();
					
					//display information in array list
					System.out.println("Remaining items: ");
					for (int i = 0; i < dataArray.size(); i++) {
			            System.out.println("Entry #" + (i)+ " " + dataArray.get(i));
					}
					System.out.println("");
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}	
				
				break;	
			case 5: 
				System.out.println("Closing program...");
				
				break;
			default:
				System.out.println("Please enter a valid option");
			}
			
		} while (selection != 5);
		
		kb.close();
	}

}
