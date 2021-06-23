package com.test;

import java.util.Calendar;
import java.util.Date;

public class Demandyear {

	public static void main(String[] args) {
		
		//String demandYear="2020-2021-1";
		String demandYear="2020-2021-2";
		String PaidfromDate="";
		String PaidtoDate="";
		int int1Year = new Integer(demandYear.substring(0,4)).intValue();
		int int2Year = new Integer(demandYear.substring(5,9)).intValue();
		System.out.println("intYear @@@ "+int1Year);
		int int1stPeriod = new Integer(demandYear.substring(10)).intValue();
		System.out.println("int1Period ####  "+int1stPeriod);
		 int intFirstPeriod=int1stPeriod;
		System.out.println("intFirstPeriod@@@@@ "+intFirstPeriod);
		
		String DmndFirstPeriod= demandYear.substring(0,10);
		DmndFirstPeriod=DmndFirstPeriod+intFirstPeriod;
		Date d=new Date();
		Calendar c=Calendar.getInstance();
		int year1=c.get(Calendar.YEAR);
		int year2=c.get(Calendar.YEAR)+1;
		
		System.out.println(c.get(Calendar.YEAR)+" "+year2);
		int m=d.getMonth()+1;
		System.out.println(d.getMonth()+1+"jjjjjj");
		 
			
		if(int1stPeriod == 1) 
		{
			PaidfromDate = int1Year+"-04-01";
			PaidtoDate= int1Year+"-09-30";
		System.out.println("PaidfromDate "+ PaidfromDate);
		System.out.println("PaidtoDate "+ PaidtoDate);
		}
		else
		{
			PaidfromDate = int1Year+"-10-01";
			PaidtoDate=int2Year+"-03-31";
		System.out.println("PaidfromDate "+ PaidfromDate);
		System.out.println("PaidtoDate "+ PaidtoDate);
		}
		
		System.out.println("============================");
		
		for(int i=1;i<13;i++){
			m=i;
			
			System.out.println("month ***** "+ m);
			if(m>=4 && m<=9){
				System.out.println("first half period");
				PaidfromDate = int1Year+"-04-01";
				PaidtoDate= int1Year+"-09-30";
				System.out.println("PaidfromDate "+ PaidfromDate);
				System.out.println("PaidtoDate "+ PaidtoDate);
			}else{
				System.out.println("second half period");
				PaidfromDate = int1Year+"-10-01";
				PaidtoDate=int2Year+"-03-31";
				System.out.println("PaidfromDate "+ PaidfromDate);
				System.out.println("PaidtoDate "+ PaidtoDate);
			}
		}
		 
		
		
	}

}
