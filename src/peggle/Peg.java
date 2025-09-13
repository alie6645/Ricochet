package peggle;

import ricochet.CollisionListener;
import ricochet.DetectorSurface;
import ricochet.Surface;
import ricochet.Updatable;

import java.awt.*;

public abstract class Peg implements Updatable {
    private DetectorSurface[] sides;
    private int timer = 50;
    private boolean hit;

    public void setHit(boolean hit){
        this.hit = hit;
    }

    public DetectorSurface[] getSides(){
        return sides;
    }

    public void setSides(DetectorSurface[] sides){
        this.sides = sides;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean isRemovable(){
        return (hit && timer<0);
    }

    public void update(){
        if (hit)
            --timer;

    }

    public void addCollisionListener(CollisionListener collisionListener){
        for (DetectorSurface side:sides)
            side.register(collisionListener);
    }

    public abstract void draw(Graphics g);
}
