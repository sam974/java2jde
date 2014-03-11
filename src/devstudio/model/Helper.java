package devstudio.model;

public class Helper {
	public final static Activity DEV = Activity.BACCHUS_DEV;
	public final static Activity DAILY = Activity.BACCHUS_MISC;

	public static Day atlantisDay() {
		Day out = new Day(Activity.ATLANTIS_DEV);
		out.addSubActivity(Activity.ATLANTIS_MISC, Day.DAILY_MEETING);
		return out;
	}

	public static Day bacchusDay() {
		Day out = new Day(Activity.BACCHUS_DEV);
		out.addSubActivity(Activity.BACCHUS_MISC, Day.DAILY_MEETING);
		return out;
	}

}
