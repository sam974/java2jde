package devstudio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Csv;
import devstudio.model.Day;
import devstudio.model.Helper;
import devstudio.model.MonthlyReport;

public class SampleReport {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2014, Calendar.JANUARY);

		report.newDay(Helper.bacchusDay()).addSubActivity(Activity.CONGE, Day.HALF_DAY);
		report.newDay(Helper.bacchusDay()).addSubActivity(Activity.CONGE, Day.HALF_DAY);
		report.newDay(Helper.bacchusDay()).addSubActivity(Activity.CONGE, Day.HALF_DAY);

		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.atlantisDay());

		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.atlantisDay());

		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.atlantisDay());
		report.newDay(Helper.bacchusDay()).addSubActivity(Activity.CONGE, Day.HALF_DAY);
		report.newDay(Helper.bacchusDay()).addSubActivity(Activity.OTHER, Day.TWO_HOURS);
		report.newDay(Helper.bacchusDay()).addSubActivity(Activity.OTHER, Day.TWO_HOURS);

		report.newDay(Helper.atlantisDay()).setGreedyActivity(Activity.ATLANTIS_TEST);
		report.newDay(Helper.atlantisDay()).setGreedyActivity(Activity.ATLANTIS_TEST);
		report.newDay(Helper.atlantisDay()).setGreedyActivity(Activity.ATLANTIS_TEST);
		report.newDay(Helper.atlantisDay()).setGreedyActivity(Activity.ATLANTIS_TEST);
		report.newDay(Helper.atlantisDay()).setGreedyActivity(Activity.ATLANTIS_TEST);

		Csv writer;
		Csv.setPadItems(true);
		writer = new Csv(new File("output/" + report.getIdentifier() + "a.csv"));
		writer.writeTimesheet(report.getFirstReport());
		writer.close();
		writer = new Csv(new File("output/" + report.getIdentifier() + "b.csv"));
		writer.writeTimesheet(report.getSecondReport());
		writer.close();
	}
}
