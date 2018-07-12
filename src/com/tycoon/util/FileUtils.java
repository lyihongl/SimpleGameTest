package com.tycoon.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileUtils {
	
	//load world from text file
	public String[] loadWorldAsString(String path){
		String[] s;
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)));
		Scanner input = new Scanner(br);
		String x = input.next();
		String y = input.next();
		s = new String[Integer.parseInt(x)*Integer.parseInt(x)+4];
		s[0] = x;
		s[1] = y;
		s[2] = input.next();
		s[3] = input.next();
		int count = 4;
		while(input.hasNext()){
			s[count] = input.next();
			count++;
		}
		return s;
		
	}
	
}
