package devstudio.model;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Day {

	public final static Double HALF_HOUR = 0.5;
	public final static Double ONE_HOUR = 1.;
	public final static Double TWO_HOURS = 2 * ONE_HOUR;
	public final static Double FOUR_HOUR = 4 * ONE_HOUR;
	public final static Double HALF_DAY = FOUR_HOUR;
	public final static Double FULL_DAY = 8 * ONE_HOUR;

	public final static Double GREEDY = Double.MAX_VALUE;
	public final static Double NOTHING = 0.;
	public final static Double DAILY_MEETING = HALF_HOUR;

	public final static Day WEEKEND = new Day();
	public final static Day CONGE = new Day(Activity.CONGE);

	/**
	 * Attributes
	 */
	private Activity greedyActivity = null;
	private final Map<Activity, Double> activities = new TreeMap<>();

	public Day() {
	}

	public Day(Activity activity) {
		setGreedyActivity(activity);
	}

	public Day addSubActivity(Activity activity, Double workLoad) {
		assert workLoad != GREEDY;
		assert workLoad >= NOTHING;
		Double load = activities.get(activity);
		if (load == null) {
			activities.put(activity, workLoad);
		} else {
			assert load + workLoad <= FULL_DAY;
			activities.put(activity, load + workLoad);
		}
		getFixedLoad();
		return this;
	}

	public Day removeSubActivity(Activity activity) {
		activities.remove(activity);
		return this;
	}

	public Double getFixedLoad() {
		Double out = NOTHING;
		for (Entry<Activity, Double> e : activities.entrySet()) {
			out += e.getValue();
		}
		assert out <= FULL_DAY;
		return out;
	}

	public Double getWork(Activity activity) {
		Double out = NOTHING;
		if (activity == greedyActivity) {
			out = FULL_DAY - getFixedLoad();
		} else if (activities.containsKey(activity)) {
			out = activities.get(activity);
		}
		return out;
	}

	public Day setGreedyActivity(Activity greedyActivity) {
		this.greedyActivity = greedyActivity;
		return this;
	}
}
