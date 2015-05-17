package de.se.testcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import junit.framework.Assert;

import org.junit.After;

import productivecode.ISomeModule;
import productivecode.ModuleService;
import productivecode.NonStaticTestee;
import productivecode.StaticTestee;

public class Test {

	@org.junit.Test
	public void testNonStatic() {
		ISomeModule dependencyMock = createMock();
		ModuleService.setModule(ISomeModule.class, dependencyMock);

		NonStaticTestee testee = new NonStaticTestee();

		Date result = testee.doSomething();
		
		Assert.assertEquals(result, new Date(0));

//		assertThat(, is(equalTo()));
	}

	@org.junit.Test
	public void testStatic() {
		ISomeModule dependencyMock = createMock();
		StaticTestee testee = StaticTestee.getInstance();
		testee.setDependeny(dependencyMock);

		Date result = testee.doSomething();

		assertThat(result, is(equalTo(new Date(0))));
	}

	private ISomeModule createMock() {
		ISomeModule mock = mock(ISomeModule.class);
		when(mock.getDate()).thenReturn(new Date(0));
		return mock;
	}

	@After
	public void after() {
		ModuleService.registerProductiveModules();
	}
}
