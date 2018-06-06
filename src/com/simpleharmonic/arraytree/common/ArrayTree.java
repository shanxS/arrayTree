package com.simpleharmonic.arraytree.common;

import com.simpleharmonic.arraytree.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class ArrayTree <T extends Comparable> implements List<T> {
    private final int DEFAULT_SIZE = 10;
    private ArrayList<Node<T>[]> nodeList;

    public ArrayTree() {
        nodeList = new ArrayList<>();
        nodeList.add(new Node[DEFAULT_SIZE]);
    }

    @Override
    public void add(T element) {
        Location predecessorLoc = findPredecessor(element);
        insertAfter(predecessorLoc, element);
    }

    private Location findPredecessor(T element) {
        return null;
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
        Node[] parentList = nodeList.get(0);
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
