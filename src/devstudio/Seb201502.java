package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Activity;
import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201502 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2015, Calendar.FEBRUARY);
		Seb seb = new Seb(Constants.PROJECT_CALYPSO);

		report.newDay(seb.dev());
		report.newDay(seb.dev().setGreedyActivity(Activity.OTHER));
		report.newDay(seb.noDaily(seb.dev()).setGreedyActivity(Activity.OTHER));
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting1h(seb.dev()));
		report.newDay(seb.dev());
		report.newDay(seb.halfDayOff(seb.dev()));

		Csv.writeReport(report);
	}
}
