package brickBreaker;

import ricochet.CollisionHandler;
import ricochet.Node;
import ricochet.Surface;
import ricochet.Updatable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SlidePanel extends JComponent {
    List<Node> nodes = new ArrayList<>();
    List<Updatable> updates = new ArrayList<>();
    List<Surface> surfaces = new ArrayList<>();
    List<Box> boxes = new ArrayList<>();
    CollisionHandler handler = new CollisionHandler(nodes, surfaces);

    public void add(Surface surface){
        surfaces.add(surface);
        if (surface instanceof Updatable)
            updates.add((Updatable) surface);
    }

    public void add(Box box){
        boxes.add(box);
        for (Surface side:box.getSides())
            add(side);
        box.register((node) -> {
            if (--box.hits == 0) {
                boxes.remove(box);
                for (Surface side : box.getSides())
                    surfaces.remove(side);
            }
        });
    }

    public void addAll(List<Surface> surfaceList){
        surfaces.addAll(surfaceList);
    }

    public void add(Node node){
        nodes.add(node);
    }

    public void update(){
        for (Updatable tick:updates)
            tick.update();

        boolean remove = false;
        handler.runCollisions();
        for (Node node:nodes) {
            node.update();
            if (node.position.y > 600)
                remove = true;
        }
        repaint();
        if (remove)
            for (Node node:nodes) {
                if (node.position.y > 600)
                    nodes.remove(node);
                return;
            }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Node node:nodes)
            node.draw(g);
        for (Surface surface:surfaces)
            surface.draw(g);
        for (Box box:boxes)
            box.draw(g);
    }
}
