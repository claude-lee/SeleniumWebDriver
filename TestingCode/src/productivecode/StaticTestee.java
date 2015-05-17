package productivecode;

import java.util.Date;

public class StaticTestee {

	private static StaticTestee instance;
	private ISomeModule dependeny;

	private StaticTestee() {
		// hide constructor
	}

	public static StaticTestee getInstance() {
		if (instance == null) {
			instance = new StaticTestee();
		}
		return instance;
	}

	public void setDependeny(ISomeModule dependeny) {
		this.dependeny = dependeny;
	}

	public Date doSomething() {
		return dependeny.getDate();
	}
}