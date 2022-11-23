package com.bjpowernode;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Example {

	public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false).setSlowMo(3000));
	      BrowserContext context = browser.newContext();
	      // Open new page
	      Page page = context.newPage();
	      page.setDefaultTimeout(30000);
	      // Go to https://jwt.extope.com/jwt3/login
	      page.navigate("https://jwt.extope.com/jwt3/login");
	      // Click text=Disagree
	      page.locator("text=Disagree").click();
	      // Click [placeholder="Login"]
	      page.locator("[placeholder=\"Login\"]").click();
	      // Fill [placeholder="Login"]
	      page.locator("[placeholder=\"Login\"]").fill("admin.8202");
	      // Click [placeholder="Password"]
	      page.locator("[placeholder=\"Password\"]").click();
	      // Fill [placeholder="Password"]
	      page.locator("[placeholder=\"Password\"]").fill("extope000");
	      // Click input:has-text("Login")
	      page.locator("input:has-text(\"Login\")").click();
	      // Click a:has-text("OK")
	      page.locator("a:has-text(\"OK\")").click();
	      assertThat(page).hasURL("https://jwt.extope.com/jwt3/portal");
	      // Click text=Remote Servi...1234511Rows 1020304050All >> img
	      page.locator("text=Remote Servi...1234511Rows 1020304050All >> img").click();
	      assertThat(page).hasURL("https://jwt.extope.com/jwt3/portal#");
	      // Click text=OK
	      Page page1 = page.waitForPopup(() -> {
	        page.locator("text=OK").click();
	      });
	      page1.setDefaultTimeout(30000);
	      //assertThat(page).hasURL("https://jwt.extope.com/MedicalNws/?code=uOwdbJ&locale=en");
	      // Click span:has-text("Reagent") >> nth=0
	      page1.locator("span:has-text(\"Reagent\")").first().click();
	      // Click text=Maintenance
	      page1.locator("text=Maintenance").click();
	      // Click text=Log
	      page1.locator("text=Log").click();
	      // Click li:has-text("Setting")
	      page1.locator("li:has-text(\"Setting\")").click();
	    }
	  }

}
