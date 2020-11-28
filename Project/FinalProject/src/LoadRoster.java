import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class LoadRoster extends World {
	
	public void loadRoster(Source source) throws IOException {
		source.clearRoster();
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "CSV", "csv");
		fileChooser.setFileFilter(filter);
		
		int returnCsv = fileChooser.showOpenDialog(getParent());
	    if(returnCsv == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            fileChooser.getSelectedFile().getName());
	       String row;
	       BufferedReader csvReader = new BufferedReader(new FileReader(fileChooser.getSelectedFile().getPath()));
	       while ((row = csvReader.readLine()) != null) {
	           String[] data = row.split(",");
	           
	           Person person = new Person(data[0], data[1], data[2], data[3], data[4], data[5]);
	           source.updateRoster(person);
	       }
	       source.rosterCompleted();
	       csvReader.close();
	    }
	}

}
