/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCreator<T> { // Uwaga: klasa musi być sparametrtyzowana

    private ArrayList<T> list;

    private ListCreator(ArrayList<T> list1){
        this.list = list1;
    }

    public static <T> ListCreator<T> collectFrom(List<T> list2) {
        return new ListCreator<>(new ArrayList<>(list2));
    }

    public ListCreator<T> when(Selector<T> selector){
        Iterator<T> iterator = list.iterator();

        while (iterator.hasNext()){
            if(!selector.select(iterator.next()))
                iterator.remove();
        }

        return this;
    }

    public <K> List<K> mapEvery(Mapper<T, K> mapper){
        List<K> mapped = new ArrayList<>();
        for (T t : list){
            mapped.add(mapper.map(t));
        }
        return mapped;
    }

}
