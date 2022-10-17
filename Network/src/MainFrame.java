import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		// attribute
		this.setSize(500, 250);
		this.setTitle("Network Computing");
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);

		// components
		TopPanel topPanel = new TopPanel();
		this.add(topPanel, BorderLayout.NORTH);
		
		MainPanel mainPanel = new MainPanel();
		this.add(mainPanel, BorderLayout.CENTER);
		
	}

}
