package productivecode;

import java.util.HashMap;
import java.util.Map;

public final class ModuleService {
	private static Map<Class<?>, Object> moduleMap = new HashMap<>();

	static {
		registerProductiveModules();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getModule(Class<T> clazz) {
		return (T) moduleMap.get(clazz);
	}

	public static void registerProductiveModules() {
		setModule(ISomeModule.class, new ProductiveModule());
	}

	public static <T> void setModule(Class<T> clazz, T module) {
		moduleMap.put(clazz, module);
	}
}