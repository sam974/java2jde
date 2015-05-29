package devstudio.model;

public interface Constants {
	public final static String ATLANTIS = "atlantis";
	public final static String BACCHUS = "bacchus";
	public final static String BAUCIS = "baucis";
	public static final String BRONTES = "brontes";
	public static final String CALYPSO = "calypso";
	public static final String CASSANDRA = "cassandra";

	public final static String DEVEL = "dev";
	public final static String DAILY = "misc";
	public final static String TEST = "test";

	public final static Double HALF_HOUR = 0.5;
	public final static Double ONE_HOUR = 1.;
	public final static Double TWO_HOURS = 2 * ONE_HOUR;
	public final static Double FOUR_HOUR = 4 * ONE_HOUR;
	public final static Double HALF_DAY = FOUR_HOUR;
	public final static Double FULL_DAY = 8 * ONE_HOUR;

	public final static Double NOTHING = 0.;
	public final static Double DAILY_MEETING = HALF_HOUR;
	public final static Double GREEDY = Double.MAX_VALUE;
}
