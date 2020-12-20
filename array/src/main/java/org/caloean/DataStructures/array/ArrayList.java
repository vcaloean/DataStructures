package org.caloean.DataStructures.array;

import java.util.Arrays;

/**
 * An attempt to recreate {@link java.util.ArrayList}.
 *
 * @param <T> The subtype of the list
 */
public class ArrayList<T> {
    Object[] list;
    private int currentSize;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int size) {
        if (size <= 0) {
            throw new NegativeArraySizeException("Size must be greater than 0, but was: " + size);
        }

        list = new Object[size];
        currentSize = 0;
    }

    /**
     * Allows addition of new item of type {@link T} to the end of the ArrayList.
     *
     * @param obj The new item to be added
     */
    public void add(T obj) {
        if (currentSize == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }

        list[currentSize++] = obj;
    }

    /**
     * Gets item at a certain index.
     *
     * @param index The index to return the item
     * @return The item at that index
     * @throws ArrayIndexOutOfBoundsException if index is negative or greater than the size of the list
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index > currentSize - 1) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return (T) list[index];
    }

    /**
     * Returns the current size of the list.
     *
     * @return The current size of the list
     */
    public int size() {
        return currentSize;
    }

    /**
     * Removes and returns the item at a certain index.
     *
     * @param index The index to remove the item
     * @return The item at that index
     * @throws ArrayIndexOutOfBoundsException if index is negative or greater than the size of the list
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index > currentSize - 1) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        T removedObject = (T) list[index];

        for (int i = index; i < currentSize; i++) {
            if (i == list.length - 1) {
                list[i] = null;
                break;
            }

            list[i] = list[i + 1];

            if (list[i + 1] == null) {
                break;
            }
        }

        currentSize--;

        return removedObject;
    }
}
