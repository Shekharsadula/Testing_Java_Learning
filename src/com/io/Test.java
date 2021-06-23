package com.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader; 
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.SSLContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
 
public class Test {
	public static void main(String[] args) {
	/*	System.out.println(Long.MAX_VALUE);
		System.out.println(Integer.parseInt("21500218604"));
		System.out.println(Integer.parseInt("2147483647"));*/
		int a[]=
		{1179004915,
		1179000824,
		1779008560, 
		1179002018, 
		1179002019, 
		1179008912,
		1179008946, 
		1179001984}; 

		//for(int  s:a)
	    //images(String.valueOf(s));
		//images("1179008560");
		//writetofile();
			saveImage("","image");
		}

	public static void images(String assessment){
		 URL url;
		 String photo11;
		 String photo22;
		try {
            url = new URL("https://bhuvan-app1.nrsc.gov.in/cdma/appservices/getAssessmentInfo.php?assmnt="+assessment);
           // url = new URL("http://localhost:8888/testWS?wsdl");
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        System.setProperty("java.net.useSystemProxies", "true");
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
                   while ((inputLine = in.readLine()) != null) {
                     response.append(inputLine);
                   }

	                 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                     InputSource is;

                         DocumentBuilder builder = factory.newDocumentBuilder();
                         is = new InputSource(new StringReader(response.toString()));
                         Document doc = builder.parse(is);
                         NodeList photo1 = doc.getElementsByTagName("photo1");
                         NodeList photo2 = doc.getElementsByTagName("photo2");
                         photo11=photo1.item(0).getTextContent();
                         photo22=photo2.item(0).getTextContent();
                         
           System.out.println("Assessment :"+assessment);
           System.out.println(photo11);
           System.out.println(photo22);
           
	                 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void writetofile(){

		 URL url;
		try {
           url = new URL("https://bhuvan-fdc1.nrsc.gov.in/cdma_fdc/upload/photos/18/80/photo2_fdc_BhuvanCDMA_BhuvanCDMAFDC_BhuvanCDMA_Point_aeb80553a5979843_15_27_33_11_7_2017.jpg");
       URLConnection con = url.openConnection();
       BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
       String inputLine;
       StringBuffer response = new StringBuffer();
       System.setProperty("java.net.useSystemProxies", "true");
       System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
                  while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                  }
                System.out.println(response);

	         
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

public static void saveImage(String imageUrl, String destinationFile) {
imageUrl = "https://bhuvan-fdc1.nrsc.gov.in/cdma_fdc/upload/photos/18/80/photo2_fdc_BhuvanCDMA_BhuvanCDMAFDC_BhuvanCDMA_Point_aeb80553a5979843_15_27_33_11_7_2017.jpg";
destinationFile = "C://Users//SATYA//Desktop//"+destinationFile+".jpg";
	try {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);
		byte[] b = new byte[2048];
		int length;
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
		System.out.println("Completed");
	} catch (Exception e) {
	}
}
	
}
