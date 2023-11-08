import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JEditorPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.MenuElement;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Checkbox;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
public class WindowsBuilder {

	private JFrame frmGameSelector;
	private JTextField companySave;
	private JTextField descriptionSave;
	private JTextField gameSave;
	private JTextField SaveCancelTextBox;
	private JTextField PriceDefault;
	private JTextField DescriptionDefault;
	private JTextField CompanyDefault;
	ArrayList <gameFileObject> gameFileArray = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
			 public void run() {
				 try {
					 WindowsBuilder window = new WindowsBuilder();
					 window.frmGameSelector.setVisible(true);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });
	 }

	 /**
	  * Create the application.
	  */
	 public WindowsBuilder() {
		 initialize();
	 }

	 /**
	  * Initialize the contents of the frame.
	  */
	 private void initialize() {
		

	 //View
		 frmGameSelector = new JFrame();
		 frmGameSelector.setTitle("Game Selector");
		 frmGameSelector.setBounds(100, 100, 800, 600);
		 frmGameSelector.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 ButtonGroup radioBG= new ButtonGroup();

		 ButtonGroup typeCeckBoxGroup= new ButtonGroup();

		 JMenuBar menuBar = new JMenuBar();
		 frmGameSelector.setJMenuBar(menuBar);

		 JMenu mnNewMenu = new JMenu("New");
		 menuBar.add(mnNewMenu);

		 JButton saveButton = new JButton("Save");

		 //View Start
		 JMenu mnNewMenu_1 = new JMenu("View");
		 menuBar.add(mnNewMenu_1);

		 JMenuItem mntmNewMenuItem = new JMenuItem("Add Image");
		 mnNewMenu_1.add(mntmNewMenuItem);
		 //View End

		 //Quit Start			
		 JMenu mnNewMenu_2 = new JMenu("Quit");
		 menuBar.add(mnNewMenu_2);

		 JButton btnNewButton_2 = new JButton("Quit");
		
		 mnNewMenu_2.add(btnNewButton_2);
		 //Quit End

		 //Default View Start
		 JPanel panel = new JPanel();
		 frmGameSelector.getContentPane().add(panel, BorderLayout.CENTER);
		 GridBagLayout gbl_panel = new GridBagLayout();
		 gbl_panel.columnWidths = new int[] {0, 0, 2};
		 gbl_panel.rowHeights = new int[]{0, 200, 0, 50, 31, 100, 0, 51, 0, 63, 0};
		 gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		 gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 panel.setLayout(gbl_panel);

		
		 
		 
		 JLabel lblNewLabel_3 = new JLabel("Game Image");
		 GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		 gbc_lblNewLabel_3.gridwidth = 2;
		 gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		 gbc_lblNewLabel_3.gridx = 0;
		 gbc_lblNewLabel_3.gridy = 0;
		 panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		 
		
		 
		
		 
		
		 
		 
		 

		 JLabel lblNewLabel_4 = new JLabel("Saved Game");
		 GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		 gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNewLabel_4.gridx = 0;
		 gbc_lblNewLabel_4.gridy = 2;
		 panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		 JLabel lblNewLabel_5 = new JLabel("Company");
		 GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		 gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		 gbc_lblNewLabel_5.gridx = 1;
		 gbc_lblNewLabel_5.gridy = 2;
		 panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		 CompanyDefault = new JTextField();
		 CompanyDefault.setEditable(false);
		 CompanyDefault.setHorizontalAlignment(SwingConstants.CENTER);
		 CompanyDefault.setText("Nintendo");
		 GridBagConstraints gbc_CompanyDefault = new GridBagConstraints();
		 gbc_CompanyDefault.insets = new Insets(0, 0, 5, 0);
		 gbc_CompanyDefault.fill = GridBagConstraints.BOTH;
		 gbc_CompanyDefault.gridx = 1;
		 gbc_CompanyDefault.gridy = 3;
		 panel.add(CompanyDefault, gbc_CompanyDefault);
		 CompanyDefault.setColumns(10);

		 JLabel lblNewLabel_2 = new JLabel("Type");
		 GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		 gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNewLabel_2.gridx = 0;
		 gbc_lblNewLabel_2.gridy = 4;
		 panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		 JLabel lblNewLabel_6 = new JLabel("Country");
		 GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		 gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		 gbc_lblNewLabel_6.gridx = 1;
		 gbc_lblNewLabel_6.gridy = 4;
		 panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		 JPanel CheckBoxDefault = new JPanel();
		 GridBagConstraints gbc_CheckBoxDefault = new GridBagConstraints();
		 gbc_CheckBoxDefault.insets = new Insets(0, 0, 5, 5);
		 gbc_CheckBoxDefault.fill = GridBagConstraints.BOTH;
		 gbc_CheckBoxDefault.gridx = 0;
		 gbc_CheckBoxDefault.gridy = 5;
		 panel.add(CheckBoxDefault, gbc_CheckBoxDefault);

		 JCheckBox ActionCBD = new JCheckBox("Action");
		 ActionCBD.setSelected(true);
		 ActionCBD.setEnabled(false);
		 CheckBoxDefault.add(ActionCBD);

		 JCheckBox AdventureCBD = new JCheckBox("Adventure");
		 AdventureCBD.setSelected(true);
		 AdventureCBD.setEnabled(false);
		 CheckBoxDefault.add(AdventureCBD);

		 JCheckBox PuzzleCBD = new JCheckBox("Puzzle");
		 PuzzleCBD.setEnabled(false);
		 CheckBoxDefault.add(PuzzleCBD);

		 JPanel RBDefault = new JPanel();
		 GridBagConstraints gbc_RBDefault = new GridBagConstraints();
		 gbc_RBDefault.insets = new Insets(0, 0, 5, 0);
		 gbc_RBDefault.fill = GridBagConstraints.BOTH;
		 gbc_RBDefault.gridx = 1;
		 gbc_RBDefault.gridy = 5;
		 panel.add(RBDefault, gbc_RBDefault);


		 JRadioButton USADefault = new JRadioButton("USA");
		 USADefault.setEnabled(false);
		 RBDefault.add(USADefault);

		 JRadioButton JapanDefault = new JRadioButton("Japan");
		 JapanDefault.setSelected(true);
		 JapanDefault.setEnabled(false);
		 RBDefault.add(JapanDefault);

		 JRadioButton CanadaDefault = new JRadioButton("Canada");
		 CanadaDefault.setEnabled(false);
		 RBDefault.add(CanadaDefault);


		 ButtonGroup CountriesDefault = new ButtonGroup();
		 CountriesDefault.add(USADefault);
		 CountriesDefault.add(CanadaDefault);
		 CountriesDefault.add(JapanDefault);

		 JLabel lblNewLabel_7 = new JLabel("Length of Game (Hours)");
		 GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		 gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNewLabel_7.gridx = 0;
		 gbc_lblNewLabel_7.gridy = 6;
		 panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		 JLabel lblNewLabel_9 = new JLabel("Price");
		 GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		 gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		 gbc_lblNewLabel_9.gridx = 1;
		 gbc_lblNewLabel_9.gridy = 6;
		 panel.add(lblNewLabel_9, gbc_lblNewLabel_9);

		 JSlider LengthDefault = new JSlider();
		 LengthDefault.setPaintLabels(true);
		 LengthDefault.setPaintTicks(true);
		 LengthDefault.setValue(10);
		 LengthDefault.setEnabled(false);
		 LengthDefault.setMajorTickSpacing(25);
		 LengthDefault.setMinorTickSpacing(5);
		 GridBagConstraints gbc_LengthDefault = new GridBagConstraints();
		 gbc_LengthDefault.fill = GridBagConstraints.HORIZONTAL;
		 gbc_LengthDefault.insets = new Insets(0, 0, 5, 5);
		 gbc_LengthDefault.gridx = 0;
		 gbc_LengthDefault.gridy = 7;
		 panel.add(LengthDefault, gbc_LengthDefault);


		 PriceDefault = new JTextField();
		 PriceDefault.setHorizontalAlignment(SwingConstants.CENTER);
		 PriceDefault.setText("$60");
		 PriceDefault.setEditable(false);
		 GridBagConstraints gbc_PriceDefault = new GridBagConstraints();
		 gbc_PriceDefault.insets = new Insets(0, 0, 5, 0);
		 gbc_PriceDefault.fill = GridBagConstraints.BOTH;
		 gbc_PriceDefault.gridx = 1;
		 gbc_PriceDefault.gridy = 7;
		 panel.add(PriceDefault, gbc_PriceDefault);
		 PriceDefault.setColumns(10);

		 JLabel lblNewLabel_8 = new JLabel("Description");
		 GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		 gbc_lblNewLabel_8.gridwidth = 2;
		 gbc_lblNewLabel_8.insets = new Insets(20, 0, 5, 0);
		 gbc_lblNewLabel_8.gridx = 0;
		 gbc_lblNewLabel_8.gridy = 8;
		 panel.add(lblNewLabel_8, gbc_lblNewLabel_8);

		 DescriptionDefault = new JTextField();
		
		 
		//Combo Box
		 JComboBox comboBoxDefault = new JComboBox();

		 comboBoxDefault.setModel(new DefaultComboBoxModel( new String[] {"zelda"}));
		 GridBagConstraints gbc_comboBoxDefault = new GridBagConstraints();
		 gbc_comboBoxDefault.fill = GridBagConstraints.HORIZONTAL;
		 gbc_comboBoxDefault.insets = new Insets(0, 0, 5, 5);
		 gbc_comboBoxDefault.gridx = 0;
		 gbc_comboBoxDefault.gridy = 3;
		 panel.add(comboBoxDefault, gbc_comboBoxDefault);
		 

		 //Default View End

		 //New Start
		 JPanel NewGameFilePanel = new JPanel();
		 mnNewMenu.add(NewGameFilePanel);
		 GridBagLayout gbl_NewGameFilePanel = new GridBagLayout();
		 gbl_NewGameFilePanel.columnWidths = new int[]{107, 106, 0, 0};
		 gbl_NewGameFilePanel.rowHeights = new int[]{34, 44, 21, 50, 0, 0, 0, 0, 0, 0, 181, 0, 0, 0};
		 gbl_NewGameFilePanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		 gbl_NewGameFilePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		 NewGameFilePanel.setLayout(gbl_NewGameFilePanel);

		 JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Company");
		 GridBagConstraints gbc_lblNewJgoodiesLabel_1 = new GridBagConstraints();
		 gbc_lblNewJgoodiesLabel_1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNewJgoodiesLabel_1.gridx = 0;
		 gbc_lblNewJgoodiesLabel_1.gridy = 0;
		 NewGameFilePanel.add(lblNewJgoodiesLabel_1, gbc_lblNewJgoodiesLabel_1);

		 JLabel GameLabelS = new JLabel("Game");
		 GridBagConstraints gbc_GameLabelS = new GridBagConstraints();
		 gbc_GameLabelS.insets = new Insets(0, 0, 5, 0);
		 gbc_GameLabelS.gridx = 2;
		 gbc_GameLabelS.gridy = 0;
		 NewGameFilePanel.add(GameLabelS, gbc_GameLabelS);

		 companySave = new JTextField();
		 GridBagConstraints gbc_companySave = new GridBagConstraints();
		 gbc_companySave.insets = new Insets(0, 0, 5, 5);
		 gbc_companySave.fill = GridBagConstraints.HORIZONTAL;
		 gbc_companySave.gridx = 0;
		 gbc_companySave.gridy = 1;
		 NewGameFilePanel.add(companySave, gbc_companySave);
		 companySave.setColumns(10);

		 gameSave = new JTextField();
		 GridBagConstraints gbc_gameSave = new GridBagConstraints();
		 gbc_gameSave.insets = new Insets(0, 0, 5, 0);
		 gbc_gameSave.fill = GridBagConstraints.HORIZONTAL;
		 gbc_gameSave.gridx = 2;
		 gbc_gameSave.gridy = 1;
		 NewGameFilePanel.add(gameSave, gbc_gameSave);
		 gameSave.setColumns(10);

		 JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Game Type");
		 GridBagConstraints gbc_lblNewJgoodiesTitle = new GridBagConstraints();
		 gbc_lblNewJgoodiesTitle.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNewJgoodiesTitle.ipady = 15;
		 gbc_lblNewJgoodiesTitle.gridx = 0;
		 gbc_lblNewJgoodiesTitle.gridy = 2;
		 NewGameFilePanel.add(lblNewJgoodiesTitle, gbc_lblNewJgoodiesTitle);

		 JLabel CountriesTitle = DefaultComponentFactory.getInstance().createTitle("Countries");
		 GridBagConstraints gbc_CountriesTitle = new GridBagConstraints();
		 gbc_CountriesTitle.insets = new Insets(0, 0, 5, 0);
		 gbc_CountriesTitle.gridx = 2;
		 gbc_CountriesTitle.gridy = 2;
		 NewGameFilePanel.add(CountriesTitle, gbc_CountriesTitle);

		 JPanel checkboxSave = new JPanel();
		 GridBagConstraints gbc_checkboxSave = new GridBagConstraints();
		 gbc_checkboxSave.insets = new Insets(0, 0, 5, 5);
		 gbc_checkboxSave.fill = GridBagConstraints.BOTH;
		 gbc_checkboxSave.gridx = 0;
		 gbc_checkboxSave.gridy = 3;
		 NewGameFilePanel.add(checkboxSave, gbc_checkboxSave);

		 JCheckBox ActionSave = new JCheckBox("Action");
		 checkboxSave.add(ActionSave);


		 JCheckBox AdventureSave = new JCheckBox("Adventure");
		 checkboxSave.add(AdventureSave);


		 JCheckBox PuzzleSave = new JCheckBox("Puzzle");
		 checkboxSave.add(PuzzleSave);

		 typeCeckBoxGroup.add(AdventureSave);
		 typeCeckBoxGroup.add(AdventureSave);



		 JPanel buttonsSave = new JPanel();
		 GridBagConstraints gbc_buttonsSave = new GridBagConstraints();
		 gbc_buttonsSave.insets = new Insets(0, 0, 5, 0);
		 gbc_buttonsSave.fill = GridBagConstraints.BOTH;
		 gbc_buttonsSave.gridx = 2;
		 gbc_buttonsSave.gridy = 3;
		 NewGameFilePanel.add(buttonsSave, gbc_buttonsSave);


		 JRadioButton CanadaSave = new JRadioButton("Canada");
		 buttonsSave.add(CanadaSave);
		 radioBG.add(CanadaSave);


		 JRadioButton USASave = new JRadioButton("USA");
		 buttonsSave.add(USASave);

		 radioBG.add(USASave);

		 JRadioButton JapanSave = new JRadioButton("Japan");
		 buttonsSave.add(JapanSave);
		 radioBG.add(JapanSave);

		 JLabel gameLengthSave = DefaultComponentFactory.getInstance().createLabel("Length of Game");
		 gameLengthSave.setBackground(new Color(240, 240, 240));
		 GridBagConstraints gbc_gameLengthSave = new GridBagConstraints();
		 gbc_gameLengthSave.ipady = 15;
		 gbc_gameLengthSave.insets = new Insets(0, 0, 5, 5);
		 gbc_gameLengthSave.gridx = 1;
		 gbc_gameLengthSave.gridy = 4;
		 NewGameFilePanel.add(gameLengthSave, gbc_gameLengthSave);

		 JSlider sliderSave = new JSlider();
		 sliderSave.setPaintLabels(true);
		 sliderSave.setMajorTickSpacing(25);
		 GridBagConstraints gbc_sliderSave = new GridBagConstraints();
		 gbc_sliderSave.insets = new Insets(0, 0, 5, 5);
		 gbc_sliderSave.gridx = 1;
		 gbc_sliderSave.gridy = 7;
		 NewGameFilePanel.add(sliderSave, gbc_sliderSave);

		 JLabel lblNewLabel_1 = new JLabel("Game Description");
		 GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		 gbc_lblNewLabel_1.insets = new Insets(20, 0, 5, 5);
		 gbc_lblNewLabel_1.gridx = 1;
		 gbc_lblNewLabel_1.gridy = 9;
		 NewGameFilePanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		 descriptionSave = new JTextField();
		 GridBagConstraints gbc_descriptionSave = new GridBagConstraints();
		 gbc_descriptionSave.insets = new Insets(0, 0, 5, 0);
		 gbc_descriptionSave.gridwidth = 3;
		 gbc_descriptionSave.fill = GridBagConstraints.BOTH;
		 gbc_descriptionSave.gridx = 0;
		 gbc_descriptionSave.gridy = 10;
		 NewGameFilePanel.add(descriptionSave, gbc_descriptionSave);
		 descriptionSave.setColumns(10);

		 JPanel panel_3 = new JPanel();
		 GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		 gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		 gbc_panel_3.fill = GridBagConstraints.BOTH;
		 gbc_panel_3.gridx = 1;
		 gbc_panel_3.gridy = 12;
		 NewGameFilePanel.add(panel_3, gbc_panel_3);

		


		 panel_3.add(saveButton);
		 JButton btnNewButton_1 = new JButton("Cancel");
		 panel_3.add(btnNewButton_1);
		 btnNewButton_1.addActionListener(event-> 
		 {

		 });



		
		 
 //Model
	 //ImageFile Testing
		 ImageFiles test = new ImageFiles();
		 GridBagConstraints gbc_ImageFileBlankPanel = new GridBagConstraints();
		 gbc_ImageFileBlankPanel.gridwidth = 2;
		 gbc_ImageFileBlankPanel.insets = new Insets(0, 0, 5, 5);
		 gbc_ImageFileBlankPanel.fill = GridBagConstraints.BOTH;
		 gbc_ImageFileBlankPanel.gridx = 0;
		 gbc_ImageFileBlankPanel.gridy = 1;
		 panel.add(test, gbc_ImageFileBlankPanel);
		 
		 
		 
		 //ComboBox 
		 File objectFile = Paths.get(" gameFileArray.array").toFile();	
		 try(
				 FileInputStream fos = new FileInputStream(objectFile);
				 ObjectInputStream ois = new ObjectInputStream(fos);
				 ){

			 gameFileArray = (ArrayList<gameFileObject>) ois.readObject();

		 }catch(FileNotFoundException e){
			 System.err.println("Unale to locate file "+objectFile.getAbsolutePath());
		 }catch(IOException e){
			 System.err.println("Unable to Read data from "+objectFile.getAbsolutePath());
		 }catch(ClassNotFoundException e){
			 System.err.println("Couldn't find proper class");
		 }
		 
		 if(gameFileArray!=null)
		 {
			 for(int i =0; i<gameFileArray.size(); i++)
			 {
				 comboBoxDefault.addItem(gameFileArray.get(i).getGameNameString());
			 }
		 }

		 comboBoxDefault.addActionListener(event->
		 {
			 int gameArrayIndex = 0;
			 while(comboBoxDefault.getSelectedItem()!=gameFileArray.get(gameArrayIndex).getGameNameString())
			 {
				 if(comboBoxDefault.getSelectedItem()!=gameFileArray.get(gameArrayIndex).getGameNameString())
				 {
					 gameArrayIndex++;
				 }
			 }	

			 AdventureCBD.setSelected(gameFileArray.get(gameArrayIndex).getAdventureBoolean());
			 ActionCBD.setSelected(gameFileArray.get(gameArrayIndex).getActionBoolean());
			 PuzzleCBD.setSelected(gameFileArray.get(gameArrayIndex).getPuzzleBoolean());
			 
			 CompanyDefault.setText(gameFileArray.get(gameArrayIndex).getCompanyString());
			 DescriptionDefault.setText(gameFileArray.get(gameArrayIndex).getDescriptionString());
			 
			 USADefault.setSelected(gameFileArray.get(gameArrayIndex).getUSABoolean());
			 JapanDefault.setSelected(gameFileArray.get(gameArrayIndex).getJapanBoolean());
			 CanadaDefault.setSelected(gameFileArray.get(gameArrayIndex).getCanadaBoolean());
			 
			 LengthDefault.setValue(gameFileArray.get(gameArrayIndex).getLengthInteger());
			 
			 PriceDefault.setText(null);			  
	 	});
		
		 if(gameFileArray.get(0) == null)
		 {
			gameFileObject original = new gameFileObject("Nintendo", "Zelda", true, true, true, 15, "The original legend of zelda", false, true, false);
			gameFileArray.add(original);
			comboBoxDefault.addItem(original.getGameNameString());
		 }
		 
		 DescriptionDefault.setEditable(false);
		 DescriptionDefault.setText("The original Legend of Zelda.");
		 DescriptionDefault.setText(gameFileArray.get(0).getDescriptionString());
		 DescriptionDefault.setHorizontalAlignment(SwingConstants.CENTER);
		 GridBagConstraints gbc_DescriptionDefault = new GridBagConstraints();
		 gbc_DescriptionDefault.gridwidth = 2;
		 gbc_DescriptionDefault.fill = GridBagConstraints.BOTH;
		 gbc_DescriptionDefault.gridx = 0;
		 gbc_DescriptionDefault.gridy = 9;
		 panel.add(DescriptionDefault, gbc_DescriptionDefault);
		 DescriptionDefault.setColumns(10);
		 btnNewButton_2.addActionListener(event -> System.exit(-1));
		 
		 
		 
	 //Control	 
			
			 saveButton.addActionListener(event-> {
				 Integer lengthSaved = sliderSave.getValue();
				 String descriptionSaved = descriptionSave.getText();	
				 String companySaved = companySave.getText();
				 String gameNameSaved = gameSave.getText();
				 Boolean USAB = USASave.isSelected();
				 Boolean JapanB = JapanSave.isSelected();
				 Boolean CanadaB = CanadaSave.isSelected();			
				 Boolean adventureSavedB = AdventureSave.isSelected();
				 Boolean actionSavedB = ActionSave.isSelected();
				 Boolean puzzleSavedB = PuzzleSave.isSelected();
				 gameFileObject newlySaved = new gameFileObject(companySaved,gameNameSaved,adventureSavedB,actionSavedB,puzzleSavedB,lengthSaved,descriptionSaved,USAB,JapanB,CanadaB);
	
				 //Reset New
				 sliderSave.setValue(50);
				 descriptionSave.setText("");
				 companySave.setText("");
				 gameSave.setText("");
				 USASave.setSelected(false);
				 JapanSave.setSelected(false);
				 CanadaSave.setSelected(false);
				 AdventureSave.setSelected(false);
				 ActionSave.setSelected(false);
				 PuzzleSave.setSelected(false);
	
				 //combobox
				 comboBoxDefault.addItem(newlySaved.getGameNameString());
				 
				 //Save 	
				 gameFileArray.add(newlySaved);
				 try( 	
						 FileOutputStream fos = new FileOutputStream(objectFile); 
						 ObjectOutputStream oos = new ObjectOutputStream(fos);
						 )
				 {
					 oos.writeObject(gameFileArray);
				 }
				 catch(FileNotFoundException e){
					 System.err.println("Unale to locate file "+objectFile.getAbsolutePath());
				 }
				 catch(IOException e){
					 System.err.println("Unable to store data in "+objectFile.getAbsolutePath());
				 }
				 System.out.println(comboBoxDefault.getSelectedItem());
			 });
			 
			 btnNewButton_2.addActionListener( event-> System.exit(-1));
		 
		 //Menu Events
		 mnNewMenu_2.addActionListener(event->{
			 JFrame frame = new JFrame("Do you want to save?");
			 frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			 frame.setSize(300, 200);
			 frame.setVisible(true);

			 JPanel cancelPanel = new JPanel();
			 cancelPanel.setPreferredSize(new Dimension(300,200));
			 cancelPanel.setBackground(Color.white);
			 frame.add(cancelPanel);

			 JButton cancel = new JButton("Cancel");   
			 JButton save = new JButton("Save");

			 cancelPanel.add(cancel);	       
			 cancelPanel.add(save);  
		 });
		 
		 
		 
		 
	 }

	 private static void addPopup(Component component, final JPopupMenu popup) {
		 component.addMouseListener(new MouseAdapter() {
			 public void mousePressed(MouseEvent e) {
				 if (e.isPopupTrigger()) {
					 showMenu(e);
				 }
			 }
			 public void mouseReleased(MouseEvent e) {
				 if (e.isPopupTrigger()) {
					 showMenu(e);
				 }
			 }
			 private void showMenu(MouseEvent e) {
				 popup.show(e.getComponent(), e.getX(), e.getY());
			 }
		 });
	 }
}
