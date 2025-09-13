package platform;

import ricochet.Surface;
import ricochet.Vector2;

import javax.swing.*;

public class PlatformLauncher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

        PlatformPanel panel = new PlatformPanel();
        frame.add(panel);

        frame.addKeyListener(new PlatformerKeyListener(panel.getPlayer()));

        Surface floor = new Surface(new Vector2(0,200), new Vector2(400, 200));
        floor.bounce = 1;
        panel.add(floor);

        Timer timer = new Timer(10, (e) -> panel.update());
        timer.start();
    }
}
