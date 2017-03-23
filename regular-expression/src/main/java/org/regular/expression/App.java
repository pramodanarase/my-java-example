package org.regular.expression;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String startRegx = "(.*?)\\[(.*?)\\].*?Request Received.*?PositionManagementService.*\\r\\n";
		// String startRegx = "^(.*?)\\[(.*?)\\].*?Request Received =
		// .*?PositionManagementService.*";
		String endRegx = null;
		try {

			FileInputStream fisTargetFile = new FileInputStream(
					new File("D:\\log-parse\\controller.log2017-03-20.txt"));
			String strFile = IOUtils.toString(fisTargetFile, "UTF-8");
			Pattern startPattern = Pattern.compile(startRegx);
			Matcher startMatcher = startPattern.matcher(strFile);
			Pattern endPattern = null;
			Matcher endMatcher = null;
			String threadId;
			String time1, time2;
			while (startMatcher.find()) {

				time1 = startMatcher.group(1);
				threadId = startMatcher.group(2);

				System.out.println("time1::" + time1 + " threadId::" + threadId);

				endRegx = "(.*?)\\[" + threadId + "\\].*?Request Completed.*?PositionManagementService.*\\r\\n";
				endPattern = Pattern.compile(endRegx);
				endMatcher = endPattern.matcher(strFile);

				if (endMatcher.find()) {
					time2 = endMatcher.group(1);
					System.out.println("time2::" + time2);
				}

			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
