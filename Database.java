import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Aasima Pathan
 * Modified from: http://stackoverflow.com/a/11219543
 * Last accessed on 23/08/2014 at 11:05AM
 */
public class Database {
 
    private Connection conn = null;
    private String dbName = "MSC";
    private String serverip="AASIMA-PC\\SQLEXPRESS";
    private String serverport="1433";
    private String url = "jdbc:sqlserver://"+serverip+":"+serverport+";databaseName="+dbName+"";
    private Statement stmt = null;
    //ResultSet result = null;
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String databaseUserName = "msc";
    private String databasePassword = "msc"; 
	
	public Database () throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		dbConnect(databaseUserName, databasePassword);
	}
	
	
	
	public void dbConnect(String databaseUserName, String databasePassword ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	
	        Class.forName(driver).newInstance();
	        conn = DriverManager.getConnection(url, databaseUserName, databasePassword);
	        setStmt(conn.createStatement());
	        System.out.println("Database connected successfully");
	        
	}

	public ResultSet viewTable(Connection conn) throws SQLException {
		String query = "select * from Test.dbo.usertype";
		Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);

    return rs;
	}
	
	


	/**
	 * @return the stmt
	 */
	public Statement getStmt() {
		return stmt;
	}



	/**
	 * @param stmt the stmt to set
	 */
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}



	public Connection getConn() {
		return conn;
	}



	public void setConn(Connection conn) {
		this.conn = conn;
	}
}