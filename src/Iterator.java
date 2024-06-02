public interface Iterator<T> {

    Iterator<T> next();

    Iterator<T> prev();

    T getElem();
}
