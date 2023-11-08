import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

@SuppressWarnings("unused")
public class CountyMapPanel extends JPanel{
	static final long serialVersionUID = -6329887291632620008L;
	public static ArrayList<CountyMapNode> countyMapArray = new ArrayList<>();
	
	CountyMapPanel()
	{
		super();

		//Map Coordinate ArrayList 
		String working = System.getProperty("user.dir");
		Path noPath = Paths.get(working, "countyCoords.txt");
		File simpleData = noPath.toFile();
		FileReader fr = null;
		BufferedReader br = null;
		int line = 1;
		int countyIndex = 0;
		Boolean repeat = true;
		try{
			fr = new FileReader(simpleData);
			br = new BufferedReader(fr);
			
			
			while(repeat)
			{
				String FIPS = br.readLine();
				
				if (line == 1 && FIPS!=null)
				{
					countyMapArray.add(countyIndex, new CountyMapNode());	
					countyMapArray.get(countyIndex).setFIPS(Integer.parseInt(FIPS));
					line++;		
				}
				
				if(line == 2 )
				{
					String Population =  br.readLine();
					countyMapArray.get(countyIndex).setFIPS(Integer.parseInt(Population));
					line++;	
				}
				if(line == 3)
				{
					String DataLine = br.readLine();
					String [] spaceSplit = DataLine.split(" ");
					ArrayList<String[]> commaSplit = new ArrayList<>();
					ArrayList<Double> Longitude= new ArrayList<>();
					ArrayList<Double> Lattitude= new ArrayList<>();
					
					for(int i=0; i<spaceSplit.length; i++)
					{
						commaSplit.add(spaceSplit[i].split(","));
						Longitude.add(Double.parseDouble(commaSplit.get(i)[0]));
						Lattitude.add(Double.parseDouble(commaSplit.get(i)[1]));
					}
					
					int [] LongitudeInt = new int[Longitude.size()];
					for(int i =0; i<Longitude.size(); i++)
					{
						LongitudeInt[i] = ((int)((((Longitude.get(i)+66.9))*10000)-1000000)/1000+1700);
					}
					
					int [] LattitudeInt = new int[Lattitude.size()];
					for(int i =0; i<Longitude.size(); i++)
					{
						LattitudeInt[i] = ((int)(((Lattitude.get(i)))*1000)/100)*-1+600;
					}
					countyMapArray.get(countyIndex).setLattitude(LattitudeInt);
					countyMapArray.get(countyIndex).setLongitude(LongitudeInt);							
					line = 1;
					countyIndex++;
				}
				if(FIPS == null)
				{
					repeat = false;
				}
			}
		}
			catch (IOException ex){
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
		
	}
	
	
	public void paintComponent(Graphics g)
	{
		for(int i =0; i<countyMapArray.size(); i++)
		{	
			
			g.setColor(Color.black);
			g.drawPolygon(countyMapArray.get(i).getLongitude(),countyMapArray.get(i).getLattitude() , countyMapArray.get(i).getLattitude().length);
			
		}
			
	}
	
}
