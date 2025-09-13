package brickBreaker;

import ricochet.CurveBuilder;
import ricochet.Surface;
import ricochet.Vector2;

import javax.swing.*;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        SlidePanel panel = new SlidePanel();
        frame.addMouseListener(new PewPew(panel));
        panel.add(surface(50,50, 50, 400));
        panel.add(surface(350, 50, 350, 400));
        panel.add(surface(50, 50, 350, 50));
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 3; j++)
                panel.add(box(50 * i + 80, 100 + j * 60, 40));

        List<Surface> curve = CurveBuilder.buildSurface(new Vector2(160, 360), new Vector2(240, 360), 1);
        MovingSurface[] platform = new MovingSurface[curve.size()];
        for (int i = 0; i < curve.size(); i++) {
            MovingSurface mover = new MovingSurface(curve.get(i));
            platform[i] = mover;
            panel.add(mover);
        }
        frame.addKeyListener(new MoveKeys(platform));
        frame.add(panel);
        frame.setVisible(true);

        Timer timer = new Timer(10, (e) -> panel.update());
        timer.start();
    }

    public static Surface surface(double x1, double y1, double x2, double y2){
        return new Surface(new Vector2(x1, y1), new Vector2(x2, y2));
    }

    public static Box box(double x, double y, double length){
        return new Box(new Vector2(x, y), length);
    }
}
