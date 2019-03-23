import java.util.ArrayList;
import java.util.List;

public class BulletPool {
    private List<Bullet> bullets = new ArrayList<>();
    private static BulletPool instance;
    private BulletPool () {
        for (int i = 0 ; i < 100 ; i ++) {

            bullets.add(new Bullet(0,0,0,0));
        }
    }

    public static BulletPool getInstance() {
        if (instance == null) {
            instance = new BulletPool();
        }
        return instance;
    }

    public Bullet getBullets(int x, int y, int dx, int dy) {
        if (bullets.isEmpty()) {
            for (int i = 0 ; i < 50 ; i ++) {
                bullets.add(new Bullet(0,0,0,0));
            }
        }
        bullets.get(0).setX(x);
        bullets.get(0).setY(y);
        bullets.get(0).setDx(dx);
        bullets.get(0).setDy(dy);
        Bullet temp = bullets.get(0);
        bullets.remove(0);
        return temp;

    }

    public void releaseBullet (Bullet bullet) {
        bullets.add(bullet);
    }

}
