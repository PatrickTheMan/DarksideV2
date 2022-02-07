import java.awt.*;

public class Settings {

    //region [Variables]
    private static int originalTileSize = 32;
    private static int scale = 2;

    private static int tileSize = originalTileSize * scale;

    private static int maxScreenCol = 20;
    private static int maxScreenRow = 10;
    private static int screenWidth = tileSize * maxScreenCol;
    private static int screenHeight = tileSize * maxScreenRow;

    private static Color backgroundColor = Color.gray;

    private static int fps = 60;
    //endregion

    //region [Getters & Setters]
    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public void setMaxScreenCol(int maxScreenCol) {
        this.maxScreenCol = maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public void setMaxScreenRow(int maxScreenRow) {
        this.maxScreenRow = maxScreenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        Settings.fps = fps;
    }
    //endregion

}
