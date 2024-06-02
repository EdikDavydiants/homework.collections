public class Word implements Comparable<Word>{

    private final String name;


    public Word(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Word word) {
        // Сравнение по длине строки.
        return Integer.compare(name.length(), word.name.length());
    }


    @Override
    public String toString() {
        return name;
    }
}
