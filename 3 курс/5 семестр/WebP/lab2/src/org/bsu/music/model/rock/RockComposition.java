package org.bsu.music.model.rock;

import org.bsu.music.model.AbstractComposition;
import org.bsu.music.model.Quality;

public class RockComposition extends AbstractComposition {

    private RockType rockType;

    public RockComposition(String name, String singer, int duration, Quality quality, int bpm, RockType rockType) {
        super(name, singer,duration, quality, bpm);
       this.rockType = rockType;
    }


    RockComposition(RockComposition rock){
        super(rock);
        this.rockType = rock.rockType;
    }

    @Override
    public Object clone() {
        return new RockComposition(this);
    }

    @Override
    public String getInfo(){
        return "Title: " + this.getName() + "; Singer: " + this.getSinger() + "; Duration:" + this.getDuration() +
                "; Quality: " + this.getQuality() + "; BPM:  " + this.getBpm() + "; RockType: " + this.getRockType();
    }

    public RockType getRockType() {
        return rockType;
    }

    public void setRockType(RockType rockType) {
        this.rockType = rockType;
    }
}
