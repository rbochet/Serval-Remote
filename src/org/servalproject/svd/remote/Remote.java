package org.servalproject.svd.remote;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Remote {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			UnknownHostException, IOException {
		if (args.length != 3) {
			System.err.println("You need 3 args");
			System.exit(1);
		}

		// Create the socket with arg1 and arg2
		Socket socket = new Socket(args[0], Integer.parseInt(args[1]));

		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);

		// Send the byte
		dos.writeByte(hexStringToByte(args[2]));
		dos.close();
		socket.close();

		// Report
		System.out.println("Data sent: " + args[2] + " (int: "
				+ hexStringToByte(args[2]) + ") to " + args[0] + ":" + args[1]);
	}

	/**
	 * My personnal magical function
	 * 
	 * @param s
	 *            Two/Four letters string (0x11 or 17)
	 * @return
	 */
	public static byte hexStringToByte(String s) {
		if (s.length() == 4) // hex ; strip the "0x" thing
			return (byte) ((Character.digit(s.charAt(2), 16) << 4) + 
					Character.digit(s.charAt(3), 16));
		else // s.length() == 2 ; decimal ; send it back
			return Byte.parseByte(s);
	}

}
