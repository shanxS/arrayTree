package com.simpleharmonic.arraytree.common.utils;

import com.simpleharmonic.arraytree.common.Node;

import java.util.ArrayList;

public class AddUtil <T extends Comparable> {
    public void addFirst(T element, ArrayList<Node<T>[]> arrayList) {
        Node<T>[] array = arrayList.get(0);
        if (array[0].getElement() == null) {
            array[0].setElement(element);
        } else {
            Node prevNode = array[0].getPrevious();
            while (prevNode != null) {
                prevNode = prevNode.getPrevious();
            }

            addBefore(element, prevNode, arrayList);
        }
    }

    private void addBefore(T element, Node prevNode,
                           ArrayList<Node<T>[]> arrayList) {



    }
}
