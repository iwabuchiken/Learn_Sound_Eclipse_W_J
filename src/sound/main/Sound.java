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

		new Sound()._D_7_v_4_Plot_Data();
//		_D_7_v_4_EachChannelData();
//		_D_7_v_4_WavFile();
//		_D_7_v_4_Check_FilePath();
		
//		WavFile wFile;
//		wavFiles.WavFile wFile;
		
//		_D_7_JNI();
		
//		_D_7_Initial_Codes();
//		_D_7_JDBC();
		
		String message = "done";
		message(message,
				Thread.currentThread().getStackTrace()[1].getLineNumber());
		

		
	}//public static void main(String[] args)

	private static void
	_D_7_v_4_EachChannelData() {
		// TODO Auto-generated method stub
		String fname_Wav = "2.wav";
//		String fname_Wav = "a.wav";
		
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
			
			// display
			wavFile.display();
			
			////////////////////////////////

			// Setup: vars

			////////////////////////////////
			int start = 10000;
			int num_of_display = 10;
			
			int framesRead;
			int numChannels = wavFile.getNumChannels();
			long num_Frames = wavFile.getNumFrames();
			
			double[] buf = new double[(int) num_Frames * numChannels];
			double[] buf_L = new double[(int) num_Frames];
			double[] buf_R = new double[(int) num_Frames];

			////////////////////////////////

			// Read: frames

			////////////////////////////////
			framesRead = wavFile.readFrames(buf, (int) wavFile.getNumFrames());
			
			message = "framesRead = " + framesRead;
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());

			////////////////////////////////

			// Close: wav

			////////////////////////////////
			wavFile.close();
			
			message = "File => closed: " + audioFile_Src.getAbsolutePath();
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			////////////////////////////////

			// Process: data

			////////////////////////////////
			for (int i = 0; i < num_Frames; i++) {
				
				buf_L[i] = buf[i];
				buf_R[i] = buf[i + 1];
				
				
//				//REF format http://stackoverflow.com/questions/47045/sprintf-equivalent-in-java answered Sep 5 '08 at 23:06
//				message = String.format(
//							"buf[%d] = %f / buf_L[%d] = %f / buf_R[%d] = %f",
//							i, buf[i], i, buf_L[i], i, buf_R[i]);
//				message(message,
//						Thread.currentThread().getStackTrace()[1]
//								.getLineNumber());
			}
			
			message = "Processing => done";
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			
			////////////////////////////////

			// Display: data

			////////////////////////////////
