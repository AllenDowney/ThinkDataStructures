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
**Time: O(N^2), Space: O(N)**.  Given an array containing n tuples of points in a plane, a "boomerang" is a set of points (i, j, k) such that the distance between i and j is equal to the distance between j and k.  Find the number of boomerangs on the plane. Note that you can never have an odd number of boomerangs because every boomerang set counts twice, as it can be flipped. For example:

Given the set of points [(0,0),(1,0),(2,0)], you should return 2.  The boomerangs are [(0, 0), (1, 0), (2, 0)] and [(2,0), (1,0), (0,0)].

Hint: If you have n points equidistant from point j, then there are n*(n-1) total boomerangs with j at the center.

### Checkoff

Explain to a NINJA:
- the main purpose of a hash function. Are there any requirements or limitations when hashing? Find at least one problem with SillyString's hash function.
- the key differences and improvements between MyLinearMap and MyHashMap.
- the runtime complexity of your solution to the boomerang problem.