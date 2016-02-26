package com.srebmem;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

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
			       team,gender,true));
	Member newMember = members.get(members.size() - 1);
	System.out.println(newMember);
	System.out.println("Added to list");
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
	ConsoleMenu input = new ConsoleMenu();
	System.out.println("Enter the ID of the member you wish to remove, enter 0 to exit");
	boolean idExist = false;
	boolean run = true;
	while (run == true) {
	    int id = input.askForIntRange();
	    if (id == 0) {
		run = false;
		break;
	    }
	    for (Member member : members) {
		if (member.getId() == id) {
		    idExist = true;
		    members.remove(member);
		} else {
		    idExist = false;
		}
	    }
	    if (idExist == true) {
		PrintWriter archive = new PrintWriter(new FileWriter("com/srebmem/archivedID.txt", true));
		archive.print(id + ";");
		archive.close();
		run = false;
		break;
	    } else {
		System.out.println("No member with that ID exists, try again");
	    }
	}
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
	fileReader.useDelimiter(";|\\r |\\n");

	boolean idNotMatch = false;
	List<Integer> archivedNumbers = new ArrayList<Integer>();
	while (fileReader.hasNextInt()) {
	    archivedNumbers.add(fileReader.nextInt());
	}
	for (Integer archivedId : archivedNumbers) {
	    if (archivedId == id) {
		idNotMatch = false;
		break;
	    } else {
		idNotMatch = true;
	    }
	}
	return idNotMatch;
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
	int teamCount = 0;
	
	while (iterator.hasNext()) {
	    teamName = iterator.next();
	    for (Member member : members) {
		if (member.getTeam().equals(teamName) && !member.getTeam().equals("")) {
		    teamMembers.add(member);
		    teamCount++;
		}
		  
	    }
	    System.out.println(teamName + " " + teamCount + " members");
	    System.out.println("\n");
	    System.out.println(teamMembers);
	    System.out.println("\n");
	    teamCount = 0;
	    teamMembers.clear();
	}
    }
    /**
     * Read a .txt file and store the data in an ArrayList of Member objects.
     *
     * @return An ArrayList of Member objects.
     * @param pathToRegister The path to the register file.
     * @throws IOException Not handled
     * 
     */
    public List<Member> readRegisterFromFile(String pathToRegister)
	throws IOException {
	Scanner sc = new Scanner(new File(pathToRegister));
	sc.useDelimiter(";|\\r|\\n");

	String[] temp = new String[9];
	List<Member> members = new ArrayList<Member>();

	while (sc.hasNext()) {
	    for (int i=0; i <= 8; i++) {
		temp[i] = sc.next();
	    }
	    int id = Integer.parseInt(temp[0]);
	    int role = Integer.parseInt(temp[5]);
	    int gender = Integer.parseInt(temp[7]);
	    boolean isActive = true;
	    if (temp[8].equals("false")) {
		isActive = false;
	    }
	    members.add(new Member(id, temp[1], temp[2], temp[3],
			       temp[4], role, temp[6], gender, isActive));
	}
	
	return members;
    }
    /**
     * Method that fills the archivedID file with all the current used ID
     * @param members The member list
     * @throws IOException not handled
     */
    public void fillArchiveList(List<Member> members)
	throws IOException {
	List<Integer> idnumbers = new ArrayList<Integer>();
	for (Member member : members) {
	    idnumbers.add(member.getId());
	}
	PrintWriter archive = new PrintWriter(new FileWriter("com/srebmem/archivedID.txt", true));
	for (Integer id : idnumbers) {
	    archive.print(id + ";");
	}
	archive.close();
    }
    /**
     * Method that saves the memberslist to file on exit
     * @param members The member list
     * @throws IOException not handled
     */
    public void saveMembersOnExit(List<Member> members)
	throws IOException {
	PrintWriter save = new PrintWriter(new FileWriter("com/srebmem/medlemsregister.txt", false));
	for (Member member : members) {
	    save.print(member.saveToFile());
	}
	save.close();
    }
    /**
     * Method to print members with inactive status
     * @param members The list of members
     */
    public void printInactiveMembers(List<Member> members) {
	System.out.println("Inactive members");
	System.out.println("----------------");
	for (Member member : members) {
	    if(member.getMemberStatus() == false) {
		System.out.println(member);
	    }
	}
	System.out.println();
    }
    
    /**
     * Method to activate a member
     * @param members The list of members
     * @return members
     */
    public List<Member> activateMember(List<Member> members) {
	ConsoleMenu input = new ConsoleMenu();
	System.out.println("Enter the ID of the member you wish to activate, enter 0 to exit");
	boolean idExist = false;
	boolean run = true;
	String activatedMember = " ";
	while (run == true) {
	    int id = input.askForIntRange();
	    if (id == 0) {
		run = false;
		break;
	    }
	    for (Member member : members) {
		if (member.getId() == id && member.getMemberStatus() == false) {
		    idExist = true;
		    member.setMemberToActive();
		    activatedMember = member.toString();
		} else {
		    idExist = false;
		}
	    }
	    if (idExist == true) {
		System.out.println(activatedMember + " has been activated");
		run = false;
	    } else {
		System.out.println("No member with that ID or the member is already active, enter a new ID");
	    } 
	}
	return members;
    }
    /**
     * Method to deactivate a member
     * @param members The list of members
     * @return members
     */
    public List<Member> deActivateMember(List<Member> members) {
	ConsoleMenu input = new ConsoleMenu();
	System.out.println("Enter the ID of the member you wish to deactivate, enter 0 to exit");
	boolean idExist = false;
	boolean run = true;
	String deActivatedMember = " ";
	while (run == true) {
	    int id = input.askForIntRange();
	    if (id == 0) {
		run = false;
		break;
	    }
	    for (Member member : members) {
		if (member.getId() == id && member.getMemberStatus() == true) {
		    idExist = true;
		    member.setMemberToInactive();
		    deActivatedMember = member.toString();
		} else {
		    idExist = false;
		}
	    }
	    if (idExist == true) {
		System.out.println(deActivatedMember + " has been deactivated");
		run = false;
	    } else {
		System.out.println("No member with that ID or the member is already inactive, enter a new ID");
	    } 
	}
	return members;
    }
    /**
     * Method that sorts by given name.
     * @param members the memberlist
     */
    public List<Member> sortByGivenName(List<Member> members) {
    	List<Member> temp = new ArrayList<Member>(members);
	Collections.sort(temp, new GivenNameComparator());
	return temp;
    }
    
    /**
     * Method that sorts by family name.
     * @param members the memberlist
     */
    public List<Member> sortByFamilyName (List<Member> members) {
    	List<Member> temp = new ArrayList<Member>(members);
	Collections.sort(temp, new FamilyNameComparator());
	return temp;
    }
    
    /**
     * Method that sorts by birthday.
     * @param members the memberlist
     */
    public List<Member> sortByBirth (List<Member> members) {
	List<Member> temp = new ArrayList<Member>(members);
	Collections.sort(temp, new BirthdayComparator());
	return temp;
    
    }
}
