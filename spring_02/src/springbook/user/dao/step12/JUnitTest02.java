package springbook.user.dao.step12;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
/**
 * 정말 순서에 상관없이 새로운 오브젝트가 맞는지 검사하는 Junit테스트
 *
 * hasItem() 은 컬렉션의 원소인지를 검사하는 매처이다.
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
