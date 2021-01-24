/*============================================================================
  Problem     : Java Priority Queue
  Author      : Santiago Soto
  Copyright   : ssotom
  Version     : HackerRank - Accepted
  link        : https://www.hackerrank.com/challenges/java-priority-queue/problem
  Created on January 2021
 ============================================================================*/

import java.util.*;


class Student {
	private int ID;
	private String name;
	private float CGPA;

	public Student(int ID, String name, float CGPA) {
		this.ID = ID;
		this.name = name;
		this.CGPA = CGPA;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public float getCGPA() {
		return CGPA;
	}
}

class Priorities {
	private final PriorityQueue<Student> queue = new PriorityQueue<>(
			Comparator.comparing(Student::getCGPA).reversed()
					.thenComparing(Student::getName)
					.thenComparing(Student::getID));

	public List<Student> getStudents(List<String> events) {
		for (String event : events) {
			if (event.equals("SERVED")) {
				queue.poll();
			}
			else {
				String[] details = event.split(" ");
				queue.add(new Student(Integer.parseInt(details[3]), details[1], Float.parseFloat(details[2])));
			}
		}

		List<Student> students = new LinkedList<>();
		while (!queue.isEmpty()) {
			students.add(queue.poll());
		}

		return students;
	}
}

public class Solution
{
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		}
		else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}
}
