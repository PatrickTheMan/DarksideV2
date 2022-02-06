import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    BufferedImage sprite;
    BufferedImage[] collectionSprites;

    public Sprite(String sprite, int singlePicWidth, int singlePicHeight, int amountPicWidth, int amountPicHeight){

        try {

            this.sprite = ImageIO.read(new File("C:\\Users\\patri\\IdeaProjects\\DarksideV2\\src\\main\\resources\\"+sprite+".png"));

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        if (sprite!=null){

            collectionSprites = new BufferedImage[amountPicWidth*amountPicHeight];

            for (int i = 0; collectionSprites.length > i; i++){

                collectionSprites[i] = this.sprite.getSubimage((i*singlePicWidth),0,singlePicWidth,singlePicHeight);
            }

        } else {
            System.out.println("No picture");
        }

    }
}
