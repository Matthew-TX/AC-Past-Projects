import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Starter06{
//Text Writing
	public static void TextWriting(String fileName) 
	{
		
		String working = System.getProperty("user.dir");
		Path noPathWrite = Paths.get(working,fileName);
		System.out.println(noPathWrite.toString());
		File simpleWriter = noPathWrite.toFile();
		PrintWriter pw = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(simpleWriter);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
				
			
			UnsortedLinkedList<Integer> ll = new UnsortedLinkedList<>();
			ll.add(2);
			ll.add(0);
			ll.add(11037);
			ll.add(9585);
			ll.add(8574);
			ll.add(214);
			ll.add(546);
			
			for(int i = 0; i<ll.getSize(); i++)
			{
				try {
					pw.print(ll.get(i).toString() + ", ");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				
								
		} catch (IOException ex){
			System.err.println("Error with file :"+ex.getMessage());
			}
		
		finally {
			if(pw!=null){
				pw.close();
			}
		}

	}

//Text Loading
	public static void ReadWriting(String fileName) {
		String working = System.getProperty("user.dir");
		System.out.println(working);
		Path noPath = Paths.get(working, fileName);
		File simpleData = noPath.toFile();
		
		FileReader fr = null;
		BufferedReader br = null;
		try{
		
			fr = new FileReader(simpleData);
			br = new BufferedReader(fr);
		
			System.out.println(br.readLine());
			
		} catch (IOException e){
					System.err.println("ERROR accessing "+e.getMessage());
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
	
//writeObjLinkedList
	public static void writeObjLinkedList(String fileName) {
		
		UnsortedLinkedList<Integer> ll = new UnsortedLinkedList<>();
		ll.add(50);
		ll.add(-120);
		ll.add(-0);
		ll.add(-70);
		ll.add(60);
		ll.add(3050);
		
		File objectFile = Paths.get(fileName).toFile();	
			try( 	
					FileOutputStream fos = new FileOutputStream(objectFile); 
					ObjectOutputStream oos = new ObjectOutputStream(fos);
				)
				{
					oos.writeObject(ll);
				}
			catch(FileNotFoundException e){
				System.err.println("Unale to locate file "+objectFile.getAbsolutePath());
			}
			catch(IOException e){
				System.err.println("Unable to store data in "+objectFile.getAbsolutePath());
			}
		
	}
	
//readObjLinkedList
public static void readObjLinkedList(String fileName) {
	File objectFile = Paths.get(fileName).toFile();	
	try(
			FileInputStream fos = new FileInputStream(objectFile);
			ObjectInputStream ois = new ObjectInputStream(fos);
		){
		UnsortedLinkedList<Integer> ll = new UnsortedLinkedList<Integer>();
		ll = (UnsortedLinkedList<Integer>) ois.readObject();
		
		System.out.println(ll.toString());
		
	}catch(FileNotFoundException e){
		System.err.println("Unale to locate file "+objectFile.getAbsolutePath());
	}catch(IOException e){
		System.err.println("Unable to Read data from "+objectFile.getAbsolutePath());
	}catch(ClassNotFoundException e){
		System.err.println("Couldn't find proper class");
	}
		
	}
	
	
	//readObjLinkedList
	
	public static void main(String[] args) {
		//Text File Methods
		String textFileName = "sample.txt";
//		TextWriting(textFileName);
		ReadWriting(textFileName);
		
//		//Object File Methods
//		String objectFileName = "LinkedListObject.ll";
//		writeObjLinkedList(objectFileName);
//		readObjLinkedList(objectFileName);
	

	}

}
