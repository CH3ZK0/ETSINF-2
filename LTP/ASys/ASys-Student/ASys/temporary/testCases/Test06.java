import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test06
{
	public static boolean test() throws Throwable
	{
		final PilaAL<Numero> pila = new PilaAL<Numero>();
		final boolean apilado = Test06.apilar(pila);
		if (!apilado)
			return false;
		final boolean desapilado = Test06.desapilar(pila);
		if (desapilado)
			return true;

		final PilaAL<Numero> pila2 = new PilaAL<Numero>();
		final boolean apilado2 = Test06.apilar(pila2);
		final boolean desapilado2 = Test06.desapilar2(pila2);
		if (!apilado2 || !desapilado2)
			return false;

		return true;
	}
	private static boolean apilar(Pila pila)
	{
		final Numero numero = new Numero(7);

		if (pila.talla() != 0)
			return false;
		pila.apilar(numero);
		if (pila.talla() != 1)
			return false;
		pila.apilar(numero);
		if (pila.talla() != 2)
			return false;
		return true;
	}
	private static boolean desapilar(Pila pila)
	{
		try
		{
			pila.desapilar();
			if (pila.talla() != 1)
				return false;
			pila.desapilar();
			if (pila.talla() != 0)
				return false;
		}
		catch (Throwable e)
		{
			return false;
		}
		return true;
	}
	private static boolean desapilar2(Pila pila)
	{
		try
		{
			final Field arrayField = Test06.getArrayList();
			arrayField.setAccessible(true);
			final ArrayList<Numero> elArray = (ArrayList<Numero>) arrayField.get(pila);

			elArray.remove(pila.talla() - 1);
			if (pila.talla() != 1)
				return false;
			elArray.remove(pila.talla() - 1);
			if (pila.talla() != 0)
				return false;
		}
		catch (Throwable e)
		{
			return false;
		}
		return true;
	}

	private static Field getArrayList()
	{
		final List<Field> fieldsExcluded = new LinkedList<Field>();
		final Field[] fields = PilaAL.class.getDeclaredFields();

		while (fieldsExcluded.size() < fields.length)
		{
			final Field field = Test06.getField(fields, "java.util.ArrayList", fieldsExcluded);
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

		return Test06.getField(fields, typeName, fieldsExcluded);
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