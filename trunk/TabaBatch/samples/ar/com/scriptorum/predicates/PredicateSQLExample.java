package ar.com.scriptorum.predicates;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.TransformerUtils;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.collections.map.TransformedMap;

public class PredicateSQLExample {
	public static void main(String[] args) {
		List<DTO> list = Arrays.asList(
				new DTO(1, "Bob", Gender.Male, State.WI), new DTO(2, "Larry",
						Gender.Male, State.WI), new DTO(3, "Bill", Gender.Male,
						State.WI), new DTO(4, "Sue", Gender.Female, State.AZ),
				new DTO(3, "Bill", Gender.Male, State.WI), new DTO(4, "Sue",
						Gender.Female, State.AZ), new DTO(5, "Joe",
						Gender.Male, State.AZ), new DTO(6, "Zoe",
						Gender.Female, State.MI));
		Predicate sqlOrQueryPredicate = PredicateUtils
				.anyPredicate(new Predicate[] { new Predicate() {
					public boolean evaluate(Object o) {
						return State.WI.equals(((DTO) o).getState());
					}
				}, new Predicate() {
					public boolean evaluate(Object o) {
						return Gender.Female.equals(((DTO) o).getGender());
					}
				} });
		Predicate sqlAndQueryPredicate = PredicateUtils
				.allPredicate(new Predicate[] { new Predicate() {
					public boolean evaluate(Object o) {
						return State.AZ.equals(((DTO) o).getState());
					}
				}, new Predicate() {
					public boolean evaluate(Object o) {
						return Gender.Male.equals(((DTO) o).getGender());
					}
				} });
		Predicate likeNameStartsWithB = new Predicate() {
			public boolean evaluate(Object o) {
				return ((DTO) o).getName().startsWith("B");
			}
		};

		Collection aList = CollectionUtils.select(list, sqlOrQueryPredicate);
		Collection bList = CollectionUtils.select(list,
				PredicateUtils.notPredicate(sqlOrQueryPredicate));
		Collection cList = CollectionUtils.select(list, sqlAndQueryPredicate);
		Collection dList = CollectionUtils
				.select(list,
						PredicateUtils.allPredicate(new Predicate[] {
								PredicateUtils.uniquePredicate(),
								sqlOrQueryPredicate }));
		Collection eList = CollectionUtils
				.select(list,
						PredicateUtils.allPredicate(new Predicate[] {
								PredicateUtils.uniquePredicate(),
								likeNameStartsWithB }));
		Collection fList = CollectionUtils.select(list,
				PredicateUtils.uniquePredicate());

		Map aGroupByStateMap = TransformedMap.decorate(new MultiValueMap(),
				new Transformer() {
					public Object transform(Object o) {
						return ((DTO) o).getState();
					}
				}, TransformerUtils.nopTransformer());
		for (Object o : fList) {
			aGroupByStateMap.put(o, o);
		}

		System.out.println("\nAll the people :\nselect * from list");
		CollectionUtils.forAllDo(list, PrintIt.getInstance());
		System.out
				.println("\nAll the people in Wisconsin OR Female :\nselect * from list where ( state = WI or gender = female );");
		CollectionUtils.forAllDo(aList, PrintIt.getInstance());
		System.out
				.println("\nAll the people NOT ( Wisconsin OR Female ) :\nselect * from list where ! ( state = WI or gender = female );");
		CollectionUtils.forAllDo(bList, PrintIt.getInstance());
		System.out
				.println("\nAll the people in Arizona AND Male :\nselect * from list where ( state = AZ and gender = male );");
		CollectionUtils.forAllDo(cList, PrintIt.getInstance());
		System.out
				.println("\nAll the distinct people in Arizona AND Male :\nselect distinct * from list where ( state = WI or gender = female );");
		CollectionUtils.forAllDo(dList, PrintIt.getInstance());
		System.out
				.println("\nAll the distinc people with the name that starts with B :\nselect distinct * from list where name like \"B%\";");
		CollectionUtils.forAllDo(eList, PrintIt.getInstance());
		System.out
				.println("\nAll the distinct people grouped by state :\nselect distinct * from list group by state;");
		Set states = aGroupByStateMap.keySet();
		for (Object state : states) {
			System.out.println(((State) state).getFullyQualifiedName());
			CollectionUtils.forAllDo((Collection) aGroupByStateMap.get(state),
					PrintIt.getInstance());
		}
	}
}