package Character;

import Animation.Animation;
import Animation.Sprite;

import java.awt.image.BufferedImage;

public class Character {

    // Images for each animation
    private BufferedImage[] walkingLeft = {Sprite.getSprite(0, 1), Sprite.getSprite(2, 1)}; // Gets the upper left images of my sprite sheet
    private BufferedImage[] walkingRight = {Sprite.getSprite(0, 2), Sprite.getSprite(2, 2)};
    private BufferedImage[] standing = {Sprite.getSprite(1, 0)};

    // These are animation states
    private Animation walkLeftAnimation = new Animation(walkingLeft, 10);
    private Animation walkRightAnimation = new Animation(walkingRight, 10);
    private Animation standingAnimation = new Animation(standing, 10);

    // This is the actual animation
    private Animation animation = standingAnimation;




}
