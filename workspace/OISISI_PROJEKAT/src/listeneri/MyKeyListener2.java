package listeneri;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyKeyListener2 implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		char c = arg0.getKeyChar();
		if (!Character.isAlphabetic(c)) {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo slova!");
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
		}
			
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();
		String str = txt.getText();
		System.out.println(str);
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}