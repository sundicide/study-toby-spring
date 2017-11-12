package springbook.user.dao.step12;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
/**
 * 메소드를 수행할 때마다 정말 새로운 오브젝트가 만들어지는지를 확인하기 위한 Junit에 대한 테스트
 * 
 * not()은 뒤에 나오는 결과를 부정하는 매쳐다.
 * sameInstance()는 동일성 비교 매처다.
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
