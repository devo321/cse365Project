import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadAttendance extends World {
	
	public void loadAttendance(Source source, String date) throws IOException {
		
		//monthBox.addActionListener(this);
		//dayBox.addActionListener(this);
		
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "CSV", "csv");
		fileChooser.setFileFilter(filter);
		
		ArrayList<Attendance> noMatchList = new ArrayList<Attendance>();
		int totalUsers = 0;
		
		int returnCsv = fileChooser.showOpenDialog(getParent());
	    if(returnCsv == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            fileChooser.getSelectedFile().getName());
	       String row;
	       BufferedReader csvReader = new BufferedReader(new FileReader(fileChooser.getSelectedFile().getPath()));
	       while ((row = csvReader.readLine()) != null) {
	           String[] data = row.split(",");
	           
	           Attendance a = new Attendance(data[0], Integer.parseInt(data[1]));
	           source.updateAttendance(a, date);
	           if (!source.didFindAsuRite(a.getAsuRite())) {
	        	   noMatchList.add(a);
	           } else {
	        	   totalUsers++;
	           }
	       }
	       csvReader.close();
	    };
	    String message = "Data loaded for users in the roster.";
	    if (noMatchList.size() != 0) {
	    	message += "\n\n" + noMatchList.size() + " additional attendee(s) was found: \n";
	    	for (Attendance a : noMatchList) {
	    		message += "\n" + a.getAsuRite() + " connected for " + a.getTime() + " minutes.";
	    	}
	    }
	    JOptionPane.showMessageDialog(this, message,"Success!", JOptionPane.ERROR_MESSAGE);
	}
	


}
