

public class Main {
    public static void main(String[] args) {


        List<Word> arrayList = new ArrayList<>();

        arrayList.add(new Word("One"));
        arrayList.add(new Word("Two"));
        arrayList.add(new Word("Three"));
        arrayList.add(new Word("Four"));
        arrayList.add(new Word("Five"));
        arrayList.add(new Word("Six"));
        arrayList.add(new Word("Seven"));
        arrayList.add(new Word("Eight"));
        arrayList.add(new Word("Nine"));
        arrayList.add(new Word("Ten"));
        arrayList.add(new Word("Eleven"));
        arrayList.add(new Word("Twelve"));



//        List.sort(arrayList); // сортировка

        List<Word> linkedList = new LinkedList<>(arrayList); // инициализация через конструктор

        linkedList.showAll(); // показать все элементы


    }


}