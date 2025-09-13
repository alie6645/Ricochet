package peggle;

import ricochet.CurveBuilder;
import ricochet.Surface;
import ricochet.Vector2;

import javax.swing.*;

public class PeggleLauncher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        PegglePanel panel = new PegglePanel();
        frame.addMouseListener(new PeggleMouse(panel));

        panel.addPeg(createRect(50,100, 10, 0, 0, 10));
        for (int i = 0; i < 10; i++)
            panel.addPeg(createRect(200 + 5*i,100+20*i,5,20,10,-5));

        for (Surface segment :CurveBuilder.buildSurface(new Vector2(100,100), new Vector2(200, 200), -10, 3)){
            panel.addPeg(new RectanglePeg(segment.p1, segment.direction(), segment.normal().normalize().scale(5)));
        }

        frame.add(panel);
        frame.setVisible(true);


        Timer timer = new Timer(10, (e) -> panel.update());
        timer.start();
    }

    private static RectanglePeg createRect(double x, double y, double u1, double v1, double u2, double v2){
        return new RectanglePeg(new Vector2(x, y), new Vector2(u1, v1), new Vector2(u2, v2));
    }
}
