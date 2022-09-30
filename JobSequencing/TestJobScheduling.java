
public class TestJobScheduling {

  public static void main(String[] args) {

    JobScheduling js = new JobScheduling();
    js.addJob('a', 2, 100);
    js.addJob('b', 1, 19);
    js.addJob('c', 2, 27);
    js.addJob('d', 1, 25);
    js.addJob('e', 3, 15);
    js.scheduleJobs();

    System.out.println();

    JobScheduling js2 = new JobScheduling();
    js2.addJob('a', 2, 6);
    js2.addJob('b', 1, 8);
    js2.addJob('c', 1, 5);
    js2.addJob('d', 2, 10);
    js2.scheduleJobs();

    System.out.println();

    JobScheduling js3 = new JobScheduling();
    js3.addJob('a', 5, 200);
    js3.addJob('b', 3, 180);
    js3.addJob('c', 3, 190);
    js3.addJob('d', 2, 300);
    js3.addJob('e', 4, 120);
    js3.addJob('f', 2, 100);
    js3.scheduleJobs();

    System.out.println();

    JobScheduling js4 = new JobScheduling();
    js4.addJob('a', 3, 2);
    js4.addJob('b', 3, 4);
    js4.addJob('c', 3, 3);
    js4.addJob('d', 4, 1);
    js4.addJob('e', 4, 10);
    js4.scheduleJobs();

    System.out.println();

    JobScheduling js5 = new JobScheduling();
    js5.addJob('a', 7, 15);
    js5.addJob('b', 2, 20);
    js5.addJob('c', 5, 30);
    js5.addJob('d', 3, 18);
    js5.addJob('e', 4, 18);
    js5.addJob('f', 5, 10);
    js5.addJob('g', 2, 23);
    js5.addJob('h', 7, 16);
    js5.addJob('i', 3, 25);
    js5.scheduleJobs();
  }
}
