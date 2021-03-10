package test.com.github.gs618.sprouts.pattern.filter.step;

import com.github.gs618.sprouts.pattern.filter.Filter;
import com.github.gs618.sprouts.pattern.filter.FilterChain;
import com.github.gs618.sprouts.pattern.filter.FilterPriority;

@FilterPriority(2)
public class Step2Filter1Option2<I, O> implements Filter<I, O> {

	@Override
	public void doFilter(I input, O output, FilterChain<I, O> filterChain) {
		System.out.println("check and invoke");
		filterChain.doFilter(input, output);
	}

}
