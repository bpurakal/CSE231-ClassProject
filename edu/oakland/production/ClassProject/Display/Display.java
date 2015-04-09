package edu.oakland.production.ClassProject.Display;

import edu.oakland.production.ClassProject.Middleware.*;

import java.util.*;


public class Display {
	private boolean runnable;
	private boolean isFirstRun = true;
	private boolean arrayList;
	private boolean binaryOption;
	private boolean hashTableOption;
	private boolean studentOption;
	private boolean searchOption;
	private Scanner scan = new Scanner(System.in);
	private int menuKey;
	private String menuString;
	private Middleware middleware = new Middleware();
	private long returnTime;
	
	private int a = -1;
	private int b;
	private int c;
	
	public Display(boolean run) {
		this.runnable = run;
	}
	
	public void runMainMenu() {
		
		while (runnable) {
			if (isFirstRun) {
				System.out.println("Hello. Please press the corresponding key to enter the JCF container: ");
				this.isFirstRun = false;
			}
			else {
				System.out.println("Hello again! Please press the corresponding key to enter the JCF container: ");
			}
			
			System.out.println("1. ArrayList and Linked List");
			System.out.println("2. BinaryTree");
			System.out.println("3. Hash Table");
			System.out.println("4. Enter Students.");
			System.out.println("5. Exit.");
			
			menuString = scan.next();
			switch (menuString) {
			case "1":
				arrayList = true;
				while (arrayList) {
					System.out.println("You have selected ArrayList and LinkedList. Please select the number of elements: ");
					System.out.println("1. 100,000 elements.");
					System.out.println("2. 200,000 elements.");
					System.out.println("3. 400,000 elements.");
					
					menuString = scan.next();
					switch (menuString) {
					case "1":
						System.out.println("You have selected 100,000 elements.");
						middleware.setNumberOfElements(100);
						middleware.createArrayList();
						returnTime = middleware.sortArrayList(true);
						System.out.println("The search time for arrayList selection sort was: " + returnTime);
						returnTime = middleware.sortLinkedList(true);
						System.out.println("The time for LinkedList selection sort was: " + returnTime);
						
						//Show Big Oh
						System.out.println("The big oh data is:\n\t ArrayList: " + middleware.bigOAL(true) + "\n\t Linked List" + middleware.bigOLL(true));
						
						//Show Big Oh
						//int [] BigO = middleware.getBigOData();
						//System.out.println("The big oh data is: ");
						//for (int i = 0; i < BigO.length; i++){
						//	System.out.println(BigO[i];
						//}
						
						// System.out.println("The big O dependency is " + middleware.bigO);
						
						returnTime = middleware.sortLinkedList(false);
						System.out.println("The time for LinkedList bubble sort was: " + returnTime);
						returnTime = middleware.sortArrayList(false);
						System.out.println("The search time for arrayList bubble sort was: " + returnTime);
						//System.out.println("The search time for LinkedListbubble sort was: " + returnTime);
						
						//Show Big Oh
						System.out.println("The big oh data is:\n\t ArrayList: " + middleware.bigOAL(false) + "\n\t Linked List" + middleware.bigOLL(false));
						
						searchOption = true;
						while (searchOption){
							System.out.println("What is the value you want to search for");
							menuString = scan.next();
							try
							{
								int searchInt = Integer.parseInt(menuString);
								if (searchInt >= 100 && searchInt <= 1000){
									//Linear Search
									returnTime = middleware.searchLinkedList(searchInt, false);
									System.out.println("The time for LinkedList Linear search was: " + returnTime);
									returnTime = middleware.searchArrayList(searchInt, false);
									System.out.println("The time for ArrayList Linear search was: " + returnTime);
									//Binary Search
									returnTime = middleware.searchLinkedList(searchInt, true);
									System.out.println("The time for LinkedList Binary search was: " + returnTime);
									returnTime = middleware.searchArrayList(searchInt, true);
									System.out.println("The time for LinkedList Binary search was: " + returnTime);
									
									searchOption = false;
								}
								else{
									System.out.println("Not a valid value.");
								}
							}
							catch (Exception e){
								System.out.println("Not a numerical value.");
							}
						}

						arrayList = false;
						break;
					case "2":
						System.out.println("You have selected 200,000 elements.");
						middleware.setNumberOfElements(200000);
						middleware.createArrayList();
						returnTime = middleware.sortArrayList(true);
						
						arrayList = false;
						break;		
						
					case "3":
						System.out.println("You have selected 400,000 elements.");
						middleware.setNumberOfElements(400000);
						middleware.createArrayList();

						arrayList = false;
						break;
						
					default:
						System.out.println("That was not a valid input. Please try again!");
						continue;
					}
				}
				break;

			case "2":	
				binaryOption = true;
				while (binaryOption) {
					System.out.println("You have selected Hash Tables. Please select the number of elements: ");
					System.out.println("1. 100,000 elements.");
					System.out.println("2. 200,000 elements.");
					System.out.println("3. 400,000 elements.");
					
					menuString = scan.next();
					switch (menuString) {
					case "1":
						//middleware.createBinary(100000);
						
						if (a == -1){
							searchOption = true;
							while (searchOption){
								System.out.println("What is the first int to search?");
								try{
									this.a = scan.nextInt();
									if (a == -1){
										searchOption = true;
									}
									else {
									searchOption = false;
									}
								}
								catch (Exception e){
									System.out.println("Enter a valid value");
								}
							}
							
							searchOption = true;
							while (searchOption){
								System.out.println("What is the 2nd int to search?");
								try{
									this.b = scan.nextInt();
									searchOption = false;
								}
								catch (Exception e){
									System.out.println("Enter a valid value");
								}
							}
							
							searchOption = true;
							while (searchOption){
								System.out.println("What is the 3rd int to search?");
								try{
									this.c = scan.nextInt();
									searchOption = false;
								}
								catch (Exception e){
									System.out.println("Enter a valid value");
								}
							}
						}
						
						//PREORDER SEARCH
						//ORDER SEARCH
						
						binaryOption = false;
						break;
					case "2":
						
						binaryOption = false;
						break;
					case "3":
						
						binaryOption = false;
						break;
					default:
						System.out.println("That was not a valid input. Please try again!");
						continue;
					}
					
					break;
				}
			case "3":
				hashTableOption = true;
				while (hashTableOption) {
					System.out.println("You have selected Hash Tables. Please select the number of elements: ");
					System.out.println("1. 100,000 elements.");
					System.out.println("2. 200,000 elements.");
					System.out.println("3. 400,000 elements.");
					
					menuString = scan.next();
					switch (menuString) {
					case "1":
						System.out.println("You have selected 100,000 elements.");
						middleware.createHashTable(100000);
						
						if (a == -1){
							searchOption = true;
							while (searchOption){
								System.out.println("What is the first int to search?");
								try{
									this.a = scan.nextInt();
									if (a == -1){
										searchOption = true;
									}
									else {
									searchOption = false;
									}
								}
								catch (Exception e){
									System.out.println("Enter a valid value");
								}
							}
							
							searchOption = true;
							while (searchOption){
								System.out.println("What is the 2nd int to search?");
								try{
									this.b = scan.nextInt();
									searchOption = false;
								}
								catch (Exception e){
									System.out.println("Enter a valid value");
								}
							}
							
							searchOption = true;
							while (searchOption){
								System.out.println("What is the 3rd int to search?");
								try{
									this.c = scan.nextInt();
									searchOption = false;
								}
								catch (Exception e){
									System.out.println("Enter a valid value");
								}
							}
						}
						
						returnTime = middleware.searchValuesAndGetTime(a);
						System.out.println("Saarched: " + a + "\tHash Search Took: " + returnTime);
						returnTime = middleware.searchValuesAndGetTime(b);
						System.out.println("Saarched: " + b + "\tHash Search Took: " + returnTime);
						returnTime = middleware.searchValuesAndGetTime(c);
						System.out.println("Saarched: " + c + "\tHash Search Took: " + returnTime);
						
						/*System.out.println("For " + a + " " + middleware.value1time
								+ " " + middleware.value1itemsearched + " " +
								middleware.value1counter + " " + middleware.value1bigO);
						System.out.println("For " + a + " " + middleware.value2time
								+ " " + middleware.value2itemsearched + " " +
								middleware.value2counter + " " + middleware.value2bigO);
						System.out.println("For " + a + " " + middleware.value3time
								+ " " + middleware.value3itemsearched + " " +
								middleware.value3counter + " " + middleware.value3bigO);*/

						hashTableOption = false;
						break;
					default:
						System.out.println("That was not a valid input. Please try again!");
						continue;
					}
				}
				break;

			case "4":
				System.out.println("You have selected class schedule. Please enter students data");
				createClass();

				studentOption = true;
				while (studentOption) {
					System.out.println("What do you want to do with the class. Please select the number of elements: ");
					System.out.println("1.) Cut Last 5 students");
					System.out.println("2.) Process Scholarships");
					System.out.println("3.) Reinstate Students to class");
					System.out.println("4.) Exit You will lose everything");
					
					menuString = scan.next();
					
					switch(menuString)
					{
					case "1":
						System.out.println("Cut Class the class");
						//String temp = middleware.CutClass();
						studentOption = false;
						break;
					case "2":
						System.out.println("Scholarship is applied");
						//temp = middleware.Scholarship();
						studentOption = false;
						break;
					case "3":
						System.out.println("Reset Class");
						//temp = middlewear.ResetClass();
						studentOption = false;
						break;
					case "4":
						studentOption = false;
						break;
					default:
						System.out.println("Invalid entry.");
					}
				}
				break;
			case "5":
				runnable = false;
				break;
			default:
				System.out.println("That was not a valid input. Please try again!");
				continue;
			}

		}
	}
	
