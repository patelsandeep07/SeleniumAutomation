package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReadUtility {

	public static Iterator<User> readExcelFile(String filename) {

		File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + filename);

		XSSFWorkbook xssfWorkbook = null;

		List<User> userList = new ArrayList<User>();
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		Iterator<Row> rowIterator;
		XSSFSheet xssfSheet;

		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		xssfSheet = xssfWorkbook.getSheet("LoginTestData");
		rowIterator = xssfSheet.iterator();
		rowIterator.next();
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			emailAddressCell = row.getCell(0);
			passwordCell = row.getCell(1);
			user = new User(emailAddressCell.toString(), passwordCell.toString());
			userList.add(user);

		}

		try {
			xssfWorkbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList.iterator();
	}
}
