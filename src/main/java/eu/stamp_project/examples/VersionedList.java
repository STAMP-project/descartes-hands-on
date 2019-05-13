package eu.stamp_project.examples;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class VersionedList<T> {

    private static int DEFAULT_CAPACITY = 10;

    private int version = 0;

    private T[] elements;

    private int size = 0;

    public VersionedList(T... elements) {
        this.elements = Arrays.copyOf(elements, Math.max(elements.length, DEFAULT_CAPACITY));
        size = elements.length;
    }

    public T get(int index) { 
        checkBounds(index);
        return elements[index];
     }

    public void set(int index, T element) {
        checkBounds(index);
        elements[index] = element;
        increaseVersion();
    }

    public void add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        increaseVersion();
    }

    public boolean contains(T element) { 
        return indexOf(element) >= 0;
    }

    public int indexOf(T element) {
        for(int index = 0; index < size; index++) {
            if(elements[index].equals(element)) {
                return index;
            }
        }
        return -1;

    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void remove(T element) {
        while(contains(element)) {
            removeFirst(element);
        }
    }

    public void removeFirst(T element) {
        int index = indexOf(element);
        if(index < 0) {
            return;
        }
        for(;index < size - 1; index++) {
            elements[index] = elements[index + 1];
        }

        size--;
        increaseVersion();
    }

    private void checkBounds(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int required) {
        if(elements.length < required) {
            elements =  Arrays.copyOf(elements, required + DEFAULT_CAPACITY);
        }
    }

    private void increaseVersion() {
        version++;
    }
}

