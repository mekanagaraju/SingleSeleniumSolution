package com.sss.webfunctions;

/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 * Author: Nagaraju.Meka
 * File: SSSController.java
 * Created: 11/25/16
 * Description: Class to help normalize startup and usage of
 * retrieving the objects from Jenkins/Properties file.
 * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- */
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSSController
{
   protected static final Logger log = LoggerFactory.getLogger(SSSController.class);
   protected WebController webController;
   protected String url, browser, environment;
   SSSProperties sssProperties = new SSSProperties();


   public WebController launchBrowser(Method method)
   {
      url = sssProperties.getValue("url");
      browser = sssProperties.getValue("browser");
      environment = sssProperties.getValue("environment");
      webController = WebController.buildWebDriver(url, browser, method);
      webController.windowMaximize();
      return webController;
   }


   public WebController launchAndroidBrowser()
   {
      return webController;
   }


   public void quitBrowser()
   {
      webController.quit();
      try
      {
         log.info("Closing the instance");
         webController.quit();
      } catch (final Exception e)
      {
         log.info("Went wrong, closing the instance");
         webController.quit();
      }
   }


   public WebController getwebController()
   {
      return webController;
   }


   public boolean waitForPageLoad()
   {
      return webController.waitForPageLoad();
   }


   public void delay(int seconds)
   {
      webController.delay(seconds);
   }
}