package gerumap;

import javax.swing.UIManager;

import gerumap.core.ApplicationFramework;
import gerumap.core.Gui;
import gerumap.gui.swing.SwingGui;
import gerumap.gui.swing.view.MainFrame;
import gerumap.util.UserPreferences;

/**
 * Start of application
 * 
 * @author Djordje Krejakovic
 * @since 1 November 2022
 *
 */
public class AppCore extends ApplicationFramework{

	public static void main(String[] args) {
		Gui gui = new SwingGui();
		AppCore.get().initialise(gui);
		AppCore.get().run();
	}
	
	private static AppCore instance;
	
	private AppCore() {
		
	}
	
	public static AppCore get() {
		if(instance == null) {
			instance = new AppCore();
		}
		return instance;
	}

	@Override
	public void run() {
		this.gui.start();
	}

}
