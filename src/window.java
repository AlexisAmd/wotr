

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class window {

	private JFrame frmWorldOfTheRing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frmWorldOfTheRing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWorldOfTheRing = new JFrame();
		frmWorldOfTheRing.setResizable(false);
		frmWorldOfTheRing.setSize(new Dimension(600, 400));
		frmWorldOfTheRing.setAlwaysOnTop(true);
		frmWorldOfTheRing.setTitle("World of the Ring");
		frmWorldOfTheRing.getContentPane().setSize(new Dimension(600, 400));
		frmWorldOfTheRing.getContentPane().setMinimumSize(new Dimension(600, 400));
		frmWorldOfTheRing.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		frmWorldOfTheRing.setBounds(100, 100, 450, 300);
		frmWorldOfTheRing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWorldOfTheRing.getContentPane().setLayout(null);
		
		JPanel panelInvFello = new JPanel();
		panelInvFello.setBounds(291, 0, 153, 271);
		frmWorldOfTheRing.getContentPane().add(panelInvFello);
		panelInvFello.setLayout(null);
		
		JPanel panelNPC = new JPanel();
		panelNPC.setBounds(0, 0, 153, 132);
		panelInvFello.add(panelNPC);
		panelNPC.setLayout(null);
		
		JList listNPC = new JList();
		listNPC.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listNPC.setBounds(8, 6, 55, 117);
		panelNPC.add(listNPC);
		
		JButton btnUseNPC = new JButton("Use");
		btnUseNPC.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUseNPC.setBounds(73, 6, 70, 21);
		panelNPC.add(btnUseNPC);
		
		JButton btnDropNPC = new JButton("Drop");
		btnDropNPC.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDropNPC.setBounds(73, 33, 70, 21);
		panelNPC.add(btnDropNPC);
		
		JTextPane textPaneDesNPC = new JTextPane();
		textPaneDesNPC.setText("Description");
		textPaneDesNPC.setBounds(73, 60, 70, 63);
		panelNPC.add(textPaneDesNPC);
		
		JPanel panelInventory = new JPanel();
		panelInventory.setBounds(0, 132, 153, 139);
		panelInvFello.add(panelInventory);
		panelInventory.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 55, 121);
		panelInventory.add(list);
		
		JButton btnUseitem = new JButton("Use");
		btnUseitem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUseitem.setBounds(73, 11, 70, 21);
		panelInventory.add(btnUseitem);
		
		JButton btnDropitem = new JButton("Drop");
		btnDropitem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDropitem.setBounds(73, 40, 70, 21);
		panelInventory.add(btnDropitem);
		
		JTextPane txtpnDescription = new JTextPane();
		txtpnDescription.setText("Description");
		txtpnDescription.setBounds(73, 69, 70, 63);
		panelInventory.add(txtpnDescription);
		
		JEditorPane editorPaneConsole = new JEditorPane();
		editorPaneConsole.setBounds(96, 181, 185, 79);
		frmWorldOfTheRing.getContentPane().add(editorPaneConsole);
		
		JPanel panelDirection = new JPanel();
		panelDirection.setBounds(10, 181, 79, 79);
		frmWorldOfTheRing.getContentPane().add(panelDirection);
		panelDirection.setLayout(new BorderLayout(0, 0));
		
		JButton btnWest = new JButton("<");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelDirection.add(btnWest, BorderLayout.WEST);
		
		JButton btnEast = new JButton(">");
		
		panelDirection.add(btnEast, BorderLayout.EAST);
		
		JButton btnNorth = new JButton("^");
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelDirection.add(btnNorth, BorderLayout.NORTH);
		
		JButton btnSouth = new JButton("v");
		panelDirection.add(btnSouth, BorderLayout.SOUTH);
		
		JPanel panelHero = new JPanel();
		panelHero.setBounds(10, 11, 272, 47);
		frmWorldOfTheRing.getContentPane().add(panelHero);
		panelHero.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelMap = new JPanel();
		panelMap.setBounds(10, 61, 272, 109);
		frmWorldOfTheRing.getContentPane().add(panelMap);
	}
}
