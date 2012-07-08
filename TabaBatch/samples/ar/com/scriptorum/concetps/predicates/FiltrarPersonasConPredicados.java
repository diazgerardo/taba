package ar.com.scriptorum.concetps.predicates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.OrPredicate;
import org.junit.Before;
import org.junit.Test;

public class FiltrarPersonasConPredicados {
	static List<Persona> listaPersona = new ArrayList<Persona>();

	@Before
	public void setUp() {
		listaPersona.add(new Persona("juan", "gomez", 3500, DateParser.parse("31-03-2014")));
		listaPersona.add(new Persona("alberto", "gonzalez", 4500, DateParser.parse("01-04-2001")));
		listaPersona.add(new Persona("juan", "gomez", 3600, DateParser.parse("21-05-2010")));
		listaPersona.add(new Persona("juan", "gonzalez", 4500, DateParser.parse("12-11-2011")));
	}

	@Test
	public void test() {
		EqualPredicate nombreEqlPredicate = new EqualPredicate("juan");
		BeanPredicate nombreBeanPredicate = new BeanPredicate("nombre",
				nombreEqlPredicate);
		EqualPredicate apellidoEqlPredicate = new EqualPredicate("gomez");
		BeanPredicate apellidoBeanPredicate = new BeanPredicate("apellido",
				apellidoEqlPredicate);
		Predicate[] arrayDePredicados = { nombreBeanPredicate,apellidoBeanPredicate };
		Predicate criterioEstricto = PredicateUtils.allPredicate(arrayDePredicados);
		Collection<?> listaFiltrada = CollectionUtils.select(listaPersona, criterioEstricto);
		System.out.println("-------------------------------------------------------------------------");
		for (Object persona : listaFiltrada) {
			System.out.println(persona);
		}
		OrPredicate criterioAmplio = new OrPredicate(nombreBeanPredicate, apellidoBeanPredicate);
		listaFiltrada = CollectionUtils.select(listaPersona, criterioAmplio);
		System.out.println("-------------------------------------------------------------------------");
		for (Object persona : listaFiltrada) {
			System.out.println(persona);
		}
		System.out.println("-------------------------------------------------------------------------");

	}
	
	static class DateParser {
		static SimpleDateFormat sdfParser = new SimpleDateFormat("dd-mm-yyyy");
		public static Date parse(String s) {
			try {
				return sdfParser.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
