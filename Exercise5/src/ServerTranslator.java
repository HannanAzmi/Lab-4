import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ServerTranslator extends Frame implements Runnable
{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Declarations
 TextArea ta;
 ServerSocket ss;
 Socket s;
 PrintWriter pw;
 BufferedReader br;
 Thread th;
 
 public ServerTranslator()
 {
  Frame f=new Frame("Server Side English Malay Translator");//Frame for Server
  f.setLayout(new FlowLayout());//set layout
  ta=new TextArea(20,28);
  f.addWindowListener(new W1());//add Window Listener to the Frame
  f.add(ta);//Add TextArea to the frame
  
  try{
   ss=new ServerSocket(4226);//Socket for server
   s=ss.accept();//accepts request from client
   System.out.println(s);
   //below line reads input from InputStreamReader
   br=new BufferedReader(new InputStreamReader(s.getInputStream()));
   //below line writes output to OutPutStream
   pw=new PrintWriter(s.getOutputStream(),true);
  }catch(Exception e){}
  
  th=new Thread(this);//start a new thread
  th.setDaemon(true);//set the thread as demon
  th.start();
  setFont(new Font("Arial",Font.BOLD,20));
  f.setSize(200,200);//set the size
  f.setLocation(300,300);//set the location
  f.setVisible(true);
  f.validate();
 }
 
 //method required to close the Frame on clicking "X" icon.
 private class W1 extends WindowAdapter
 {
  public void windowClosing(WindowEvent we) 
  {
   System.exit(0);
  }
 }
 
 
 //Thread running as a process in background
 public void run()
 {
  while(true)
  {
   try{
    
    String text=br.readLine();//reads the input from textfield
    ta.append("English text: " + text+"\n");//Append to TextArea

    // perform the required operation.
    String result = translate("en", "ms", text);
    pw.println(result);//write the result into PrintWriter
   }catch(Exception e)
   {
   }
  } 
 }
 
private static String translate(String langFrom, String langTo, String text) throws IOException {
     
     String urlStr = "https://script.google.com/macros/s/AKfycbzuE3Y3PTwIF22RdNaJn4AAQmji_XPDtrODlk2wakYMNOqxIsRRqJU-VccgJaHHs21d/exec" +
             "?q=" + URLEncoder.encode(text, "UTF-8") +
             "&target=" + langTo +
             "&source=" + langFrom;
     URL url = new URL(urlStr);
     StringBuilder response = new StringBuilder();
     HttpURLConnection con = (HttpURLConnection) url.openConnection();
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
     String inputLine;
     while ((inputLine = in.readLine()) != null) {
         response.append(inputLine);
     }
     in.close();
     return response.toString();
 }
 
 //Main method
 public static void main(String args[]) 
 {
  //Instantiate ServerTranslator class
	 ServerTranslator server = new ServerTranslator();
 }
} 