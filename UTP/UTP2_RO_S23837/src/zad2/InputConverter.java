package zad2;

import java.util.function.Function;

public class InputConverter<T> {
    private T o;

    public InputConverter(T o){
        this.o = o;

    }

    public <K> K  convertBy(Function... functions){
        Object in = o;
        Object out = null;

        for (Function f :
                functions) {
            out = f.apply(in);
            in=out;
        }

        return (K) out;
    }
}
