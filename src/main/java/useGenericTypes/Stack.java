package useGenericTypes;

import java.util.Arrays;
import java.util.EmptyStackException;

class Stack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        //push requires elements of type E, so casting is safe here
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        elements[size] = null; //remove unused reference
        return result;
    }

    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2*size + 1);
        }
    }
}