	private boolean createClass(){
		
		boolean stayIn = true;
		int counter = 0;
		do{
			boolean notSuccessful = true;
			String tempToParse;
			String temp;
			int grizzlyID;
			String name;
			String major;
			double gpa;
			int thesisGrade;
			System.out.println("Enter student data:");
			System.out.println("What is the student's Grizzly ID?");
			tempToParse = scan.next();
			do{
				try{
					grizzlyID = Integer.parseInt(tempToParse);
					notSuccessful = false;
				} catch (Exception e) {
					System.out.println("ID Entered is not a valid number, What is the student's Grizzly ID?");
					tempToParse = scan.next();
				}
			} while (notSuccessful);
			notSuccessful = true;
			
			System.out.println("What is the student's name?");
			name = scan.next();
			System.out.println("What is the major of the student");
			major = scan.next();
		
			System.out.println("What is the GPA");
			tempToParse = scan.next();
			do{
				try{
					gpa = Double.parseDouble(tempToParse);
					notSuccessful = false;
				} catch (Exception e) {
					System.out.println("GPA Entered is not a valid number, What is the GPA?");
					tempToParse = scan.next();
				}
			} while (notSuccessful);
			notSuccessful = true;
			System.out.println("Thesis grade?");
			tempToParse = scan.next();
			do{
				try{
					thesisGrade = Integer.parseInt(tempToParse);
					notSuccessful = false;
				} catch (Exception e) {
					System.out.println("Thesis Entered is not a valid number, What is the student's thesis grade?");
					tempToParse = scan.next();
				}
			} while (notSuccessful);
			notSuccessful = true;
			
			///Create the student
			
			counter++;
			if (counter >= 10){
				stayIn = false;
			}
		} while (stayIn);
		return true;
	}
}