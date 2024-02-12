package no.hvl.dat110.messaging;

public class Message {

	// the up to 127 bytes of data (payload) that a message can hold
	private byte[] data;

	// construction a Message with the data provided
	public Message(byte[] data) {
		// Checking if data is either null or too big before creating the message
		if(data == null || data.length > 127) {
			throw new IllegalArgumentException("Data cannot be null or bigger than 127 bytes");
		} else {
			this.data = data;
		}
	}

	public byte[] getData() {
		return this.data; 
	}

}
