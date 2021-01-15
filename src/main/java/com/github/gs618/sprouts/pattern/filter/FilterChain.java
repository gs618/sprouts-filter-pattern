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

	/**
	 * Invoke filter
	 * @param input input to filter
	 * @param output output from filter
	 */
	public void doFilter(I input, O output) {
		if(iterator.hasNext()) {
			Filter<I, O> filter = iterator.next().getValue();
			filter.doFilter(input, output, this);
		}
	}

	/**
	 * add a filter
	 * @param filter Filter
	 * @return FilterChain
	 */
	public FilterChain<I, O> addFilter(Filter<I, O> filter) {
		FilterPriority annotation = filter.getClass().getAnnotation(FilterPriority.class);
		int priority;
		if(Objects.nonNull(annotation)) {
			priority = annotation.value();
		} else {
			priority = Filter.DEFAULT_PRIORITY;
		}
		return addFilter(priority, filter);
	}

	/**
	 * add a filter
	 *
	 * @param priority the smaller of the number, the higher of the priority
	 * @param filter	Filter
	 * @return FilterChain
	 */
	public FilterChain<I, O> addFilter(Integer priority, Filter<I, O> filter) {
		filters.put(priority, filter);
		return reset();
	}

	/**
	 * reset iterator
	 * @return FilterChain
	 */
	public FilterChain<I, O> reset() {
		iterator = filters.entrySet().iterator();
		return this;
	}
}
