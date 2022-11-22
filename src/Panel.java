import Interfaces.Drawable;
import Interfaces.Updatable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JComponent {
    List<Drawable> drawings = new ArrayList();
    List<Updatable> updates = new ArrayList<>();

    public void add(Drawable drawing){
        drawings.add(drawing);
        if (drawing instanceof Updatable){
            updates.add((Updatable) drawing);
        }
    }

    public void update(){
        for (Updatable comp:updates){
            comp.update();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Drawable comp:drawings){
            comp.draw(g2);
        }
    }
}
