package devstudio.model;

public interface Constants {

	public final static String PROJECT_ATLANTIS = "CO10004";
	public final static String PROJECT_BACCHUS = "AP14026";
	public final static String PROJECT_BAUCIS = "AP14035";
	public static final String PROJECT_BRONTES = "AP14049";
	public static final String PROJECT_CALYPSO = "AP15012";
	public static final String PROJECT_CASSANDRA = "AP15021";
	public static final String PROJECT_CONCERTO = "AP15024";
	public static final String PROJECT_LEGACY = "AP10027";
	public static final String PROJECT_MISC = "AP10018";
	public static final String PROJECT_FORMATION = "AP10049";
	public static final String PROJECT_ABSENCE = "XXXX700";
	
	public final static String TASK_DEVEL = "SW";
	public final static String TASK_TEST = "SVT";
	public final static String TASK_MISC = "PM";
	public final static String TASK_CONGE = "XPL";
	public final static String TASK_FERIE = "XSH";
	public final static String TASK_MALADIE = "XSL";
	public final static String TASK_OTHER = "ADM";

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
