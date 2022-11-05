package info3.game.menu;

import java.io.Serializable;
import java.util.HashMap;

public class GameOptions implements Serializable {
	private static final long serialVersionUID = -3887740815244145516L;
	public int playerCount = 1;
	public static GameOptions instance = new GameOptions();
	public HashMap<String, String> automates = new HashMap<String, String>();
	public String fichierGal;
}
