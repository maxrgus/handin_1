package com.srebmem;

import java.util.*;
import java.io.*;

/**
 * MemberList.java
 * Purpose: Holds methods related to the memberlist.
 *
 * @version 1.0 2016-02-25
 * @author Maximilian Gustafsson and Dominika Wróblewska
 */
public class MemberList {
    /**
     * Method to adding a member to the memberlist.
     * @param members The list of type Member to be added to.
     * @return members
     * @throws IOException Not handled
     */
    public List<Member> addMember(List<Member> members)
	throws IOException {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter given name");
	String givenName = sc.next();
	System.out.println("Enter family name");
	String familyName = sc.next();
	System.out.println("Enter birthday in the format of yyyy-mm-dd");
	String birthday = sc.next();
	System.out.println("Enter membership startdate in the format of yyyy-mm-dd");
	String memberSince = sc.next();
	System.out.println("Enter role: 0. Player  1. Coach  2. Parent");
	int role = sc.nextInt();
	System.out.println("Enter gender: 1. Male  2. Female");
	int gender = sc.nextInt();
	System.out.println("Enter team");
	String team = sc.next();
	Member temp = members.get(members.size() - 1);
	int id = temp.getId() + 1;
	MemberList ml = new MemberList();
	while (ml.checkArchivedIdFromFile(id) == false) {
	    id++;
	}
	members.add(new Member(id,givenName,familyName,birthday,memberSince,role,
			       team,gender));
	return members;
    }
    /**
     * Method to remove a member from the memberlist.
     * @param members The list of type Member to be removed from.
     * @return members
     * @throws IOException Not handled
     */
    public List<Member> removeMember(List<Member> members)
	throws IOException {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the ID of the member you wish to remove");
	int id = sc.nextInt();
	for (Member member : members) {
	    if (member.getId() == id) {
		members.remove(member);
		break;
	    }
	}
	PrintWriter archive = new PrintWriter(new FileWriter("com/srebmem/archivedID.txt", true));
	archive.print(id + ";");
	archive.close();
	return members;
    }
    /**
     * Method to read the archived ID numbers from file and check
     * if the ID matches the id provided as a parameter.
     * @param id The ID that needs to be checked.
     * @return boolean
     * @throws IOException Not handled
     */
    public boolean checkArchivedIdFromFile(int id)
	throws IOException {
	Scanner fileReader = new Scanner(new File("com/srebmem/archivedID.txt"));
	fileReader.useDelimiter(";");

	boolean idNotMatch = false;
	List<Integer> archivedNumbers = new ArrayList<Integer>();
	
	while (fileReader.hasNext()) {
	    archivedNumbers.add(fileReader.nextInt());
        }
	for (Integer archivedId : archivedNumbers) {
	    if (archivedId != id) {
		idNotMatch = true;
	    }
	}
	if (idNotMatch == true) {
	    return true;
	}
	else {
	    return false;
	}
    }
    /**
     * Method for printing team names and all associated
     * with that team
     * @param members The list of members
     * 
     */
    public void printTeams(List<Member> members) {
	TreeSet<String> teams = new TreeSet<String>();
	for (Member member : members) {
	    teams.add(member.getTeam());
	}
	Iterator<String> iterator = teams.iterator();
	List<Member> teamMembers = new ArrayList<Member>();
	String teamName = " ";
	
	while (iterator.hasNext()) {
	    teamName = iterator.next();
	    for (Member member : members) {
		if (member.getTeam().equals(teamName) && !member.getTeam().equals("")) {
		    teamMembers.add(member);
		}
		  
	    }
	    System.out.println(teamName);
	    System.out.println("\n");
	    System.out.println(teamMembers);
	    System.out.println("\n");
	    teamMembers.clear();
	}
    }
}
