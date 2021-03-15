package week6;

public class PPJ35_c61 {
    public static void main(String[] args){
        // Zadanie 1
        {
            Cookie c1 = new Cookie("malinowe", 2.12, 2345);
            System.out.println(c1.toString());
        }

        // Zadanie 2
        {
            Point2D point1 = new Point2D(2,3);
            Point2D point2 = new Point2D(4,6);
            System.out.println(point1.distance(point2));

            Point3D point3 = new Point3D(0,0,0);
            Point3D point4 = new Point3D(1,1,1);
            System.out.println(point3.distance(point4));
        }

        // Zadanie 3
        {
            Telephone tPhone = new Telephone("Test", "blue");
            tPhone.call("123");
        }

        // Zadanie 4
        {
            CellPhone cPhone = new CellPhone("test", "red");
            cPhone.call("11111");
        }

        // Zadanie 5
        {
            Person[] arr = {
                    new Person("Adam", "Smith", "333 333 333")
            };
            SmartPhone sPhone = new SmartPhone("LTE", "black", arr);
            sPhone.call("333 333 333");

        }

        // Zadanie 6
        {
            Person[] arr = {
                    new Person("Adam", "Smith", "333 333 333")
            };
            SmartPhone sPhone = new SmartPhone("LTE", "black", arr);
            sPhone.call("333 333 333");
            sPhone.showLastCalls();
        }

        // Zadanie 7
        {
            System.out.println("Zadanie 7");
            Telephone tPhone = new Telephone("Test", "blue");
            CellPhone cPhone = new CellPhone("test", "red");
            Person[] arr = {
                    new Person("Adam", "Smith", "333 333 333")
            };
            SmartPhone sPhone = new SmartPhone("LTE", "black", arr);
            Telephone[] tab = {tPhone, cPhone, sPhone};

            for (Telephone tel : tab){
                System.out.println(tel.toString()); // jak wywolac tutaj nazwe klasy
                for (int i =0; i<10;i++){
                    if (i%2 == 1){
                        tel.call("333 333 333");
                    } else {
                        tel.call("111 111 111");
                    }
                }
                tel.showLastCalls();
            }

        }

    }

    static class Cookie {
        private String name;
        private double mass;
        private int id;

        public Cookie(String name, double mass, int id){
            this.name = name;
            this.mass = mass;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Cookie{" +
                    "name='" + name + '\'' +
                    ", mass=" + mass +
                    ", id=" + id +
                    '}';
        }
    }


    static class Point2D {
        public int x;
        public int y;

        public Point2D(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int distance(Point2D p2){
            return (int) (Math.sqrt(Math.pow((this.x - p2.x),2) + Math.pow((this.y - p2.y),2)));
        }

    }


    static class Point3D
            extends Point2D{

        public int z;

        public Point3D(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }

        public int distance(Point3D p2){
            return (int) (Math.sqrt(Math.pow((this.x - p2.x),2) + Math.pow((this.y - p2.y),2) + Math.pow((this.z - p2.z),2)));
        }
    }


    static class Telephone {
        protected String ci;
        protected String color;

        public Telephone(String ci, String color){
            this.ci = ci;
            this.color = color;
        }

        public void call(String number){
            System.out.println("Calling: " + number);
        }

        public void showLastCalls(){
            System.out.println("No history");

        }


    }


    static class CellPhone
            extends Telephone{
        String[] tab;
        int cnt = 0;

        public CellPhone(String ci, String color) {
            super(ci, color);
            tab = new String[10];
        }

        public void call(String number){
            if (cnt > 10){
                for (int i=0; i<9;i++){
                    tab[i] = tab[i+1];
                }
                tab[10] = number;
            } else {
                tab[cnt] = number;
                cnt++;
            }

            super.call(number);
        }

        public void showLastCalls(){
            for (int i=0; i<cnt && i<10; i++){
                System.out.println(tab[i]);
            }
        }
    }


    static class SmartPhone extends CellPhone{

        protected Person[] friends;

        public SmartPhone(String ci, String color, Person[] friends) {
            super(ci, color);
            this.friends = friends;

        }

        public void showLastCalls(){
            for (int i=0; i<cnt && i<10; i++){
                boolean displayed = false;
                for (int j=0; j<friends.length; j++){
                    if (friends[j].isCaller(tab[i]) && !displayed){
                        System.out.println(friends[j]);
                        displayed = true;
                    }
                }
                if (!displayed)
                    System.out.println(tab[i]);
            }
        }

    }

    static class Person {
        protected String fName;
        protected String lName;
        protected String number;

        public Person(String fname, String lName, String number){
            this.fName = fname;
            this.lName = lName;
            this.number = number;
        }

        public boolean isCaller(String number){
            return this.number.equals(number);
        }

        public String toString(){
            return fName+" "+lName+" "+number;
        }
    }



}
