package devstudio.model;

public class Seb {

	private String projectName;

	public Seb(String projectName) {
		this.projectName = projectName;
	}

	public Seb setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}

	public Day test() {
		return daily(new Day(Activity.getTest(projectName)));
	}

	public Day dev() {
		return daily(new Day(Activity.getDevel(projectName)));
	}

	public Day daily(Day in) {
		return in.addSubActivity(Activity.getDaily(projectName), Constants.DAILY_MEETING);
	}

	public Day noDaily(Day in) {
		return in.removeSubActivity(Activity.getDaily(projectName), Constants.DAILY_MEETING);
	}

	public Day halfDayOff(Day in) {
		return in.addSubActivity(Activity.DAYOFF, Constants.HALF_DAY);
	}

	public Day dayOff() {
		Day out = new Day(Activity.DAYOFF);
		return out;
	}

	public Day publicHolyday() {
		Day out = new Day(Activity.PUBLICHOLYDAY);
		return out;
	}

	public Day meeting1h(Day in) {
		return meeting(in, Constants.ONE_HOUR);
	}

	public Day meeting(Day in, Double duration) {
		return in.addSubActivity(Activity.OTHER, duration);
	}
}
