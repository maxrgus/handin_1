package com.srebmem;

import java.util.Comparator;

public class FamilyNameComparator implements Comparator<Member> {
    public int compare(Member a, Member b) {
		return a.getFamilyName().compareTo(b.getFamilyName());
    }
}
