package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201501 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2015, Calendar.JANUARY);
		Seb seb = new Seb(Constants.PROJECT_BRONTES);

		report.newDay(seb.publicHoliday());
		report.newDay(seb.dayOff());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev()).addSubActivity(Activity.OTHER, Constants.HALF_HOUR);
		report.newDay(seb.test());
		report.newDay(seb.test());

		report.newDay(seb.dev().setGreedyActivity(Activity.OTHER));
		report.newDay(seb.dev()).setGreedyActivity(Activity.OTHER).addSubActivity(Activity.SUPPORT_LEGACY, Constants.ONE_HOUR);
		seb.setProjectName(Constants.PROJECT_CALYPSO);
		report.newDay(seb.dev()).addSubActivity(Activity.OTHER, Constants.HALF_HOUR).addSubActivity(Activity.SUPPORT_LEGACY, Constants.TWO_HOURS);
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		Csv.writeReport(report);
	}
}
