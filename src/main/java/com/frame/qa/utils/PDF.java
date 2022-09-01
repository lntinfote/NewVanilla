package com.frame.qa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class PDF {
	
	public static String PDFtext;

	
	 /**
     * This method extracts pdf text & returns it.
     * @return Returns the PDF content as String.
     */
	  public static String extractAllText(String filePath) {
	    	 try {
	             PDDocument doc = Loader.loadPDF(new File(filePath));
	               PDFtext = new PDFTextStripper().getText(doc);
	              System.out.println("Text in PDF\n---------------------------------");
	              System.out.println(PDFtext);
	             } catch (IOException e) {
	                 e.printStackTrace();
	         }
			return PDFtext;
	    	}
	    
	   
	   /**
	     * This method counts the number of PDF pages & returns it.
	     * @return Returns the PDF PDF page count as integer number.
	     */
	  public static int getPageCount(String filePath) {
  		PDDocument doc = null;
			try {
				doc = Loader.loadPDF(new File(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return doc.getNumberOfPages();
   }
	    
	    
	    /**
	     * This method extracts pdf text by specifying start page and end page number & returns it.
	     * @return Returns the PDF content as String.
	     */
	  public static void extractText(String filePath, int StartPageNo, int endPageNo ) throws IOException {
          PDDocument doc = Loader.loadPDF(new File(filePath));
          PDFTextStripper reader = new PDFTextStripper();
	    	reader.setStartPage(StartPageNo);
	    	reader.setEndPage(endPageNo);
	    	 PDFtext = reader.getText(doc);
	    	System.out.println(PDFtext);
	    	
	    }
	    	

}
