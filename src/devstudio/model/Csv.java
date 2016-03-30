package devstudio.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Csv extends PrintWriter {

	private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat();

	static {
		DecimalFormatSymbols custom = new DecimalFormatSymbols();
		custom.setDecimalSeparator('.');
		DECIMAL_FORMAT.setDecimalFormatSymbols(custom);
		DECIMAL_FORMAT.setMinimumFractionDigits(2);
		DECIMAL_FORMAT.setMaximumFractionDigits(2);
	}

	private static final String COMA = ",";
	private static final String DQ = "\"";

	private static boolean padItems = false;

	public Csv(File file) throws FileNotFoundException {
		super(file);
		System.out.println("--- open ---");
	}

	public Csv(OutputStream out) {
		super(out, true);
	}

	public static void setPadItems(boolean padItems) {
		Csv.padItems = padItems;
	}

	public void writeTimesheet(List<Day> days) {
		for (Activity activity : Activity.values()) {
			String line = getActivityLine(activity, days);
			if (line != null) {
				println(line);
				System.out.println(line);
			}
		}
	}

	@Override
	public void close() {
		System.out.println("--- close ---");
		super.close();
	}

	private String getActivityLine(Activity activity, List<Day> days) {
		List<String> items = new ArrayList<>();
		items.add(item2string("0"));
		items.add(item2string(activity.getProject()));
		items.add(item2string(activity.getTask()));
		boolean hasLoad = false;
		for (Day day : days) {
			Double load = day.getWork(activity);
			hasLoad |= load != Constants.NOTHING;
			String string = DECIMAL_FORMAT.format(load);
			items.add(item2string(string));
		}
		return hasLoad ? StringUtils.join(items, COMA) : null;
	}

	private String item2string(String item) {
		return StringUtils.rightPad(DQ + item + DQ, padItems ? 6 : 0);
	}

	public static void writeReport(MonthlyReport report) throws FileNotFoundException {
		Csv.setPadItems(true);
		try (Csv writer = new Csv(new File("output/" + report.getIdentifier() + "a.csv"))) {
			writer.writeTimesheet(report.getFirstReport());
		}
		try (Csv writer = new Csv(new File("output/" + report.getIdentifier() + "b.csv"))) {
			writer.writeTimesheet(report.getSecondReport());
		}
	}
}
