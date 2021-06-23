package com.json;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import com.json.NonTax;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JacksonStreaming {
 
	public static void main(String[] args) {

		      try {        	
		       JsonFactory jsonFactory = new JsonFactory();
				HashSet<NonTax> total = new HashSet<NonTax>();
		         JsonParser jsonParser = jsonFactory.createParser(new URL("http://52.66.191.117/response"));
		         while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
		        	 NonTax nontax = new NonTax();
		              while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
		            	  
		            	  String fieldname1 = jsonParser.getCurrentName();
		            	  if ("responseId".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setResponseId(jsonParser.getText());
				            }
		            	  if ("receiptType".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setReceiptType(jsonParser.getText());
				            }
		            	  if ("asseseCode".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setAsseseCode(jsonParser.getText());
				            }
		            	  if ("asseseName".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setAsseseName(jsonParser.getText());
				            }
		            	  if ("voucherDate".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setVoucherDate(jsonParser.getText());
				            }
		            	  if ("billCollectorName".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setBillCollectorName(jsonParser.getText());
				            }
		            	  if ("refNo".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setRefNo(jsonParser.getText());
				            }
		            	  if ("ddOrChequeNumber".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setDdOrChequeNumber(jsonParser.getText());
				            }
		            	  if ("ddOrChequeDate".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setDdOrChequeDate(jsonParser.getText());
				            }
		            	  if ("ddOrChequeBankName".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setDdOrChequeBankName(jsonParser.getText());
				            }
		            	  if ("machineEntryTimeStamp".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setMachineEntryTimeStamp(jsonParser.getText());
				            }
		            	  if ("eSuvidhaTimeStamp".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.seteSuvidhaTimeStamp(jsonParser.getText());
				            }
		            	  if ("glCode".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setGlCode(jsonParser.getText());
				            }
		            	  if ("glCodeDescription".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setGlCodeDescription(jsonParser.getText());
				            }
		            	  if ("amount".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setAmount(jsonParser.getText());
				            }
		            	  if ("ulbCode".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setUlbCode(jsonParser.getText());
				            }
		            	  if ("districtCode".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setDistrictCode(jsonParser.getText());
				            }
		            	  if ("bcCode".equals(fieldname1)) {
		            		  jsonParser.nextToken();
		            		  nontax.setBcCode(jsonParser.getText());
				            }
		            	  
		            }
		              total.add(nontax);
		              jsonParser.nextToken();
			        	 if( jsonParser.nextToken()==null) break;
		           
		         }
		     System.out.println(total.size());
		     for(NonTax n:total){
		    	 System.out.println(n.toString());
		     }
		      }catch (Exception e) {
		         e.printStackTrace();
		      }
		  }
		public void m2(){
			//JacksonStreaming tester = new JacksonStreaming();
		      try {        	
		       JsonFactory jsonFactory = new JsonFactory();
		       /*  
		         JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(
		            "student.json"), JsonEncoding.UTF8);
		         jsonGenerator.writeStartObject();
		         jsonGenerator.writeStringField("name", "Mahesh Kumar"); 
		         jsonGenerator.writeNumberField("age", 21);
		         jsonGenerator.writeBooleanField("verified", false); 
		         jsonGenerator.writeFieldName("marks"); 
		         jsonGenerator.writeStartArray(); // [
		         jsonGenerator.writeNumber(100); 
		         jsonGenerator.writeNumber(90); 
		         jsonGenerator.writeNumber(85); 
		         jsonGenerator.writeEndArray(); 
		         jsonGenerator.writeEndObject(); 
		         jsonGenerator.close();       	 
*/
		         //result student.json
		         //{ 
		         //   "name":"Mahesh Kumar",
		         //   "age":21,
		         //   "verified":false,
		         //   "marks":[100,90,85]
		         //}

		         //JsonParser jsonParser = jsonFactory.createParser(new File("student.json"));
		    // having districts code
		       int i=0;
				HashSet<String> districts = new HashSet<String>();
				// having category names
				HashSet<String> category = new HashSet<String>();
				// having ulbcodes
				HashSet<String> ulbcodes = new HashSet<String>();
				// having billcollectornames
				HashSet<String> billcollectornames = new HashSet<String>();
		         JsonParser jsonParser = jsonFactory.createParser(new URL("http://52.66.191.117/response"));
		         /*jsonParser.nextToken();
		         jsonParser.nextToken();
		         jsonParser.nextToken();
		         jsonParser.nextToken();
		         System.out.println(jsonParser.getCurrentName()+" "+jsonParser.getText());
		         jsonParser.nextToken();
		         jsonParser.nextToken();
		         System.out.println(jsonParser.getCurrentName()+" "+jsonParser.getText());
		         jsonParser.nextToken();
		         jsonParser.nextToken();*/
		       /*  String recp="";
		         while(jsonParser.nextToken() != JsonToken.END_ARRAY){
		        	 while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
		        		 String fieldname = jsonParser.getCurrentName();
		        		 if ("refNo".equals(fieldname) &&recp.equals(jsonParser.getText())) { 
				            	System.out.println(jsonParser.getText());    
				            	System.out.println(jsonParser.getCurrentName()+" "+jsonParser.getText());
				            }
		        	 }
		        	 jsonParser.nextToken();
		        	 if( jsonParser.nextToken()==null) break;
		         }*/
		         while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
		              while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
		            	  String fieldname1 = jsonParser.getCurrentName();
		            	  if ("districtCode".equals(fieldname1)) {
		            		  jsonParser.nextToken();
				            	districts.add(jsonParser.getText());
				            }
				            if("ulbCode".equals(fieldname1)){
				            	 jsonParser.nextToken();
				            	ulbcodes.add(jsonParser.getText());
				            }
				            if("glCodeDescription".equals(fieldname1)){
				            	 jsonParser.nextToken();
				            	category.add(jsonParser.getText());
					            }
				            if("billCollectorName".equals(fieldname1)){
				            	 jsonParser.nextToken();
				               billcollectornames.add(jsonParser.getText());
				            }
		            }
		              jsonParser.nextToken();
			        	 if( jsonParser.nextToken()==null) break;
		           
		         }
		         System.out.println("Completed>>>>>>>");
		         System.out.println(districts);
		         System.out.println(category);
		         System.out.println(ulbcodes);
		         System.out.println(billcollectornames);
		         System.out.println(districts.size());
		         System.out.println(category.size());
		         System.out.println(ulbcodes.size());
		         System.out.println(billcollectornames.size());
		         System.out.println(jsonParser.version());
		      } catch (JsonParseException e) {
		         e.printStackTrace();
		      } catch (JsonMappingException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
		}
	}
