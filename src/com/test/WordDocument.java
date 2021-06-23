package com.test;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
public class WordDocument {
	public static void addImagesToWordDocument(File imageFile1, File imageFile2,String pt)
			throws IOException, InvalidFormatException {
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph p = doc.createParagraph();
		XWPFRun r = p.createRun();
		BufferedImage bimg1 = ImageIO.read(imageFile1);
		int width1 = bimg1.getWidth();
		int height1 = bimg1.getHeight();
		System.out.println(width1+" "+height1);
		BufferedImage bimg2 = ImageIO.read(imageFile2);
		int width2 = bimg2.getWidth();
		int height2 = bimg2.getHeight();
		String imgFile1 = imageFile1.getName();
		String imgFile2 = imageFile2.getName();
		int imgFormat1 = getImageFormat(imgFile1);
		int imgFormat2 = getImageFormat(imgFile2);
		String p1 = "Sample Paragraph Post. This is a sample Paragraph post. Sample Paragraph text is being cut and pasted again and again. This is a sample Paragraph post. peru-duellmans-poison-dart-frog.";
		String p2 = "Sample Paragraph Post. This is a sample Paragraph post. Sample Paragraph text is being cut and pasted again and again. This is a sample Paragraph post. peru-duellmans-poison-dart-frog.";
		r.setText("Assessment No: "+pt);
		r.addBreak();
		r.addPicture(new FileInputStream(imageFile1), imgFormat1, imgFile1, Units.toEMU(width1/10), Units.toEMU(height1/10));
		// page break
		// r.addBreak(BreakType.PAGE);
		// line break
		r.addBreak();
		//r.setText(p2);
		r.addPicture(new FileInputStream(imageFile2), imgFormat2, imgFile2, Units.toEMU(width2/10), Units.toEMU(height2/10));
		r.addBreak();
		FileOutputStream out = new FileOutputStream("C://Users//SATYA//Desktop//word_images.docx",true);
		doc.write(out);
		out.close();
		doc.close();
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