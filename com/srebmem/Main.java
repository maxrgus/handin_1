package com.srebmem;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

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
		userInput = menu.askForIntRange();
		switch (userInput) {
		case 1:
		    menu.printSortingMenu();
		    userInput = menu.askForIntRange();
		    if (userInput == 1) {
			System.out.println(ml.sortByFamilyName(members));
			break;
		    } else if (userInput == 2) {
			System.out.println(ml.sortByGivenName(members));
			break;
		    } else if (userInput == 3) {
			System.out.println(ml.sortByBirth(members));
			break;
		    } else if (userInput == 4) {
			System.out.println(members);
			break;
		    } else if (userInput == 5) {
			break;
		    } else {
			System.out.println("Incorrect choice, try again.");
			break;
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
		default:
		    System.out.println("Incorrect choice, try again");
		}
	}
	
	}

    }
