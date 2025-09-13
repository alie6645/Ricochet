package peggle;

import ricochet.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PegglePanel extends JComponent {
    List<Node> nodes = new ArrayList<>();
    List<Updatable> updates = new ArrayList<>();
    List<Surface> surfaces = new ArrayList<>();
    List<Peg> pegs = new ArrayList<>();
    CollisionHandler handler = new CollisionHandler(nodes, surfaces);

    public void add(Surface surface){
        surfaces.add(surface);
        if (surface instanceof Updatable)
            updates.add((Updatable) surface);
    }

    public void addPeg(Peg peg){
        pegs.add(peg);
        updates.add(peg);
        for (Surface side : peg.getSides())
            add(side);
        peg.addCollisionListener((node -> peg.setHit(true)));
    }

    public void add(Node node){
        nodes.add(node);
    }

    public void update(){
        for (Updatable tick:updates)
            tick.update();
        boolean remove = false;
        for (Peg peg:pegs)
            if (peg.isRemovable())
                for (Surface side:peg.getSides()) {
                    surfaces.remove(side);
                    remove = true;
                }
        handler.runCollisions();
        for (Node node:nodes) {
            node.update();
            node.velocity = node.velocity.add(new Vector2(0, 0.1));
            if (node.position.y > 600)
                remove = true;
        }
        repaint();
        if (remove) {
            for (Node node : nodes) {
                if (node.position.y > 600) {
                    nodes.remove(node);
                    return;
                }
            }
            for (Peg peg : pegs) {
                if (peg.isRemovable()){
                    pegs.remove(peg);
                    return;
                }
            }
        }
    }

    public void click(){
        Node node = new Node(new Vector2(200,10));
        node.velocity = new Vector2(getMousePosition().x - 200, getMousePosition().y - 10).normalize().scale(5);
        add(node);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Node node:nodes)
            node.draw(g);
        for (Surface surface:surfaces)
            surface.draw(g);
        for (Peg peg:pegs)
            peg.draw(g);
    }
}
