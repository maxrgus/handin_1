package com.srebmem;

import java.util.*;
import java.io.*;

/**
 * Main.java
 * Purpose: Simple administration of a member register for a sport association.
 *
 * @author Maximilian Gustafsson and Dominika Wróblewska
 * @version 1.0 2016-02-25
 */

public class Main {

    /**
     * The main method for the program
     *
     * @param args not used
     * @throws IOException Not handled
     */
    public static void main(String[] args)
	throws IOException {
	
	String pathToRegister = "com/srebmem/medlemsregister.txt";
	MemberList ml = new MemberList();
	ConsoleMenu menu = new ConsoleMenu();
	Scanner input = new Scanner(System.in);
	List<Member> members = ml.readRegisterFromFile(pathToRegister);
	ml.fillArchiveList(members);
	boolean run = true;
	int userInput;
	while (run == true) {
	    menu.printMainMenu();
	    userInput = input.nextInt();
	    switch (userInput) {
	    case 1:
		menu.printSortingMenu();
		userInput = input.nextInt();
		switch (userInput) {
		case 1:
		    // sorted by familyName
		    break;
		case 2:
		    // sorted by givenName
		    break;
		case 3:
		    // sorted by birthday
		    break;
		case 4:
		    System.out.println(members);
		    break;
		case 5: 
		    
		}
	    case 2:
		ml.addMember(members);
		break;
	    case 3:
		System.out.println(members);
		ml.removeMember(members);
		break;
	    case 4:
	        ml.printInactiveMembers(members);
		ml.activateMember(members);
		break;
	    case 5:
		System.out.println(members);
		ml.deActivateMember(members);
		break;
	    case 6:
	        ml.printTeams(members);
		break;
	    case 7:
		ml.saveMembersOnExit(members);
		run = false;
		break;
	    }
	}


    }

}
