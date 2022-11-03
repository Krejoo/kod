package gerumap.gui.swing;

import gerumap.core.Gui;
import gerumap.gui.swing.view.MainFrame;

public class SwingGui implements Gui{

	@Override
	public void start() {
		MainFrame.get().setVisible(true);
		
	}

}
