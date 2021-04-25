package com.github.gs618.sprouts.pattern.filter;

/**
 * @author sgao
 */
@FunctionalInterface
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

	/**
	 * Get priority
	 *
	 * @return Priority
	 */
	default int getPriority() {
		return DEFAULT_PRIORITY;
	}

	/**
	 * Whether the filter should run
	 *
	 * @param input input
	 * @param output output
	 * @return true: the filter runs
	 * 				false: the filter is bypassed
	 */
	default boolean shouldFilter(I input, O output) {
		return true;
	}

	/**
	 * if the filter should not run, whether the rest filters run
	 *
	 * @param input input
	 * @param output output
	 * @return true: the filter runs
	 * 				false: the filter is bypassed
	 */
	default boolean shouldRestFilter(I input, O output) {
		return false;
	}

	/**
	 * This method will run until all of the downstream filter calls back
	 *
	 * @param input input
	 * @param output output
	 */
	default void postFilter(I input, O output) {}

	/**
	 * Runs before filter method
	 *
	 * @param input input
	 * @param output output
	 */
	default void preFilter(I input, O output) {}
}
