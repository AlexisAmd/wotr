
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
import javax.swing.ImageIcon;
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
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class Window extends JFrame {


	private Game game;

public Window(){
					



		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0,1166,768 - 150);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setFont(new Font("Roboto", Font.PLAIN, 12));
		this.setOpacity(1);
		this.setResizable(false);;
		this.setTitle("World of the Ring");
		this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panelLeft = new JPanel();
		JLabel backGroundLeft = new JLabel(new ImageIcon("src/gui/image/backGroundLeft.jpeg"));
		panelLeft.add(backGroundLeft);
		panelLeft.setBounds(0, 0, 756, 589);
		this.getContentPane().add(panelLeft);
		panelLeft.setLayout(null);
		
		JPanel panelDirection = new JPanel();
		panelDirection.setBounds(150, 417, 160, 160);
		panelLeft.add(panelDirection);
		panelDirection.setLayout(new BorderLayout(0, 0));
		
		JButton btnWest = new JButton(new ImageIcon("src/gui/image/westArrow.png"));
		btnWest.setToolTipText("West");
		btnWest.setOpaque(false);
		btnWest.setBorderPainted(false);
		btnWest.setContentAreaFilled(false);
		panelDirection.add(btnWest, BorderLayout.WEST);
		
		JButton btnEast = new JButton(new ImageIcon("src/gui/image/eastArrow.png"));
		btnEast.setToolTipText("East");
		btnEast.setOpaque(false);
		btnEast.setBorderPainted(false);
		btnEast.setContentAreaFilled(false);
		panelDirection.add(btnEast, BorderLayout.EAST);
		
		JButton btnNorth = new JButton(new ImageIcon("src/gui/image/northArrow.png"));
		btnNorth.setToolTipText("North");
		btnNorth.setOpaque(false);
		btnNorth.setBorderPainted(false);
		btnNorth.setContentAreaFilled(false);
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelDirection.add(btnNorth, BorderLayout.NORTH);
		
		JButton btnSouth = new JButton(new ImageIcon("src/gui/image/southArrow.png"));
		btnSouth.setToolTipText("South");
		btnSouth.setOpaque(false);
		btnSouth.setBorderPainted(false);
		btnSouth.setContentAreaFilled(false);
		panelDirection.add(btnSouth, BorderLayout.SOUTH);
		
		JPanel panelSU = new JPanel();
		panelSU.setBounds(12, 417, 126, 160);
		panelLeft.add(panelSU);
		panelSU.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnSearch = new JButton(new ImageIcon("src/gui/image/13857-jumo-oeil.png"));
		btnSearch.setToolTipText("Search");
		btnSearch.setOpaque(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setContentAreaFilled(false);
		panelSU.add(btnSearch);
		
		JButton btnPickUp = new JButton(new ImageIcon("src/gui/image/Hand-icon.png"));
		btnPickUp.setToolTipText("Pick Up");
		btnPickUp.setOpaque(false);
		btnPickUp.setBorderPainted(false);
		btnPickUp.setContentAreaFilled(false);
		panelSU.add(btnPickUp);
		
		JButton btnMap = new JButton(new ImageIcon("src/gui/image/map2.png"));
		btnMap.setToolTipText("Map");
		btnMap.setOpaque(false);
		btnMap.setBorderPainted(false);
		btnMap.setContentAreaFilled(false);
		panelSU.add(btnMap);
		
		JTextPane txtpnPrompt = new JTextPane();
		txtpnPrompt.setBounds(322, 417, 422, 160);
		panelLeft.add(txtpnPrompt);
		txtpnPrompt.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtpnPrompt.setForeground(Color.WHITE);
		txtpnPrompt.setBackground(Color.BLACK);
		
		JPanel panelImage = new JPanel();
		JLabel Image = new JLabel(new ImageIcon("src/gui/image/HomePage.jpg"));//Test image
		panelImage.add(Image);
		panelImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelImage.setBounds(12, 12, 732, 393);
		
		panelLeft.add(panelImage);
		panelImage.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelRight = new JPanel();
		panelRight.setBorder(null);
		panelRight.setBackground(new Color(218, 165, 32));
		panelRight.setBounds(756, 0, 404, 589);
		this.getContentPane().add(panelRight);
		panelRight.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panelInfoPlayer = new JPanel();
		panelRight.add(panelInfoPlayer);
		panelInfoPlayer.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelInfoTopPlayer = new JPanel();
		panelInfoTopPlayer.setBorder(null);
		panelInfoTopPlayer.setLayout(null);
		panelInfoPlayer.add(panelInfoTopPlayer);
		
		JTextPane textPanePlayer = new JTextPane();
		textPanePlayer.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textPanePlayer.setBounds(96, 12, 296, 74);
		panelInfoTopPlayer.add(textPanePlayer);
		
		
		JPanel panelIconPlayer = new JPanel();
		panelIconPlayer.setLayout(new BorderLayout());
		JLabel iconPlayer = new JLabel( new ImageIcon("src/gui/image/frodo.png"));
		panelIconPlayer.setBounds(12, 12, 75, 74);
		panelIconPlayer.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelIconPlayer.add(iconPlayer, BorderLayout.NORTH);
		panelInfoTopPlayer.add(panelIconPlayer);
		
		JPanel panelInfoBotom = new JPanel();
		panelInfoPlayer.add(panelInfoBotom);
		panelInfoBotom.setLayout(null);
		
		JProgressBar progressBarHealth = new JProgressBar();
		progressBarHealth.setStringPainted(true);
		progressBarHealth.setString("Hp : 0 %");
		progressBarHealth.setBounds(12, 8, 380, 37);
		progressBarHealth.setToolTipText("Health points, if they are equal to 100 you're dead !");
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
		panelInventory.setBorder(null);
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
	}
}

	
