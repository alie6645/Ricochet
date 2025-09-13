package ricochet;

import ricochet.CollisionHandler;
import ricochet.Node;
import ricochet.Surface;
import ricochet.Updatable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasicPanel extends JComponent {
    List<Node> nodes = new ArrayList<>();
    List<Updatable> updates = new ArrayList<>();
    List<Surface> surfaces = new ArrayList<>();
    CollisionHandler handler = new CollisionHandler(nodes, surfaces);


    public void add(Node node){
        if (node != null)
            updates.add(node);
        nodes.add(node);
    }

    public void add(Surface surface){
        if (surface instanceof Updatable)
            updates.add((Updatable) surface);
        surfaces.add(surface);
    }
    public void update(){
        for (Updatable updatable:updates){
            updatable.update();
        }
        handler.runCollisions();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Node node:nodes)
            node.draw(g);
        for (Surface surface:surfaces)
            surface.draw(g);
    }
}

