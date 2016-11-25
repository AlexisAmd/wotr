
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
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

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
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmWOTR.setBounds(0, 0,screen.width-200,screen.height - 150);
		frmWOTR.setExtendedState(frmWOTR.MAXIMIZED_BOTH);
		frmWOTR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWOTR.getContentPane().setFont(new Font("Roboto", Font.PLAIN, 12));
		frmWOTR.setOpacity(1);
		frmWOTR.setResizable(false);
		frmWOTR.setForeground(Color.LIGHT_GRAY);
		frmWOTR.setFont(new Font("Roboto", Font.PLAIN, 12));
		frmWOTR.setAlwaysOnTop(true);
		frmWOTR.setTitle("World of the Ring");
		frmWOTR.getContentPane().setSize(new Dimension(1024, 800));
		frmWOTR.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		frmWOTR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWOTR.getContentPane().setLayout(null);
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(new Color(218, 165, 32));
		panelRight.setBounds(756, 0, 404, 589);
		frmWOTR.getContentPane().add(panelRight);
		panelRight.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panelInfoPlayer = new JPanel();
		panelRight.add(panelInfoPlayer);
		panelInfoPlayer.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelInfoTop = new JPanel();
		panelInfoTop.setLayout(null);
		panelInfoPlayer.add(panelInfoTop);
		
		JPanel panelInfoBotom = new JPanel();
		panelInfoPlayer.add(panelInfoBotom);
		panelInfoBotom.setLayout(null);
		
		JProgressBar progressBarHealth = new JProgressBar();
		progressBarHealth.setString("Hp : 0 %");
		progressBarHealth.setBounds(12, 8, 380, 37);
		progressBarHealth.setToolTipText("Health points, if they are equal to 100 you're dead !");
		progressBarHealth.setStringPainted(true);
		progressBarHealth.setForeground(Color.RED);
		progressBarHealth.setBackground(Color.WHITE);
		panelInfoBotom.add(progressBarHealth);
		
		JProgressBar progressBarCorruption = new JProgressBar();
		progressBarCorruption.setString("Cp : 0 %");
		progressBarCorruption.setBounds(12, 53, 380, 37);
		progressBarCorruption.setStringPainted(true);
		progressBarCorruption.setBackground(Color.WHITE);
		panelInfoBotom.add(progressBarCorruption);
		
		JPanel panelNPC = new JPanel();
		panelRight.add(panelNPC);
		panelNPC.setLayout(null);
		
		JButton btnUseNPC = new JButton("Use");
		btnUseNPC.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnUseNPC.setBounds(275, 11, 117, 32);
		panelNPC.add(btnUseNPC);
		
		JButton btnDropNPC = new JButton("Drop");
		btnDropNPC.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnDropNPC.setBounds(275, 53, 117, 32);
		panelNPC.add(btnDropNPC);
		
		JTextPane textPaneDesNPC = new JTextPane();
		textPaneDesNPC.setText("Description");
		textPaneDesNPC.setBounds(12, 12, 251, 172);
		panelNPC.add(textPaneDesNPC);
		
		JList listNPC = new JList();
		listNPC.setBounds(275, 97, 117, 87);
		panelNPC.add(listNPC);
		
		JPanel panelInventory = new JPanel();
		panelRight.add(panelInventory);
		panelInventory.setLayout(null);
		
		JList listInventory = new JList();
		listInventory.setBounds(275, 97, 117, 87);
		panelInventory.add(listInventory);
		
		JButton btnUseitem = new JButton("Use");
		btnUseitem.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnUseitem.setBounds(275, 11, 117, 32);
		panelInventory.add(btnUseitem);
		
		JButton btnDropitem = new JButton("Drop");
		btnDropitem.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnDropitem.setBounds(275, 53, 117, 32);
		panelInventory.add(btnDropitem);
		
		JTextPane txtpnDesInventory = new JTextPane();
		txtpnDesInventory.setText("Description");
		txtpnDesInventory.setBounds(12, 11, 251, 173);
		panelInventory.add(txtpnDesInventory);
		
		JPanel panelDirection = new JPanel();
		panelDirection.setBounds(53, 181, 68, 79);
		frmWOTR.getContentPane().add(panelDirection);
		panelDirection.setLayout(new BorderLayout(0, 0));
		
		JButton btnWest = new JButton();
		//btnWest.setIcon(new ImageIcon(Interface.class.getResource("image/westArrow.png")));
		panelDirection.add(btnWest, BorderLayout.WEST);
		
		
		JButton btnEast = new JButton();
		//btnEast.setIcon(new ImageIcon(Interface.class.getResource("image/eastArrow.png")));
		panelDirection.add(btnEast, BorderLayout.EAST);
		
		JButton btnNorth = new JButton();
		//btnNorth.setIcon(new ImageIcon(Interface.class.getResource("image/northArrow.png")));
		panelDirection.add(btnNorth, BorderLayout.NORTH);
		
		JButton btnSouth = new JButton();
		//btnSouth.setIcon(new ImageIcon(Interface.class.getResource("image/southArrow.png")));
		panelDirection.add(btnSouth, BorderLayout.SOUTH);
		
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
		txtpnPrompt.setBounds(126, 181, 156, 80);
		frmWOTR.getContentPane().add(txtpnPrompt);
	}
}