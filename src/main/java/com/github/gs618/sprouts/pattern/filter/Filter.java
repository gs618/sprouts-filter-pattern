package com.github.gs618.sprouts.pattern.filter;

/**
 * @author sgao
 */
public interface Filter<I, O> {

	int DEFAULT_PRIORITY = 256;

	/**
	 * Filter by business logic
	 *
	 * @param input input
	 * @param output output
	 * @param filterChain the chain that filter belongs to
	 */
	void doFilter(I input, O output, FilterChain<I, O> filterChain);

}
