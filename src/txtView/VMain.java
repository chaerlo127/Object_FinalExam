package txtView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VMain {

	private VInitial initial;
	
	public VMain(Scanner scanner) {	
		this.initial = new VInitial(scanner);
	}
	public void run() {
		
		this.initial.show();
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss�� ������û ���α׷� �����մϴ�.");
		Date time = new Date();
		String onTime = sdf.format(time);
		System.out.println(onTime);
		VMain main = new VMain(scanner);
		main.run();
		scanner.close();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss�� ������û ���α׷��� �����մϴ�.");
		Date time1 = new Date();
		String onTime1 = sdf1.format(time1);
		System.out.println(onTime1);
		long end = System.currentTimeMillis();// ������ ���� ��.
		System.out.println("���α׷� ���ð�: " + ( end - start )/1000+"��");
		System.exit(0);
	}
}
