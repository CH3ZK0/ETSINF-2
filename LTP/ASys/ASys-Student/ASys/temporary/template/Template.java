import japa.parser.ast.body.ModifierSet;

import java.lang.reflect.Type;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import codeassess.javassessment.Assessor;
import codeassess.misc.Misc;

public class Template extends Assessor
{
	public Map<String, String> getConfig()
	{
		final Map<String, String> config = new Hashtable<String, String>();

		config.put("Language", "Java");
		config.put("Extensions", ".java");
		config.put("AssessmentMode", "SemiAutomatic");

		return config;
	}
	public List<Object[]> getProperties()
	{
		final List<Object[]> properties = new LinkedList<Object[]>();

		properties.add(new Object[]{ "PilaALIsGeneric", "Functionality", "PilaAL.java", "Debes utilizar \"<…>\"", "PilaAL debe tener un parámetro genérico", 0.75 });
		properties.add(new Object[]{ "PilaALImplementsPila", "Functionality", "PilaAL.java", "Debes utilizar \"implements\"", "PilaAL debe implementar la interfaz Pila<T>", 0.75 });
		properties.add(new Object[]{ "PilaALArrayListField", "Functionality", "PilaAL.java", "Comprueba que hay un atributo de tipo ArrayList<T>", "PilaAL debe utilizar un atributo (ArrayList<T>) para los elementos de la pila", 0.5 });
		properties.add(new Object[]{ "PilaALConstructor", "Functionality", "PilaAL.java", "Comprueba los argumentos del constructor", "Crear el constructor de la clase PilaAL", 0.5 });
		properties.add(new Object[]{ "PilaALApilarMethod", "Functionality", "PilaAL.java", "Comprueba los argumentos del método", "Crear el método apilar en la clase PilaAL", 1.0 });
		properties.add(new Object[]{ "PilaALTallaMethod", "Functionality", "PilaAL.java", "Comprueba los argumentos del método", "Crear el método talla en la clase PilaAL", 1.0 });
		properties.add(new Object[]{ "PilaALDesapilarMethod", "Functionality", "PilaAL.java", "Comprueba los argumentos del método", "Crear el método desapilar en la clase PilaAL", 1.5 });
		properties.add(new Object[]{ "PilaALCimaMethod", "Functionality", "PilaAL.java", "Comprueba los argumentos del método", "Crear el método cima en la clase PilaAL", 1.5 });
		properties.add(new Object[]{ "PilaALEsVaciaMethod", "Functionality", "PilaAL.java", "Comprueba los argumentos del método", "Crear el método esVacia en la clase PilaAL", 1.0 });
		properties.add(new Object[]{ "PilaALToStringMethod", "Functionality", "PilaAL.java", "Comprueba los argumentos del método", "Crear el método toString en la clase PilaAL", 1.5 });

		return properties;
	}

