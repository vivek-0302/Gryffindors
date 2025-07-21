package com.urbanLadder.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.urbanLadder.pages.BookShelves;
import com.urbanLadder.pages.CheckOutPage;
import com.urbanLadder.pages.ConnectWithUs;
import com.urbanLadder.pages.StudyChairs;
import com.urbanLadder.utils.DriverSetup;
import com.urbanLadder.pages.BeingAtHome;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		String xlFile, beingAtHomeSheet, bookShelvesSheet, studyChairsSheet;
//		String[] beingAtHome, bookShelves, studyChairs, price, chairPrices;
//		xlFile = System.getProperty("user.dir") + "/src/test/resources/DataSet.xlsx";
//		beingAtHomeSheet = "Sheet1";
//		bookShelvesSheet = "Sheet2";
//		studyChairsSheet = "Sheet3";
		DriverSetup d = new DriverSetup();
		WebDriver driver = d.driverInstance("chrome");
		BookShelves Bookobj = new BookShelves(driver);
		Bookobj.moveToLiving();
		Bookobj.clickBookShelves();
		Bookobj.closePopup();
		Bookobj.moveToPrice();
		Bookobj.moveSlider();
		Bookobj.clickExcludeStock();
		Bookobj.displayNamesandPrices();
//		bookShelves = Bookobj.name();
//		for (int i = 0; i < bookShelves.length; i++) {
//			ExcelUtils.setCellData(xlFile, bookShelvesSheet, i + 1, 1, bookShelves[i]);
//		}
//		price = Bookobj.price();
//		for (int i = 0; i < price.length; i++) {
//			ExcelUtils.setCellData(xlFile, bookShelvesSheet, i + 1, 2, price[i]);
//		}
		StudyChairs studyobj = new StudyChairs(driver);
		studyobj.moveToStudy();
		studyobj.clickStudyChair();
		studyobj.scrollToStudyChairs();
		studyobj.DisplayChairsPrices();
//		studyChairs = studyobj.name();
//		for (int i = 0; i < studyChairs.length; i++) {
//			ExcelUtils.setCellData(xlFile, studyChairsSheet, i + 1, 1, studyChairs[i]);
//		}
//		chairPrices = studyobj.price();
//		for (int i = 0; i < chairPrices.length; i++) {
//			ExcelUtils.setCellData(xlFile, studyChairsSheet, i + 1, 2, chairPrices[i]);
//		}
		BeingAtHome homeobj = new BeingAtHome(driver);
		homeobj.searchBeingatHome();
		homeobj.clickSearch();
		homeobj.selectCategory();
//		beingAtHome = homeobj.DisplaySubItems();
//		for (int i = 0; i < beingAtHome.length; i++) {
//			ExcelUtils.setCellData(xlFile, beingAtHomeSheet, i + 1, 1, beingAtHome[i]);
//		}
		CheckOutPage checkObj = new CheckOutPage(driver);
		checkObj.clickProduct();
		checkObj.moveToCart();
		checkObj.DoCheckOut();
		checkObj.passEmail();
		checkObj.DisplayErrorMsg();
		ConnectWithUs connectObj = new ConnectWithUs(driver);
		connectObj.ClickOnLogo();
		connectObj.Connect();
		connectObj.DisplayConnections();
		d.driverTearDown();
	}

}
