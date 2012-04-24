package indaprojekt;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DefaultUserInterface extends UserInterface {

	public DefaultUserInterface(int screenWidth, int screenHeight)
			throws SlickException {
		
		super(58, 10, screenWidth - 290, screenHeight - 40, 
				new Image("res//images//BlueHeart.png"), 
				new Image("res//images//brokenHeart.png"), 
				new Image("res//images//OrangeHeart.png"), 
				new Image("res//images//brokenHeart.png"), 18, 5);

	}

}