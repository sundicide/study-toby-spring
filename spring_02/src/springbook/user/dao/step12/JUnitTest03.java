package springbook.user.dao.step12;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.junit.matchers.JUnitMatchers.either;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 정말 애플리케이션 컨텍스트가 테스트 개수에 상관없이 하나만 만들어 지고 
 * 이렇게 만들어진 컨텍스트가 모든 테스트에서 공유 되는지 검증한다. 
 *
 * assertTrue는 조건문을 받아서 그 결과가 true인지 false인지를 호가인하도록 만들어주는 검증용 메소드다.
 * either()는 뒤에 이어서 나오는 or()와 함께 두 개의 매처의 결과를 OR 조건으로 비교해준다. 
 * nullValue()는 이름 그대로 오브젝트가 null인지를 확인해준다. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JUnitTest03 {
	//테스트 컨텍스트가 매번 주입해주는 애플리케이션 컨텍스트가 항상 같은 오븝젝트인지 테스트로 확인해본다.
	@Autowired ApplicationContext context;
	
	static Set<JUnitTest03> testObjects = new HashSet<JUnitTest03>();
	static ApplicationContext contextObject = null;
	
	@Test public void test1() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
		
		assertThat(contextObject == null || contextObject == this.context, is(true));
		contextObject = this.context;
	}
	
	@Test public void test2() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
		
		assertTrue(contextObject == null || contextObject == this.context);
		contextObject = this.context;
	}
	
	@Test public void test3() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
		
		assertThat(contextObject, either(is(nullValue())).or(is(this.context)));
		assertThat(contextObject == null || contextObject == this.context, is(true));
		contextObject = this.context;
	}
}
