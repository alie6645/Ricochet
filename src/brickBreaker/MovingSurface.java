package brickBreaker;

import ricochet.Surface;
import ricochet.Updatable;
import ricochet.Vector2;

public class MovingSurface extends Surface implements Updatable {
    Vector2 velocity = new Vector2(0, 0);
    public MovingSurface(Vector2 p1, Vector2 p2) {
        super(p1, p2);
    }

    public MovingSurface(Surface surface){
        super(surface.p1, surface.p2);
    }

    @Override
    public void update() {
        p1 = p1.add(velocity);
        p2 = p2.add(velocity);
    }
}
