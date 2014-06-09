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
import java.io.*;

import org.apache.commons.lang.StringUtils;

import sound.utils.Methods;
import stream.io.WavFile;
import stream.io.WavFileException;

public class Sound {

	static {  
        // load library  
//        System.loadLibrary("JNI_Library");  
        System.loadLibrary("hello");  
    }  

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("JavaPlot");
		
//		_D_7_v_4_Check_FilePath();
		_D_7_v_4_WavFile();
		
//		WavFile wFile;
//		wavFiles.WavFile wFile;
		
//		_D_7_JNI();
		
//		_D_7_Initial_Codes();
//		_D_7_JDBC();
		
		String message = "done";
		message(message,
				Thread.currentThread().getStackTrace()[1].getLineNumber());
		

		
	}//public static void main(String[] args)

	private static void _D_7_v_4_WavFile() {
		// TODO Auto-generated method stub
		String fname_Wav = "a.wav";
		
		String fpath_Wav = StringUtils.join(
				new String[]{
					"audio",
					fname_Wav
				}, File.separator);
		
		File audioFile_Src = new File(fpath_Wav);
		
		WavFile wavFile = null;
		
		try {
			
			wavFile = WavFile.openWavFile(audioFile_Src);
			
			String message = "File => opened: " + audioFile_Src.getAbsolutePath();
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			
			wavFile.close();
			
			message = "File => closed: " + audioFile_Src.getAbsolutePath();
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WavFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void _D_7_v_4_Check_FilePath() {
		// TODO Auto-generated method stub
		String fname_Wav = StringUtils.join(
				new String[]{
					
					"abc_",
					Methods.get_TimeLabel(Methods.getMillSeconds_now()),
					".txt"
						
				});
		
//		String fpath_Wav = "";
		
		File f = new File(fname_Wav);
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(f);
			
			String message = "Time is "
						+ Methods.get_TimeLabel(Methods.getMillSeconds_now());
			
//					"abc_" + Methods.get_TimeLabel(Methods.getMillSeconds_now()) + ".txt";
			
			fw.write(message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			
			try {
				fw.close();
				
				String message = "File closed";
				
				message(message,
						Thread.currentThread().getStackTrace()[1].getLineNumber());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
//		try {
//			WavFile wavFile = WavFile.openWavFile(new File(args[0]));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (WavFileException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private static void _D_7_Initial_Codes() {
		// TODO Auto-generated method stub
//		JavaPlot p = new JavaPlot();
//      p.addPlot("sin(x)");
//      p.plot();
//		JavaPlot p = new JavaPlot(true);
//		
//		p.setTitle(Thread.currentThread().getStackTrace()[1].getFileName());
//		
//      p.addPlot("sin(x)*y");
//      p.plot();
      

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
		
		
//      // Log
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
//          System.out.format("%s=%s%n",
//                            envName,
//                            env.get(envName));
//      }
	}

	private static void _D_7_JNI() {
		// TODO Auto-generated method stub

		String message = new Sound().hello("world");
		
		message(message,
				Thread.currentThread().getStackTrace()[1].getLineNumber());
		
		double[] data = new Sound().get_Wave("world");
		
		message = "data[0] = " + data[0];
		message(message,
				Thread.currentThread().getStackTrace()[1].getLineNumber());
		
		// Console output
		//		JavaPlot
		//		Hello world
		//		[Sound.java : message : 98] world => received
		//		[Sound.java : message : 104] data[0] = 0.3
		//		[Sound.java : message : 48] done

		
	}

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
	
	public native String hello(String name);
	
	public native double[] get_Wave(String name);
	
}
