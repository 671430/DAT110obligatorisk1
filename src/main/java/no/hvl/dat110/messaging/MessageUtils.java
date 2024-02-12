package no.hvl.dat110.messaging;

import java.util.Arrays;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		data = message.getData();
		// Making the segment 128 bytes long, placing the length of the message in the first
		// spot and then filling in the message from there on.
		segment = new byte[128];
		int length = data.length;
		segment[0] = (byte) length;
		
		for(int i = 1; i<=length; i++) {
			segment[i] = data[i-1];
		}
				
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		// extracts the lenght of the data in the segment and places it in a separate byte-array
		// creates a message and returns it
		int length = (byte) segment[0];
		byte[] data = new byte[length];
		
		for(int i = 1; i<=length; i++) {
			data[i-1] = segment[i];
		}
		message = new Message(data);
		
		return message;
		
	}
	
}
