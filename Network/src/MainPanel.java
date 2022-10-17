import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public MainPanel() {
		CalculatePanel rightPanel = new CalculatePanel();
		this.add(rightPanel);
		CalculatePanel leftPanel = new CalculatePanel();
		this.add(leftPanel);
	}

}
