import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Search{
	private List<String> terms = new ArrayList<String>();

	public Search(List<String> terms){
		this.terms.addAll(terms);
	}

	public Collection<String> search(String value) {

		List<String> found = new ArrayList<String>();

		for ( String s : terms ){

			if ( s.indexOf(value) == 0 ){

				found.add(s);

			}

		}
		return found;

	}

	

}
