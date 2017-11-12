package springbook.user.dao.step12;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
/**
 * �޼ҵ带 ������ ������ ���� ���ο� ������Ʈ�� ������������� Ȯ���ϱ� ���� Junit�� ���� �׽�Ʈ
 * 
 * not()�� �ڿ� ������ ����� �����ϴ� ���Ĵ�.
 * sameInstance()�� ���ϼ� �� ��ó��.
 */
public class JUnitTest {
	static JUnitTest testObject;
	
	@Test public void test1() {
		assertThat(this, is(not(sameInstance(testObject))));
		testObject = this;
	}
	
	@Test public void test2() {
		assertThat(this, is(not(sameInstance(testObject))));
		testObject = this;
	}
	
	@Test public void test3() {
		assertThat(this, is(not(sameInstance(testObject))));
		testObject = this;
	}
}
