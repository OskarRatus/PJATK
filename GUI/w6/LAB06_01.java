package w6;

import java.util.Iterator;

public class LAB06_01 {
}

class terst implements Iterable{

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
