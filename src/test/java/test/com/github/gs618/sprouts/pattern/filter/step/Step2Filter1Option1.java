package test.com.github.gs618.sprouts.pattern.filter.step;

import com.github.gs618.sprouts.pattern.filter.Filter;
import com.github.gs618.sprouts.pattern.filter.FilterChain;
import com.github.gs618.sprouts.pattern.filter.FilterPriority;

@FilterPriority(2)
public class Step2Filter1Option1 implements Filter {

	@Override
	public void doFilter(Object input, Object output, FilterChain filterChain) {
		System.out.println("waiting timeout");
		filterChain.doFilter(input, output);
	}

}
