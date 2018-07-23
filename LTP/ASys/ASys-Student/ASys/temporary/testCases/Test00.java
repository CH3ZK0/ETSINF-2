import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test00
{
	public static boolean test() throws Throwable
	{
		String texto = "";
		Pila<Integer> pi = new PilaAL <Integer>();

		for (int i=1; i<=10; i++) pi.apilar(i);
		texto = "Pila(enteros)= "+pi;
		if (!texto.equals("Pila(enteros)= cima: 10 / 9 / 8 / 7 / 6 / 5 / 4 / 3 / 2 / 1"))
			return false;

		int n=5;
		for (int i=0; i<n; i++) pi.desapilar();
		texto = "Pila(desapilados "+n+" elementos)= "+pi;
		if (!texto.equals("Pila(desapilados 5 elementos)= cima: 5 / 4 / 3 / 2 / 1"))
			return false;

		int m=3;
		for (int i=1; i<=m; i++) pi.apilar(i);
		texto = "Pila(apilados "+m+" elementos)= "+pi;
		if (!texto.equals("Pila(apilados 3 elementos)= cima: 3 / 2 / 1 / 5 / 4 / 3 / 2 / 1"))
			return false;

		Pila<Character> pc = new PilaAL <Character>();

		for (char i='a'; i<='f'; i++) pc.apilar( new Character(i) );
		texto = "Pila(caracteres)= "+pc;
		if (!texto.equals("Pila(caracteres)= cima: f / e / d / c / b / a"))
			return false;

		int r=3;
		for (int i=0; i<r ; i++) pc.desapilar();
		texto = "Pila(desapilados "+r+" elementos)= "+pc;
		if (!texto.equals("Pila(desapilados 3 elementos)= cima: c / b / a"))
			return false;

		int s = 4;
		char t = (char)(((int)'k')+s);
		for (char i='k'; i<t; i++) pc.apilar( new Character(i) );
		texto = "Pila(apilados "+s+" elementos)= "+pc;
		if (!texto.equals("Pila(apilados 4 elementos)= cima: n / m / l / k / c / b / a"))
			return false;

		return true;
	}

	private static Field getArrayList()
	{
		final List<Field> fieldsExcluded = new LinkedList<Field>();
		final Field[] fields = PilaAL.class.getDeclaredFields();

		while (fieldsExcluded.size() < fields.length)
		{
			final Field field = Test00.getField(fields, "java.util.ArrayList", fieldsExcluded);
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

		return Test00.getField(fields, typeName, fieldsExcluded);
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