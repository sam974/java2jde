package devstudio.model;

public interface Constants {

	/**
	 * Projects
	 */
	String PROJECT_ATLANTIS = "CO10004";
	String PROJECT_BACCHUS = "AP14026";
	String PROJECT_BAUCIS = "AP14035";
	String PROJECT_BRONTES = "AP14049";
	String PROJECT_CALYPSO = "AP15012";
	String PROJECT_CASSANDRA = "AP15021";
	String PROJECT_CONCERTO = "AP15024";
	String PROJECT_CORNAMUSE = "AP15032";
	String PROJECT_DEBUSSY = "AP16015";
	String PROJECT_DIAPASON = "AP16020";
	String PROJECT_DISCO = "AP16034";
	String PROJECT_ELECTRO = "AP17012";

	/**
	 * Other projects
	 */
	String PROJECT_LEGATO = "AP17004";
	String PROJECT_LEGACY = "AP10027";
	String PROJECT_MISC = "AP10018";
	String PROJECT_FORMATION = "AP10049";
	String PROJECT_ABSENCE = "XXXX700";

	/**
	 * Tasks
	 */
	String TASK_LEGATO_JAVA = "AF";
	String TASK_DEVEL = "SW";
	String TASK_TEST = "SVT";
	String TASK_TEAMMEETING = "PM";
	String TASK_CONGE = "XPL";
	String TASK_FERIE = "XSH";
	String TASK_MALADIE = "XSL";
	String TASK_OTHER = "ADM";
	String TASK_SUPPORT = "SUP";
	String TASK_TRAVEL = "TRV";

	/**
	 * Time
	 */
	Double WORKLOAD_30min = 0.5;
	Double WORKLOAD_1h = 1.;
	Double WORKLOAD_2h = 2 * WORKLOAD_1h;
	Double WORKLOAD_4h = 4 * WORKLOAD_1h;
	Double WORKLOAD_HALFDAY = WORKLOAD_4h;
	Double WORKLOAD_FULLDAY = 8 * WORKLOAD_1h;

	Double WORKLOAD_NOTHING = 0.;
	Double WORKLOAD_GREEDY = Double.MAX_VALUE;
}
