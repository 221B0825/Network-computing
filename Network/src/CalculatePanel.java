import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField tfCode;
	private JTextField tfData;

	private JButton calculateButton;
	private JLabel result;

	public CalculatePanel() {
		// attributes
		LayoutManager layoutManger = new GridLayout(3, 2, 5, 30);
		this.setLayout(layoutManger);

		// components
		JLabel lbCode = new JLabel("code: ");
		this.add(lbCode);
		this.tfCode = new JTextField();
		this.tfCode.setColumns(10);
		this.add(tfCode);

		JLabel lbData = new JLabel("data: ");
		this.add(lbData);
		this.tfData = new JTextField();
		this.tfData.setColumns(10);
		this.add(tfData);

		this.calculateButton = new JButton("calcuate");
		ActionHandler actionHandler = new ActionHandler();
		this.calculateButton.addActionListener(actionHandler);
		this.add(calculateButton);
		this.result = new JLabel("result: ");
		this.add(result);
	}

	private void calculate() {
		Calculator calculator = new Calculator();
		this.result.setText("result: "+calculator.compute(tfCode.getText(), tfData.getText()));
		this.repaint();

	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			calculate();
		}

	}

}