	// PilaAL is generic
	public boolean checkPilaALIsGeneric()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		return super.introspector.getGenericTypeParameterCount(pilaALClass) == 1;
	}
	public boolean solvePilaALIsGeneric()
	{
		return false;
	}
	public boolean testPilaALIsGeneric()
	{
		return true;
	}

	// PilaAL implements Pila
	public boolean checkPilaALImplementsPila()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		if (super.introspector.getGenericTypeParameterCount(pilaALClass) != 1)
			return false;

		final TypeVariable<?>[] genericTypes = super.introspector.getGenericTypeParameters(pilaALClass);
		if (genericTypes.length == 0)
			return false;
		final TypeVariable<?> genericType = genericTypes[0];

		final Class<?> pilaClass = super.introspector.getClass("Pila");
		if (pilaClass == null)
			return false;

		final Class<?>[] pilaALImplements = super.introspector.getInterfaces(pilaALClass);
		if (pilaALImplements.length != 1)
			return false;

		final Class<?> implementsClass = pilaALImplements[0];
		if (!super.introspector.checkSameClasses(implementsClass, pilaClass))
			return false;

		if (super.introspector.getGenericTypeParameterCount(implementsClass) != 1)
			return false;

		final TypeVariable<?> implementClassGenericType = super.introspector.getGenericTypeParameters(implementsClass)[0];

		return super.introspector.checkSameGenericTypes(implementClassGenericType, genericType);
	}
	public boolean solvePilaALImplementsPila()
	{
		return false;
	}
	public boolean testPilaALImplementsPila()
	{
		return true;
	}

	// PilaAL has ArrayList field
	public boolean checkPilaALArrayListField()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		if (super.introspector.getGenericTypeParameterCount(pilaALClass) != 1)
			return false;

		final TypeVariable<?>[] genericTypes = super.introspector.getGenericTypeParameters(pilaALClass);
		if (genericTypes.length == 0)
			return false;
		final TypeVariable<?> genericType = genericTypes[0];

		final Field[] fields = super.introspector.getDeclaredFields(pilaALClass);
		for (Field field : fields)
		{
			if (!super.introspector.checkClass(field, ArrayList.class, true))
				continue;

			if (!super.introspector.checkGenericType(field, 0))
				continue;

			final Type fieldType = super.introspector.getType(field);
			final TypeVariable<?> fieldGenericType = super.introspector.getGenericType(fieldType, new int[] { 0 });
			if (super.introspector.checkSameGenericTypes(fieldGenericType, genericType))
				return true;
		}

		return false;
	}
	public boolean solvePilaALArrayListField()
	{
		return false;
	}
	public boolean testPilaALArrayListField()
	{
		return true;
	}

	// PilaAL has constructor
	public boolean checkPilaALConstructor()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		final Class<?>[] paramTypes = { };

		return super.introspector.checkDeclaredConstructor(pilaALClass, paramTypes, true);
	}
	public boolean solvePilaALConstructor()
	{
		return false;
	}
	public boolean testPilaALConstructor()
	{
		final String testCaseName = "Test01";
		final String testMethodName = "test";
		final Object result = super.tester.executeTestCase(testCaseName, testMethodName);

		return result == null ? false : (Boolean) result;
	}

	// PilaAL apilar method
	public boolean checkPilaALApilarMethod()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		final Class<?>[] paramTypes = { Object.class };

		return super.introspector.checkDeclaredMethod(pilaALClass, "apilar", paramTypes, void.class, true);
	}
	public boolean solvePilaALApilarMethod()
	{
		return false;
	}
	public boolean testPilaALApilarMethod()
	{
		final String testCaseName = "Test02";
		final String testMethodName = "test";
		final Object result = super.tester.executeTestCase(testCaseName, testMethodName);

		return result == null ? false : (Boolean) result;
	}
	private double testPilaALApilarMethod2()
	{
		final String testCaseName = "PilaALApilar";
		final double passedPercentage = super.tester.executeTestCases(testCaseName);

		return Misc.round(passedPercentage, 2);
	}

	// PilaAL desapilar method
	public boolean checkPilaALDesapilarMethod()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		if (super.introspector.getGenericTypeParameterCount(pilaALClass) != 1)
			return false;

		final TypeVariable<?>[] genericTypes = super.introspector.getGenericTypeParameters(pilaALClass);
		if (genericTypes.length == 0)
			return false;
		final TypeVariable<?> genericType = genericTypes[0];

		final Class<?>[] paramTypes = { };
		final Method desapilarMethod = super.introspector.getDeclaredMethod(pilaALClass, "desapilar", paramTypes, true);
		if (desapilarMethod == null)
			return false;

		final Type returnType = super.introspector.getReturnType(desapilarMethod);
		final TypeVariable<?> desapilarReturnType = super.introspector.getGenericType(returnType, new int[] { });
		if (desapilarReturnType == null)
			return false;

		return super.introspector.checkSameGenericTypes(desapilarReturnType, genericType);
	}
	public boolean solvePilaALDesapilarMethod()
	{
		return false;
	}
	public boolean testPilaALDesapilarMethod()
	{
		final String testCaseName = "Test03";
		final String testMethodName = "test";
		final Object result = super.tester.executeTestCase(testCaseName, testMethodName);

		return result == null ? false : (Boolean) result;
	}
	private double testPilaALDesapilarMethod2()
	{
		final String testCaseName = "PilaALDesapilar";
		final double passedPercentage = super.tester.executeTestCases(testCaseName);

		return Misc.round(passedPercentage, 2);
	}

	// PilaAL cima method
	public boolean checkPilaALCimaMethod()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		if (super.introspector.getGenericTypeParameterCount(pilaALClass) != 1)
			return false;

		final TypeVariable<?>[] genericTypes = super.introspector.getGenericTypeParameters(pilaALClass);
		if (genericTypes.length == 0)
			return false;
		final TypeVariable<?> genericType = genericTypes[0];

		final Class<?>[] paramTypes = { };
		final Method cimaMethod = super.introspector.getDeclaredMethod(pilaALClass, "cima", paramTypes, true);
		if (cimaMethod == null)
			return false;

		final Type returnType = super.introspector.getReturnType(cimaMethod);
		final TypeVariable<?> cimaReturnType = super.introspector.getGenericType(returnType, new int[] { });
		if (cimaReturnType == null)
			return false;

		return super.introspector.checkSameGenericTypes(cimaReturnType, genericType);
	}
	public boolean solvePilaALCimaMethod()
	{
		return false;
	}
	public boolean testPilaALCimaMethod()
	{
		final String testCaseName = "Test04";
		final String testMethodName = "test";
		final Object result = super.tester.executeTestCase(testCaseName, testMethodName);

		return result == null ? false : (Boolean) result;
	}
	private double testPilaALCimaMethod2()
	{
		final String testCaseName = "PilaALCima";
		final double passedPercentage = super.tester.executeTestCases(testCaseName);

		return Misc.round(passedPercentage, 2);
	}

	// PilaAL esVacia method
	public boolean checkPilaALEsVaciaMethod()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		final Class<?>[] paramTypes = { };

		return super.introspector.checkDeclaredMethod(pilaALClass, "esVacia", paramTypes, boolean.class, true);
	}
	public boolean solvePilaALEsVaciaMethod()
	{
		return false;
	}
	public boolean testPilaALEsVaciaMethod()
	{
		final String testCaseName = "Test05";
		final String testMethodName = "test";
		final Object result = super.tester.executeTestCase(testCaseName, testMethodName);

		return result == null ? false : (Boolean) result;
	}
	private double testPilaALEsVaciaMethod2()
	{
		final String testCaseName = "PilaALEsVacia";
		final double passedPercentage = super.tester.executeTestCases(testCaseName);

		return Misc.round(passedPercentage, 2);
	}

	// PilaAL talla method
	public boolean checkPilaALTallaMethod()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		final Class<?>[] paramTypes = { };

		return super.introspector.checkDeclaredMethod(pilaALClass, "talla", paramTypes, int.class, true);
	}
	public boolean solvePilaALTallaMethod()
	{
		return false;
	}
	public boolean testPilaALTallaMethod()
	{
		final String testCaseName = "Test06";
		final String testMethodName = "test";
		final Object result = super.tester.executeTestCase(testCaseName, testMethodName);

		return result == null ? false : (Boolean) result;
	}
	private double testPilaALTallaMethod2()
	{
		final String testCaseName = "PilaALTalla";
		final double passedPercentage = super.tester.executeTestCases(testCaseName);

		return Misc.round(passedPercentage, 2);
	}

	// PilaAL toString method
	public boolean checkPilaALToStringMethod()
	{
		final Class<?> pilaALClass = super.introspector.getClass("PilaAL");
		if (pilaALClass == null)
			return false;

		final Class<?>[] paramTypes = { };

		return super.introspector.checkDeclaredMethod(pilaALClass, "toString", paramTypes, String.class, true);
	}
	public boolean solvePilaALToStringMethod()
	{
		return false;
	}
	public boolean testPilaALToStringMethod()
	{
		final String testCaseName = "Test07";
		final String testMethodName = "test";
		final Object result = super.tester.executeTestCase(testCaseName, testMethodName);

		return result == null ? false : (Boolean) result;
	}
	private double testPilaALToStringMethod2()
	{
		final String testCaseName = "PilaALToString";
		final double passedPercentage = super.tester.executeTestCases(testCaseName);

		return Misc.round(passedPercentage, 2);
	}
}