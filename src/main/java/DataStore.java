import java.util.HashMap;
import java.util.Map;


public class DataStore {

	//Map of names to Person instances.
	private Map<String, Person> personMap = new HashMap<>();
	
	//this class is a singleton and should not be instantiated directly!
	private static DataStore instance = new DataStore();
	public static DataStore getInstance(){
		return instance;
	}

	//private constructor so people know to use the getInstance() function instead
	private DataStore(){
		//dummy data
		personMap.put("Uzair", new Person("Uzair", "Uzair786*", "Admin", "Uzair" ));
		}
	private Boolean personExists(Person p)
	{
		String name=p.getName();
		Boolean flag=true;
		Person s=personMap.get(name);
		if(s==null)
			flag=false;
		return flag;
	}
	private Boolean notnull(Person p)
	{
		Boolean flag=false;
		if(p.getName()!=null && p.getPassword()!=null && p.getRole()!=null && (p.getName()!=""&& p.getPassword()!="" && p.getRole()!=""))
			flag=true;
		return flag;
	}
	public Person getPerson(String name) {
		return personMap.get(name);
	}
	public Person getPwd(String name) {
		return personMap.get(name);
	}

	public Boolean putPerson(Person person) {
		if(!personExists(person) && notnull(person))
		{
			personMap.put(person.getName(), person);
			return true;
		}
		else
			return false;
	}
}