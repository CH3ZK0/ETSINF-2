import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test01
{
	public static boolean test() throws Throwable
	{
		final PilaAL<Numero> pila = new PilaAL<Numero>();
		final Field arrayField = Test01.getArrayList();
		if (arrayField == null)
			return false;

		arrayField.setAccessible(true);
		final ArrayList<Numero> elArray = (ArrayList<Numero>) arrayField.get(pila);

		return elArray.isEmpty();
	}

	private static Field getArrayList()
	{
		final List<Field> fieldsExcluded = new LinkedList<Field>();
		final Field[] fields = PilaAL.class.getDeclaredFields();

		while (fieldsExcluded.size() < fields.length)
		{
			final Field field = Test01.getField(fields, "java.util.ArrayList", fieldsExcluded);
			final Class<?> fieldType = field.getType();
			final TypeVariable<?>[] typeParameters = fieldType.getTypeParameters();

			if (typeParameters.length == 1)
				return field;
			fieldsExcluded.add(field);
		}

		return null;
	}
	private static Field getField(Class<?> clazz, String typeName, List<Field> fieldsExcluded)
	{
		final Field[] fields = PilaAL.class.getDeclaredFields();

		return Test01.getField(fields, typeName, fieldsExcluded);
	}
	private static Field getField(Field[] fields, String typeName, List<Field> fieldsExcluded)
	{
		for (Field field : fields)
		{
			if (fieldsExcluded.contains(field))
				continue;

			final Class<?> fieldType = field.getType();
			final String fieldTypeName = fieldType.getName();

			if (fieldTypeName.equals(typeName))
				return field;
		}

		return null;
	}

	static class Numero
	{
		private int numero;

		public Numero(int numero)
		{
			this.numero = numero;
		}

		public int getNumero()
		{
			return this.numero;
		}

		public String toString()
		{
			return "Numero " + this.numero;
		}
	}
}