package springbook.user.dao.step12;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
/**
 * ���� ������ ������� ���ο� ������Ʈ�� �´��� �˻��ϴ� Junit�׽�Ʈ
 *
 * hasItem() �� �÷����� ���������� �˻��ϴ� ��ó�̴�.
 */
public class JUnitTest02 {
	static Set<JUnitTest02> testObjects = new HashSet<JUnitTest02>();
	
	@Test public void test1() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}
	
	@Test public void test2() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}
	
	@Test public void test3() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}
}
