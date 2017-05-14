package nz.ac.aut.ense701.gameModel;

public class Timer extends Thread {
	static private TimeChangeListener timeListenner;
	static private int totalTime;
	static private boolean stop;

	/**
	 * The constructor of Timer and set the initial time
	 * @param time
	 */
	public Timer(int time) {
		stop = false;
		totalTime = time;
	}
	
	/**
	 * Update the panel every second
	 */
	public void run() {
		
		while (!stop) {
			totalTime += 1;
			try {
			timeListenner.timeChanged(totalTime + "");
			this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Ignore this error if you running from test");
				return;
			}
//			try {
//				this.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return;
//			}
		}
	}

	public void addTimeListener(TimeChangeListener timeListenner) {
		this.timeListenner = timeListenner;
	}
	
	public String getTime(){
		return this.totalTime+"";
		
	}
	
	public void resetTime(){
		this.totalTime=0;
		
	}

}
