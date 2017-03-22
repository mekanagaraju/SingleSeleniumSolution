package com.sss.test;

/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 * Author: Nagaraju.Meka
 * File: GoogleTest.java
 * Created: 11/25/16
 * Description: Class to help normalize startup and usage of
 * retrieving the objects from Jenkins/Properties file.
 * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- */
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sss.basetest.SSSBaseTest;
import com.sss.pageobjects.GoogleHomeScreen;

public class GoogleTest extends SSSBaseTest
{
   protected static final Logger log = LoggerFactory.getLogger(GoogleTest.class);
   private final GoogleHomeScreen ss = new GoogleHomeScreen();


   @BeforeMethod
   public void setBeforeTest(Method method)
   {
      sssController.launchBrowser(method);
      ss.setWebFunctions(sssController.getwebController());
      setWebFunctions(sssController.getwebController());
   }


   @AfterTest
   public void doAfterTest()
   {
      log.info("Closing the browser");
      sssController.quitBrowser();
   }


   @Test(description = "Sample test case", groups = "sample-test", priority = 1)
   public void testGooglePage()
   {
      log.info("Alert present: {}", ss.checkAlert());
      assertTrue( !ss.checkAlert(), "");
      assertElementExist(GoogleHomeScreen.SEARCHMENU);
   }
}
