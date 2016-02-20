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
     * @param isActive If the member is active or not. 
     */
    public Member(int id, String givenName, String familyName, String birthday,
		  String memberSince, int role, String team, int gender, boolean isActive) {

	this.id = id;
	this.givenName = givenName;
	this.familyName = familyName;
	this.birthday = birthday;
	this.memberSince = memberSince;
	this.role = role;
	this.team = team;
	this.gender = gender;
	this.isActive = isActive;
    }
    /**
     * ToString method for Member objects.
     * @return id, givenName, familyName, birthday, memberSince, role, team, gender.
     */
    @Override
    public String toString() {
	String actualRole = "UNKNOWN";
	String actualGender = "UNKNOWN";
	String activeStatus = "ACTIVE";
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
	if (isActive == false) {
	    activeStatus = "INACTIVE";
	}
	return "\n" + id + " " + givenName + " " + familyName + " " + birthday + " " +
	    memberSince + " " + actualRole + " " + team + " " + actualGender + " " + activeStatus; 
	
    }
    /**
     * Method to get the member activation
     * status
     * @return isActive
     */
    public boolean getMemberStatus() {
	return isActive;
    }
    /**
     * Method to activate a member.
     */
    public void setMemberToActive() {
	isActive = true;
    }
    /**
     * Method to de-activate a member.
     */
    public void setMemberToInactive() {
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
     /**
     * Method to get the given name.
     * @return givenName
     */
    public String getGivenName() { return givenName; }
     /**
     * Method to get the birthday.
     * @return birthday
     */
    public String getBirthday() { return birthday; }
    /**
     * Method to get the team.
     * @return team
     */
    public String getTeam() { return team; }
    /**
     * Method returns a string that is saved in the medlemsregister.txt
     * file
     * @return id;givenName;familyName;birthday;
	    memberSince;role;team;gender;isActive\n
     */
    public String saveToFile() {
	return id + ";" + givenName + ";" + familyName + ";" + birthday + ";" +
	    memberSince + ";" + role + ";" + team + ";" + gender + ";" + isActive + "\n";
    }
}
