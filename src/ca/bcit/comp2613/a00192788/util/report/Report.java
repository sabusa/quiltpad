package ca.bcit.comp2613.a00192788.util.report;

import java.util.ArrayList;

import ca.bcit.comp2613.quiltpad.model.Quilt;

public class Report {

	public static void printReport(ArrayList<Quilt> quilts) {
		for (Quilt quilt : quilts) {
			System.out.println("New Quilt\n");
			System.out.println(quilt);
			System.out.println("----------------------------------------------"
					+ "--------------------------------------------\n\n");
		}
	}	
}
