package br.com.til;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcherPatternTest {

	
	public static void main(String[] args) {
		
		String regex = "[a-zA-z]([0-9])+";
		String matcherText = "a12b2c3d5e6";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(matcherText);
			
		while(matcher.find()) {
			
			String groupText = matcher.group();
			
			String regexInnerChar = "[a-zA-z]";
			
			String groupTextChar = getText(groupText, regexInnerChar);
			
			String regexInnerDigit = "([0-9])+";
			
			String groupTextDigit = getText(groupText, regexInnerDigit);
			
			
			for (int i = 0; i < Integer.parseInt(groupTextDigit); i++) {
				System.out.print(groupTextChar);
			}
			System.out.println("");
		}
		
	}
	
	private static String getText(String regexText, String regexPattern) {
		
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(regexText);
		
		String groupText = "";
		
		while(matcher.find()) {
			groupText = matcher.group();
		}
		
		return groupText;
	}
}
