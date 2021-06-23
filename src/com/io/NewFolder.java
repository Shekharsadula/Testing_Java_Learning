package com.io;
import java.io.File;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.ResourceBundle;

public class NewFolder {
	static int i=0;
	    public static void main(String[] args) {
	    	NewFolder name = new NewFolder();
	    	 
	    	new Thread(){public void run(){}}.start();
	    	System.out.println(i);
	    	for(String ulb:getUlbs()){
	    		File file = new File("C:\\Users\\SATYA\\Desktop\\meeseva\\"+ulb);
	    		if (!file.exists()) {
	    			if (file.mkdir()) {
	    				System.out.println("Directory is created!");
	    			} else {
	    				System.out.println("Failed to create directory!");
	    			}
	    		}
	    	}
	    }
	    public  static HashSet<String> getUlbs() {
			ResourceBundle rb = ResourceBundle.getBundle("UNames");
			Enumeration<String> keys = rb.getKeys();
			HashSet<String> ulbs = new HashSet<String>();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
					ulbs.add(key);
			}
			return ulbs;
		}

	}
