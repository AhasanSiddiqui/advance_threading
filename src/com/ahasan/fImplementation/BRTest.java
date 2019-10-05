package com.ahasan.fImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.ahasan.functionalInterface.BufferedReaderProcessoer;

public class BRTest implements BufferedReaderProcessoer{
	

	@Override
	public String process(BufferedReader p) throws IOException {
		try (BufferedReader br=new BufferedReader(new FileReader("abc/abc.txt"))) {
			//return p.process(br);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
