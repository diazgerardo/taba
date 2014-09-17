package ar.com.scriptorum.actions;

import ar.com.scriptorum.beans.PUnit;

public class ByLine implements DirectionableComparator<PUnit> {

    private Boolean sentido = false;
    @Override
    public int compare(PUnit p1, PUnit p2) {
        try {
            if(sentido) {
                return p1.getnLines()-p2.getnLines();
            } else {
                return p2.getnLines()-p1.getnLines();
            }
        }catch(Exception e) {
            if(sentido)
                return -1;
            else
                return 1;
        }

    }

    @Override
    public DirectionableComparator<PUnit> direction(Boolean t) {
        this.sentido=t;
        return this;
    }

}
