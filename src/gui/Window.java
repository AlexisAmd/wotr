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
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Window extends JFrame {
	private JPanel panelLeft, panelDirection, panelSU, panelImage, panelRight, panelInfoTopPlayer, panelInfoPlayer,
			panelIconPlayer, panelinfoBottom, panelNPC, panelInventory;
	private JButton btnWest, btnEast, btnNorth, btnSouth, btnSearch, btnPickUp, btnMap, btnUseNPC, btnDropNPC,
			btnUseItem, btnDropItem;
	private JTextPane textPanePrompt, textPanePlayer, textPaneDesNPC, textPanelDesInventory;
	private JList listNPC, listInventory;
	private JLabel backGroundLeft, iconPlayer, ImageHome;
	private JProgressBar progressBarHealth, progressBarCorruption;
	private JScrollPane scrollBar;
	// Other variables
	private NPC selectedNPC;
	private Item selectedItem;
	private Game game;

	// public static void main(String[] arg) {
	// Window window = new Window();
	// }
	public Window() {
		this.setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, 1166, 768 - 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setFont(new Font("Roboto", Font.PLAIN, 12));
		this.setOpacity(1);
		this.setResizable(false);
		this.setTitle("World of the Ring");
		this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		panelLeft = new JPanel();
		backGroundLeft = new JLabel(new ImageIcon("src/gui/image/backGroundLeft.jpeg"));
		panelLeft.add(backGroundLeft);
		panelLeft.setOpaque(false);
		panelLeft.setBackground(new Color(0, 0, 0, 0));
		panelLeft.setBounds(0, 0, 756, 589);
		this.getContentPane().add(panelLeft);
		panelLeft.setLayout(null);
		panelDirection = new JPanel();
		panelDirection.setBounds(150, 417, 160, 160);
		panelDirection.setOpaque(false);
		panelDirection.setBackground(new Color(0, 0, 0, 0));
		panelLeft.add(panelDirection);
		panelDirection.setLayout(new BorderLayout(0, 0));
		btnWest = new JButton(new ImageIcon("src/gui/image/westArrow.png"));
		btnWest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				game.getPlayer().goRoom("west");
			}
		});
		btnWest.setToolTipText("West");
		btnWest.setOpaque(false);
		btnWest.setBorderPainted(false);
		btnWest.setContentAreaFilled(false);
		panelDirection.add(btnWest, BorderLayout.WEST);
		btnEast = new JButton(new ImageIcon("src/gui/image/eastArrow.png"));
		btnEast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.getPlayer().goRoom("east");
			}
		});
		btnEast.setToolTipText("East");
		btnEast.setOpaque(false);
		btnEast.setBorderPainted(false);
		btnEast.setContentAreaFilled(false);
		panelDirection.add(btnEast, BorderLayout.EAST);
		btnNorth = new JButton(new ImageIcon("src/gui/image/northArrow.png"));
		btnNorth.setToolTipText("North");
		btnNorth.setOpaque(false);
		btnNorth.setBorderPainted(false);
		btnNorth.setContentAreaFilled(false);
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.getPlayer().goRoom("north");
			}
		});
		panelDirection.add(btnNorth, BorderLayout.NORTH);
		btnSouth = new JButton(new ImageIcon("src/gui/image/southArrow.png"));
		btnSouth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.getPlayer().goRoom("south");
			}
		});
		btnSouth.setToolTipText("South");
		btnSouth.setOpaque(false);
		btnSouth.setBorderPainted(false);
		btnSouth.setContentAreaFilled(false);
		panelDirection.add(btnSouth, BorderLayout.SOUTH);
		panelSU = new JPanel();
		panelSU.setBounds(12, 417, 126, 160);
		panelSU.setOpaque(false);
		panelSU.setBackground(new Color(0, 0, 0, 0));
		panelLeft.add(panelSU);
		panelSU.setLayout(new GridLayout(3, 1, 0, 0));
		btnSearch = new JButton(new ImageIcon("src/gui/image/oeil.gif"));
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.getPlayer().getCurrentRoom().getItemList();
			}
		});
		btnSearch.setToolTipText("Search");
		btnSearch.setOpaque(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setContentAreaFilled(false);
		panelSU.add(btnSearch);
		btnPickUp = new JButton(new ImageIcon("src/gui/image/Hand-icon2.png"));
		btnPickUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnPickUp.setToolTipText("Pick Up");
		btnPickUp.setOpaque(false);
		btnPickUp.setBorderPainted(false);
		btnPickUp.setContentAreaFilled(false);
		panelSU.add(btnPickUp);
		btnMap = new JButton(new ImageIcon("src/gui/image/map2.png"));
		btnMap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame mapImg = new JFrame();
				mapImg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mapImg.setVisible(true);
				mapImg.setTitle("Map of the game");
				JPanel panelImg = new JPanel();
				JLabel myImg = new JLabel(new ImageIcon("src/gui/image/fullMapView.jpg"));
				panelImg.add(myImg);
				mapImg.getContentPane().add(panelImg);
			}
		});
		btnMap.setToolTipText("Map");
		btnMap.setOpaque(false);
		btnMap.setBorderPainted(false);
		btnMap.setContentAreaFilled(false);
		panelSU.add(btnMap);
		textPanePrompt = new JTextPane();
		textPanePrompt.setToolTipText("Command prompt : displays a lot of informations");
		textPanePrompt.setBounds(322, 417, 422, 160);
		panelLeft.add(textPanePrompt);
		textPanePrompt.setFont(new Font("Roboto", Font.PLAIN, 12));
		textPanePrompt.setForeground(Color.WHITE);
		textPanePrompt.setBackground(Color.BLACK);
		//
		//
		panelImage = new JPanel();
		ImageHome = new JLabel(new ImageIcon("src/gui/image/HomePage.jpg"));// Test
																			// image
		panelImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelImage.setBounds(12, 12, 732, 393);
		panelImage.add(ImageHome);
		panelLeft.add(panelImage);
		panelImage.setLayout(new GridLayout(0, 1, 0, 0));
		panelRight = new JPanel();
		panelRight.setBorder(null);
		panelRight.setBackground(new Color(218, 165, 32));
		panelRight.setBounds(756, 0, 404, 589);
		this.getContentPane().add(panelRight);
		panelRight.setLayout(new GridLayout(3, 1, 0, 0));
		panelInfoPlayer = new JPanel();
		panelRight.add(panelInfoPlayer);
		panelInfoPlayer.setLayout(new GridLayout(2, 0, 0, 0));
		panelInfoTopPlayer = new JPanel();
		panelInfoTopPlayer.setBorder(null);
		panelInfoTopPlayer.setLayout(null);
		panelInfoPlayer.add(panelInfoTopPlayer);
		textPanePlayer = new JTextPane();
		textPanePlayer.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textPanePlayer.setBounds(96, 12, 296, 74);
		panelInfoTopPlayer.add(textPanePlayer);
		textPanePlayer.setEditable(false);
		panelIconPlayer = new JPanel();
		panelIconPlayer.setLayout(new BorderLayout());
		iconPlayer = new JLabel(new ImageIcon("src/gui/image/frodo.png"));
		panelIconPlayer.setBounds(12, 12, 75, 74);
		panelIconPlayer.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelIconPlayer.add(iconPlayer, BorderLayout.NORTH);
		panelInfoTopPlayer.add(panelIconPlayer);
		panelinfoBottom = new JPanel();
		panelInfoPlayer.add(panelinfoBottom);
		panelinfoBottom.setLayout(null);
		progressBarHealth = new JProgressBar();
		progressBarHealth.setStringPainted(true);
		progressBarHealth.setString("Hp : 0 %");
		progressBarHealth.setBounds(12, 8, 380, 37);
		progressBarHealth.setToolTipText("Health points, if they are equal to 100 you're dead !");
		progressBarHealth.setForeground(Color.RED);
		progressBarHealth.setBackground(Color.WHITE);
		panelinfoBottom.add(progressBarHealth);
		progressBarCorruption = new JProgressBar();
		progressBarCorruption.setString("Cp : 0 %");
		progressBarCorruption.setBounds(12, 53, 380, 37);
		progressBarCorruption.setStringPainted(true);
		progressBarCorruption.setBackground(Color.WHITE);
		panelinfoBottom.add(progressBarCorruption);
		panelNPC = new JPanel();
		panelRight.add(panelNPC);
		panelNPC.setLayout(null);
		btnUseNPC = new JButton("Use");
		btnUseNPC.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnUseNPC.setBounds(275, 11, 117, 32);
		panelNPC.add(btnUseNPC);
		btnDropNPC = new JButton("Drop");
		btnDropNPC.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnDropNPC.setBounds(275, 53, 117, 32);
		panelNPC.add(btnDropNPC);
		textPaneDesNPC = new JTextPane();
		textPaneDesNPC.setText("Description");
		textPaneDesNPC.setEditable(false);
		textPaneDesNPC.setBounds(12, 12, 251, 172);
		panelNPC.add(textPaneDesNPC);
		listNPC = new JList();
		listNPC.setBounds(275, 97, 117, 87);
		panelNPC.add(listNPC);
		listNPC.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectedNPC = (NPC) listNPC.getSelectedValue();
			}
		});
		panelInventory = new JPanel();
		panelInventory.setBorder(null);
		panelRight.add(panelInventory);
		panelInventory.setLayout(null);
		listInventory = new JList();
		listInventory.setBounds(275, 97, 117, 87);
		panelInventory.add(listInventory);
		listInventory.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectedItem = (Item) listInventory.getSelectedValue();
			}
		});
		btnUseItem = new JButton("Use");
		btnUseItem.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnUseItem.setBounds(275, 11, 117, 32);
		panelInventory.add(btnUseItem);
		btnDropItem = new JButton("Drop");
		btnDropItem.setFont(new Font("Roboto", Font.PLAIN, 10));
		btnDropItem.setBounds(275, 53, 117, 32);
		panelInventory.add(btnDropItem);
		textPanelDesInventory = new JTextPane();
		textPanelDesInventory.setText("Description");
		textPanelDesInventory.setEditable(false);
		textPanelDesInventory.setBounds(12, 11, 251, 173);
		panelInventory.add(textPanelDesInventory);
	}

	/**
	 * Add a line to the command prompt
	 * 
	 * @param script
	 *            The line which has to be added
	 */
	public void setScript(String script) {
		String currentText = textPanePrompt.getText();
		textPanePrompt.setText(" ");
		this.textPanePrompt.setText(script + "\n" + currentText);
	}

	/**
	 * @param btnWest
	 *            the btnWest to set
	 */
	public void setBtnWest(boolean b) {
		btnWest.setEnabled(b);
	}

	/**
	 * @param btnEast
	 *            the btnEast to set
	 */
	public void setBtnEast(boolean b) {
		btnEast.setEnabled(b);
	}

	/**
	 * @param btnNorth
	 *            the btnNorth to set
	 */
	public void setBtnNorth(boolean b) {
		btnNorth.setEnabled(b);
	}

	/**
	 * @param btnSouth
	 *            the btnSouth to set
	 */
	public void setBtnSouth(boolean b) {
		btnSouth.setEnabled(b);
	}

	/**
	 * @param textPanePlayer
	 *            the textPanePlayer to set
	 */
	public void setTextPanePlayer(JTextPane textPanePlayer) {
		this.textPanePlayer = textPanePlayer;
	}

	/**
	 * @param textPaneDesNPC
	 *            the textPaneDesNPC to set
	 */
	public void setTextPaneDesNPC(String description) {
		this.textPaneDesNPC.setText(description);
	}

	/**
	 * @param textPanelDesInventory
	 *            the textPanelDesInventory to set
	 */
	public void settextPanelDesInventory(String description) {
		this.textPanelDesInventory.setText(description);
	}

	/**
	 * @param listNPC
	 *            the listNPC to set
	 */
	public void setListNPC(JList listNPC) {
		this.listNPC = listNPC;
	}

	/**
	 * @param progressBarHealth
	 *            the progressBarHealth to set
	 */
	public void setProgressBarHealth(int percentHealth) {
		this.progressBarHealth.setValue(percentHealth);
	}

	/**
	 * @param progressBarCorruption
	 *            the progressBarCorruption to set
	 */
	public void setProgressBarCorruption(int percentCorruption) {
		progressBarCorruption.setValue(percentCorruption);
	}

	public void updateDirectionButton(boolean bEast, boolean bNorth, boolean bWest, boolean bSouth) {
		btnNorth.setEnabled(bNorth);
		btnSouth.setEnabled(bSouth);
		btnWest.setEnabled(bSouth);
		btnEast.setEnabled(bEast);
	}

	public void updateProgressBar(int percentHealth, int percentCorruption) {
		progressBarCorruption.setValue(percentCorruption);
		progressBarCorruption.setString("Cp :" + percentCorruption + " %");
		progressBarHealth.setValue(percentHealth);
		progressBarHealth.setString("Hp :" + percentHealth + " %");
	}

	public void updateList(ArrayList<NPC> plistNPC, ArrayList<Item> plistItem) {
		listNPC = new JList(plistNPC.toArray());
		listInventory = new JList(plistItem.toArray());
	}

	public void updateImage(String url) {
		ImageHome = new JLabel(new ImageIcon(url));
	}

	public void updatePromptWithRoomDescription(String description) {
		setScript(description);
	}

	public void updateAll() {
		boolean bNorth, bEast, bSouth, bWest;
		bNorth = game.getPlayer().getCurrentRoom().getExits().containsKey("north");
		bSouth = game.getPlayer().getCurrentRoom().getExits().containsKey("south");
		bWest = game.getPlayer().getCurrentRoom().getExits().containsKey("west");
		bEast = game.getPlayer().getCurrentRoom().getExits().containsKey("east");
		this.updateDirectionButton(bEast, bNorth, bWest, bSouth);
		this.updateProgressBar(game.getPlayer().getHp(), game.getPlayer().getCorruption());
		this.updateList(game.getPlayer().getFellowship(), game.getPlayer().getInventory());
		this.updateImage(game.getPlayer().getCurrentRoom().getImg());
		this.updatePromptWithRoomDescription(game.getPlayer().getCurrentRoom().getDescription());
	}

	/**
	 * @param game2
	 */
	public void setGame(Game game) {
		this.game = game;
	}
}