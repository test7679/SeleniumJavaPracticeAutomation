package tutorialsninja.utils;

import java.util.Date;

public class dynamicTimestampGeneration {
    
    public static void main(String[] args) {
    // Date date = new Date(); //date object creation
    // String strConv = date.toString(); //convert date to string
    // String noSpaceDate = strConv.replace(" ",""); //replace all spaces with empty string
    // String noSpaceColonDate = noSpaceDate.replace(":",""); //replace all colons with empty string
   
    // String emailWithTimestamp = noSpaceColonDate+"@gmail.com"; //append to email domain
    // System.out.println("Email with Timestamp: " + emailWithTimestamp);
    // }

    //(or)
    //less lines of code
    // public static void generateDynamicEmail(){
	// Date date = new Date(); //date object creation
    // String emailWithTimestamp = date.toString().replace(" ","").replace(":","")+"@gmail.com"; //convert date to string & replace all spaces with empty string & replace all ":" to empty string & append to email domain  
    // System.out.println("Email with Timestamp: " + emailWithTimestamp);
	// }
    }

    //reduce same time stamp code to a single line
    public static String generateDynamicEmail() {
    return new Date().toString().replace(" ","").replace(":","")+"@gmail.com"; //create date object using new Date() , convert date to string & replace all spaces with empty string & replace all ":" to empty string & append to email domain  
	}

    //reduce same time stamp code to a single line but email domain is dynamic - this is useful when you want to use different email domains email.com, gmail.com, google.com etc
    public static String generateDynamicEmail(String domain) {
    return new Date().toString().replace(" ","").replace(":","")+"@"+domain; //create date object using new Date() , convert date to string & replace all spaces with empty string & replace all ":" to empty string & append to email domain  
    }
}
