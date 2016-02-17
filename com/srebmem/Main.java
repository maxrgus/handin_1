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
     */
    public static void main(String[] args) {
	String pathToRegister = "com/srebmem/medlemsregister.txt";
	List<Member> members = readRegisterFromFile(pathToRegister);
	

    }

    /**
     * Read a .txt file and store the data in an ArrayList of Member objects.
     *
     * @return An ArrayList of Member objects.
     * @param pathToRegister The path to the register file.
     * @throws IOException
     * 
     */
    public static List<Member> readRegisterFromFile(String pathToRegister)
	throws IOException {
	Scanner sc = new Scanner(new File(pathToRegister));
	sc.useDelimiter(";|\\n");

	String[] temp = new String[8];
	List<Member> members = new ArrayList<Member>();

	while (sc.hasNext()) {
	    for (int i=0; i <= 7; i++) {
		temp[i] = sc.next();
	    }
	    int id = Integer.parseInt(temp[0]);
	    int role = Integer.parseInt(temp[5]);
	    int gender = Integer.parseInt(temp[7]);
	    members.add(new Member(id, temp[1], temp[2], temp[3],
				   temp[4], role, temp[6], gender));
	}
	return members;
    }
    

}
