package com.simpleharmonic.arraytree.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
class Location {
    @Getter
    private final int arrayIndex, index;
}
