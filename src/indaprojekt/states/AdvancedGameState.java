package indaprojekt.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A game state with some more advanced features
 *
 */

public abstract class AdvancedGameState extends BasicGameState
{
	private Music theme;
	private int stateID, previousStateID, nextStateID;
	private boolean stopPlayingTheme;
	private boolean startPlayingTheme;
	
	public AdvancedGameState(int stateID) 
	{
		this.stateID = stateID;
		previousStateID = -1;
		nextStateID = -1;
		stopPlayingTheme = true;
		startPlayingTheme = true;
	}
	
	public AdvancedGameState(int stateID, int previousStateID, int nextStateID) 
	{
		this.stateID = stateID;
		this.previousStateID = previousStateID;
		this.nextStateID = nextStateID;
	}
	
	public void setStopPlayingTheme(boolean stopPlaying)
	{
		stopPlayingTheme = stopPlaying;
	}
	
	public void setStartPlayingTheme(boolean startPlaying)
	{
		startPlayingTheme = startPlaying;
	}
	
	@Override
	public void leave(GameContainer gc, StateBasedGame game)
	{
		if (theme != null && stopPlayingTheme) {
			theme.stop();
		}
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame game)
	{
		if (theme != null && startPlayingTheme) {
			theme.loop();
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException 
	{
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_ENTER)) {
			if (nextStateID != -1) {
				game.enterState(nextStateID);
			}
		} else if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			if (previousStateID != -1) {
				game.enterState(previousStateID);
			}
		}
	}
	
	/**
	 * Sets the theme song of this game state
	 * @param theme
	 */
	protected void setTheme(Music theme)
	{
		this.theme = theme;
	}
	
	@Override
	public int getID() 
	{
		return stateID;
	}
}
