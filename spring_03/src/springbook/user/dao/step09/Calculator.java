package springbook.user.dao.step09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

public class Calculator {
	public Integer calcSum(String filepath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		Integer sum = 0;
		String line = null;
		while((line = br.readLine()) != null) {
			sum += Integer.valueOf(line);
		} 
		br.close();//한 번 연 파일은 반드시 닫아준다. 
		return sum;
	}
}
