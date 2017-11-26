package springbook.user.dao.step12;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class CalcSumTest {
	Calculator342 calculator = new Calculator342();
	String numFilepath;
	@Before public void setUp() {
		this.calculator = new Calculator342();
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
	@Test
	public void concatenateStrings() throws IOException {
		assertThat(calculator.concatenate(numFilepath), is("1234"));
	}
}
