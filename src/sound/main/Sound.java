package sound.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.sql.*;

import com.panayotis.gnuplot.JavaPlot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("JavaPlot");
		
		_D_7_JDBC();
		
//		JavaPlot p = new JavaPlot();
//        p.addPlot("sin(x)");
//        p.plot();
//		JavaPlot p = new JavaPlot(true);
//		
//		p.setTitle(Thread.currentThread().getStackTrace()[1].getFileName());
//		
//        p.addPlot("sin(x)*y");
//        p.plot();
        
        String message = "done";
		message(message,
				Thread.currentThread().getStackTrace()[1].getLineNumber());
		

//		String message = "message";
//		
//		message(message, Thread.currentThread().getStackTrace()[1].getLineNumber());
		
//		String label = "["
//				+ Thread.currentThread().getStackTrace()[1].getFileName()
//				+ " : "
//				+ Thread.currentThread().getStackTrace()[1].getMethodName()
//				+ " : "
//				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
//				+ "]";
//		System.out.println(label + " " + message);
		
		
//        // Log
//		String msg_Log = "message";
//		Log.d("Sound.java" + "["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ "]", msg_Log);
        
//		Map<String, String> env = System.getenv();
//		
//		Set<String> kSet = env.keySet();
//		
//		List<String> list = new ArrayList<String>();
//		
		//REF http://stackoverflow.com/questions/8892360/convert-set-to-list-without-creating-new-list answered Jan 17 '12 at 9:43
//		list.addAll(kSet);
//		
//		Collections.sort(list);
//
		//REF http://docs.oracle.com/javase/tutorial/essential/environment/env.html
//		for (String envName : list) {
////			for (String envName : env.keySet()) {
//            System.out.format("%s=%s%n",
//                              envName,
//                              env.get(envName));
//        }
		
	}//public static void main(String[] args)

	private static void _D_7_JDBC() {
		// TODO Auto-generated method stub
		try {
			
			String className = "org.sqlite.JDBC";
			
			Class.forName(className);
//			Class.forName("org.sqlite.JDBC");
			
			String message = "Class found => " + className;
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.exit(-1);
			
		}
		
		Connection connection = null;
		
		try {
			
			String dbName = "sample1.db";
			
			connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
//			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.
			
			statement.executeUpdate("drop table if exists person");
			statement.executeUpdate("create table person (id integer, name string)");
			statement.executeUpdate("insert into person values(1, 'leo')");
			statement.executeUpdate("insert into person values(2, 'yui')");
			
			String message = "Executions => done";
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			
		} finally {
			
			try
			{
				if(connection != null)
					connection.close();
				
				String message = "Connection => closed";
				message(message,
						Thread.currentThread().getStackTrace()[1]
								.getLineNumber());
				
			}
			catch(SQLException e)
			{
				// 	connection close failed.
				System.err.println(e);
			}
		}
		
	}//private static void _D_7_JDBC()

	public static void message(String message, int line) {
		
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ line
				+ "]";
		System.out.println(label + " " + message);
	}
	
}
