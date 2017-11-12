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
 * ���� ���ø����̼� ���ؽ�Ʈ�� �׽�Ʈ ������ ������� �ϳ��� ����� ���� 
 * �̷��� ������� ���ؽ�Ʈ�� ��� �׽�Ʈ���� ���� �Ǵ��� �����Ѵ�. 
 *
 * assertTrue�� ���ǹ��� �޾Ƽ� �� ����� true���� false������ ȣ�����ϵ��� ������ִ� ������ �޼ҵ��.
 * either()�� �ڿ� �̾ ������ or()�� �Բ� �� ���� ��ó�� ����� OR �������� �����ش�. 
 * nullValue()�� �̸� �״�� ������Ʈ�� null������ Ȯ�����ش�. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JUnitTest03 {
	//�׽�Ʈ ���ؽ�Ʈ�� �Ź� �������ִ� ���ø����̼� ���ؽ�Ʈ�� �׻� ���� ������Ʈ���� �׽�Ʈ�� Ȯ���غ���.
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
