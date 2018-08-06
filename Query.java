
import java.io.Serializable;


public class Query implements Serializable {

	private String id;
	private String query;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5185436346460434400L;

	public Query(String id){
		this.setId(id);
		setQuery("select * from Test.dbo.usertype where utid = ?");
	}
	
	public Query(){
		
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
