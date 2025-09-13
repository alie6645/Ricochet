package brickBreaker;

import ricochet.Vector2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MoveKeys extends KeyAdapter {
    MovingSurface[] mover;
    private final int SPEED = 4;

    public MoveKeys(MovingSurface[] mover){
        this.mover = mover;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key==37)
            for (MovingSurface surface:mover)
                surface.velocity = new Vector2(-SPEED,0);
        if (key==39)
            for (MovingSurface surface:mover)
                surface.velocity = new Vector2(SPEED,0);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key==37)
            if (mover[0].velocity.x < 0)
                for (MovingSurface surface:mover)
                    surface.velocity = new Vector2(0,0);
        if (key==39)
            if (mover[0].velocity.x > 0)
                for (MovingSurface surface:mover)
                    surface.velocity = new Vector2(0,0);
    }
}
