package org.bsu.music.service;
import org.bsu.music.model.AbstractComposition;
import org.bsu.music.model.Quality;
import org.bsu.music.model.classic.ClassicComposition;
import org.bsu.music.model.classic.ClassicGenre;
import org.bsu.music.model.disk.Disk;
import org.bsu.music.model.hipHop.HipHopComposition;
import org.bsu.music.model.rock.RockComposition;
import org.bsu.music.model.rock.RockType;

import java.util.ArrayList;
import java.util.List;

public class DiskFactory {

    public Disk getDiskWithPlaylist() {
        List<AbstractComposition> playlist = new ArrayList<>();
        Disk disk = new Disk(playlist);

        disk.addComposition(
                new ClassicComposition("Sonata N16", "Del Pierro", 189, Quality.HIGH,
                   80, 20, ClassicGenre.OPERA )
        );
        disk.addComposition(
                new HipHopComposition("House", "Flo Rida", 134, Quality.MEDIUM,
                        90, true, 17)
        );
        disk.addComposition(
                new RockComposition("Strange","Mrixon", 208, Quality.HIGH, 120, RockType.HARD)
        );
        return disk;
    }

    public void printDisk(Disk disk) {
        int i = 1;
        for (var composition : disk) {
            System.out.println("-" + i +"." + composition.getInfo());
            i++;
        }
        System.out.println();
    }


}
