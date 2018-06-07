package com.simpleharmonic.arraytree.common.utils;

import com.simpleharmonic.arraytree.common.Location;
import com.simpleharmonic.arraytree.common.Node;

import java.util.ArrayList;

public class FindUtil<T extends Comparable> {
    public Location find(T element, ArrayList<Node<T>[]> arrayList) {

        Integer arrayIndex = findPossibleArray(element, arrayList, 0);
        if (arrayIndex == null) {
            return null;
        }

        return findInArray(element, arrayList.get(arrayIndex));
    }
    
    public Location findPredecessor(T element, ArrayList<Node<T>[]> arrayList) {
        Integer arrayIndex = findPossibleArray(element, arrayList, 0);
        if (arrayIndex == null) {
            return null;
        }
        
        return findPredecessorInArray(element, arrayList.get(arrayIndex));
    }

    private Location findPredecessorInArray(T element, Node<T>[] array) {
        Node first = getFirstValidNode(array);
        Node last = getLastValidNode(array);

        int start = first.getThisLocation().getIndex(), end = last.getThisLocation().getIndex();
        return findPredecessorInRange(element, array, start, end);
    }

    private Location findPredecessorInRange(T element, Node<T>[] array, int start, int end) {
        Location predecessorLoc = null;
        int mid = (start + end)/2;
        while (start <= end) {
            Node thisNode = array[mid];
            if (thisNode == null) {
                Location leftFindResult = findInRange(element, array, start, mid-1);
                if (leftFindResult == null) {
                    return findInRange(element, array, mid+1, end);
                } else {
                    return leftFindResult;
                }
            }

            int compareResult = thisNode.getElement().compareTo(element);
            if (compareResult == 0) {
                throw new RuntimeException("Element already exist");
            } else if (compareResult < 0) {
                predecessorLoc = thisNode.getThisLocation();
                start = mid+1;
            } else {
                end = mid-1;
            }

            mid = (start + end)/2;
        }
        
        if(predecessorLoc == null) {
            throw new RuntimeException("We should have found a predecessor if we are in this function");
        }
        
        return predecessorLoc;
    }

    private Location findInArray(T element, Node<T>[] array) {
        Node first = getFirstValidNode(array);
        Node last = getLastValidNode(array);

        int start = first.getThisLocation().getIndex(), end = last.getThisLocation().getIndex();
        return findInRange(element, array, start, end);
    }

    private Location findInRange(T element, Node<T>[] array, int start, int end) {
        Location location = null;
        int mid = (start + end)/2;
        while (start <= end) {
            Node thisNode = array[mid];
            if (thisNode == null) {
                Location leftFindResult = findInRange(element, array, start, mid-1);
                if (leftFindResult == null) {
                    return findInRange(element, array, mid+1, end);
                } else {
                    return leftFindResult;
                }
            }

            int compareResult = thisNode.getElement().compareTo(element);
            if (compareResult == 0) {
                return thisNode.getThisLocation();
            } else if (compareResult < 0) {
                start = mid+1;
            } else {
                end = mid-1;
            }

            mid = (start + end)/2;
        }

        return location;
    }

    private Integer findPossibleArray(T element, ArrayList<Node<T>[]> arrayList, int arrayIndex) {
        Node first = getFirstValidNode(arrayList.get(arrayIndex));
        Node last = getLastValidNode(arrayList.get(arrayIndex));

        if (element.compareTo(first.getElement()) == 0) {
            return arrayIndex;
        } else if (element.compareTo(last.getElement()) == 0) {
            return arrayIndex;
        } else if (element.compareTo(first.getElement()) > 0
                && element.compareTo(last.getElement()) < 0 ) {
            return arrayIndex;
        } else if (element.compareTo(first.getElement()) < 0
                   && element.compareTo(last.getElement()) < 0 ) {
            if (last.getNext() != null) {
                int nextArrayIndex = last.getNext().getThisLocation().getArrayIndex();
                return findPossibleArray(element, arrayList, nextArrayIndex);
            }
        } else if (element.compareTo(first.getElement()) > 0
                   && element.compareTo(last.getElement()) > 0 ) {
            if (last.getPrevious() != null) {
                int nextArrayIndex = last.getPrevious().getThisLocation().getArrayIndex();
                return findPossibleArray(element, arrayList, nextArrayIndex);
            }
        }

        return null;
    }

    private Node getLastValidNode(Node[] array) {
        return array[array[0].getLastValidIndex()];
    }

    private Node getFirstValidNode(Node[] array) {
        return array[array[0].getFirstValidIndex()];
    }
}