//			int start = 0;
//			int num_of_display = 10;
			
			for (int i = start; i < start + num_of_display; i++) {
				
				//REF format http://stackoverflow.com/questions/47045/sprintf-equivalent-in-java answered Sep 5 '08 at 23:06
				message = String.format(
							"buf[%d] = %f / buf_L[%d] = %f / buf_R[%d] = %f",
							i, buf[i], i, buf_L[i], i, buf_R[i]);
				message(message,
						Thread.currentThread().getStackTrace()[1]
								.getLineNumber());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WavFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}//_D_7_v_4_EachChannelData()
	
	private void
	_D_7_v_4_Plot_Data() {
		// TODO Auto-generated method stub
		String fname_Wav = "2.wav";
//		String fname_Wav = "a.wav";
		
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
			
			// display
			wavFile.display();
			
			////////////////////////////////
			
			// Setup: vars
			
			////////////////////////////////
			int start = 10000;
			int num_of_display = 10;
			
			int framesRead;
			int numChannels = wavFile.getNumChannels();
			long num_Frames = wavFile.getNumFrames();
			
			double[] buf = new double[(int) num_Frames * numChannels];
			double[] buf_L = new double[(int) num_Frames];
			double[] buf_R = new double[(int) num_Frames];
			
			////////////////////////////////
			
			// Read: frames
			
			////////////////////////////////
			framesRead = wavFile.readFrames(buf, (int) wavFile.getNumFrames());
			
			message = "framesRead = " + framesRead;
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			////////////////////////////////
			
			// Close: wav
			
			////////////////////////////////
			wavFile.close();
			
			message = "File => closed: " + audioFile_Src.getAbsolutePath();
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			////////////////////////////////
			
			// Process: data
			
			////////////////////////////////
//			for (int i = 0; i < num_Frames; i += 2) {
//				for (int i = 0; i < num_Frames; i++) {
			for (int i = 0, j = 0; i < num_Frames; i += 2, j ++) {
				
				buf_L[j] = buf[i];
				buf_R[j] = buf[i + 1];
				
				
//				//REF format http://stackoverflow.com/questions/47045/sprintf-equivalent-in-java answered Sep 5 '08 at 23:06
//				message = String.format(
//							"buf[%d] = %f / buf_L[%d] = %f / buf_R[%d] = %f",
//							i, buf[i], i, buf_L[i], i, buf_R[i]);
//				message(message,
//						Thread.currentThread().getStackTrace()[1]
//								.getLineNumber());
			}
			
			message = "Processing => done";
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			
			////////////////////////////////
			
			// Display: data
			
			////////////////////////////////
//			int start = 0;
//			int num_of_display = 10;
			
			for (int i = start; i < start + num_of_display; i++) {
				
				//REF format http://stackoverflow.com/questions/47045/sprintf-equivalent-in-java answered Sep 5 '08 at 23:06
				message = String.format(
						"buf[%d] = %f / buf_L[%d] = %f / buf_R[%d] = %f",
						i, buf[i], i, buf_L[i], i, buf_R[i]);
				message(message,
						Thread.currentThread().getStackTrace()[1]
								.getLineNumber());
			}
			
			////////////////////////////////

			// Prep: plot data

			////////////////////////////////
			//REF multi http://stackoverflow.com/questions/12231453/creating-two-dimensional-array answered Sep 1 '12 at 21:15
			
			int count = 0;
			start = 10000; num_of_display = 5;
			
			double[][] data = new double[(int) num_of_display][2];
			
			for (int i = start; i < start + num_of_display; i++) {
//				for (int i = 361000; i < 36110; i++) {
//				for (int i = 361000; i < buf_R.length; i++) {
				
				data[count][0] = count;
				data[count][1] = buf_L[i];
				
				count ++;
				
			}
			
			start = 0; num_of_display = 5;
			
			for (int i = start; i < start + num_of_display; i++) {
				
				message = String.format(
						"data[%d][0] = %f / data[%d][1] = %f", 
						i, data[i][0], i, data[i][1]);
				
				message(message,
						Thread.currentThread().getStackTrace()[1]
								.getLineNumber());
				
				
			}
			
//			 0.000000 / data[0][1] = 0.107300
//					 [Sound.java : message : 318] data[1][0] = 1.000000 / data[1][1] = 0.058380
//					 [Sound.java : message : 318] data[2][0] = 2.000000 / data[2][1] = 0.103516
//					 [Sound.java : message : 318] data[3][0] = 3.000000 / data[3][1] = 0.055573
//					 [Sound.java : message : 318] data[4][0] = 4.000000 / data[4][1] = 0.100372
//					 [Sound.java : message : 318] data[5][0] = 5.000000 / data[5][1] = 0.053314
//					 [Sound.java : message : 318] data[6][0] = 6.000000 / data[6][1] = 0.097321
//					 [Sound.java : message : 318] data[7][0] = 7.000000 / data[7][1] = 0.051605
//					 [Sound.java : message : 318] data[8][0] = 8.000000 / data[8][1] = 0.093140
//					 [Sound.java : message : 318] data[9][0] = 9.000000 / data[9][1] = 0.050568			
//			double[][] data = new double[][]{
//					
//					{1.0, 0.058},
//					{2.0, 0.103},
//					
//			};
//			
//			start = 0; num_of_display = 2;
//			
//			for (int i = start; i < start + num_of_display; i++) {
//			
//				message = String.format(
//						"data[%d][0] = %f / data[%d][1] = %f", 
//						i, data[i][0], i, data[i][1]);
//				
//				message(message,
//						Thread.currentThread().getStackTrace()[1]
//								.getLineNumber());
//				
//				
//			}

			
//			double[][] data = new double[][]{
//					
//					{0.3, 0.4},
//					{0.2, 0.1},
//					
//			};
			
			
			////////////////////////////////

			// Plot

			////////////////////////////////
			
			
			
			
			JavaPlot p = new JavaPlot();
//			p.addPlot("sin(x)");
//			p.plot();
//				JavaPlot p = new JavaPlot(true);
				
			p.setTitle(Thread.currentThread().getStackTrace()[1].getFileName());
			
			p.addPlot(data);
//			p.addPlot("sin(x)*y");
			p.plot();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WavFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}//_D_7_v_4_EachChannelData()

	private static void _D_7_v_4_WavFile() {
		// TODO Auto-generated method stub
		String fname_Wav = "2.wav";
//		String fname_Wav = "a.wav";
		
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
			
			// display
			wavFile.display();
			
			//
			int offset = 300000;
			int num_of_samples = 10;
			int num_of_frames = 100;
			
			int framesRead;
			int numChannels = wavFile.getNumChannels();
			double[] buffer = new double[(int) wavFile.getNumFrames() * numChannels];
//			double[] buffer = new double[num_of_frames * numChannels];
			
			framesRead = wavFile.readFrames(buffer, (int) wavFile.getNumFrames());
			
			message = "framesRead = " + framesRead;
			message(message,
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			
			for (int i = 0 + offset; i < num_of_samples + offset; i++) {
				
				//REF format http://stackoverflow.com/questions/47045/sprintf-equivalent-in-java answered Sep 5 '08 at 23:06
				message = String.format("double[%d] = %f", i, buffer[i]);
				message(message,
						Thread.currentThread().getStackTrace()[1]
								.getLineNumber());
				
			}
			
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
		
		//REF http://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
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
