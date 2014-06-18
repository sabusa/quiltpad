package ca.bcit.comp2613.a00192788.util.report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import ca.bcit.comp2613.quiltpad.model.Quilt;

public class Report {

	public static void printReport(ArrayList<Quilt> quilts) {
		
		Logger log = Logger.getLogger(Report.class);
		log.info("Writing to file");
		File list = new File("quiltlist.txt");
		try {		
			FileUtils.writeLines(list, quilts);
		} catch (IOException e) {
			log.error("ERROR", new Exception("IOException"));		
			e.printStackTrace();
		}
	}	
}
