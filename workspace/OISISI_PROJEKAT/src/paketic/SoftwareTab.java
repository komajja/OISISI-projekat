package paketic;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SoftwareTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7445755320045782268L;

	private String tableName;

	public SoftwareTab(String text) {
		this.tableName = text;
		add(new JLabel("Table" + this.tableName + " content!"));
	}

	public void saveTableContent() {
		System.out.println("Saving table: " + this.tableName);
	}

}
