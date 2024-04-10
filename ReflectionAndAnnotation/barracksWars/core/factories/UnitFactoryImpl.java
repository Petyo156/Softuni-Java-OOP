package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException,
			InvocationTargetException, InstantiationException, IllegalAccessException {
		// TODO: implement for problem 3
		String className = UNITS_PACKAGE_NAME+unitType;
		Class<Unit> unitClass = (Class<Unit>) Class.forName(className);

		Constructor<Unit> declaredConstructor = unitClass.getDeclaredConstructor();

		return declaredConstructor.newInstance();
	}
}
