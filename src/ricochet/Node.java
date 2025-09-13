package ricochet;

import java.awt.*;

public class Node implements Updatable {
    public Vector2 velocity = new Vector2(0, 0);
    public Vector2 position;

    public Node(Vector2 position){
        this.position = position;
    }

    public void update(){
        position = position.add(velocity);
    }

    public void draw(Graphics g){
        g.drawOval((int) position.x-2, (int) position.y-2, 5, 5);
    }
}
