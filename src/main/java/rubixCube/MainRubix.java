package rubixCube;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class MainRubix {
	static Object[][] cube = new Object[6][];
	static char[][] white = new char[3][];
	static char[][] red = new char[3][];
	static char[][] blue = new char[3][];
	static char[][] orange = new char[3][];
	static char[][] green = new char[3][];
	static char[][] yellow = new char[3][];

	public static void main(String[] args) {
		fillColours();
		print();
		sloveTop();
	}

	private static void sloveTop() {
		findWhitesAndArrangePlus();

	}

	private static void findWhitesAndArrangePlus() {
		checkAll12Parts();

	}

	private static void checkAll12Parts() {
		System.out.println("sloveingg");
		boolean c = false;
		if (c) {
			r_();
			print();
			return;
		}
		ArrayList top = getTopWhite();
		System.out.println(top);
		for (int i = 0; i < top.size(); i++) {
			String color = (String) top.get(i);
			System.out.println(top.get(i));
			if (color.charAt(1) == 'w') {
				System.out.println("already at possion");
				continue;
			}
			// if white midle at red top
			if (color.charAt(1) == 'r') {
				// keep not filled on 3rd possion
				f();
				// print();

				while (checkWVlaisWhie(1, 2)) {
					System.out.println(checkWVlaisWhie(1, 2));
					// u operaion should be performed
					u();
					// print();
				}
				System.out.println("at w 1,2 there is not white");
				// now need to perform r-
				r_();
				top = getTopWhite();
				i=0;

			}
			// if white midle at blue top
			if (color.charAt(1) == 'b') {

				r();
				ArrayList<Integer> l = getWhiteEmptyNumbers();
				if (!(l.contains(4))) {
					if (l.contains(2)) {
						u();
						u();
						u();
					}
					else if (l.contains(1)) {
						u();
						u();
					}
				
				}
				{
					System.out.println("is is empty");
				}
				System.out.println(" can rotate f");
				f();
				f();
				f();
				i=0;
				top=getTopWhite();

			}
			// if it is at orange
			if (color.charAt(1) == 'o') {
				
				b();
				b();
				b();
				ArrayList<Integer> l = getWhiteEmptyNumbers();
				if(!l.contains(3)) {
					if(l.contains(2)) {
						u();
						u();
					}
					else if(l.contains(3)) {
						u();
						u();
						u();
					}
					
				}
				else {
					System.out.println("already present at possiotin");
				}
				r();
			}

		}
		print();
	}

	private static void b() {
		System.out.println("need to perform back form left to right  action");
		char w[]=new char[3];
		for(int i=0;i<3;i++) {
			w[i]=white[0][i];
			white[0][i]=blue[i][2];
			blue[i][2]=yellow[2][2-i];
			yellow[2][2-i]=green[2-i][0];
				
		}
		for(int i=0;i<3;i++) {
			System.out.print("===>"+w[2-i]);
			green[i][0]=w[2-i];
		}
		
		// rotate orange(keep orang front white top) 90 degree clock wise
				char[] o0 = orange[0], o1 = orange[1], o2 = orange[2];
				for (int i = 0; i < 3; i++) {
					char c[] = { o2[i], o1[i], o0[i] };
					orange[i] = c;
				}
		
	}

	private static ArrayList<Integer> getWhiteEmptyNumbers() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		if (!(white[0][1] == 'w')) {
			l.add(1);
		}
		if (!(white[1][0] == 'w')) {
			l.add(2);
		}
		if (!(white[1][2] == 'w')) {
			l.add(3);
		}
		if (!(white[2][1] == 'w')) {
			l.add(4);
		}

		return l;
	}

	private static void r_() {
		System.out.println("r * is should perfprmed");
		char w[] = new char[3];
		char r[] = new char[3];
		char y[] = new char[3];
		for (int i = 0; i < 3; i++) {
			w[i] = white[i][2];
			white[i][2] = red[i][2];
			red[i][2] = yellow[i][2];
			yellow[i][2] = orange[2 - i][0];
			orange[2 - i][0] = w[i];

		}
		// rotate blue 90 degree clock wise
		char[] r0 = blue[0], r1 = blue[1], r2 = blue[2];
		for (int i = 0; i < 3; i++) {
			char c[] = { r2[i], r1[i], r0[i] };
			blue[i] = c;
		}

	}

	private static void r() {
		System.out.println("r  is perfprmed");
		char w[] = new char[3];
		char r[] = new char[3];
		char y[] = new char[3];
		for (int i = 0; i < 3; i++) {
			w[i] = white[i][2];
			white[i][2] = orange[2 - i][0];
			// red
			r[i] = red[i][2];
			red[i][2] = w[i];
			// yellow
			y[i] = yellow[i][2];
			yellow[i][2] = r[i];
			// oragnge
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(y[i]);
			orange[i][0] = y[2 - i];
		}
		// blue anti clock wise 90

		char[] b0 = blue[0], b1 = blue[1], b2 = blue[2];
		for (int i = 0; i < 3; i++) {
			char c[] = { b0[i], b1[i], b2[i] };
			blue[2 - i] = c;
		}
	}

	private static void u() {
		// u operation should be performed
		System.out.println("u opration performed");
		char g[] = green[0];
		green[0] = red[0];
		char o[] = orange[0];
		orange[0] = g;
		char b[] = blue[0];
		blue[0] = o;
		red[0] = b;
		// rotate white 90 clock wise
		char[] r0 = white[0], r1 = white[1], r2 = white[2];
		for (int i = 0; i < 3; i++) {
			char c[] = { r2[i], r1[i], r0[i] };
			white[i] = c;
		}

	}

	private static void f() {
		System.out.println("f operation should be performed");
		char[] w = white[2];
		char[] b = new char[3];
		for (int i = 0; i < 3; i++) {
			b[2 - i] = blue[i][0];
			blue[i][0] = w[i];
		}
		char[] y = yellow[0];
		yellow[0] = b;
		char[] g = new char[3];
		for (int i = 0; i < 3; i++) {
			g[2 - i] = green[i][2];
			green[i][2] = y[i];
		}
		white[2] = g;

		// now red should be swaped
		char[] r0 = red[0], r1 = red[1], r2 = red[2];
		for (int i = 0; i < 3; i++) {
			char c[] = { r2[i], r1[i], r0[i] };
			red[i] = c;
		}
	}

	private static boolean checkWVlaisWhie(int i, int j) {
		return white[i][j] == 'w' ? true : false;

	}

	private static ArrayList<String> getTopWhite() {
		ArrayList<String> whiteC = new ArrayList<String>();
		// w01
		if (white[0][1] == 'w') {
			whiteC.add("0w1");
		} else if (orange[0][1] == 'w') {
			whiteC.add("0o1");
		}
		//// System.out.println(whiteC);
		// w11
		if (white[1][1] == 'w') {
			whiteC.add("1w1");
		} else if (green[0][1] == 'w') {
			whiteC.add("0g1");
		}
		// System.out.println(whiteC);
		// w12
		if (white[1][2] == 'w') {
			whiteC.add("1w2");
		} else if (blue[0][1] == 'w') {
			whiteC.add("0b1");
		}
		// System.out.println(whiteC);
		// w21
		if (white[2][1] == 'w') {
			whiteC.add("2w1");
		} else if (red[0][1] == 'w') {
			whiteC.add("0r1");
		}
		// System.out.println(whiteC);
		return whiteC;

	}

	private static void print() {
		print(white, "white");
		print(red, "red");
		print(blue, "blue");
		print(orange, "orange");
		print(green, "green");
		print(yellow, "yellow");

	}

	private static void print(char[][] val, String name) {
		System.out.println("====" + name + "=====");
		for (int i = 0; i < val[0].length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(val[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void fillColours() {
		System.out.println("keep white on top and red in front");
		char y = 'y', w = 'w', b = 'b', r = 'r', g = 'g', o = 'o';

		char[] w1 = splitAndReturnasArray("obr"), w2 = splitAndReturnasArray("wwb"), w3 = splitAndReturnasArray("ygb");
		
		white[0] = w1;
		white[1] = w2;
		white[2] = w3;

		char[] r1 = splitAndReturnasArray("oyr"), r2 = splitAndReturnasArray("grr"), r3 = splitAndReturnasArray("rww");
		red[0] = r1;
		red[1] = r2;
		red[2] = r3;

		char[] b1 = splitAndReturnasArray("yrw"), b2 = splitAndReturnasArray("wby"), b3 = splitAndReturnasArray("obr");
		blue[0] = b1;
		blue[1] = b2;
		blue[2] = b3;

		char[] o1 = splitAndReturnasArray("gwg"), o2 = splitAndReturnasArray("oor"), o3 = splitAndReturnasArray("woo");
		orange[0] = o1;
		orange[1] = o2;
		orange[2] = o3;

		char[] g1 = splitAndReturnasArray("wog"), g2 = splitAndReturnasArray("ygr"), g3 = splitAndReturnasArray("yog");
		green[0] = g1;
		green[1] = g2;
		green[2] = g3;
// oranger should be front yellow should be top blue left
		char[] y1 =splitAndReturnasArray("ygb"), y2 =splitAndReturnasArray("byy"), y3 = splitAndReturnasArray("bgb");
		yellow[0] = y1;
		yellow[1] = y2;
		yellow[2] = y3;

//		cube[0]=white;
//		cube[1]=red;
//		cube[2]=blue;
//		cube[3]=orange;
//		cube[4]=green;
//		cube[5]=yellow;

	}

	private static char[] splitAndReturnasArray(String s) {
		char []c=new char[3];
		for(int i=0;i<3;i++) {
			c[i]=s.charAt(i);
		}
		return c;
	}

}
