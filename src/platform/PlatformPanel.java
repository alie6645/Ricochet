package platform;

import ricochet.BasicPanel;
import ricochet.Node;
import ricochet.Vector2;

public class PlatformPanel extends BasicPanel {
    Node player = new Node(new Vector2(50, 50));
    public PlatformPanel(){
        add(player);
    }

    public Node getPlayer(){
        return player;
    }

    @Override
    public void update(){
        player.velocity = player.velocity.add(new Vector2(0,0.1));
        super.update();

    }
}
