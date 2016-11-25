
package gui;
import wotr.*;
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
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class Window {

	private JFrame frmWOTR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window Window = new Window();
					Window.frmWOTR.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWOTR = new JFrame();
		frmWOTR.getContentPane().setFont(new Font("Roboto", Font.PLAIN, 12));
		frmWOTR.setOpacity(1);
		frmWOTR.setResizable(false);
		frmWOTR.setForeground(Color.LIGHT_GRAY);
		frmWOTR.setFont(new Font("Roboto", Font.PLAIN, 12));
		frmWOTR.setSize(new Dimension(1024, 800));
		frmWOTR.setAlwaysOnTop(true);
		frmWOTR.setTitle("World of the Ring");
		frmWOTR.getContentPane().setSize(new Dimension(1024, 800));
		frmWOTR.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmWOTR.setBounds(100, 100, 450, 300);
		frmWOTR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWOTR.getContentPane().setLayout(null);
		
		JPanel panelInvFello = new JPanel();
		panelInvFello.setBackground(new Color(218, 165, 32));
		panelInvFello.setBounds(291, 0, 153, 271);
		frmWOTR.getContentPane().add(panelInvFello);
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
		btnUseNPC.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnUseNPC.setBounds(73, 6, 70, 21);
		panelNPC.add(btnUseNPC);
		
		JButton btnDropNPC = new JButton("Drop");
		btnDropNPC.setFont(new Font("Roboto", Font.PLAIN, 10));
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
		btnUseitem.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnUseitem.setBounds(73, 11, 70, 21);
		panelInventory.add(btnUseitem);
		
		JButton btnDropitem = new JButton("Drop");
		btnDropitem.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnDropitem.setBounds(73, 40, 70, 21);
		panelInventory.add(btnDropitem);
		
		JTextPane txtpnDescription = new JTextPane();
		txtpnDescription.setText("Description");
		txtpnDescription.setBounds(73, 69, 70, 63);
		panelInventory.add(txtpnDescription);
		
		JPanel panelDirection = new JPanel();
		panelDirection.setBounds(53, 181, 68, 79);
		frmWOTR.getContentPane().add(panelDirection);
		panelDirection.setLayout(new BorderLayout(0, 0));
		
		JButton btnWest = new JButton();
		btnWest.setIcon(new ImageIcon(Interface.class.getResource("image/westArrow.png")));
		panelDirection.add(btnWest, BorderLayout.WEST);
		
		
		JButton btnEast = new JButton();
		btnEast.setIcon(new ImageIcon(Interface.class.getResource("image/eastArrow.png")));
		panelDirection.add(btnEast, BorderLayout.EAST);
		
		JButton btnNorth = new JButton();
		btnNorth.setIcon(new ImageIcon(Interface.class.getResource("image/northArrow.png")));
		panelDirection.add(btnNorth, BorderLayout.NORTH);
		
		JButton btnSouth = new JButton();
		btnSouth.setIcon(new ImageIcon(Interface.class.getResource("image/southArrow.png")));
		panelDirection.add(btnSouth, BorderLayout.SOUTH);
		
		JPanel panelHero = new JPanel();
		panelHero.setBounds(10, 11, 272, 47);
		frmWOTR.getContentPane().add(panelHero);
		panelHero.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelMap = new JPanel();
		panelMap.setBounds(10, 61, 272, 109);
		frmWOTR.getContentPane().add(panelMap);
		
		JPanel panelSU = new JPanel();
		panelSU.setBounds(10, 182, 40, 78);
		frmWOTR.getContentPane().add(panelSU);
		panelSU.setLayout(new BorderLayout(0, 0));
		
		JButton btnSearch = new JButton("Search");
		panelSU.add(btnSearch, BorderLayout.NORTH);
		
		JButton btnPick = new JButton("Pick");
		panelSU.add(btnPick, BorderLayout.SOUTH);
		
		JTextPane txtpnPrompt = new JTextPane();
		txtpnPrompt.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtpnPrompt.setForeground(Color.WHITE);
		txtpnPrompt.setBackground(Color.BLACK);
		txtpnPrompt.setBounds(133, 180, 153, 80);
		frmWOTR.getContentPane().add(txtpnPrompt);
	}
}