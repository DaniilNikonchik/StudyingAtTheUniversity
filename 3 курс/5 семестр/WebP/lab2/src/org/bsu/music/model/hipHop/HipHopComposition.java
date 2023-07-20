package org.bsu.music.model.hipHop;

import org.bsu.music.model.AbstractComposition;
import org.bsu.music.model.Quality;

public class HipHopComposition extends AbstractComposition {

    private boolean freestyle;

    private HipHopStyle hipHopStyle;

    private int panchesCount;

    public HipHopComposition(String name, String singer, int duration, Quality quality, int bpm, boolean freestyle, int numberPanches) {
        super(name, singer, duration, quality, bpm);
        this.freestyle = freestyle;
        this.panchesCount = numberPanches;
    }

    HipHopComposition(HipHopComposition hipHop){
        super(hipHop);
        this.freestyle = hipHop.freestyle;
        this.panchesCount = hipHop.panchesCount;
    }

    @Override
    public Object clone() {
        return new HipHopComposition(this);
    }

    @Override
    public String getInfo(){
        return "Title: " + this.getName() + "; Singer: " + this.getSinger() + "; Duration:" + this.getDuration() +
                "; Quality: " + this.getQuality() + "; BPM:  " + this.getBpm() + "; Freestyle: " + this.isFreestyle() +
                "; Count of Panches: " + this.getPanchesCount();
    }

    public boolean isFreestyle() {
        return freestyle;
    }

    public void setFreestyle(boolean freestyle) {
        this.freestyle = freestyle;
    }

    public int getPanchesCount() {
        return panchesCount;
    }

    public void setPanchesCount(int panchesCount) {
        this.panchesCount = panchesCount;
    }

    public HipHopStyle getHipHopStyle() {
        return hipHopStyle;
    }

    public void setHipHopStyle(HipHopStyle hipHopStyle) {
        this.hipHopStyle = hipHopStyle;
    }

}
