package springbook.user.dao.step10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class CalcSumTest {
	Calculator335 calculator = new Calculator335();
	String numFilepath;
	@Before public void setUp() {
		this.calculator = new Calculator335();
		this.numFilepath = getClass().getResource("numbers.txt").getPath();  
	}
	@Test
	public void sumOfNumbers() throws IOException {
		assertThat(calculator.calcSum(this.numFilepath), is(10));
	}
	@Test
	public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calcMultiply(this.numFilepath), is(24));
	}
}
