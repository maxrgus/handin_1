package com.srebmem;
import java.util.*;
import java.util.Comparator;
import java.text.SimpleDateFormat;

public class BirthdayComparator implements Comparator<Member> {
    public int compare(Member a, Member b) {
	SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
	try{
	    Date d1=sdf.parse(a.getBirthday());
	    Date d2=sdf.parse(b.getBirthday());
	    return d1.compareTo(d2);
	}catch(Exception e){
	}

	return 0;
    }
}
