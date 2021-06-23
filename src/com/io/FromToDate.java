package com.io;

public class FromToDate {
 
	public static void main(String[] args) {
			
			String[] leastyear = "2012-2013-1".split("-"); // 2012-2013-1
			if (leastyear[2].equals("1")) {
				System.out.println("30-09-" + leastyear[0]);
			} else if (leastyear[2].equals("2")) {
				System.out.println("31-03-" + leastyear[1]);
			}

			String[] topyear = "2012-2013-2".split("-");
			if (topyear[2].equals("1")) {
				System.out.println("01-04-" + topyear[0]);
			} else if (topyear[2].equals("2")) {
				System.out.println("01-10-" + topyear[0]);
			}
		
	}

}
