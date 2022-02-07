import javax.swing.*;
import java.awt.*;

public class GameEngine extends JPanel implements Runnable {

    //region [Objects]
    public static Settings settings = new Settings();

    Thread gameThread;

    KeyHandler keyHandler = new KeyHandler();

    Player player = new Player("space marine",96,96,6,1,1,100,5, settings.getTileSize(), settings.getTileSize());

    WaveManager waveManager = new WaveManager(50,player,true,true,true,true);
    //endregion

    //region [Constructor]
    public GameEngine(){

        this.setPreferredSize(new Dimension(settings.getScreenWidth(), settings.getScreenHeight()));
        this.setBackground(settings.getBackgroundColor());
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    //endregion

    //region [Thread]
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    //endregion

    //region [Run method]
    @Override
    public void run() {

        double drawInterval = 1000000000/ settings.getFps();
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime-lastTime) / drawInterval;
            timer += (currentTime-lastTime);

            lastTime = currentTime;

            if (delta >= 1){

                // Updates all as fast as the fps allows
                Update.all(timer,keyHandler,player,waveManager.getWave());

                // Draw
                repaint();

                delta--;
                drawCount++;
            }

            if (timer >= 1000000000){

                // Updates 1 time pr sec
                Update.prSec(timer,drawCount,player);

                drawCount = 0;
                timer = 0;
            }

        }

    }
    //endregion

    //region [Paint]
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        // Draw the player
        //player.getPlayerBox(g);
        player.getPlayerSprite(g);

        // Draw the wave enemys
        for (Enemy e : waveManager.getWave()){
            //e.getEnemyBox(g);
            e.getEnemySprite(g,player);
        }

    }
    //endregion

}
