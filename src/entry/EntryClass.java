package entry;
import java.sql.SQLException;
import config.JDBCConnection;

public class EntryClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		if (JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}

	}

}
