package paketic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import baza.BazaSoftware;


public class MyFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7521964742559320968L;
		//BOJE za GUI
		Color ColBraon=new Color(59,48,28);
		Color ColCrvena=new Color(207,68,39);
		Color ColKrem=new Color(235,226,195);
		Color ColBela=new Color(251,248,241);
		Color ColNaran=new Color(230,160,36);
		
		//
	
	public static MyFrame instance = null;
	public static MyFrame getInstance() {
		if (instance == null)
			instance = new MyFrame();

		return instance;
	}
	
	JTabbedPane tabbedPane;	
	private static JTable TableEmployees;
	private static JTable TableSoftware;
	
	public MyFrame() {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setSize(screenWidth*3/4, screenHeight*3/4);
	setTitle("Animacija OISISI projekat");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	MyMenuBar menu = new MyMenuBar();
	this.setJMenuBar(menu);
	
	setVisible(true);
	
	JPanel panel = new JPanel();
	panel.setBackground(ColNaran);
	panel.setLayout(new BorderLayout());
	this.add(panel, BorderLayout.CENTER);
	
	MyToolBar toolbar = new MyToolBar();
	panel.add(toolbar, BorderLayout.SOUTH);
	toolbar.setBackground(ColBela);
	
	MyStatusBar statusbar = new MyStatusBar();
	statusbar.setPreferredSize(new Dimension(this.getWidth(), 20));
	this.add(statusbar, BorderLayout.SOUTH);
	statusbar.setLayout(new BoxLayout(statusbar,BoxLayout.LINE_AXIS));
	statusbar.setBackground(ColKrem);
	
	Date date = new Date();
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String today = formatter.format(date);
	JLabel dateLabel = new JLabel(today);
	statusbar.add(Box.createHorizontalGlue());
	statusbar.add(dateLabel);
	statusbar.add(Box.createRigidArea(new Dimension(5,0)));
	
	tabbedPane = new JTabbedPane();
	tabbedPane.setBackground(ColKrem);
	
///////TABELA ZAPOSLENI///////
	panel.add(tabbedPane, BorderLayout.CENTER);
	
	TableEmployees = new JTable(new AbstractTableModelEmployee());
	JScrollPane scrollPaneEmployee = new JScrollPane(TableEmployees);
	tabbedPane.addTab("Employees", scrollPaneEmployee);
	
	TableEmployees.setBackground(ColBela);
	TableEmployees.setSelectionBackground(ColNaran);
	
/////////TABELA SOFTVER//////////
	
	TableSoftware = new JTable(new AbstractTableModelSoftware()) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3126918640183210220L;

		@Override
        public Component prepareRenderer(TableCellRenderer renderer,
                int row, int col) {

            Component c = super.prepareRenderer(renderer, row, col);
            if (c instanceof JComponent) {
                JComponent jc = (JComponent)c;
                ArrayList<Color> Colours = new ArrayList<Color>();
            	for (int i = 0; i<BazaSoftware.getInstance().getSoftware().get(row).getCetkice().size(); i++) {
            		Colours.add(BazaSoftware.getInstance().getSoftware().get(row).getCetkice().get(i).getColor());
            	}
                String html = getHtml(Colours);
                jc.setToolTipText(html);
            }   
            return c;
        }
	};
	
	JScrollPane scrollPaneSoftware = new JScrollPane(TableSoftware);
	tabbedPane.addTab("Software", scrollPaneSoftware);
	
	TableSoftware.setBackground(ColBela);
	TableSoftware.setSelectionBackground(ColNaran);
	
//	ArrayList<String> boje = new ArrayList<String>();
//    for(int i = 0; i<Colours.size(); i ++) {
//    		boje.add(String.valueOf(Colours.get(i).getRed())+","+String.valueOf(Colours.get(i).getGreen())+","+String.valueOf(Colours.get(i).getBlue()));
//    }
	
	//String boje = (String.valueOf(Colours.get(1).getRed())+","+String.valueOf(Colours.get(1).getGreen())+","+String.valueOf(Colours.get(1).getBlue()));
    //String html = getHtml(Colours);
	
	}
	
public static JTable getTableEmployees() {
	return TableEmployees;
}

public static JTable getTableSoftware() {
	return TableSoftware;
}
	
public void createTab(String tablename, JScrollPane pane) {
	tabbedPane.addTab("Tab #", pane);
	}

public JTabbedPane getTab() {
	return tabbedPane;
}

public void updateDisplay() {
	AbstractTableModelEmployee model = (AbstractTableModelEmployee) TableEmployees.getModel();
	// azuriranje modela tabele, kao i njenog prikaza
	model.fireTableDataChanged();
	validate();
}

private String getHtml(ArrayList<Color> colors) {
	ArrayList<String> boje = new ArrayList<String>();
  for(int i = 0; i<colors.size(); i ++) {
  		boje.add(String.valueOf(colors.get(i).getRed())+","+String.valueOf(colors.get(i).getGreen())+","+String.valueOf(colors.get(i).getBlue()));
  }
    StringBuilder sb = new StringBuilder();
    sb.append("<html><body>");
    for (int i=0; i<boje.size(); i++) {
    	sb.append("<div style='background-color:rgb(");
    	sb.append(boje.get(i));
    	sb.append("); height:150px; width:150px'></div>");
    }
    sb.append("</body></html>");
    return sb.toString();
}

}