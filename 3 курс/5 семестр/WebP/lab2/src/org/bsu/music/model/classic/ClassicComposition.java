package org.bsu.music.model.classic;

import org.bsu.music.model.AbstractComposition;
import org.bsu.music.model.Quality;

public class ClassicComposition extends AbstractComposition {

    private int instrumentsCount;

    private ClassicGenre classicGenre;

    public ClassicComposition(String name, String singer, int duration, Quality quality, int bpm, int instrumentsCount, ClassicGenre classicGenre) {
        super(name, singer,duration, quality, bpm);
        this.instrumentsCount = instrumentsCount;
        this.classicGenre = classicGenre;
    }

    public ClassicComposition(ClassicComposition classic){
        super(classic);
        this.instrumentsCount = classic.instrumentsCount;
        this.classicGenre = classic.classicGenre;
    }

    @Override
    public Object clone() {
        return new ClassicComposition(this);
    }

    @Override
    public String getInfo(){
        return "Title: " + this.getName() + "; Singer: " + this.getSinger() + "; Duration:" + this.getDuration() +
                "; Quality: " + this.getQuality() + "; BPM:  " + this.getBpm() +
                "; Count of Instruments: " + this.getInstrumentsCount() + "; Genre: " + this.getClassicGenre();
    }

    public int getInstrumentsCount() {
        return instrumentsCount;
    }

    public void setInstrumentsCount(int instrumentsCount) {
        this.instrumentsCount = instrumentsCount;
    }

    public ClassicGenre getClassicGenre() {
        return classicGenre;
    }

    public void setClassicGenre(ClassicGenre classicGenre) {
        this.classicGenre = classicGenre;
    }
}
