package Graphic;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Playing {
	
	private List<Drawable> drawablesList;
	JPanel panel;
	
	public List<Drawable> getDrawablesList() {
		return drawablesList;
	}

	public void setDrawablesList(List<Drawable> drawablesList) {
		this.drawablesList = drawablesList;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Playing(){
		panel = new JPanel();
		drawablesList = new ArrayList<Drawable>();
		panel.setLayout(null);
	}

	public void DrawAll(){
		for(Drawable d : drawablesList){
			d.Draw();
		}
		panel.repaint();
	}
}
