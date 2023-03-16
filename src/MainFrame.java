import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Panel panel = new Panel();
        Map map = new Map();
        panel.add(map.getWalls());
        panel.add(map.getProjectiles());
        RicochetHandler handler = new RicochetHandler();
        handler.walls = map.walls;
        handler.projectiles = map.projectiles;
        map.projectiles.add(new Projectile(100,100,2,-3,1000));
        map.projectiles.add(new Projectile(100,100,-4,2,1000));

        frame.add(panel);
        frame.addMouseListener(new Cursor());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));
        frame.setVisible(true);




        Timer timer = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.checkCollisions();
                panel.update();
            }
        });

        timer.start();
    }
}
