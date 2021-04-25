package test.com.github.gs618.sprouts.pattern.filter.step;

import com.github.gs618.sprouts.pattern.filter.Filter;
import com.github.gs618.sprouts.pattern.filter.FilterChain;

public class ReturnTestStep1 implements Filter {

	@Override
	public boolean shouldFilter(Object input, Object output) {
		return false;
	}

	@Override
	public boolean shouldRestFilter(Object input, Object output) {
		return false;
	}

	@Override
	public void doFilter(Object input, Object output, FilterChain filterChain) {
		filterChain.doFilter(input, output);
	}

}
