package com.simpleharmonic.arraytree.common;

import com.simpleharmonic.arraytree.common.utils.FindUtil;

import java.util.ArrayList;

public class ArrayTree <T extends Comparable> implements com.simpleharmonic.arraytree.List<T> {
    private final int DEFAULT_SIZE = 10;
    private ArrayList<Node<T>[]> arrayList;
    private FindUtil<T> findUtil;

    public ArrayTree() {
        findUtil = new FindUtil<>();
        arrayList = new ArrayList<>();
        arrayList.add(new Node[DEFAULT_SIZE]);
        arrayList.get(0)[0] = new Node<>(new Location(0, 0));
    }

    @Override
    public void add(T element) {
        Location predecessorLoc = findUtil.findPredecessor(element, arrayList);
        insertAfter(predecessorLoc, element);
    }

    private void insertAfter(Location predecessorLoc, T element) {
        if (predecessorLoc == null) {

        }
    }

    @Override
    public void remove(T element) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean find(T element) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void print() {
        Node[] parentList = arrayList.get(0);
        for (int i=0; i<parentList.length; ++i) {
            Node node = parentList[i];
            if (node != null) {
                printNode(node);
            }
        }
    }

    private void printNode(Node node) {
        System.out.println(node.getElement() + " ");
        if (node.getNext() != null) {
            printNode(node.getNext());
        }
    }
}
