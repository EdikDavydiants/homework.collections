public interface List<T extends Comparable<T>> {


    int size();

    void add(T elem);

    void addAll(List<T> elems);


    T get(int i);


    void remove(int i);

    void add(T elem, int i);

    void sort();


    default void showAll() {
        Iterator<T> iterator = iterator();
        for (int j = 0; j < size(); j++) {
            System.out.println(iterator.getElem().toString());
            iterator = iterator.next();
        }
    }

    static void sort(List<? extends Comparable<?>> list) {
        list.sort();
    }


    Iterator<T> iterator();


}



