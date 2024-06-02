public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node first;
    private Node last;
    private int size;


    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public LinkedList(List<T> list) {
        this();
        addAll(list);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T elem) {
        Node newNode = new Node(elem);
        newNode.next = null;
        if (size > 0) {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        } else {
            first = newNode;
            last = newNode;
            newNode.prev = null;
        }
        size++;
    }

    @Override
    public void addAll(List<T> elems) {
        Iterator<T> iterator = elems.iterator();
        add(iterator.getElem());
        for (int i = 0; i < elems.size() - 1; i++) {
            iterator = iterator.next();
            add(iterator.getElem());
        }
    }



    @Override
    public T get(int i) {
        Node node = getNode(i);
        if(node != null) {
            return node.elem;
        }
        else {
            return null;
        }
    }

    @Override
    public void remove(int i) {
        Node node = getNode(i);
        if(node != null) {
            if (node.prev != null && node.next != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else if (node.prev != null) {
                node.prev.next = null;
                last = node.prev;
            } else {
                node.next.prev = null;
                first = node.next;
            }
            size--;
        }
    }

    @Override
    public void add(T elem, int i) {
        if (i >= 0 && i <= size) {
            if (size == 0) {
                add(elem);
                size++;
            } else {
                Node newNode = new Node(elem);
                if (i == size) {
                    add(elem);
                } else {
                    Node node = getNode(i);
                    if (node != null) {
                        if(node.prev != null) {
                            node.prev.next = newNode;
                            newNode.prev = node.prev;
                        } else {
                            newNode.prev = null;
                            first = newNode;
                        }
                        newNode.next = node;
                        node.prev = newNode;
                        size++;
                    }
                }
            }
        }
    }

    @Override
    public void sort() {
        // Реализовал только для ArrayList, потому что основная идея и так понятна.
    }

    private Node getNode(int i) {
        if (i < size && i >= 0) {
            Node iterNode;

            if (i < size / 2) {
                iterNode = first;
                for (int j = 0; j < i; j++) {
                    iterNode = iterNode.next;
                }
            } else {
                iterNode = last;
                for (int j = 0; j < size - i - 1; j++) {
                    iterNode = iterNode.prev;
                }
            }
            return iterNode;
        }
        else {
            return null;
        }
    }



    private class Node implements Iterator<T> {
        private final T elem;
        private Node prev;
        private Node next;

        public Node(T elem) {
            this.elem = elem;
        }

        @Override
        public Iterator<T> next() {
            return next;
        }

        @Override
        public Iterator<T> prev() {
            return prev;
        }

        @Override
        public T getElem() {
            return elem;
        }


    }

    @Override
    public Iterator<T> iterator() {
        return first;
    }



}
