package com.github.gs618.sprouts.pattern.filter;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author sgao
 */
public class FilterChain<I, O> {

	private final Map<Integer, Filter<I, O>> filters = new TreeMap<>();

	private Iterator<Map.Entry<Integer, Filter<I, O>>> iterator;

	private Exception exception = null;

	private boolean success = true;

	/**
	 * @return Null: No exception happens during the filterChain runs, the flag success should be true
	 * Not null: there must be an exception thrown out during the process, the flag success should be false
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @return true: success
	 * false: failure
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Invoke filter
	 *
	 * @param input  input to filter
	 * @param output output from filter
	 */
	public void doFilter(I input, O output) {
		if (iterator.hasNext()) {
			Filter<I, O> filter = iterator.next().getValue();
			if (filter.shouldFilter(input, output)) {
				try {
					filter.preFilter(input, output);
					filter.doFilter(input, output, this);
				} catch (Exception e) {
					// doFilter is a recursion so the exception will not be spread
					exception = e;
					success = false;
				} finally {
					filter.postFilter(input, output);
				}
			} else {
				// if current filter does not run, then we'd know if the rest filters run.
				if (filter.shouldRestFilter(input, output)) {
					doFilter(input, output);
				}
			}
		}
	}

	/**
	 * add a filter
	 *
	 * @param filter Filter
	 * @return FilterChain
	 */
	public FilterChain<I, O> addFilter(Filter<I, O> filter) {
		Priority annotation = filter.getClass().getAnnotation(Priority.class);
		int priority;
		if (Objects.nonNull(annotation)) {
			priority = annotation.value();
		} else {
			priority = filter.getPriority();
		}
		return addFilter(priority, filter);
	}

	/**
	 * add a filter
	 *
	 * @param priority the smaller of the number, the higher of the priority
	 * @param filter   Filter
	 * @return FilterChain
	 */
	public FilterChain<I, O> addFilter(Integer priority, Filter<I, O> filter) {
		filters.put(priority, filter);
		return reset();
	}

	/**
	 * reset iterator
	 *
	 * @return FilterChain
	 */
	public FilterChain<I, O> reset() {
		iterator = filters.entrySet().iterator();
		return this;
	}
}
