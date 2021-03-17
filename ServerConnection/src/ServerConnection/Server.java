package ServerConnection;
import java.net.*;
import java.io.*;
public class Server {
	private Socket socket =null;
	private ServerSocket server =null;
	private DataInputStream in = null;
	
	public Server(int port) {
		try
		{
		server = new ServerSocket(port);
		System.out.println("Server Started");
		System.out.println("Waiting for a client...");
		socket = server.accept();
		System.out.print("Client accepted ");
		in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line ="";
		while(!line.equals("Over")) {
			try {
				line = in.readUTF();
				System.out.println(line	);
			}
			catch(IOException i){
				System.out.println(i);
			}
		}
		}
			 
		catch(IOException i)
		{
			System.out.println(i);
			
		}
		
	}
	public static void main(String args[]) {
		Server server = new Server(9990);
	}
	
}
