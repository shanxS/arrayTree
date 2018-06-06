package com.simpleharmonic.arraytree.common;

import lombok.Getter;
import lombok.Setter;

public class Node  <T extends Comparable> {
    @Getter private final T element;
    @Setter @Getter private Integer firstValidIndex = null, lastValidIndex = null;
    @Setter @Getter private Node next, previous;
    @Getter private final Location thisLocation;


    public Node(T element, Location thisLocation) {
        this.element = element;
        this.thisLocation = thisLocation;
    }
}
