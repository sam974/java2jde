package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201407 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2014, Calendar.JULY);
		Seb seb = new Seb(Constants.PROJECT_BACCHUS);

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting1h(seb.dev()));
		report.newDay(seb.dev());
		report.newDay(seb.setProjectName(Constants.PROJECT_BAUCIS).noDaily(seb.dev()));

		report.newDay(seb.publicHoliday());
		report.newDay(seb.noDaily(seb.dev()));
		report.newDay(seb.noDaily(seb.dev()));
		report.newDay(seb.noDaily(seb.dev()));
		report.newDay(seb.noDaily(seb.dev()));

		report.newDay(seb.noDaily(seb.dev()));
		report.newDay(seb.noDaily(seb.dev()));
		report.newDay(seb.noDaily(seb.dev()));
		report.newDay(seb.noDaily(seb.dev()));
		report.newDay(seb.noDaily(seb.dev()));

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());

		Csv.writeReport(report);
	}
}
