
public class Job {
	
	char id;
	int deadline;
	int profit;
	
	Job() {
		id = '\0';
		deadline = -1;
		profit = -1;
	}
	
	Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}
