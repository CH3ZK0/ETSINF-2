import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test02
{
	public static boolean test() throws Throwable
	{
		final List<Numero> numeros = new LinkedList<Numero>();
		numeros.add(new Numero(1));
		numeros.add(new Numero(2));
		numeros.add(new Numero(3));
		numeros.add(new Numero(5));
		numeros.add(new Numero(7));

		final PilaAL<Numero> pila = new PilaAL<Numero>();
		for (Numero numero : numeros)
			pila.apilar(numero);

		final Field arrayField = Test02.getArrayList();
		arrayField.setAccessible(true);
		final ArrayList<Numero> elArray = (ArrayList<Numero>) arrayField.get(pila);

		for (Numero numero : elArray)
			if (!numeros.contains(numero))
				return false;
		for (Numero numero : numeros)
			if (!elArray.contains(numero))
				return false;
		return true;
	}

	private static Field getArrayList()
	{
		final List<Field> fieldsExcluded = new LinkedList<Field>();
		final Field[] fields = PilaAL.class.getDeclaredFields();

		while (fieldsExcluded.size() < fields.length)
		{
			final Field field = Test02.getField(fields, "java.util.ArrayList", fieldsExcluded);
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

		return Test02.getField(fields, typeName, fieldsExcluded);
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