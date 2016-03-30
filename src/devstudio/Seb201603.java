package devstudio;

import java.io.FileNotFoundException;
import java.util.Calendar;

import devstudio.model.Constants;
import devstudio.model.Csv;
import devstudio.model.MonthlyReport;
import devstudio.model.Seb;

public class Seb201603 {
	public static void main(String[] args) throws FileNotFoundException {
		MonthlyReport report = new MonthlyReport(2016, Calendar.MARCH);
		Seb seb = new Seb(Constants.PROJECT_DEBUSSY);

		report.newDay(seb.dev());
		report.newDay(seb.meeting(seb.dev(), Constants.ONE_HOUR));
		report.newDay(seb.test());
		report.newDay(seb.test());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting(seb.dev(), Constants.ONE_HOUR));
		report.newDay(seb.test());
		report.newDay(seb.test());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting(seb.dev(), Constants.ONE_HOUR));
		report.newDay(seb.test());
		report.newDay(seb.test());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.test());
		report.newDay(seb.test());

		report.newDay(seb.dev());
		report.newDay(seb.dev());
		report.newDay(seb.meeting(seb.dev(), Constants.ONE_HOUR));
		report.newDay(seb.test());

		Csv.writeReport(report);
	}
}
