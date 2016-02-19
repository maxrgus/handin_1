package com.srebmem;

import java.util.*;

/**
 * Member.java
 * Purpose: Store information about the members of the association.
 *
 * @version 1.0 2016-02-25
 * @author Maximilian Gustafsson and Dominika Wróblewska
 */
public class Member {
    private int id;
    private String givenName;
    private String familyName;
    private int role;
    private String team;
    private int gender;
    private String birthday;
    private String memberSince;
    private boolean isActive;

    /**
     * Public constructor of the Member class
     * @param id The unique member ID.
     * @param givenName The first name of the member.
     * @param familyName The family name of the member.
     * @param birthday The day of birth formatted as year-month-day.
     * @param memberSince The day the member joined formatted as year-month-day.
     * @param role The members role, 0 = player, 1 = coach, 2 = parent.
     * @param team The name of the team, can be blank.
     * @param gender The gender of the member, 1 = male, 2 = female. 
     */
    public Member(int id, String givenName, String familyName, String birthday,
		  String memberSince, int role, String team, int gender) {

	this.id = id;
	this.givenName = givenName;
	this.familyName = familyName;
	this.birthday = birthday;
	this.memberSince = memberSince;
	this.role = role;
	this.team = team;
	this.gender = gender;
	isActive = true;
    }
    /**
     * ToString method for Member objects.
     * @return id, givenName, familyName, birthday, memberSince, role, team, gender.
     */
    @Override
    public String toString() {
	String actualRole = "UNKNOWN";
	String actualGender = "UNKNOWN";
	if (role == 0 && gender == 1) {
	    actualRole = "PLAYER";
	    actualGender = "MALE";
	} else if (role == 0 && gender == 2) {
	    actualRole = "PLAYER";
	    actualGender = "FEMALE";
	} else if (role == 1 && gender == 1) {
	    actualRole = "COACH";
	    actualGender = "MALE";
	} else if (role == 1 && gender == 2) {
	    actualRole = "COACH";
	    actualGender = "FEMALE";
	} else if (role == 2 && gender == 1) {
	    actualRole = "PARENT";
	    actualGender = "MALE";
	} else if (role == 2 && gender == 2) {
	    actualRole = "PARENT";
	    actualGender = "FEMALE";
	}
	return "\n" + id + " " + givenName + " " + familyName + " " + birthday + " " +
	    memberSince + " " + actualRole + " " + team + " " + actualGender; 
	
    }
    /**
     * Method to activate a member.
     */
    public void activateMember() {
	isActive = true;
    }
    /**
     * Method to de-activate a member.
     */
    public void deActivateMember() {
	isActive = false;
    }
    /**
     * Method to get the id number.
     * @return id
     */
    public int getId() { return id; }
    /**
     * Method to get the family name.
     * @return familyName
     */
    public String getFamilyName() { return familyName; }
    public String getTeam() { return team; }
}
