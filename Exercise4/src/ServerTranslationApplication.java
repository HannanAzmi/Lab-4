import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplication {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serversocket = null;
		
		try {
			//Bind Serversocket to a port
			int portNo = 4228;
			serversocket = new ServerSocket(portNo);
			
			String text1 = "Good afternoon";
			System.out.println("Waiting for request");
			
			while (true) {
				
				//Accept client request for connection
				Socket clientSocket = serversocket.accept();
				
				//Create stream to write data on the network
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				//Send current date back to the client
				outputStream.writeUTF(text1);
				
				//Close the socket
				clientSocket.close();
			}
			
			//Closing is not necessary because the code is unreachable

		} catch (IOException ioe) {
			
			if (serversocket != null)
				serversocket.close();
			
			ioe.printStackTrace();
		}
	}
	
}
