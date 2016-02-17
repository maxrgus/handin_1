package com.srebmem;

import java.util.*;

/**
 * MemberList.java
 * Purpose: Holds varibles and methods related to the memberlist.
 *
 * @version 1.0 2016-02-25
 * @author Maximilian Gustafsson and Dominika Wróblewska
 */
public class MemberList {
    /**
     * Method to adding a member to the memberlist.
     * @param members The list of type Member to be added to.
     * @return members
     */
    public List<Member> addMember(List<Member> members) {
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
	int id = temp.getId(temp) + 1;
	members.add(new Member(id,givenName,familyName,birthday,memberSince,role,
			       team,gender));
	return members;
    }
}
