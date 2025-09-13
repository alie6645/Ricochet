package peggle;

import brickBreaker.SlidePanel;
import ricochet.Vector2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PeggleMouse extends MouseAdapter {
    private PegglePanel panel;

    public PeggleMouse(PegglePanel panel){
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        panel.click();
    }
}
