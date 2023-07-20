package org.bsu.music.model.disk;
import org.bsu.music.model.AbstractComposition;
import org.bsu.music.service.DiskByDurationComparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;


public class Disk implements Iterable<AbstractComposition> {

    private List<AbstractComposition> playlist;


    public Disk(List<AbstractComposition> playlist) {
        this.playlist = playlist;
    }

    public List<AbstractComposition> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<AbstractComposition> playlist) {
        this.playlist = playlist;
    }

    public void addComposition(AbstractComposition composition) {
        playlist.add(composition);
    }

    public int countDiskDuration() {
        int diskDuration = 0;
        for (int i = 0; i < this.getPlaylist().size(); i++) {
            diskDuration += this.getPlaylist().get(i).getDuration();
        }
        return diskDuration;
    }

    public List<AbstractComposition> compositionsByDuration(int duration1, int duration2) {
        List<AbstractComposition> compositionsByDuration = new ArrayList<>();

        for (int i = 0; i < this.getPlaylist().size(); i++) {
            if (this.getPlaylist().get(i).getDuration() > duration1 &&
                    this.getPlaylist().get(i).getDuration() < duration2) {
                compositionsByDuration.add(this.getPlaylist().get(i));
            }
        }
        return compositionsByDuration;
    }

    public void sort() {
        this.playlist.sort(new DiskByDurationComparator());
    }

    @Override
    public Iterator<AbstractComposition> iterator() {
        return playlist.iterator();
    }

    @Override
    public void forEach(Consumer<? super AbstractComposition> action) {
        playlist.forEach(action);
    }
}
