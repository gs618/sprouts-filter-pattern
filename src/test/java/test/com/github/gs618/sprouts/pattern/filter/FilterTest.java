package test.com.github.gs618.sprouts.pattern.filter;

import com.github.gs618.sprouts.pattern.filter.FilterChain;
import org.junit.Test;
import test.com.github.gs618.sprouts.pattern.filter.step.ReturnTestStep1;
import test.com.github.gs618.sprouts.pattern.filter.step.Step1Filter1Option1;
import test.com.github.gs618.sprouts.pattern.filter.step.Step1Filter1Option2;
import test.com.github.gs618.sprouts.pattern.filter.step.Step2Filter1Option1;
import test.com.github.gs618.sprouts.pattern.filter.step.Step2Filter1Option2;

import java.util.List;

public class FilterTest {

	@Test
	public void filterChainTest() {
		FilterChain<Integer, List<Integer>> integerListFilterChain = new FilterChain<>();
		Step1Filter1Option1 step1Filter1Option1 = new Step1Filter1Option1();
		Step2Filter1Option1 step2Filter1Option1 = new Step2Filter1Option1();
		integerListFilterChain.addFilter(step2Filter1Option1).addFilter(step1Filter1Option1);
		integerListFilterChain.doFilter(null, null);
	}

	@Test
	public void filterChainOrderTest() {
		FilterChain<Integer, List<Integer>> integerListFilterChain = new FilterChain<>();
		Step1Filter1Option1 step1Filter1Option1 = new Step1Filter1Option1();
		Step2Filter1Option1 step2Filter1Option1 = new Step2Filter1Option1();
		integerListFilterChain.addFilter(1, step2Filter1Option1).addFilter(10, step1Filter1Option1);
		integerListFilterChain.doFilter(null, null);
	}

	@Test
	public void filterChainReturnTest() {
		FilterChain<Integer, List<Integer>> integerListFilterChain = new FilterChain<>();
		integerListFilterChain.addFilter(new Step1Filter1Option1());
		integerListFilterChain.addFilter(new Step1Filter1Option2());
		integerListFilterChain.addFilter(new ReturnTestStep1());
		integerListFilterChain.addFilter(new Step2Filter1Option1());
		integerListFilterChain.addFilter(new Step2Filter1Option2());
		integerListFilterChain.doFilter(null, null);
		System.out.println(integerListFilterChain.isSuccess());
	}
}
