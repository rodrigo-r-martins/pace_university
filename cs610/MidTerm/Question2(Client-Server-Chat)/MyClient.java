import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	static private PrintWriter writer = null;
	static private BufferedReader reader = null;
	static private Scanner input = new Scanner(System.in);

	static class ReceiveMsgThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					if (reader.ready()) {
						String receiveMsg = reader.readLine();
						System.out.println("Server: " + receiveMsg);
						Thread.sleep(100);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	static class SendMsgThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					String sendMsg = input.nextLine();
					writer.println(sendMsg);
					if (sendMsg.equalsIgnoreCase("end")) {
						System.exit(0);
					}
					Thread.sleep(100);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	public static void main(String args[]) {

		try {
			System.out.println("Client connected...");
			Socket socket = new Socket("localhost", 1235);

			writer = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			Thread receiveMsgThread = new ReceiveMsgThread();
			receiveMsgThread.start();

			Thread sendMsgThread = new SendMsgThread();
			sendMsgThread.start();

		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
