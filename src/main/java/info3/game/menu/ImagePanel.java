package info3.game.menu;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class ImagePanel extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2310604834592919432L;
	private Image image;

	public ImagePanel(Image image) {
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}
