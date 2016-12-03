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
import javax.swing.DefaultListModel;
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
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Rectangle;

public class Window extends JFrame {
    private JPanel panelLeft, panelDirection, panelSU, panelImage, panelRight, panelInfoTopPlayer, panelInfoPlayer,
	 panelinfoBottom, panelNPC, panelInventory;
    private JButton btnWest, btnEast, btnNorth, btnSouth, btnSearch, btnPickUp, btnframeMap, btnUseNPC, btnDropNPC,
	    btnUseItem, btnDropItem;
    private JTextPane textPanePrompt, textPanePlayer, textPaneDesNPC, textPaneDesInventory;
    private JLabel ImageHome;
    private JProgressBar progressBarHealth, progressBarCorruption;
    private JScrollPane scrollBar;
    private DefaultListModel<String> modelNPC, modelInventory;
    // Other variables
    private Game game;
    private JList<String> listNPC;
    private JList<String> listInventory;
    private JLabel iconPlayer;


    // public static void main(String[] arg) {
    // Window window = new Window();
    // }
    public Window() {
	this.setVisible(true);
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
		String textCurrentRoom = game.getPlayer().getCurrentRoom().getDescription();
		String textCurrentRoomExits = game.getPlayer().getCurrentRoom().toStringExits();
		updateAll();
		setScript(textCurrentRoom);
		setScript(textCurrentRoomExits);
		
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
		String textCurrentRoom = game.getPlayer().getCurrentRoom().getDescription();
		String textCurrentRoomExits = game.getPlayer().getCurrentRoom().toStringExits();
		updateAll();
		setScript(textCurrentRoom);
		setScript(textCurrentRoomExits);
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
		String textCurrentRoom = game.getPlayer().getCurrentRoom().getDescription();
		String textCurrentRoomExits = game.getPlayer().getCurrentRoom().toStringExits();
		updateAll();
		setScript(textCurrentRoom);
		setScript(textCurrentRoomExits);
		
		
	    }
	});
	panelDirection.add(btnNorth, BorderLayout.NORTH);
	btnSouth = new JButton(new ImageIcon("src/gui/image/southArrow.png"));
	btnSouth.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		game.getPlayer().goRoom("south");
		String textCurrentRoom = game.getPlayer().getCurrentRoom().getDescription();
		String textCurrentRoomExits = game.getPlayer().getCurrentRoom().toStringExits();
		setScript(textCurrentRoomExits);
		updateAll();
		setScript(textCurrentRoom);
		setScript(textCurrentRoomExits);
		
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
	// Search
	btnSearch = new JButton(new ImageIcon("src/gui/image/oeil.gif"));
	btnSearch.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		ArrayList<Item> arrayItem = game.getPlayer().getCurrentRoom().getItemList();
		ArrayList<NPC> arrayNPC = game.getPlayer().getCurrentRoom().getNPCList();
		if (!arrayItem.isEmpty()) {
		    setScript("Here you can find : ");
		    for (Item item : arrayItem) {
			setScript(
				item.getName() + ": " + item.getDescription() + " (Weight: " + item.getWeight() + ")");
		    }
		} else {
		    setScript("No item here.");
		}
		
		if (!arrayNPC.isEmpty()) {
		    setScript("Here you can meet : ");
		    for (NPC npc : arrayNPC) {
			setScript(
				npc.getName() + ": " + npc.getDescription());
		    }
		} else {
		    setScript("Nobody is here");
		}
	    }
	});
	btnSearch.setToolTipText("Search");
	btnSearch.setOpaque(false);
	btnSearch.setBorderPainted(false);
	btnSearch.setContentAreaFilled(false);
	panelSU.add(btnSearch);
	// PickUp
	btnPickUp = new JButton(new ImageIcon("src/gui/image/Hand-icon2.png"));
	btnPickUp.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		for (Item item : new ArrayList<Item>(game.getPlayer().getCurrentRoom().getItemList()))     
		{
		    if(game.getPlayer().pickUpItem(item)){
			setScript(item.getName()+ " has been picked up.");
			
		    } updateAll();
		}
		
		for (NPC npc : new ArrayList<NPC>(game.getPlayer().getCurrentRoom().getNPCList()))     
		{
		    if(game.getPlayer().pickUpNPC(npc)){
			setScript(npc.getName()+ " has joined you community.");
			
		    } updateAll();
		}
		
		
