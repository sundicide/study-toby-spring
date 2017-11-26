package springbook.user.dao.step12;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

public class Calculator342 {
	public <T> T lineReadTemplate(String filepath, LineCallback341<T> callback, T initVal) throws IOException {
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filepath));
			T res = initVal;
			String line = null;
			while((line = br.readLine()) != null) {
				res = callback.doSomethingWithLines(line, res);
			} 
			return res;
		}catch(IOException e){
			System.out.println(e.getMessage());
			throw e;
		}finally{
			if(br!=null){
				try{br.close();}
				catch(IOException e){System.out.println(e.getMessage());}
			}
		}
	}
	
	public String concatenate(String filepath) throws IOException {
		LineCallback341<String> concatenateCallback = 
				new LineCallback341<String>() {
					public String doSomethingWithLines(String line, String value){
						return value + line;
					}};
		return lineReadTemplate(filepath, concatenateCallback, "");
	}
	
	
	public Integer calcSum(String filepath) throws IOException {
		LineCallback341<Integer> sumCallback = 
				new LineCallback341<Integer>(){
			public Integer doSomethingWithLines(String line, Integer value){
				return value + Integer.valueOf(line);
			}};
			return lineReadTemplate(filepath, sumCallback, 0);
	}
	
	public Integer calcMultiply(String filepath) throws IOException {
		LineCallback341<Integer> multiplyCallback = 
				new LineCallback341<Integer>(){
					public Integer doSomethingWithLines(String line, Integer value){
						return value * Integer.valueOf(line);
					}};
					return lineReadTemplate(filepath, multiplyCallback, 1);
	}
	
	
}
