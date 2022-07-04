package zad4;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XList<T> extends ArrayList<T> {

    public XList(T ... args) {
        for (T t : args) {
            this.add(t);
        }
    }

    public XList(Collection<T> collection) {
        this.addAll(collection);
    }

    public static <T> XList<T> of(T ... args){
        XList<T> nXList = new XList<>(args);
        return nXList;
    }

    public static <T> XList<T> of(Collection<T> collection) {
        XList<T> nXList = new XList<T>(collection);
        return nXList;
    }

    public static XList<String> charsOf(String string) {
        XList<String> stringXList = new XList<String>(string.split(""));
        return stringXList;
    }

    public static XList<String> tokensOf(String string) {
        return new XList<String>(string.split(" "));
    }

    public static XList<String> tokensOf(String string, String regex){
        return new XList<String>(string.split(regex));
    }

    public XList<T> union(XList<T> list) {
        this.addAll(list);
        return new XList<T>(this);
    }

    public XList<T> union(T ... args){
        XList<T> nXList = new XList<T>(this);
        return nXList.union(new XList<T>(args));
    }

    public XList<T> union(Collection<T> collection){
        return new XList<T>(this).union(new XList<T>(collection));
    }

    public XList<T> diff(Collection<T> collection) {
        XList<T> nXList = new XList<T>(this);
        for (T t : this) {
            if (collection.stream().anyMatch(o -> o==t))
                nXList.remove(t);
        }
        return nXList;
    }

    public XList<T> unique() {
        List<T> list = this.stream().distinct().collect(Collectors.toList());
        return new XList<T>(list);
    }


    public XList<XList<T>> combine() {
        List<T> o0 = (List<T>) this.get(0);
        List<T> o1 = (List<T>) this.get(1);
        List<T> o2 = (List<T>) this.get(2);

        XList<XList<T>> nXList = new XList<XList<T>>();

        for (T t0 : o0) {
            for (T t1: o1) {
                for (T t2 : o2) {
                    nXList.add(new XList<T>(t0, t1, t2));
                }
            }
        }

        return nXList;
    }

    public <U> XList<U> collect(Function<T, U> function) {
        XList<U> nXList = new XList<U>();
        for (T t : this) {
            nXList.add(function.apply(t));
        }
        
        return nXList;
    }

    public String join() {
        return this.stream().map(Object::toString).collect(Collectors.joining());
    }

    public String join(String sep) {
        return this.stream().map(Object::toString).collect(Collectors.joining(sep));
    }

    public void forEachWithIndex(BiConsumer<T, Integer> consumer){
        for (int i = 0; i < this.size(); i++) {
            consumer.accept(this.get(i), i);
        }

    }
}
