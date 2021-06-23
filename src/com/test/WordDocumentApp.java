package com.test;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class WordDocumentApp {
	public static void main(String[] args) throws InvalidFormatException, IOException {
		int a[]=
			{1166004839,
				1166004398,
				1166004066,
				1166007496,
				1166005263,
				1166003954}; 
		
		
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph p = doc.createParagraph();
		XWPFRun r = p.createRun();
		FileOutputStream out = new FileOutputStream("C://Users//SATYA//Desktop//images//word_images.docx",true);
		int count=0;
			for(int  s:a){
				//images(String.valueOf(s));
				
				File image1 = new File("C:\\Users\\SATYA\\Desktop\\images\\"+String.valueOf(s)+"photo1.jpg");
				File image2 = new File("C:\\Users\\SATYA\\Desktop\\images\\"+String.valueOf(s)+"photo2.jpg");
				if(image1.exists() &&image1.exists()){
					count++;
				BufferedImage bimg1 = ImageIO.read(image1);
				//int width1 = bimg1.getWidth()/10;
				//int height1 = bimg1.getHeight()/10;
				int width1=450;
				int height1=300;
				int width2=450;
				int height2=300;
				BufferedImage bimg2 = ImageIO.read(image2);
				//int width2 = bimg2.getWidth()/10;
				//int height2 = bimg2.getHeight()/10;
				String imgFile1 = image1.getName();
				String imgFile2 = image2.getName();
				int imgFormat1 = getImageFormat(imgFile1);
				int imgFormat2 = getImageFormat(imgFile2);
				r.setText("Assessment No: "+String.valueOf(s));
				r.addBreak();
				r.addPicture(new FileInputStream(image1), imgFormat1, imgFile1, Units.toEMU(width1), Units.toEMU(height1));
				//r.addTab();
				r.addBreak();
				r.addPicture(new FileInputStream(image2), imgFormat2, imgFile2, Units.toEMU(width2), Units.toEMU(height2));
//				if(count%2==0)
				r.addBreak(BreakType.PAGE);
				r.addBreak(BreakType.PAGE);
				}
			}
			doc.write(out);
			out.close();
			doc.close();
	}
	public static void images(String assessment){
		 URL url;
		 String photo11="empty";
		 String photo22="empty";
		try {
           url = new URL("https://bhuvan-app1.nrsc.gov.in/cdma/appservices/getAssessmentInfo.php?assmnt="+assessment);
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
                        if(photo1.item(0)!=null && photo2.item(0)!=null){
                        	photo11=photo1.item(0).getTextContent();
                        	photo22=photo2.item(0).getTextContent();
                        	saveImage(photo11,assessment+"photo1");
                        	saveImage(photo22,assessment+"photo2");
                        }
                        
          System.out.println("Assessment :"+assessment);
          System.out.println(photo11);
          System.out.println(photo22);
	                 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 

public static void saveImage(String imageUrl, String destinationFile) {
//imageUrl = "https://bhuvan-fdc1.nrsc.gov.in/cdma_fdc/upload/photos/18/80/photo2_fdc_BhuvanCDMA_BhuvanCDMAFDC_BhuvanCDMA_Point_aeb80553a5979843_15_27_33_11_7_2017.jpg";
destinationFile = "C://Users//SATYA//Desktop//images//"+destinationFile+".jpg";
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
	} catch (Exception e) {
	}
}
private static int getImageFormat(String imgFileName) {
	int format;
	if (imgFileName.endsWith(".emf"))
		format = XWPFDocument.PICTURE_TYPE_EMF;
	else if (imgFileName.endsWith(".wmf"))
		format = XWPFDocument.PICTURE_TYPE_WMF;
	else if (imgFileName.endsWith(".pict"))
		format = XWPFDocument.PICTURE_TYPE_PICT;
	else if (imgFileName.endsWith(".jpeg") || imgFileName.endsWith(".jpg"))
		format = XWPFDocument.PICTURE_TYPE_JPEG;
	else if (imgFileName.endsWith(".png"))
		format = XWPFDocument.PICTURE_TYPE_PNG;
	else if (imgFileName.endsWith(".dib"))
		format = XWPFDocument.PICTURE_TYPE_DIB;
	else if (imgFileName.endsWith(".gif"))
		format = XWPFDocument.PICTURE_TYPE_GIF;
	else if (imgFileName.endsWith(".tiff"))
		format = XWPFDocument.PICTURE_TYPE_TIFF;
	else if (imgFileName.endsWith(".eps"))
		format = XWPFDocument.PICTURE_TYPE_EPS;
	else if (imgFileName.endsWith(".bmp"))
		format = XWPFDocument.PICTURE_TYPE_BMP;
	else if (imgFileName.endsWith(".wpg"))
		format = XWPFDocument.PICTURE_TYPE_WPG;
	else {
		return 0;
	}
	return format;
}
	
}