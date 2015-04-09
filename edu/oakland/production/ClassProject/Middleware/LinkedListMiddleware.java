package edu.oakland.production.ClassProject.Middleware;

import java.util.*;
import edu.oakland.production.ClassProject.Database.LinkedListDB;

/**
*@author Zack Waldrup
*Updates: "wasPresent" Method. Proper Methods Called on LinkedListDB
*@version version 2.6 150408
*@since version 2.4 150403
*/
public class LinkedListMiddleware {
	
	/**
	*Instance variables needed for the constructors and methods
	*/
	int listSize;
	int iMin;
	long taskTime;
	int value;
	public static int timesThrough;
	static long startTime, endTime;
	private boolean valuePresent = false;
	public LinkedListDB<Integer> db;
	
	/**
	@return True if the previous search was successful
	*/
	public boolean wasPresent() {
		return valuePresent;
	}
	
	/**
	*Overloaded constructor for the LinkedListMiddleware class.
	*Passes the requested list size to the database.
	*@param listSize of type "int"
	*/
	public LinkedListMiddleware(int listSize) {
		this.listSize = listSize;
		db = new LinkedListDB<Integer>();
		this.createLinkedList(listSize);
	}	
	
	/**
	*This method performs a Selection Sort on a LinkedList
	*Big O: O(n^2)
	*/
	public void selectSort() {
		startTime = System.currentTimeMillis();
		
		for (int j = 0; j < listSize; j++) {
			iMin = j;
			for (int i = j + 1; i < listSize; i++) {
       			if (db.get(i).getData().intValue() < db.get(iMin).getData().intValue()) {
            		iMin = i;
            	}
            }
            if(iMin != j) {
            	swapValues(j, iMin);
            }
        }
        endTime = System.currentTimeMillis();
		taskTime = endTime - startTime;
		System.out.println("Selection Sort time taken: " + taskTime);
	}
	
	/**
	*This method performs a Bubble Sort on a LinkedList
	*Big O: O(n^2)
	*/
	public void bubbleSort() {
		startTime = System.currentTimeMillis();
		
		for (int i = listSize - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if(db.get(j).getData().intValue() > db.get(j + 1).getData().intValue()){
					swapValues(j, j+1);
				}
			}
		}
		endTime = System.currentTimeMillis();
		taskTime = endTime - startTime;
		System.out.println("Bubble Sort time taken: " + taskTime);
	}
	
	/**
	*This method linearly searches a LinkedList
	*Big O: O(n)
	*@param value of type "int"
	*/
	public void linearSearch(int value) {
		this.value = value;
		valuePresent = false;
		String indexWithValue = "";
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < listSize; i++) {
			if(db.get(i).getData().intValue() == value) {
				valuePresent = true;
				indexWithValue += i + " ";
			}
		}
		System.out.println("Value found: " + valuePresent);
		endTime = System.currentTimeMillis();
		taskTime = endTime - startTime;
		System.out.println("Linear Search time taken: " + taskTime);
	}
	
	/**
	*This method conducts a binary searche on a LinkedList
	*Big O: O(log(n))
	*@param value of type "int"
	*/
	public void binarySearch(int value) {
		this.value = value;
		int lowIndex = 0;
		int highIndex = listSize - 1;
		timesThrough = 0;
		startTime = System.currentTimeMillis();
		
		while (lowIndex <= highIndex) {
			int middleIndex = (highIndex + lowIndex) / 2;
			if(db.get(middleIndex).getData().intValue() < value) {
				lowIndex = middleIndex + 1;
			} else if(db.get(middleIndex).getData().intValue() > value) {
				highIndex = middleIndex - 1;
			} else if(db.get(middleIndex).getData().intValue() == value){
				valuePresent = true;
				System.out.println("Found " + value + "at " + middleIndex);
				lowIndex = highIndex + 1;
			} else {
				System.out.println("Value is not in this list");
			}
			timesThrough++;
		}
		
		endTime = System.currentTimeMillis();
		taskTime = endTime - startTime;
		System.out.println("Binary Search time taken: " + taskTime);
		System.out.println("Binary Search times through: " + timesThrough);
	}
	
	/**
	*This method swaps the values of 2 elements in a LinkedList
	*@param indexOne of type "int"
	*@param indexTwo of type "int"
	*/
	public void swapValues(int indexOne, int indexTwo) {
		Integer temp = db.get(indexOne).getData();
		db.set(indexOne,db.get(indexTwo).getData());
		db.set(indexTwo, temp);
	}
	
	/**
	*Method for creating a LinkedList<Integer>
	*@param listSize of type "int"
	*@return list1 of type "LinkedList<Integer>"
	*/
	public void createLinkedList(int listSize) {
		this.listSize = listSize;
		
		for(int i = 0; i < listSize; i++) {
			db.add((Integer)randomInt(100, 1000));
		}
	}
	
	/**
	*This method gives a random number based on a maximum and
	*minimum range of selection
	*@param min of type "int"
	*@param max of type "int"
	*@return randomNumber of type "int"
	*/
	public static int randomInt(int min, int max) {
		Random rand = new Random();
		int randomNumber = rand.nextInt((max - min) + 1) + min;
		return randomNumber;
	}
	
}