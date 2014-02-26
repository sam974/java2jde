package devstudio.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MonthlyReport {

	private final List<Day> days = new ArrayList<>();

	private final int firstDayOfMonth;
	private final int dayCount;
	private final int year;
	private final int month;
	private Day lastDay = null;

	public MonthlyReport(int year, int month) {
		this.year = year;
		this.month = month;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		this.firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
		this.dayCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public Day newDay(Day day) {
		switch ((days.size() % 7) + firstDayOfMonth) {
		case Calendar.SUNDAY:
			days.add(Day.WEEKEND);
			break;
		case Calendar.SATURDAY:
			days.add(Day.WEEKEND);
			days.add(Day.WEEKEND);
			break;
		default:
			break;
		}
		days.add(lastDay = day);
		return lastDay;
	}

	public List<Day> getFirstReport() {
		List<Day> out = new ArrayList<>();
		for (Day day : days.subList(0, Math.min(15, days.size()))) {
			if (day != Day.WEEKEND) {
				out.add(day);
			}
		}
		return out;
	}

	public List<Day> getSecondReport() {
		List<Day> out = new ArrayList<>();
		for (Day day : days.subList(Math.min(15, days.size()), Math.min(dayCount, days.size()))) {
			if (day != Day.WEEKEND) {
				out.add(day);
			}
		}
		return out;
	}

	public Day getLastDay() {
		return lastDay;
	}

	public String getIdentifier() {
		return String.format("%d-%02d", year, month + 1);
	}
}
