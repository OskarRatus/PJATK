package w2;

public class LAB02_02 {
    public static void main(String[] args) {
        // B
        Figura p2 = new Prostokat2(20, 20, 10, 5, '*');       // prostokąt rozmiaru 10 x 5 będzie "rysowany" na konsoli za pomocą znaku '*'
        ((Prostokat2)p2).rysuj();                                               // Wyjaśnić dlaczego p2.rysuj() nie działa?

        // C
        Kolo2 k2 = new Kolo2(15, 20, 5);

        k2.przesunDo(50, 40);       // przesunięcie środka koła do punktu (50, 40)
        System.out.println(k2);

        k2.powrot();                     // powrót do poprzedniej pozycji (bezpośrednio przed przesunięciem) środka koła
        System.out.println(k2);
    }
}


interface Transformacja{
    public void przesunDo(int x, int y);
    public void powrot();
}


interface Rysowanie{
    public void rysuj();
}


class Kolo2 extends Kolo implements Transformacja{

    int tmpX;
    int tmpY;

    public Kolo2(int x, int y, int r) {
        super(x, y, r);
    }

    @Override
    public void przesunDo(int x, int y) {
        tmpX = this.x;
        tmpY = this.y;
        this.x = x;
        this.y = y;
    }

    @Override
    public void powrot() {
        this.x = tmpX;
        this.y = tmpY;

    }
}


class Prostokat2 extends Prostokat implements Rysowanie{

    char c;

    public Prostokat2(int x, int y, int width, int height, char c) {
        super(x, y, width, height);
        this.c = c;
    }

    @Override
    public void rysuj() {
        for (int i = 0; i < height; i++){
            for (int j=0; j < width; j++){
                System.out.print(c);
            }
            System.out.println();
        }

    }
}