//		for (Iterator<Item> iterator = game.getPlayer().getCurrentRoom().getItemList().iterator(); iterator
//			.hasNext();) {
//		    Item item = iterator.next();
//		    if (game.getPlayer().pickUpItem(item)) {
//			setScript(item.getName() + " has been picked up ! ");
//		    } else {
//			setScript(item.getName() + "is to heavy for you.");
//		    }
//		}
	    }
	});
	btnPickUp.setToolTipText("Pick Up");
	btnPickUp.setOpaque(false);
	btnPickUp.setBorderPainted(false);
	btnPickUp.setContentAreaFilled(false);
	panelSU.add(btnPickUp);
	btnframeMap = new JButton(new ImageIcon("src/gui/image/map2.png"));
	btnframeMap.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		JFrame frameMapImg = new JFrame();
		frameMapImg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMapImg.setVisible(true);
		frameMapImg.setTitle("Map of the game");
		JPanel panelImg = new JPanel();
		JLabel myImg = new JLabel(new ImageIcon("src/gui/image/fullMapView.jpg"));
		panelImg.add(myImg);
		frameMapImg.getContentPane().add(panelImg);
		frameMapImg.pack();
		frameMapImg.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
			myImg.setIcon(new ImageIcon("src/gui/image/fullMapViewZoom.jpg"));
			scrollBar = new JScrollPane();
			scrollBar.setViewportView(myImg);
			frameMapImg.getContentPane().add(scrollBar);
		    }
		});
	    }
	});
	btnframeMap.setToolTipText("Map of the frame");
	btnframeMap.setOpaque(false);
	btnframeMap.setBorderPainted(false);
	btnframeMap.setContentAreaFilled(false);
	panelSU.add(btnframeMap);
	
	JScrollPane scrollPanePrompt = new JScrollPane();
	scrollPanePrompt.setMaximumSize(new Dimension(424, 160));
	scrollPanePrompt.setBounds(320, 417, 424, 160);
	panelLeft.add(scrollPanePrompt);
	textPanePrompt = new JTextPane();
	scrollPanePrompt.setViewportView(textPanePrompt);
	textPanePrompt.setToolTipText("Command prompt : displays a lot of informations");
	textPanePrompt.setFont(new Font("Roboto", Font.PLAIN, 12));
	textPanePrompt.setForeground(Color.WHITE);
	textPanePrompt.setBackground(Color.BLACK);
	//
	//
	panelImage = new JPanel();
	ImageHome = new JLabel(new ImageIcon("src/gui/image/roomBilboHouseStart.jpg"));// Test
									    // image
	panelImage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	panelImage.setBounds(12, 12, 732, 393);
	panelImage.add(ImageHome);
	panelLeft.add(panelImage);
	panelImage.setLayout(new GridLayout(0, 1, 0, 0));
	//
	panelRight = new JPanel();
	panelRight.setBackground(Color.BLACK);
	//panelRight.setForeground(Color.BLACK);
	panelRight.setBorder(null);
	//panelRight.setBackground(new Color(218, 165, 32));
	panelRight.setBounds(756, 0, 404, 589);
	this.getContentPane().add(panelRight);
	panelRight.setLayout(new GridLayout(3, 1, 0, 0));
	panelInfoPlayer = new JPanel();
	panelInfoPlayer.setForeground(Color.BLACK);
	panelRight.add(panelInfoPlayer);
	panelInfoPlayer.setLayout(new GridLayout(2, 0, 0, 0));
	panelInfoTopPlayer = new JPanel();
	panelInfoTopPlayer.setBorder(null);
	panelInfoTopPlayer.setLayout(null);
	panelInfoPlayer.add(panelInfoTopPlayer);
	textPanePlayer = new JTextPane();
	textPanePlayer.setFont(new Font("Roboto Light", Font.PLAIN, 17));
	textPanePlayer.setText("Faire une description styl\u00E9e de frodo ici, ou mettre une image. Game designer un avis ?");
	textPanePlayer.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	textPanePlayer.setBounds(96, 12, 296, 74);
	panelInfoTopPlayer.add(textPanePlayer);
	textPanePlayer.setEditable(false);
	
	iconPlayer = new JLabel("Frodo");
	iconPlayer.setIcon(new ImageIcon(Window.class.getResource("/gui/image/frodo.png")));
	iconPlayer.setBounds(10, 12, 76, 74);
	panelInfoTopPlayer.add(iconPlayer);
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
	progressBarCorruption.setToolTipText("Corruption points, if they are equal to 0 you're dead !");
	progressBarCorruption.setString("Cp : 0 %");
	progressBarCorruption.setBounds(12, 53, 380, 37);
	progressBarCorruption.setStringPainted(true);
	progressBarCorruption.setBackground(Color.WHITE);
	panelinfoBottom.add(progressBarCorruption);
	//PANEL NPC
	panelNPC = new JPanel();
	panelNPC.setLayout(null);
	panelRight.add(panelNPC);
	//BUTTON NPC
	btnUseNPC = new JButton("Use");
	btnUseNPC.setFont(new Font("Roboto", Font.PLAIN, 16));
	btnUseNPC.setBounds(166, 11, 108, 50);
	panelNPC.add(btnUseNPC);
	btnDropNPC = new JButton("Drop");
	btnDropNPC.setFont(new Font("Roboto", Font.PLAIN, 16));
	btnDropNPC.setBounds(284, 11, 108, 50);
	panelNPC.add(btnDropNPC);
	//Description NPPC
	textPaneDesNPC = new JTextPane();
	textPaneDesNPC.setText("Description");
	textPaneDesNPC.setEditable(false);
	textPaneDesNPC.setBounds(166, 72, 226, 113);
	panelNPC.add(textPaneDesNPC);
	//List item
	modelNPC = new DefaultListModel();
	modelNPC.addElement("letest");
	listNPC = new JList(modelNPC);
	listNPC.setFont(new Font("Roboto", Font.PLAIN, 11));
	listNPC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	listNPC.setBounds(10, 11, 146, 174);
	panelNPC.add(listNPC);
	//
	//PANEL INVENTORY
	panelInventory = new JPanel();
	panelInventory.setLayout(null);
	panelRight.add(panelInventory);
	//BTN Inventory
	btnUseItem = new JButton("Use");
	btnUseItem.setFont(new Font("Roboto", Font.PLAIN, 16));
	btnUseItem.setBounds(166, 11, 108, 50);
	panelInventory.add(btnUseItem);
	btnDropItem = new JButton("Drop");
	btnDropItem.setFont(new Font("Roboto", Font.PLAIN, 16));
	btnDropItem.setBounds(284, 11, 108, 50);
	panelInventory.add(btnDropItem);
	//Decription Invetory
	textPaneDesInventory = new JTextPane();
	textPaneDesInventory.setText("Description");
	textPaneDesInventory.setEditable(false);
	textPaneDesInventory.setBounds(166, 72, 226, 113);
	panelInventory.add(textPaneDesInventory);
	//list Inventory
	modelInventory = new DefaultListModel();
	modelInventory.addElement("azer");
	listInventory = new JList(modelInventory);
	listInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	listInventory.setFont(new Font("Roboto", Font.PLAIN, 11));
	listInventory.setBounds(10, 11, 146, 174);
	panelInventory.add(listInventory);
    }


    /**
     * Add a line to the command prompt
     * 
     * @param script
     *            The line which has to be added
     */
    public void setScript(String script) {
	String currentText = textPanePrompt.getText();
	// textPanePrompt.setText("");
	this.textPanePrompt.setText(currentText+"\n"+script);
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
	this.textPaneDesInventory.setText(description);
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

    public void updateImage(String url) {
	ImageIcon image = new ImageIcon(url);
	ImageHome.setIcon(image);
    }

    public void updatePromptWithRoomDescription(String description) {
	setScript(description);
    }

    public void updateInventory() {
	modelInventory.clear();
	for (Item item : game.getPlayer().getInventory()) {
	    modelInventory.addElement(item.getName());
	}
	listInventory = new JList<>(modelInventory);
    }

    public void updateListNPC() {
	modelNPC.clear();
	for (NPC npc : game.getPlayer().getFellowship()) {
	    modelNPC.addElement(npc.getName());
	}
	listNPC = new JList<>(modelNPC);
    }

    public void updateAll() {

	this.updateProgressBar(game.getPlayer().getHp(), game.getPlayer().getCorruption());
	this.updateListNPC(); //a checker
	this.updateInventory(); // a checker
	
	boolean bNorth, bEast, bSouth, bWest;
	bNorth = game.getPlayer().getCurrentRoom().getExits().containsKey("north");
	bSouth = game.getPlayer().getCurrentRoom().getExits().containsKey("south");
	bWest = game.getPlayer().getCurrentRoom().getExits().containsKey("west");
	bEast = game.getPlayer().getCurrentRoom().getExits().containsKey("east");
	this.updateDirectionButton(bEast, bNorth, bWest, bSouth);
	this.updateImage(game.getPlayer().getCurrentRoom().getImg());
    }

    /**
     * @param game2
     */
    public void setGame(Game game) {
	this.game = game;
    }
}