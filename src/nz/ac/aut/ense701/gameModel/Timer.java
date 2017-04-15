package nz.ac.aut.ense701.gameModel;

public class Timer extends Thread {
	private TimeChangeListener timeListenner;
	private int totalTime;
	private boolean stop;

	public Timer(int time) {
		stop = false;
		totalTime = time;
	}

	public void addTimeListener(TimeChangeListener timeListenner) {
		this.timeListenner = timeListenner;
	}

	public void run() {
		while (!stop) {
			totalTime += 1;
			timeListenner.timeChanged(totalTime + "");
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
