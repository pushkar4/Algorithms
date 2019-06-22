
public class JobScheduling {
	
	SortedJobList jobListHead;
	
	public void addJob(char id, int deadline, int profit) {
		
		Job j = new Job(id, deadline, profit);
		
		SortedJobList jobNode = new SortedJobList(j);
		
		if(jobListHead == null)
			jobListHead = jobNode;
		else { 
			SortedJobList prev = null;
			SortedJobList curr = jobListHead;
			while(curr != null && curr.job.profit > jobNode.job.profit) {
				prev = curr;
				curr = curr.next;
			}
			
			jobNode.next = curr;
			if(prev == null)
				jobListHead = jobNode;
			else
				prev.next = jobNode;
		}
	}
	
	private int computeScheduleLength() {
		
		SortedJobList node = jobListHead;
		int max = Integer.MIN_VALUE;
		
		while(node != null) {
			if(node.job.deadline > max)
				max = node.job.deadline;
			node = node.next;
		}

		return max;
	}
	
	public void scheduleJobs() {
		
		int maxDeadline = computeScheduleLength();
		Job[] schedule = new Job[maxDeadline + 1];
		
		SortedJobList node = jobListHead;
		
		while(node != null) {
			
			Job job = node.job;
			
			for(int pos = job.deadline; pos >= 1; pos--) {
				if(schedule[pos] == null) {
					schedule[pos] = job;
					break;
				}
			}
			
			node = node.next;
		}
			
		for(int i = 1; i < schedule.length; i++) {
			if(schedule[i] != null)
				System.out.println(i + ": " + schedule[i].id + " " + schedule[i].deadline + " " + schedule[i].profit);
		}
	}	
}
