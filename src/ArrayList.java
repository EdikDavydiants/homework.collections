public class ArrayList<T extends Comparable<T>> implements List<T> {

    public static final float EXPANSION_COEFFICIENT = 1.5f;
    private Object[] elems;
    private int size;


    public ArrayList() {
        elems = new Object[10];
        size = 0;
    }

    public ArrayList(List<T> list) {
        this();
        addAll(list);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T elem) {
        if (size < elems.length) {
            elems[size] = elem;
        } else {
            Object[] newElems = new Object[(int) (elems.length * EXPANSION_COEFFICIENT)];
            System.arraycopy(elems, 0, newElems, 0, elems.length);
            newElems[elems.length] = elem;
            elems = newElems;
        }
        size++;
    }

    @Override
    public T get(int i) {
        if (i > 0 && i < size) {
            return (T) elems[i];
        } else {
            return null;
        }
    }

    @Override
    public void addAll(List<T> elems) {
        Iterator<T> iterator = elems.iterator();

        if (size + elems.size() <= this.elems.length) {
            for (int i = 0; i < elems.size(); i++) {
                this.elems[size + i] = iterator.getElem();
                iterator = iterator.next();
            }
        } else {
            Object[] newElems = new Object[(int) ((size + elems.size()) * EXPANSION_COEFFICIENT)];
            if (size >= 0) System.arraycopy(this.elems, 0, newElems, 0, size);
            for (int i = 0; i < elems.size(); i++) {
                newElems[size + i] = iterator.getElem();
                iterator = iterator.next();
            }
            this.elems = newElems;
        }
        size += elems.size();
    }

    @Override
    public void remove(int i) {
        if (i > 0 && i < size - 1) {
            for (int j = i; j < size - 1; j++) {
                elems[j] = elems[j + 1];
            }
            elems[size - 1] = null;
        } else if (i == size - 1) {
            elems[i] = null;
        }
    }

    @Override
    public void add(T elem, int i) {

    }

    @Override
    public void sort() {
        // без флага
        for (int j = 1; j < size; j++) {
            for (int i = 0; i < size - j; i++) {
                int comp = ((T) elems[i]).compareTo((T) elems[i + 1]);
                if (comp < 0) {
                    Object elem = elems[i];
                    elems[i] = elems[i + 1];
                    elems[i + 1] = elem;
                }
            }
        }
    }


    private class IteratorClass implements Iterator<T> {
        int iter = 0;


        @Override
        public Iterator<T> next() {
            if (iter < size - 1) {
                iter++;
                return this;
            } else {
                return null;
            }
        }

        @Override
        public Iterator<T> prev() {
            if (iter > 0) {
                iter--;
                return this;
            } else {
                return null;
            }
        }

        @Override
        public T getElem() {
            return (T) elems[iter];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorClass();
    }


}
