package org.bsu.music;

import org.bsu.music.model.disk.Disk;
import org.bsu.music.service.DiskFactory;

public class Main {

    public static void main(String[] args) {
        DiskFactory o = new DiskFactory();
        Disk disk = o.getDiskWithPlaylist();

        System.out.println("---------------  Disk before sorting  ----------------------");
        o.printDisk(disk);

        disk.sort();

        System.out.println("---------------  Disk after sorting by duration  ----------------------");
        o.printDisk(disk);

        System.out.println();
        System.out.println("Total duration of the disk : " +  disk.countDiskDuration() + "sec" );
        System.out.println();


        System.out.println("---------------  Compositions by duration boundaries   ----------------------");
        for(int i = 0; i < disk.compositionsByDuration(120,169).size(); i++){
            System.out.println(disk.compositionsByDuration(120,169).get(i).getInfo());
        }
    }
}
