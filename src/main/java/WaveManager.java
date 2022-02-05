import java.util.ArrayList;

public class WaveManager {

    public ArrayList<Enemy> getWave() {
        return wave;
    }

    public void setWave(ArrayList<Enemy> wave) {
        this.wave = wave;
    }

    private ArrayList<Enemy> wave = new ArrayList<>();


    public WaveManager (int amountOfEnemys){

        for (int i = 0; amountOfEnemys>wave.size(); i++){
            wave.add(new Enemy(100,10, GameEngine.settings.getTileSize(),GameEngine.settings.getTileSize()));
        }
    }

}
