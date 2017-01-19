
public class MyArrayList<T> {

    private Object[] elems;
    private int numElems;

    public MyArrayList(){

        elems = new Object[10];
        numElems = 0;

    }

    public void add(T c){

        if(numElems==elems.length){
            doubleSize();
        }
        elems[numElems] = c;
        numElems++;

    }

    public int size(){

        return numElems;

    }

    public T get(int index){

        if(index >= numElems) throw new IndexOutOfBoundsException("Index out of bounds.");
        return (T)elems[index];

    }

    public T remove(int index){

        if(index >= numElems) throw new IndexOutOfBoundsException("Index out of bounds.");
        if(numElems<elems.length/4 && elems.length > 10){
            halfSize();
        }
        T toRemove = get(index);
        index++;
        while(index < numElems){
            elems[index-1] = elems[index];
            index++;
        }
        numElems--;
        return toRemove;

    }

    public void add(int index, T c){

        if(index > numElems) throw new IndexOutOfBoundsException("Index out of bounds.");
        if(numElems==elems.length){
            doubleSize();
        }
        int mover = index;
        while(mover<numElems){
            elems[mover+1]=elems[mover];
            mover++;
        }
        elems[index]=c;
        numElems++;

    }

    private void doubleSize(){

        Object[] newElems = new Object[elems.length*2];
        for(int i = 0; i < numElems; i++){
            newElems[i] = elems[i];
        }
        elems = newElems;
    }

    private void halfSize(){

        Object[] newElems = new Object[Math.max(10,elems.length/2)];
        for(int i = 0; i < numElems; i++){
            newElems[i] = elems[i];
        }
        elems = newElems;

    }

}
