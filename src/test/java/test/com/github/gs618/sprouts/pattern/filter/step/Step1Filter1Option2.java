package test.com.github.gs618.sprouts.pattern.filter.step;

import com.github.gs618.sprouts.pattern.filter.Filter;
import com.github.gs618.sprouts.pattern.filter.FilterChain;
import com.github.gs618.sprouts.pattern.filter.Priority;

@Priority(1)
public class Step1Filter1Option2 implements Filter {

	@Override
	public void doFilter(Object input, Object output, FilterChain filterChain) {
		System.out.println("upload file to s3 bucket directly");
		filterChain.doFilter(input, output);
	}

}
