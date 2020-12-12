package entry;
import java.sql.SQLException;
import java.text.ParseException;

import view.LoginFrame;
import view.Starter;

public class FrameTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		Starter st=new Starter();
		Thread Start=new Thread(st);
		Start.start();
		
		new LoginFrame();
	}

}
