package com.sss.pageobjects;

/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 * Author: Nagaraju.Meka
 * File: GoogleHomeScreen.java
 * Created: 11/25/16
 * Description: Class to help normalize startup and usage of
 * retrieving the objects from Jenkins/Properties file.
 * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sss.webfunctions.WebController;

public class GoogleHomeScreen
{
   protected static final Logger log = LoggerFactory.getLogger(GoogleHomeScreen.class);
   protected WebController webController;
   public static final String SEARCHMENU = "css=input[title='Search']";


   public void setWebFunctions(WebController webFunctions)
   {
      this.webController = webFunctions;
   }


   public boolean checkAlert()
   {
      return webController.isAlertPresent();
   }
}
