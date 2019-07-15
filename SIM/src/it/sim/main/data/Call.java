package it.sim.main.data;

public class Call {

	private long sender;
	private long reciever;
	
	private float start;
	private float end;
	
	public Call(long sender, long reciever) {
		this.sender = sender;
		this.reciever = reciever;
	}
	
	/**
	 * 
	 * @return call's reciever
	 */
	public long getReciever() {
		return reciever;
	}
	
	/**
	 * starting the call and get the current time
	 */
	public void startCall() {
		this.start = System.currentTimeMillis();
	}
	
	/**
	 * end the call and get the current time and subtracted to the start of the call
	 */
	public void endCall() {
		this.end = System.currentTimeMillis() - start;
	}
	
	/**
	 * 
	 * @return call's sender
	 */
	public long getSender() {
		return sender;
	}
	
	/**
	 * 
	 * @return the end of the call
	 */
	public float getEnd() {
		return end;
	}
}
