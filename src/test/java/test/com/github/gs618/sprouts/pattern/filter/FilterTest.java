package test.com.github.gs618.sprouts.pattern.filter;

import com.github.gs618.sprouts.pattern.filter.FilterChain;
import org.junit.Test;
import test.com.github.gs618.sprouts.pattern.filter.step.Step1Filter1Option1;
import test.com.github.gs618.sprouts.pattern.filter.step.Step2Filter1Option1;

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
}
