package DataTransferObjectGA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;

import DataTransferObjectGA.Task;
import javax.management.Query;

public class Individual {
	public float zz;
	int t, r, s;
	float maxDur;
	final int T = 100;
	final int R = 200;
	final int S = 100;
	public float[] dur = new float[T];
	public float[][] lexp = new float[R][S]; 
	public int[][] treq = new int[T][S];
	ArrayList< ArrayList<Integer> > adj_f = new ArrayList<ArrayList<Integer>>();
	ArrayList< ArrayList<Integer> > adj_b = new ArrayList<ArrayList<Integer>>();
	//public int[] adj_b = new int[T];

	public Task[] task = new Task[T];
	
	float fitn;
	Queue<Integer> queues = new LinkedList<>();	
	Random ranDom = new Random();
	//khởi tạo quần thể
	public Individual() {
		for (int i = 0; i < t; i++)
		{
			// nếu các task không phụ thuộc
			if (adj_b.isEmpty() == true) {
				queues.add(i);
				float sched = ranDom.nextFloat()* (dur[i] + maxDur)/8;
				task[i].setSched(sched); 
				
			}
		}
		//nếu các task có phụ thuộc
		while (!queues.isEmpty()) {
			int u = queues.peek(); 
			queues.poll();
			Iterator<Integer> iter = adj_f.get(u).iterator();
			while(iter.hasNext()) {
				int v = iter.next();
				float sched = Math.max(task[v].getSched(), (float)(task[v].getSched() + dur[u] +(ranDom.nextFloat()- 0.5)*(dur[v]+maxDur)/4));
				task[v].setSched(sched);
				queues.add(v);
			}
		}
		for (int i = 0; i < t; i++) {
			float sched = Math.max(task[i].getSched(),(float)0);
			task[i].setSched(sched);
		}
		
		for(int i = 0; i < t; i++) {
			for (int j = 0; j < r; i++)
			{
				byte assign =  (byte) (ranDom.nextFloat() < 0.6 ? 1 : 0);
				task[i].setAssign(i, assign);
			}
		}
		
	}
	
	public void Print() {
		System.out.println("SCHED: ");
		for(int i = 0; i < t; i++) {
			System.out.println(i+1 + "\t" + task[i].getSched());
		}
		System.out.println("ASSIGN: ");
		for(int i = 0; i < t; i++) {
			System.out.println(i+1 + "\t");
			for (int j = 0; j < r; j++) {
				System.out.println(task[i].getAssign(j));
			}
		}
		System.out.println("***************************************");
	}
	public static void main(String args[])
	{
		
	}
	//hàm Tiến độ DURATION
//	public float duration(Individual a, int i) {
//		float ti_start = 0;
//		 
//		float t_deadline = zz - dur[i];
//		
//		if(adj_b.get(i).size() == 0)
//		{
//			float t_duration = 0;
//			if(a.task[i].getSched() < t_deadline) {
//				t_duration = (float) (0.9 + 0.1*(t_deadline - a.task[i].getSched())/(t_deadline - ti_start));
//			}
//			else {
//				t_duration = (float) (0.9 - (a.task[i].getSched() - t_deadline)/dur[i]);
//			}
//			return t_duration; 
//		}
//		else {
//			float t_duration = 0;
//			int n = 0;
//			for (int k = 0; k < adj_b.get(i).size(); k++) {
//				int b = adj_b.get(i).get(k);
//				
//				ti_start = a.task[b].getSched() + dur[b];
//
//				if (a.task[i].getSched() < ti_start) {
//					t_duration += 2 * (a.task[i].getSched()- (a.task[b].getSched() + dur[b] / 2)) / dur[b]; // làm đc 50% thì task i có thể làm, nhân 2 để đưa điểm lên
//				}
//				else if (a.task[i].getSched() < t_deadline) {
//					t_duration += 0.9 + 0.1 * (t_deadline - a.task[i].getSched()) / (t_deadline - ti_start);
//				}
//				else {
//					t_duration += 0.9 - (a.task[i].getSched()- t_deadline) / dur[i];
//				}
//				n ++;
//			}
//			return t_duration / n;
//		}
//
//	}
//	
//	public float experience(Individual a, int i) {
//		int ns = 0;
//		float ti_exp = 0;
//		for(int j = 0; j < s; j++) {
//			float sume = 0;
//			for(int k = 0; k < r; k++) {
//				float lexpkj = a.task[i].getAssign(k) * lexp[k][j];
//				sume += lexpkj;
//			}
//			
//			ti_exp += (treq[i][j]*sume/(sume + 1));
//			ns += treq[i][j];
//		}
//		return (float) (ti_exp / (ns + 1e-9)); 
//		
	//}
}
