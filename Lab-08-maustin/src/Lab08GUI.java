import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.Panel;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import java.awt.Window.Type;

@SuppressWarnings("unused")
public class Lab08GUI extends JPanel{
	private static final long serialVersionUID = -3247647021759581756L;
	private final JTextField enterFIPSField = new JTextField();
	ArrayList<CountyInformationNode> countyInformationArray = new ArrayList<>();
	JFrame frmLabGui = new JFrame();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab08GUI window = new Lab08GUI();
					window.frmLabGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Lab08GUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		//View
		frmLabGui.getContentPane().setBackground(new Color(255, 255, 255));
		frmLabGui.setTitle("Lab 08 GUI");
		frmLabGui.setBounds(100, 100, 800, 600);
		frmLabGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
		frmLabGui.getContentPane().setLayout(gridBagLayout);
		
		CountyMapPanel countyPanel = new CountyMapPanel();
		GridBagConstraints gbc_countyPanel = new GridBagConstraints();
		gbc_countyPanel.insets = new Insets(0, 0, 5, 0);
		gbc_countyPanel.fill = GridBagConstraints.BOTH;
		gbc_countyPanel.gridx = 0;
		gbc_countyPanel.gridy = 0;
		frmLabGui.getContentPane().add(countyPanel, gbc_countyPanel);

		JLabel enterFIPSLabel = DefaultComponentFactory.getInstance().createLabel("FIPS Below");
		GridBagConstraints gbc_enterFIPSLabel = new GridBagConstraints();
		gbc_enterFIPSLabel.insets = new Insets(0, 0, 5, 0);
		gbc_enterFIPSLabel.gridx = 0;
		gbc_enterFIPSLabel.gridy = 1;
		frmLabGui.getContentPane().add(enterFIPSLabel, gbc_enterFIPSLabel);
		GridBagConstraints gbc_enterFIPSField = new GridBagConstraints();
		gbc_enterFIPSField.insets = new Insets(0, 0, 5, 0);
		gbc_enterFIPSField.gridx = 0;
		gbc_enterFIPSField.gridy = 2;
		frmLabGui.getContentPane().add(enterFIPSField, gbc_enterFIPSField);
		enterFIPSField.setColumns(10);

		JLabel FIPSData = DefaultComponentFactory.getInstance().createLabel("Country Data");
		GridBagConstraints gbc_FIPSData = new GridBagConstraints();
		gbc_FIPSData.insets = new Insets(0, 0, 5, 0);
		gbc_FIPSData.gridx = 0;
		gbc_FIPSData.gridy = 3;
		frmLabGui.getContentPane().add(FIPSData, gbc_FIPSData);
		
		JComboBox countyDataField = new JComboBox();
		GridBagConstraints gbc_countyDataField = new GridBagConstraints();
		gbc_countyDataField.fill = GridBagConstraints.BOTH;
		gbc_countyDataField.gridx = 0;
		gbc_countyDataField.gridy = 4;
		frmLabGui.getContentPane().add(countyDataField, gbc_countyDataField);
		
		

//Model
	//Map Loading
		//Link
		String link = "https://raw.githubusercontent.com/nytimes/covid-19-data/master/us-counties.csv";
		URL githubUrl = new URL(link);
		HttpURLConnection githubHTTP = (HttpURLConnection) githubUrl.openConnection();
		Map<String, List<String>> headerMap = githubHTTP.getHeaderFields();

		//Error Handling
		for (String header : headerMap.get(null)) {
			if (header.contains(" 302 ") || header.contains(" 301 ")) {
				link = headerMap.get("Location").get(0);
				githubUrl = new URL(link);
				githubHTTP = (HttpURLConnection) githubUrl.openConnection();
				headerMap = githubHTTP.getHeaderFields();
			}
		}

		//Load Link and Make Array
		InputStream dataStream = githubHTTP.getInputStream();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(dataStream, "UTF-8"));
			br.readLine();
			String lineOData = br.readLine();
			
			int countyNYTIndex = 0;
			
			while (lineOData != null) {
				String[] brokenLine = lineOData.split(",");
				if(brokenLine.length==6)
				{
				countyInformationArray.add(new CountyInformationNode(brokenLine[0], brokenLine[1], brokenLine[2], brokenLine[3], brokenLine[4], brokenLine[5]));
				}		
				countyNYTIndex++;
				lineOData = br.readLine();
			}
			
		//Catch and Finally
		} catch (IOException ex){
			System.err.println("ERROR accessing :"+ex.getMessage());
		} finally {
			try {
				if(br != null){
					br.close();
				}
			} catch (IOException ex){
				ex.printStackTrace();
				System.exit(-1);
			}
		}
		
		//FIPS Field Events
		enterFIPSField.addActionListener( event -> 
		{
			countyDataField.removeAllItems();
			int i =0;
			while(i<countyInformationArray.size())
			{
				if(enterFIPSField.getText().equals(countyInformationArray.get(i).getFIPS()))
				{
//					countyDataField.setText(countyInformationArray.get(i).toString());
					countyDataField.addItem(countyInformationArray.get(i));	
				}
				i++;
			}	
			enterFIPSField.setText("");				
			countyPanel.repaint();
		});
	}
}