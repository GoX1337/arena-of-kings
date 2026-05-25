/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class bug<T>
implements Iterable<T>,
Iterator<T> {
    private final T[] var_T_arr_a;
    private int var_int_a;

    public bug(T[] TArray) {
        this.var_T_arr_a = TArray;
        this.var_int_a = 0;
    }

    @Override
    public boolean hasNext() {
        return this.var_int_a < this.var_T_arr_a.length;
    }

    @Override
    public T next() {
        if (this.var_int_a >= this.var_T_arr_a.length) {
            throw new NoSuchElementException();
        }
        return this.var_T_arr_a[this.var_int_a++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }
}

