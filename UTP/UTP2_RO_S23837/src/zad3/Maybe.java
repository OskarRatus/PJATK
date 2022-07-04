package zad3;


import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {
    private T t;

    public Maybe(T t){
        this.t = t;
    }

    public static <T> Maybe<T> of(T t){
        return new Maybe(t);
    }

    public void ifPresent(Consumer consumer){
        if (this.t != null)
            consumer.accept(t);
    }

    public <F> Maybe<F> map (Function<T, F> function) {
        return this.t != null ? new Maybe<>(function.apply(this.t)) : new Maybe<>(null);
    }

    public T get(){
        if (this.t == null)
            throw new NoSuchElementException("maybe is empty");
        else
            return this.t;

    }

    public boolean isPresent(){
        return this.t != null;
    }

    public T orElse (T value) {
        return (this.t != null) ? this.t : value;
    } //TODO dlaczego tutaj nie trzeba pisać <T> a w metodzie of() trzeba?????

    public Maybe<T> filter(Predicate<T> predicate){
        if (predicate.test(this.t) || !this.isPresent())
            return this;
        else
            return new Maybe(null);
    }

    public String toString() {
        if(this.t == null)
            return "Maybe is empty";
        else
            return "Maybe has value " + this.t;
    }
}


