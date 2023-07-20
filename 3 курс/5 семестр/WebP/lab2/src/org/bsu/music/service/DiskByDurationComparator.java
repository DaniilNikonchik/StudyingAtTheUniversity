package org.bsu.music.service;

import org.bsu.music.model.AbstractComposition;

import java.util.Comparator;

public class DiskByDurationComparator  implements Comparator<AbstractComposition> {

    @Override
    public int compare(AbstractComposition o1, AbstractComposition o2) {
        return Integer.compare(o1.getDuration(), o2.getDuration());
    }
}
