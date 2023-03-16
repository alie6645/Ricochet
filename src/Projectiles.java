import Interfaces.Drawable;
import Interfaces.Updatable;

import java.awt.*;
import java.util.ArrayList;

public class Projectiles implements Drawable, Updatable {
    private ArrayList<Projectile> projectiles = new ArrayList<>();

    public void add(Projectile projectile){
        projectiles.add(projectile);
    }

    public Projectile get(int index){
        return projectiles.get(index);
    }

    public int getSize(){
        return projectiles.size();
    }

    @Override
    public void draw(Graphics2D g2) {
        for (Projectile proj:projectiles){
            proj.draw(g2);
        }
    }

    @Override
    public void update() {
        for (Projectile proj:projectiles){
            //proj.setVector(proj.getxChange()- proj.getxChange()*0.005, proj.getyChange()- proj.getyChange()*0.005);
            proj.update();
        }
    }
}
