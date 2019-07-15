package it.sim.main.data;

import java.util.HashMap;

public class SIMCard {
	
	private long number;
	private float money;
	private int countCalls;
	HashMap<Integer,Call> register = new HashMap<Integer, Call>();
	
	
	public SIMCard(long number, float money, int countCalls) {
		this.number = number;
		this.money = money;
		this.countCalls = countCalls;
	}
	
	
	/**
	 * Create a new Call, start the call and and the call, then add the call into the HashMap
	 * the key will be the last call's id into the file + 1, the value = the call;
	 * @param reciever of the call
	 */
	public void addCall(long reciever) {
		Call call = new Call(this.number, reciever);
		call.startCall();
		call.endCall();
		register.put(countCalls, call);
	}
	/**
	 * 
	 * @return sim's register
	 */
	public HashMap<Integer, Call> getRegister() {
		return register;
	}

	/**
	 * 
	 * @return sim's number
	 */
	public long getNumber() {
		return number;
	}

	
	/**
	 * 
	 * @return sim's money
	 */
	public float getMoney() {
		return money;
	}
	
	/**
	 * 
	 * @return sim's counter of calls
	 */
	public int getCountCalls() {
		return countCalls;
	}
}
