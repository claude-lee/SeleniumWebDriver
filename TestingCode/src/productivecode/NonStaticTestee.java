package productivecode;

import java.util.Date;

public class NonStaticTestee {

	private ISomeModule dependeny;

	public NonStaticTestee() {
		// In a DPI container, we would use @Inject on the member
		// declaration instead of the following line
		dependeny = ModuleService.getModule(ISomeModule.class);
	}

	public Date doSomething() {
		return dependeny.getDate();
	}
}