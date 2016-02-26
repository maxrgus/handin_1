package com.srebmem;

import java.util.Comparator;

public class GivenNameComparator implements Comparator<Member> {
    public int compare(Member a, Member b) {
		return a.getGivenName().compareTo(b.getGivenName());
    }
}
