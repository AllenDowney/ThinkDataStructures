import java.util.*;

/**
 * Implementation of a HashMap using a collection of MyLinearMap and
 * resizing when there are too many entries.
 *
 * @author downey
 * @param <K>
 * @param <V>
 *
 */
public class MyHashMapSoln<K, V> implements Map<K, V> {

	// average number of entries per map before we rehash
	protected static final double ALPHA = 2.0;

	// resizing factor: (new size) = (old size) * (resize factor)
	protected static final double RESIZE_FACTOR = 2.0;

	// list of maps
	protected List<MyLinearMap<K,V>> maps;
	private int size = 0;

	public MyHashMapSoln() {
		makeMaps(2);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO: Complete this method
        MyLinearMap<K,V> map = chooseMap(key);
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO: Complete this method
        for (MyLinearMap<K,V> map : maps) {
			if (map.containsValue(value)) return true;
		}

		return false;
	}

	@Override
	public V get(Object key) {
        MyLinearMap<K,V> m = chooseMap(key);
		return m.get(key);
	}

	@Override
	public V put(K key, V value) {
        // TODO: Complete this method
        MyLinearMap<K,V> map = chooseMap(key);
		size -= map.size();
		V oldValue = map.put(key, value);
		size += map.size();

		// check if the number of elements per map exceeds the threshold
		if (size() > maps.size() * ALPHA) {
			size = 0;
			rehash();
		}
		return oldValue;
	}

	@Override
	public V remove(Object key) {
		// TODO: Complete this method
        MyLinearMap<K,V> map = chooseMap(key);
		size -= map.size();
		V oldValue = map.remove(key);
		size += map.size();
		return oldValue;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Doubles the number of maps and rehashes the existing entries.
	 */
	protected void rehash() {
		// TODO: Implement this method
		List<MyLinearMap<K,V>> oldMaps = maps;
        int newSize = (int) (maps.size() * RESIZE_FACTOR);

        makeMaps(newSize);

		for (MyLinearMap<K,V> map : oldMaps) {
			for (Map.Entry<K,V> entry : map.getEntries()) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}

	protected void makeMaps(int size) {
		// TODO: Implement this method
		maps = new ArrayList<>();
		for (int i=0; i<size; i++) {
			maps.add(new MyLinearMap<K, V>());
		}
	}

	public void clear() {
		for (int i=0; i<maps.size(); i++) {
			maps.get(i).clear();
		}
	}

	protected MyLinearMap<K, V> chooseMap(Object key) {
		// TODO: Implement this method
		int index = key==null ? 0 : Math.abs(key.hashCode()) % maps.size();
		return maps.get(index);
	}

	@Override
	public Set<K> keySet() {
        Set<K> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.keySet());
		}
		return set;
	}

	@Override
	public Collection<V> values() {
        Set<V> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.values());
		}
		return set;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.getEntries());
		}
		return set;
	}
}
