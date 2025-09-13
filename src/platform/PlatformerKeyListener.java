package platform;

import ricochet.Node;
import ricochet.Vector2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlatformerKeyListener extends KeyAdapter {
    Node player;
    double SPEED = 2;
    double JUMP_POWER = 4;
    public PlatformerKeyListener(Node player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'w':
                player.velocity = new Vector2(player.velocity.x, -JUMP_POWER);
                break;
            case 'a':
                player.velocity = new Vector2(-SPEED, player.velocity.y);
                break;
            case 'd':
                player.velocity = new Vector2(SPEED, player.velocity.y);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'a':
                if (player.velocity.x < 0)
                    player.velocity = new Vector2(0, player.velocity.y);
                break;
            case 'd':
                if (player.velocity.x > 0)
                    player.velocity = new Vector2(0, player.velocity.y);
        }
    }
}
