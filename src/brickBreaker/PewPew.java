package brickBreaker;

import ricochet.Node;
import ricochet.Vector2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PewPew extends MouseAdapter {
    Vector2 location = new Vector2(200, 350);
    SlidePanel panel;

    public PewPew(SlidePanel panel){
        this.panel = panel;
    }

    public void setLocation(Vector2 location){
        this.location = location;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Node node = new Node(new Vector2(location.x,location.y));
        Vector2 direction = new Vector2(location.x - e.getX(), location.y - e.getY());
        node.velocity = direction.normalize().scale(-3);
        panel.add(node);
    }
}
