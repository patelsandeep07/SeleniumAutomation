package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVreaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {

		File CSVFile = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
		FileReader filereader = null;
		CSVReader csvReader;
		String[] data;
		List<User> userList = null;
		User userData;

		try {
			filereader = new FileReader(CSVFile);
			csvReader = new CSVReader(filereader);
			csvReader.readNext();// 0th index we get the column name(row 1)

			userList = new ArrayList<User>();
			while ((data = csvReader.readNext()) != null) {
				userData = new User(data[0], data[1]);
				userList.add(userData);
			}

			for (User user : userList) {
				System.out.println(user);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
