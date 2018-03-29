package com.ganli.thread03.demo10.ThreadLocalTest.test;

import com.ganli.thread03.demo10.ThreadLocalTest.tools.Tools;
import com.ganli.thread03.demo10.ThreadLocalTest.extthread.ThreadA;
import com.ganli.thread03.demo10.ThreadLocalTest.extthread.ThreadB;

public class Run {

	public static void main(String[] args) {

		try {
			ThreadA a = new ThreadA();
			ThreadB b = new ThreadB();
			a.start();
			b.start();

			for (int i = 0; i < 100; i++) {
				if (Tools.tl.get() == null) {
					Tools.tl.set("Main" + (i + 1));
				} else {
					System.out.println("Main get Value=" + Tools.tl.get());
				}
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
