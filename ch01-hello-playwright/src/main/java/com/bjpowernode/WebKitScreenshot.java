package com.bjpowernode;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebKitScreenshot {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try (Playwright playwright = Playwright.create()){
			Browser browser = playwright.webkit().launch();
			Page page = browser.newPage();
			page.navigate("http://whatsmyuseragent.org/");
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		}
	}

}
