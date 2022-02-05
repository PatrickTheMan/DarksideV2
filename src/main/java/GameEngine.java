import javax.swing.*;
import java.awt.*;

public class GameEngine extends JPanel implements Runnable {

    public static Settings settings = new Settings();

    Thread gameThread;

    KeyHandler keyHandler = new KeyHandler();



    Player player = new Player(100,5, settings.getTileSize(), settings.getTileSize(), Player.characterSelection.Guy);

    WaveManager waveManager = new WaveManager(10);




    public GameEngine(){

        this.setPreferredSize(new Dimension(settings.getScreenWidth(), settings.getScreenHeight()));
        this.setBackground(settings.getBackgroundColor());
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

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
                Update.all(keyHandler,player,waveManager.getWave());

                // Draw
                repaint();

                delta--;
                drawCount++;
            }

            if (timer >= 1000000000){

                // Updates 1 time pr sec
                Update.prSec(timer,drawCount);

                drawCount = 0;
                timer = 0;
            }

        }

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        player.getPlayerBox(g);

        for (Enemy e : waveManager.getWave()){
            e.getEnemyBox(g);
        }

    }

}
