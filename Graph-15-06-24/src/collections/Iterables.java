package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unused")
public class Iterables {

	public static <E> Iterable<E> iterableWithPredicate(
			final Iterable<? extends E> iterable, final Predicate<? super E> p) {
		/*
		 * athman lambda expresssion
		 */
		return () -> Iterators.iteratorWithPredicate(iterable.iterator(), p);
				/*new Iterable<E>() {
			@Override
			public Iterator<E> iterator() {
				return Iterators.iteratorWithPredicate(iterable.iterator(), p);
			}

		};*/
	}

	public static <E> Iterable<E> append(final Iterable<? extends E> it1,
			final Iterable<? extends E> it2) {
		/*
		 * athman lambda expresssion
		 */
		return () -> Iterators.append(it1.iterator(), it2.iterator());
				/*new Iterable<E>() {

			@Override
			public Iterator<E> iterator() {
				return Iterators.append(it1.iterator(), it2.iterator());
			}

		};*/
	}

	/**
	 * Used mainly for testing. Test if the iterator <tt>it</tt> returns exactly
	 * the values contained in <tt>elements</tt>.
	 * 
	 * @param <E>
	 *            type of the elements.
	 * @param it
	 *            an iterable
	 * @param elements
	 *            an array of elements
	 * @return
	 */
	@SafeVarargs
	public static <E> boolean hasElements(Iterable<E> it, E... elements) {
		return Iterators.hasElements(it.iterator(), elements);
	}

	/**
	 * Used mainly for testing. Returns the number of elements returned by
	 * <tt>it</tt>.
	 * 
	 * @param <E>
	 *            type of the elements.
	 * @param it
	 *            an iterable
	 * 
	 * @return the number of elements returned by the iterable
	 */
	public static <E> int size(Iterable<E> it) {
		return Iterators.size(it.iterator());
	}

	public static <E> Iterable<E> emptyIterable() {
		/*
		 * athman lambda expresssion
		 */
		return () -> Iterators.emptyIterator();
				/*new Iterable<E>() {
			@Override
			public Iterator<E> iterator() {
				return Iterators.emptyIterator();
			}
		};*/
	}

	public static <E> Iterable<E> singleton(final E element) {
		/*
		 * athman lambda expresssion
		 */
		return () -> Iterators.singleton(element);
				/*new Iterable<E>() {
			@Override
			public Iterator<E> iterator() {
				return Iterators.singleton(element);
			}
		};*/
	}

	public static <E> List<E> fillList(List<E> list, Iterable<? extends E> it) {
		for (E element : it)
			list.add(element);
		return list;
	}

	public static <E> List<E> fillList(Iterable<? extends E> it) {
		return fillList(new ArrayList<E>(), it);
	}

	public static void print(Iterable<?> iterable, String separator) {
		Iterators.print(iterable.iterator(), separator);
	}
}
