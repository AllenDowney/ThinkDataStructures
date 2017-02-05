# Day05 - `MyHashMap`

## Learning Goals

After completing this assignment you should be able to:
* Understand the key concepts of hashing
  * Understand hash functions and considerations when creating them
  * Understand how a hash map chooses which sub-map to place objects in
* Compare the efficiency of various hash map implementations
  * Understand how a hash map achieves average constant time
* Identify when using a hash map is effective

## Due Date:

Midnight, Feb. 9, 2017

## Assignment

### Reading

- In *Think Algorithms*, read sections **15.4 and 15.5**.

### Code

Finish the implementation of these methods in MyHashMap:
* `makeMaps(int size)` Initialize `maps` to `n` LinearMaps, where `n=size`
* `chooseMap(Object key)` given a key, return the `LinearMap` where the `K, V` pair would be stored if it is in the map.
* `containsKey(Object key)` return true if key is in map
* `containsValue(Object value)` return true if value is in map
* `rehash(double growthFactor)` Changes the number of maps and rehashes the existing entries. If growthFactor is 2, the number of maps doubles. If it is 0.25, the number of maps is divided by 4.
* `put(K key, V value)` add a new key-value pair to the map. Grow if needed, according to `ALPHA`.
* `remove(Object key)` remove and return the key-value pair associated with the given key. Shrink if needed, according to `BETA`. Make sure the number of `LinearMaps` doesn't go below `MIN_MAPS`. 

### PSet Problem
Given a string, pattern, and another string, str, return true if str follows the same sequence as pattern.  Following the sequence means that every space separated word in str has a one-to-one correspondence to a letter in pattern (for the curious, this is a bijection in graph theory).  For example:

- pattern = "abba" and str = "dog cat cat dog" -> return true
- pattern = "abba" and str = "dog cat cat fish" -> return false  
- pattern = "aaaa" and str = "dog cat cat dog" -> return false
- pattern = "abba" and str = "dog dog dog dog" -> return false

### Checkoff

Explain to a NINJA the main purpose of a hash function. Are there any requirements or limitations when hashing? Find at least one problem with SillyString's hash function.

Tell a NINJA about the key differences and improvements between MyLinearMap and MyHashMap.

Explain the runtime complexity of your solution to the boomerang problem.