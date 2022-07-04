/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad1;


public interface Mapper<T, K> { // Uwaga: interfejs musi być sparametrtyzowany
    K map(T t);
}  
