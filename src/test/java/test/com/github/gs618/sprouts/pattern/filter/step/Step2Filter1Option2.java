package test.com.github.gs618.sprouts.pattern.filter.step;

import com.github.gs618.sprouts.pattern.filter.Filter;
import com.github.gs618.sprouts.pattern.filter.FilterChain;
import com.github.gs618.sprouts.pattern.filter.Priority;

@Priority(2)
public class Step2Filter1Option2 implements Filter {

	@Override
	public void doFilter(Object input, Object output, FilterChain filterChain) {
		System.out.println("check and invoke");
		filterChain.doFilter(input, output);
	}

}
