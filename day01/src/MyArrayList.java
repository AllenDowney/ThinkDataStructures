public class MyArrayList<T> {
    private Object[] elems;
    private int size;

    public MyArrayList() {
    	this(10);
    }

    public MyArrayList(int capacity) {
        elems = new Object[capacity];
        size = 0;
    }

    public void add(T c) {
        if (size==elems.length)
                doubleSize();

        elems[size] = c;
        size++;
    }

    public int size() {
      return size;
    }

    public T get(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds.");
        return (T) elems[index];
    }

    public T remove(int index){
        if (index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds.");

        if (size<elems.length/4 && elems.length > 10)
            halfSize();

        T removed = get(index);
        index++;

        // Shift elements to fill empty space from removing element
        while (index < size) {
            elems[index-1] = elems[index];
            index++;
        }

        size--;
        return removed;
    }

    public void add(int index, T c){
        if (index > size)
            throw new IndexOutOfBoundsException("Index out of bounds.");

        if (size==elems.length)
            doubleSize();

        // Shift elements to make space for new element
        int mover = index;
        while (mover<size) {
            elems[mover+1]=elems[mover];
            mover++;
        }

        elems[index]=c;
        size++;
    }

    private void doubleSize(){
        Object[] newElems = new Object[elems.length*2];
        System.arraycopy(elems, 0, newElems, 0, size);
        elems = newElems;
    }

    private void halfSize(){
    	int newCapacity = elems.length / 2;
        Object[] newElems = new Object[newCapacity];
        System.arraycopy(elems, 0, newElems, 0, newCapacity);
        elems = newElems;
    }
}
