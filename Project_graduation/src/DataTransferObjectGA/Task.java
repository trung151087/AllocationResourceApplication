package DataTransferObjectGA;
public class Task {
	int t, r, s;
	public int R = 200;
	private float sched;
	private byte assign[] = new byte[R];
	public Task() {
	}
	//truyen mảng vào constructor ntn?
	public Task(float sched, byte assign[]) {
		super();
		this.sched = sched;
		this.assign = assign;
		
	}
	public float getSched() {
		return sched;
	}
	public byte getAssign(int i) {
		return assign[i];
	}
	public void setSched(float sched) {
		this.sched = sched;
	}
	public void setAssign(int i, byte assign) {
		this.assign[i] = assign; 
	}
	public void Printf() {
		System.out.println("*************************************");
		System.out.println("SCHED: ");
		System.out.println(sched);
		System.out.println("\n ASSIGN: ");
		for (int i = 0; i < r; i++)
		{
			System.out.println(assign[i]);
			System.out.println("\n");
			System.out.println("***************************************");
		}
	}
	
}
