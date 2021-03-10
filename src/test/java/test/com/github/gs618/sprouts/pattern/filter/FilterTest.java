package test.com.github.gs618.sprouts.pattern.filter;

import com.github.gs618.sprouts.pattern.filter.FilterChain;
import org.junit.Test;
import test.com.github.gs618.sprouts.pattern.filter.step.Step1Filter1Option1;
import test.com.github.gs618.sprouts.pattern.filter.step.Step2Filter1Option1;

import java.util.ArrayList;
import java.util.List;

public class FilterTest {

	@Test
	public void filterChainTest() {
		FilterChain<Integer, List<Integer>> integerListFilterChain = new FilterChain<>();
		Step1Filter1Option1<Integer, List<Integer>> step1Filter1Option1 = new Step1Filter1Option1<>();
		Step2Filter1Option1<Integer, List<Integer>> step2Filter1Option1 = new Step2Filter1Option1<>();
		integerListFilterChain.addFilter(step2Filter1Option1).addFilter(step1Filter1Option1);
		integerListFilterChain.doFilter(null, null);
	}

	@Test
	public void filterChainOrderTest() {
		FilterChain<Integer, List<Integer>> integerListFilterChain = new FilterChain<>();
		Step1Filter1Option1<Integer, List<Integer>> step1Filter1Option1 = new Step1Filter1Option1<>();
		Step2Filter1Option1<Integer, List<Integer>> step2Filter1Option1 = new Step2Filter1Option1<>();
		integerListFilterChain.addFilter(1, step2Filter1Option1).addFilter(10, step1Filter1Option1);
		integerListFilterChain.doFilter(null, null);
	}

	@Test
	public void interfaceFunctionTest() {
		FilterChain<Integer, List<Integer>> integerListFilterChain = new FilterChain<>();
		integerListFilterChain.addFilter(1, (input, output, chain) -> {
			System.out.println(input);
			output.add(input + 1);
			input += 10;
			chain.doFilter(input, output);
		}).addFilter(10, (input, output, chain) -> {
			System.out.println(input);
			output.add(input + 1);
			chain.doFilter(input, output);
		});
		List<Integer> output = new ArrayList<>(2);
		integerListFilterChain.doFilter(10, output);
		System.out.println(output);
	}
}
