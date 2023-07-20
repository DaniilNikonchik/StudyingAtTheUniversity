package org.bsu.music.model;

public abstract class AbstractComposition {

    private int duration;

    private Quality quality;

    private int bpm;

    private String singer;

    private String name;

    public AbstractComposition(String name, String singer, int duration, Quality quality, int bpm){
        this.duration = duration;
        this.quality = quality;
        this.bpm =  bpm;
        this.name = name;
        this.singer = singer;
    }

    public AbstractComposition(AbstractComposition composition){
        this.duration = composition.duration;
        this.quality = composition.quality;
        this.bpm = composition.bpm;
        this.name = composition.name;
        this.singer = composition.singer;
    }

    abstract public Object clone();

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract String getInfo();
}
