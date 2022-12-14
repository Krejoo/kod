package gerumap.core;

public abstract class ApplicationFramework {
	protected Gui gui;
	
	public abstract void run();
	
	public void initialise(Gui gui) {
		this.gui = gui;
	}
}
