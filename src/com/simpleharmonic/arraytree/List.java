package com.simpleharmonic.arraytree;

public interface List<T> {
    void add(T element);
    void remove(T element);
    void remove(int index);
    boolean find(T element);
    T get(int index);
    void print();
}
