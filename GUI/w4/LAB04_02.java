package w4;

public class LAB04_02 {
    public static void main(String[] args) {
        ArrayBox<Osoba>  bo = new ArrayBox<>(2);

        bo.add(new Osoba("Kowalski", 19));                                 // nazwisko = "Kowalki", wiek = 19
        bo.add(new Student("Kowalska", 18, 100));                    // nazwisko, wiek, grupa = 100
        bo.add(new Student("Kowalska", 20, 200));

        Osoba[] to = new Osoba[] {new Osoba("Nowak", 21), new Student("Nowak", 22, 200)};
        bo.addAll(to);

        System.out.println(bo.min());                                           // Student 1: Kowalska, 18, 100

        ArrayBox<Student> bst = new ArrayBox<>(1);
        bst.add(new Student("Nowacka", 24, 100));
        bst.add(new Student("Nowacka", 24, 300));
        bst.add(new Student("Nowacka", 24, 200));

        System.out.println(bst.max());                                          // Student 5: Nowacka, 24, 300

        ArrayBox<Integer> bi = new ArrayBox<>(2);
        Integer[] ti = new Integer[] {Integer.valueOf(1), 2, 3};
        bi.addAll(ti);

        bi.print();                                                                          // 1, 2, 3

        ArrayBox<String> bs = new ArrayBox<>(1);
        String[] ts = new String[] {"cpp", new String("java")};
        bs.addAll(ts);
        bs.swap(0,2);
        bs.print();                                                                         // java, cpp

        System.out.println("##############################################");

        //delete
        bst.delete(new Student("Nowacka", 24,300));
        System.out.println(bst.max());                                                      // Nowacka, 24, 200

        //search
        System.out.println(
        bst.search(new Student("Nowacka", 24, 200))                     // 1
        );


    }
}

class ArrayBox <T extends Comparable>{
    Object[] arr;
    int index;
    boolean contains;

    ArrayBox(int c){                // TODO dlaczego nie uzywamy tutaj modyfikatorów dostepu ??????
        arr = new Object[c];
        index =0;
    }

    boolean add(T e){
        checkSize();
        if (!isInArray(e)){
            arr[index]=e;
            index++;
            return true;
        }

        return false;
    }

    boolean addAll(T[] array){
        boolean isAtLeastOne = false;
        for (T obj : array){
            if (add(obj)){
                isAtLeastOne= true;
            }
        }
        return isAtLeastOne;
    }

    boolean delete(T e){

        if (this.search(e) < 0) {
            return false;
        }
        for (int i=0; i< index; i++){
            T el = (T) arr[i];
            if (el.compareTo(e) == 0){
                for (int j=i; j<index; j++){
                    arr[j] = j+1 < arr.length ? arr[j+1] : null;
                }
                index--;
                return true;
            }
        }
        return false;

    }

    boolean swap(int n1, int n2){
        try {
            Object temp = arr[n1];
            arr[n1] = arr[n2];
            arr[n2] = temp;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    T max(){
        T max = (T) arr[0];
        for (int i=0; i<index; i++){
            if (max.compareTo((T) arr[i]) < 0)
                max = (T) arr[i];
        }
        return max;
    }

    T min()
    {
        T min = (T) arr[0];
        for (int i=0; i<index; i++){
            if (min.compareTo((T) arr[i]) > 0)
                min = (T) arr[i];
        }
        return min;

    }

    int search(T e){
        for (int i=0; i< index; i++){
            T el = (T) arr[i];
            if(el.compareTo(e) == 0)
                return i;
        }
        return -1;
    }

    void print(){
        for (int i=0; i<index; i++) {
            System.out.println(arr[i].toString());
        }
    }

    void checkSize(){
        if (index + 1 > arr.length) {
            Object[] temp = new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
    }

    boolean isInArray(T e){
        for (int i=0; i<index;i++){
            if (arr[i].hashCode() == e.hashCode())
                return true;
        }
        return false;
    }
}

class Osoba implements Comparable<Osoba>{
    String nazwisko;
    int wiek;

    public Osoba(String nazwisko, int wiek){
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public int getWiek() {
        return wiek;
    }

    public int compareTo(Osoba o) {
        int i = nazwisko.compareTo(o.nazwisko);
        if(i==0){
            return this.wiek - o.getWiek();
        }
        else {
            return nazwisko.compareTo(o.nazwisko);
        }
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}

class Student extends Osoba{
    private int grupa;

    public Student(String nazwisko, int wiek, int grupa) {
        super(nazwisko, wiek);
        this.grupa = grupa;
    }

    public int getGrupa() {
        return grupa;
    }


    public int compareTo(Osoba o) {
        if (o instanceof Student){
            Student s = (Student) o;
            return super.compareTo(s)==0 ? this.grupa - s.getGrupa() : super.compareTo(s);
        }else {
            return super.compareTo(o);
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                ", grupa=" + grupa +
                '}';
    }
}



