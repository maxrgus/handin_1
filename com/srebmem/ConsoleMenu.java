package com.srebmem;

import java.util.*;

/**
 * ConsoleMenu.java
 * Purpose: Methods for printing the console menu.
 *
 * @author Maximilian Gustafsson and Dominika Wróblewska
 * @version 1.0 2016-02-25
 */
public class ConsoleMenu {
    public void printMainMenu() {
	System.out.println("-------------------");
	System.out.println("Main menu\n");
	System.out.println("1. Print list\n");
	System.out.println("2. Add member\n");
	System.out.println("3. Remove member\n");
	System.out.println("4. Activate member\n");
	System.out.println("5. Deactivate member\n");
	System.out.println("6. Print teams\n");
	System.out.println("7. Quit");
	System.out.println("-------------------");
    }
    public void printSortingMenu() {
	System.out.println("----------------------");
	System.out.println("Sorting menu\n");
	System.out.println("1. by Family name\n");
	System.out.println("2. by Given name\n");
	System.out.println("3. by Birthdate\n");
	System.out.println("4. by Member ID\n");
	System.out.println("5. Return to main menu\n");
	System.out.println("----------------------");
    }
    public int askForIntRange() {
	Scanner input = new Scanner(System.in);
	try {
	    return input.nextInt();
	} catch (InputMismatchException e) {
	    return 99999;
	}
    }
}
