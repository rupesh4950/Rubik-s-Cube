package rubixCube;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class MainRubix {
	static char white[][] = new char[3][];
	static char red[][] = new char[3][];
	static char blue[][] = new char[3][];
	static char orange[][] = new char[3][];
	static char green[][] = new char[3][];
	static char yellow[][] = new char[3][];
	static int itr=0;

//f f' l l' u u' r r' b b' d d'
	// f front blue side
	// l white left to red side
	// r red [0][1] to white side
	// b back form blue to white
	// d blue to red
	public static void main(String[] args) {
		fillCollors();
		//d_();
		slove();
		printAll();
	}

	private static void slove() {
		sloveFirstLayer();
	}

	private static void sloveFirstLayer() {
		makeAPlusWithWhite();
		arrangeWhitesAtExacte();
		setTheCorners();
		
	}

	private static void setTheCorners() {
		//firest set rwb
		HashMap<Integer, String> val = getAllColorAtCorner();
		
	}

	private static HashMap<Integer, String> getAllColorAtCorner() {
		HashMap<Integer, String> val=new HashMap<Integer, String>();
		String s=""+white[0][0]+green[0][0]+orange[0][2];
		val.put(1, s);
		s=""+white[0][2]+blue[0][2]+orange[0][0];
		val.put(2, s);
		s=""+white[2][0]+green[0][2]+red[0][0];
		val.put(3,s);
		s=""+white[2][2]+blue[0][0]+red[0][2];
		val.put(4,s);
		///////////
		s=""+yellow[2][2]+green[2][2]+red[2][0];
		val.put(5,s);
		s=""+yellow[2][0]+blue[2][0]+red[2][2];
		val.put(6,s);
		s=""+yellow[0][2]+blue[2][2]+orange[2][0];
		val.put(7,s);
		s=""+yellow[0][0]+green[2][0]+orange[2][2];
		return val;
		
		
	}

	private static void arrangeWhitesAtExacte() {
		 HashMap<Integer, Character> v = getLocationsOfOthersColorsWithPluesMiddles();
		 if(v.get(1)!='o') {
			 System.out.println("its not equral to orange need ot change");
			int n= getIndexOfColor('o',v);
			if(n==2) {
				r();
				r();
				d();
				b();
				b();
				d_();
				r();
				r();
			}
			if(n==3) {
				l();
				l();
				d_();
				b();
				b();
				d();
				l();
				l();
			}
			if(n==4) {
				f();
				f();
				d();
				d();
				b();
				b();
				d();
				d();
				f();
				f();
			}
			 v = getLocationsOfOthersColorsWithPluesMiddles();
		 }
		 if(v.get(2)!='g') {
			 System.out.println("its not equral to green need ot change");
			 int n= getIndexOfColor('g',v);
			 if(n==1) {
				 b();
				 b();
				 d_();
				 r();
				 r();
				 d();
				 b();
			 }
			 else if(n==3) {
				 l();
				 l();
				 d();
				 d();
				 r();
				 r();
				 d();
				 d();
				 l();
				 l();
				
			 }
			 else if(n==4) {
				f();
				f();
				d();
				r();
				r();
				d_();
				f();
				f();
			 }
			 v = getLocationsOfOthersColorsWithPluesMiddles();
			 
		 }
		 if(v.get(3)!='b') {
			 System.out.println("its not equral to blue need ot change");
			 int n= getIndexOfColor('b',v);
			 if(n==1) {
				 b();
				 b();
				 d();
				 l();
				 l();
				 d_();
				 b();
				 b();
				 v.put(1, v.get(3));
			 }
			 else if(n==2) {
				 r();
				 r();
				 d();
				 d();
				 l();
				 l();
				 d();
				 d();
				 r();
				 r();
				 v.put(2, v.get(3));
			 }
			 else if (n==4) {
				 f();
				 f();
				 d_();
				 l();
				 l();
				 d();
				 f();
				 f();
				 v.put(4,v.get(3));
			 }
			 v = getLocationsOfOthersColorsWithPluesMiddles();
		 }
		 if(v.get(4)!='r') {
			 System.out.println("its not equral to red need ot change");
			 int n= getIndexOfColor('r',v);
			 if(n==1) {
				 b();
				 b();
				 d();
				 d();
				 f();
				 f();
				 d();
				 d();
				 b();
				 b();
				 v.put(1,v.get(4));
			 }
			 else if(n==2) {
				r();
				r();
				d_();
				f();
				f();
				d();
				r();
				r();
				v.put(2,v.get(4));
			 }
			 else if(n==3) {
				 l();
				 l();
				 d();
				 f();
				 f();
				 d_();
				 l();
				 l();
				 v.put(3,v.get(4));
			 }
			 v = getLocationsOfOthersColorsWithPluesMiddles();
		 }
		
	}

	private static int getIndexOfColor(char c, HashMap<Integer, Character> v) {
		if(v.get(1)==c) {
			return 1;
		}
		if(v.get(2)==c) {
			return 2;
		}
		if(v.get(3)==c) {
			return 3;
		}
		if(v.get(4)==c) {
			return 4;
		}
		return c;
		
	}

	private static HashMap<Integer, Character> getLocationsOfOthersColorsWithPluesMiddles() {
		HashMap<Integer,Character> val=new HashMap<Integer, Character>();
		char c[]=new char[4];
		c[0]= orange[0][1];
		
		val.put(1, orange[0][1]);
		val.put(2, green[0][1]);
		val.put(3, blue[0][1]);
		val.put(4, red[0][1]);
		return val;
		
	}

	private static void makeAPlusWithWhite() {
		// firest need to move all white to top
		ArrayList<String> v = findAllWhites();
		ArrayList<String> comp = new ArrayList<String>();
		while (true) {
			// v.removeAll(comp);
			if (v.size() == 0) {
				break;
			}

			String s = v.get(0);
			if (s.contains("w")) {
				comp.add(s);
				v.remove(s);
				System.out.println("already present");
			} else if (s.contains("r")) {
				System.out.println("values are " + v);
				sloveMiddleWhiteAtRed(s);
				v = findAllWhites();
			} else if (s.contains("b")) {
				System.out.println("values are " + v);
				sloveMiddleWhiteAtBlue(s);
				v = findAllWhites();
				// break;
			} else if (s.contains("o")) {
				System.out.println("values are " + v);
				sloveMiddleWhiteAtOrange(s);
				v = findAllWhites();
			}

			else if (s.contains("g")) {
				System.out.println("values are " + v);
				sloveMiddleWhiteAtGreen(s);
				v = findAllWhites();
			} else if (s.contains("y")) {
				System.out.println("values are " + v);
				sloveMiddleWhiteAtYellow(s);
				v = findAllWhites();
			}
			// break;

		}

		
	}

	private static void sloveMiddleWhiteAtYellow(String s) {
		if (s.contains("1")) {
			// kepp white 1 empty
			kepWhiteAt1();
			b();
			b();
		} else if (s.contains("2")) {
			kepWhiteAt3();
			l();
			l();

		} else if (s.contains("3")) {
			kepWhiteAt2();
			r();
			r();
		} else if (s.contains("4")) {
			kepWhiteAt4();
			f();
			f();
		}

	}

	private static void sloveMiddleWhiteAtGreen(String s) {
		if (s.contains("1")) {
			r_();
			kepWhiteAt4();
			f();

		} else if (s.contains("2")) {
			kepWhiteAt1();
			b_();
		} else if (s.contains("3")) {
			kepWhiteAt4();
			f();
		} else if (s.contains("4")) {
			d_();
			sloveWhiteAtRedBottom();
		}

	}

	private static void sloveMiddleWhiteAtOrange(String s) {
		if (s.contains("1")) {
			b();
			kepWhiteAt2();
			r_();
		} else if (s.contains("2")) {
			kepWhiteAt3();
			l();
		} else if (s.contains("3")) {
			kepWhiteAt2();
		} else if (s.contains("4")) {
			d();
			d();
			sloveWhiteAtRedBottom();
		}

	}

	private static void sloveMiddleWhiteAtBlue(String s) {
		System.out.println("==========");
		System.out.println("slovieng " + s);
		if (s.contains("1")) {
			// perform l
			l();
			kepWhiteAt4();
			f_();
		} else if (s.contains("2")) {
			kepWhiteAt4();
			f_();
		} else if (s.contains("3")) {
			kepWhiteAt1();
			b();
		} else if (s.contains("4")) {
			d();
			sloveWhiteAtRedBottom();

		}

	}


	private static void sloveMiddleWhiteAtRed(String s) {
		System.out.println("==========");
		System.out.println("slovieng " + s);
		// if white present at top of red
		if (s.contains("1")) {
			// perform f
			f();
			int n = findNonWhiteOnTop();
			if (n == 1) {
				// perform u 1 time
				u();
			} else if (n == 2) {

				// perform u 2 time
				u();
				u();
			} else if (n == 3) {
				// no need of any orperaiton
			} else if (n == 4) {
				// perform u * 1 time
				u_();
			}
			l_();

		}
		// if white present at top of red midle and green
		else if (s.contains("2")) {
			int n = findNonWhiteOnTop();
			if (n == 1) {
				// perform u_ 1 time
				u_();
			} else if (n == 2) {
				// already at possion
			} else if (n == 3) {
				// perfomr u 2 times
				u();
				u();
			} else if (n == 4) {
				// perform u 1 time
				u();
			}
			// perfomr r
			r();

		} else if (s.contains("3")) {
			int n = findNonWhiteOnTop();
			if (n == 1) {

				// perform u 1 time
				u();
			} else if (n == 2) {

				// perform u 2 time
				u();
				u();
			} else if (n == 3) {
				// no need of any orperaiton
			} else if (n == 4) {
				// perform u * 1 time
				u_();
			}
			l_();
		} else if (s.contains("4")) {
			sloveWhiteAtRedBottom();
		}

		System.out.println("==========");

	}

	private static void sloveWhiteAtRedBottom() {
		// perform f *
		f_();
		int n = findNonWhiteOnTop();
		if (n == 1) {

			// perform u 1 time
			u();
		} else if (n == 2) {

			// perform u 2 time
			u();
			u();
		} else if (n == 3) {
			// no need of any orperaiton
		} else if (n == 4) {
			// perform u * 1 time
			u_();
		}
		// l*
		l_();
		// again we need to check the top at 4 empty shoub be there
		n = findNonWhiteOnTop();
		if (n == 1) {

			// perform u 1 time
			u_();
		} else if (n == 2) {
			// perform u 2 time
			u();
			u();
		} else if (n == 3) {
			// perform u 1 time
			u();

		} else if (n == 4) {
			// alredy at possition
		}

		// f
		f();

	}

	private static void kepWhiteAt1() {
		int n = findNonWhiteOnTop();
		if (n == 1) {

		} else if (n == 2) {
			// perform u 2 time
			u();
		} else if (n == 3) {
			u_();

		} else if (n == 4) {
			u();
			u();
		}

	}

	private static void kepWhiteAt2() {
		int n = findNonWhiteOnTop();
		if (n == 1) {
			u_();
		} else if (n == 2) {

		} else if (n == 3) {
			u();
			u();
		} else if (n == 4) {
			u();
		}

	}

	private static void kepWhiteAt3() {
		int n = findNonWhiteOnTop();
		if (n == 1) {
			u();
		} else if (n == 2) {
			u();
			u();
		} else if (n == 3) {

		} else if (n == 4) {
			u_();
		}

	}

	private static void kepWhiteAt4() {
		int n = findNonWhiteOnTop();
		if (n == 1) {
			// perform u_ 1 time
			u_();
			u_();
		} else if (n == 2) {

			// perform u 2 time
			u_();

		} else if (n == 3) {
			u();
		} else if (n == 4) {

		}

	}

	private static ArrayList<String> findAllWhites() {
		ArrayList<String> v = new ArrayList<String>();
		v.addAll(getWhites(white));
		v.addAll(getWhites(red));
		v.addAll(getWhites(blue));
		v.addAll(getWhites(orange));
		v.addAll(getWhites(green));
		v.addAll(getWhites(yellow));
		// System.out.println(v);
		return v;

	}

	private static int findNonWhiteOnTop() {
		char[][] color = white;

		if (color[0][1] != 'w') {
			return 1;
		} else if (color[1][0] != 'w') {
			return 2;
		} else if (color[1][2] != 'w') {
			return 3;
		} else if (color[2][1] != 'w') {
			return 4;
		}
		return -1;

	}

	private static ArrayList<String> getWhites(char[][] color) {
		ArrayList<String> v = new ArrayList<String>();

		if (color[0][1] == 'w') {
			v.add(color[1][1] + "1");
		}
		if (color[1][0] == 'w') {
			v.add(color[1][1] + "2");
		}
		if (color[1][2] == 'w') {
			v.add(color[1][1] + "3");
		}
		if (color[2][1] == 'w') {
			v.add(color[1][1] + "4");
		}

		return v;

	}

	private static void l_() {
		System.out.println(++itr+ " perform l *");
		char c[] = new char[3];
		for (int i = 0; i < 3; i++) {
			c[i] = white[i][2];
			white[i][2] = red[i][2];
			red[i][2] = yellow[2 - i][0];
			yellow[2 - i][0] = orange[2 - i][0];
			orange[2 - i][0] = c[i];
		}
		spin90F(blue);
	}

	private static void l() {
		System.out.println(++itr+" perform l ");
		char c[] = new char[3];
		for (int i = 0; i < 3; i++) {
			c[i] = white[i][2];
			white[i][2] = orange[2 - i][0];
			orange[2 - i][0] = yellow[2 - i][0];
			yellow[2 - i][0] = red[i][2];
			red[i][2] = c[i];
		}
		spin90R(blue);
	}

	private static void d_() {
		System.out.println(++itr+" perform d * down green to red ");
		char c[] = red[2];
		red[2] = green[2];
		green[2] = orange[2];
		orange[2] = blue[2];
		blue[2] = c;
		spin90F(yellow);

	}

	private static void d() {
		System.out.println(++itr+" perform d down blue to red");
		char c[] = red[2];
		red[2] = blue[2];
		blue[2] = orange[2];
		orange[2] = green[2];
		green[2] = c;
		spin90R(yellow);

	}

	private static void b_() {
		System.out.println(++itr+" perfom b * form green to white");
		char c[] = new char[3];
		for (int i = 0; i < 3; i++) {
			c[i] = white[0][i];
			white[0][i] = green[2 - i][0];
			green[2 - i][0] = yellow[0][i];
			yellow[0][i] = blue[i][2];
			blue[i][2] = c[i];
		}
		spin90R(orange);

	}

	private static void b() {
		System.out.println(++itr+" perfom b form blue to white");
		char c[] = new char[3];
		for (int i = 0; i < 3; i++) {
			c[i] = white[0][i];
			white[0][i] = blue[i][2];
			blue[i][2] = yellow[0][i];
			yellow[0][i] = green[2 - i][0];
			green[2 - i][0] = c[i];
		}
		spin90F(orange);

	}

	private static void r_() {
		System.out.println(++itr+" perform r *");
		char c[] = new char[3];
		for (int i = 0; i < 3; i++) {
			c[i] = white[i][0];
			white[i][0] = orange[2 - i][2];
			orange[2 - i][2] = yellow[2 - i][2];
			yellow[2 - i][2] = red[i][0];
			red[i][0] = c[i];
		}
		spin90F(green);

	}

	private static void r() {
		System.out.println(++itr+" perform r");
		char c[] = new char[3];
		for (int i = 0; i < 3; i++) {
			c[i] = white[i][0];
			white[i][0] = red[i][0];
			red[i][0] = yellow[2 - i][2];
			yellow[2 - i][2] = orange[2 - i][2];
			orange[2 - i][2] = c[i];
		}
		spin90R(green);

	}

	private static void u_() {
		System.out.println(++itr+" perform u *");
		char c[] = red[0];
		red[0] = green[0];
		green[0] = orange[0];
		orange[0] = blue[0];
		blue[0] = c;
		spin90R(white);

	}

	private static void u() {
		System.out.println(++itr+" perorm u");
		char r[] = red[0];
		red[0] = blue[0];
		blue[0] = orange[0];
		orange[0] = green[0];
		green[0] = r;
		spin90F(white);

	}

	private static void f_() {
		System.out.println(++itr+" perform f *");
		char w[] = new char[3];
		for (int i = 0; i < 3; i++) {
			w[i] = white[2][i];
			white[2][i] = blue[i][0];
			blue[i][0] = yellow[2][i];
			yellow[2][i] = green[2 - i][2];
			green[2 - i][2] = w[i];
		}
		spin90R(red);

	}

	private static void f() {
		System.out.println(++itr+ " perform f");
		char w[] = new char[3];

		for (int i = 0; i < 3; i++) {
			w[i] = white[2][i];
			white[2][i] = green[2 - i][2];
			green[2 - i][2] = yellow[2][i];
			yellow[2][i] = blue[i][0];
			blue[i][0] = w[i];
		}
		spin90F(red);

	}

	private static void spin90F(char[][] color) {
		char c0[] = color[0];
		char c1[] = color[1];
		char c2[] = color[2];
		for (int i = 0; i < 3; i++) {
			char c[] = { c2[i], c1[i], c0[i] };
			color[i] = c;
		}

	}

	private static void spin90R(char[][] color) {
		char c0[] = color[0];
		char c1[] = color[1];
		char c2[] = color[2];
		for (int i = 0; i < 3; i++) {
			char c[] = { c0[i], c1[i], c2[i] };
			color[2 - i] = c;
		}

	}

	private static void fillCollors() {
		String w = "oobowrgbr";
		String r = "wybbrgggy";
		String b = "wwoybobyy";
		String o = "wggwogobb";
		String g = "wyrwgwyoy";
		String y = "grrryborr";

		white = fill(w);
		red = fill(r);
		blue = fill(b);
		orange = fill(o);
		green = fill(g);
		yellow = fill(y);
		printAll();

	}

	private static void printAll() {
		print(white, "White");
		print(red, "red");
		print(blue, "blue");
		print(orange, "orange");
		print(green, "green");
		print(yellow, "yellow");

	}

	private static void print(char[][] w, String name) {
		System.out.println(name);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(w[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}

	private static char[][] fill(String w) {
		char[] a = new char[3];
		char[] b = new char[3];
		char[] c = new char[3];
		for (int i = 0; i < 9; i++) {
			if (i < 3) {
				a[i] = w.charAt(i);
			} else if (i < 6) {
				b[i - 3] = w.charAt(i);
			} else {
				c[i - 6] = w.charAt(i);
			}
		}
		char[][] d = { a, b, c };
		return d;
	}

}
/*
 * static Object[][] cube = new Object[6][]; static char[][] white = new
 * char[3][]; static char[][] red = new char[3][]; static char[][] blue = new
 * char[3][]; static char[][] orange = new char[3][]; static char[][] green =
 * new char[3][]; static char[][] yellow = new char[3][];
 * 
 * public static void main(String[] args) { fillColours(); print(); sloveTop();
 * }
 * 
 * private static void sloveTop() { findWhitesAndArrangePlus();
 * 
 * }
 * 
 * private static void findWhitesAndArrangePlus() { checkAll12Parts();
 * 
 * }
 * 
 * private static void checkAll12Parts() { System.out.println("sloveingg");
 * boolean c = true; if (c) { f_(); print(); return; } ArrayList top =
 * getTopWhite(); System.out.println(top); for (int i = 0; i < top.size(); i++)
 * { String color = (String) top.get(i); System.out.println(top.get(i)); if
 * (color.charAt(1) == 'w') { System.out.println("already at possion");
 * continue; } // if white midle at red top if (color.charAt(1) == 'r') { //
 * keep not filled on 3rd possion f(); // print();
 * 
 * while (checkWVlaisWhie(1, 2)) { System.out.println(checkWVlaisWhie(1, 2)); //
 * u operaion should be performed u(); // print(); }
 * System.out.println("at w 1,2 there is not white"); // now need to perform r-
 * r_(); top = getTopWhite(); i=0;
 * 
 * } // if white midle at blue top if (color.charAt(1) == 'b') {
 * 
 * r(); ArrayList<Integer> l = getWhiteEmptyNumbers(); if (!(l.contains(4))) {
 * if (l.contains(2)) { u(); u(); u(); } else if (l.contains(1)) { u(); u(); }
 * 
 * } { System.out.println("is is empty"); } System.out.println(" can rotate f");
 * f(); f(); f(); i=0; top=getTopWhite();
 * 
 * } // if it is at orange if (color.charAt(1) == 'o') {
 * 
 * b(); b(); b(); ArrayList<Integer> l = getWhiteEmptyNumbers();
 * if(!l.contains(3)) { if(l.contains(2)) { u(); u(); } else if(l.contains(3)) {
 * u(); u(); u(); }
 * 
 * } else { System.out.println("already present at possiotin"); } r(); }
 * 
 * } print(); } private static ArrayList<Integer> getWhiteEmptyNumbers() {
 * ArrayList<Integer> l = new ArrayList<Integer>(); if (!(white[0][1] == 'w')) {
 * l.add(1); } if (!(white[1][0] == 'w')) { l.add(2); } if (!(white[1][2] ==
 * 'w')) { l.add(3); } if (!(white[2][1] == 'w')) { l.add(4); }
 * 
 * return l; } private static void l() {
 * System.out.println(" l  is left hand side top to bottom "); char w[] = new
 * char[3]; char r[] = new char[3]; char y[] = new char[3]; for(int i=0;i<3;i++)
 * {
 * 
 * w[i]=white[i][0]; white[i][0]=orange[2-i][2]; orange[2-i][2]=yellow[i][0];
 * yellow[i][0]=red[i][0]; red[i][0]=w[i]; }
 * 
 * // need to rotate green 90 degrees char[] o0 = green[0], o1 = green[1], o2 =
 * green[2]; for (int i = 0; i < 3; i++) { char c[] = { o2[i], o1[i], o0[i] };
 * orange[i] = c; }
 * 
 * } private static void l_() { System.out.println("L* should be performed");
 * char w[]=new char[3]; for(int i=0;i<3;i++) { w[i]=white[i][0];
 * white[i][0]=red[i][0]; red[i][0]=yellow[i][0]; yellow[i][0]=orange[2-i][2];
 * orange[2-i][2]=w[i]; }
 * 
 * char[] b0 = green[0], b1 = green[1], b2 = green[2]; for (int i = 0; i < 3;
 * i++) { char c[] = { b0[i], b1[i], b2[i] }; green[2-i] = c; }
 * 
 * }
 * 
 * private static void b() {
 * System.out.println("need to perform back form left to right  action"); char
 * w[]=new char[3]; for(int i=0;i<3;i++) { w[i]=white[0][i];
 * white[0][i]=blue[i][2]; blue[i][2]=yellow[2][2-i];
 * yellow[2][2-i]=green[2-i][0];
 * 
 * } for(int i=0;i<3;i++) { System.out.print("===>"+w[2-i]); green[i][0]=w[2-i];
 * }
 * 
 * // rotate orange(keep orang front white top) 90 degree clock wise char[] o0 =
 * orange[0], o1 = orange[1], o2 = orange[2]; for (int i = 0; i < 3; i++) { char
 * c[] = { o2[i], o1[i], o0[i] }; orange[i] = c; }
 * 
 * } private static void b_() { System.out.println("perform b * back"); char
 * w[]=new char[3]; for(int i=0;i<3;i++) { w[i]=white[0][i];
 * white[0][i]=green[2-i][0]; green[2-i][0]=yellow[2][2-i];
 * yellow[2][2-i]=blue[i][2]; } for(int i=0;i<3;i++) { blue[i][2]=w[i]; } char[]
 * b0 = orange[0], b1 = orange[1], b2 = orange[2]; for (int i = 0; i < 3; i++) {
 * char c[] = { b0[i], b1[i], b2[i] }; orange[2-i] = c; }
 * 
 * }
 * 
 * private static void r() { System.out.println("r  is should perfprmed"); char
 * w[] = new char[3]; char r[] = new char[3]; char y[] = new char[3]; for (int i
 * = 0; i < 3; i++) { w[i] = white[i][2]; white[i][2] = red[i][2]; red[i][2] =
 * yellow[i][2]; yellow[i][2] = orange[2 - i][0]; orange[2 - i][0] = w[i];
 * 
 * } // rotate blue 90 degree clock wise char[] r0 = blue[0], r1 = blue[1], r2 =
 * blue[2]; for (int i = 0; i < 3; i++) { char c[] = { r2[i], r1[i], r0[i] };
 * blue[i] = c; }
 * 
 * }
 * 
 * private static void r_() { System.out.println("r  is perfprmed"); char w[] =
 * new char[3]; char r[] = new char[3]; char y[] = new char[3]; for (int i = 0;
 * i < 3; i++) { w[i] = white[i][2]; white[i][2] = orange[2 - i][0]; // red r[i]
 * = red[i][2]; red[i][2] = w[i]; // yellow y[i] = yellow[i][2]; yellow[i][2] =
 * r[i]; // oragnge } for (int i = 0; i < 3; i++) { //System.out.print(y[i]);
 * orange[i][0] = y[2 - i]; } // blue anti clock wise 90
 * 
 * char[] b0 = blue[0], b1 = blue[1], b2 = blue[2]; for (int i = 0; i < 3; i++)
 * { char c[] = { b0[i], b1[i], b2[i] }; blue[2 - i] = c; } }
 * 
 * private static void u() { // u operation should be performed
 * System.out.println("u opration performed"); char g[] = green[0]; green[0] =
 * red[0]; char o[] = orange[0]; orange[0] = g; char b[] = blue[0]; blue[0] = o;
 * red[0] = b; // rotate white 90 clock wise char[] r0 = white[0], r1 =
 * white[1], r2 = white[2]; for (int i = 0; i < 3; i++) { char c[] = { r2[i],
 * r1[i], r0[i] }; white[i] = c; }
 * 
 * } private static void u_() { System.out.println("perfom u *"); char
 * r[]=red[0]; red[0]=green[0]; green[0]=orange[0]; orange[0]=blue[0];
 * blue[0]=red[0]; char[] b0 = white[0], b1 = white[1], b2 = white[2]; for (int
 * i = 0; i < 3; i++) { char c[] = { b0[i], b1[i], b2[i] }; white[2-i] = c; } }
 * private static void f() {
 * System.out.println("f operation should be performed"); char[] w = white[2];
 * char[] b = new char[3]; for (int i = 0; i < 3; i++) { b[2 - i] = blue[i][0];
 * blue[i][0] = w[i]; } char[] y = yellow[0]; yellow[0] = b; char[] g = new
 * char[3]; for (int i = 0; i < 3; i++) { g[2 - i] = green[i][2]; green[i][2] =
 * y[i]; } white[2] = g;
 * 
 * // now red should be swaped char[] r0 = red[0], r1 = red[1], r2 = red[2]; for
 * (int i = 0; i < 3; i++) { char c[] = { r2[i], r1[i], r0[i] }; red[i] = c; } }
 * private static void f_() { System.out.println("perform f *"); char w[]=new
 * char[3]; for(int i=0;i<3;i++) { w[i]=white[2][i]; white[2][i]=blue[i][0];
 * blue[i][0]=yellow[0][2-i]; yellow[0][2-i]=green[2][2-i];
 * 
 * } } private static boolean checkWVlaisWhie(int i, int j) { return white[i][j]
 * == 'w' ? true : false;
 * 
 * }
 * 
 * private static ArrayList<String> getTopWhite() { ArrayList<String> whiteC =
 * new ArrayList<String>(); // w01 if (white[0][1] == 'w') { whiteC.add("0w1");
 * } else if (orange[0][1] == 'w') { whiteC.add("0o1"); } ////
 * System.out.println(whiteC); // w11 if (white[1][1] == 'w') {
 * whiteC.add("1w1"); } else if (green[0][1] == 'w') { whiteC.add("0g1"); } //
 * System.out.println(whiteC); // w12 if (white[1][2] == 'w') {
 * whiteC.add("1w2"); } else if (blue[0][1] == 'w') { whiteC.add("0b1"); } //
 * System.out.println(whiteC); // w21 if (white[2][1] == 'w') {
 * whiteC.add("2w1"); } else if (red[0][1] == 'w') { whiteC.add("0r1"); } //
 * System.out.println(whiteC); return whiteC;
 * 
 * }
 * 
 * private static void print() { print(white, "white"); print(red, "red");
 * print(blue, "blue"); print(orange, "orange"); print(green, "green");
 * print(yellow, "yellow");
 * 
 * }
 * 
 * private static void print(char[][] val, String name) {
 * System.out.println("====" + name + "====="); for (int i = 0; i <
 * val[0].length; i++) { for (int j = 0; j < 3; j++) {
 * System.out.print(val[i][j] + " "); } System.out.println(); }
 * 
 * }
 * 
 * private static void fillColours() {
 * System.out.println("keep white on top and red in front"); char y = 'y', w =
 * 'w', b = 'b', r = 'r', g = 'g', o = 'o';
 * 
 * char[] w1 = splitAndReturnasArray("wwg"), w2 = splitAndReturnasArray("bww"),
 * w3 = splitAndReturnasArray("wyy");
 * 
 * white[0] = w1; white[1] = w2; white[2] = w3;
 * 
 * char[] r1 = splitAndReturnasArray("gro"), r2 = splitAndReturnasArray("yrw"),
 * r3 = splitAndReturnasArray("bgw"); red[0] = r1; red[1] = r2; red[2] = r3;
 * 
 * char[] b1 = splitAndReturnasArray("boo"), b2 = splitAndReturnasArray("rbb"),
 * b3 = splitAndReturnasArray("rog"); blue[0] = b1; blue[1] = b2; blue[2] = b3;
 * 
 * char[] o1 = splitAndReturnasArray("ybr"), o2 = splitAndReturnasArray("roo"),
 * o3 = splitAndReturnasArray("rgw"); orange[0] = o1; orange[1] = o2; orange[2]
 * = o3;
 * 
 * char[] g1 = splitAndReturnasArray("byo"), g2 = splitAndReturnasArray("bgg"),
 * g3 = splitAndReturnasArray("owr"); green[0] = g1; green[1] = g2; green[2] =
 * g3; // oranger should be front yellow should be top blue left char[] y1
 * =splitAndReturnasArray("yrg"), y2 =splitAndReturnasArray("gyy"), y3 =
 * splitAndReturnasArray("boy"); yellow[0] = y1; yellow[1] = y2; yellow[2] = y3;
 * 
 * // cube[0]=white; // cube[1]=red; // cube[2]=blue; // cube[3]=orange; //
 * cube[4]=green; // cube[5]=yellow;
 * 
 * }
 * 
 * private static char[] splitAndReturnasArray(String s) { char []c=new char[3];
 * for(int i=0;i<3;i++) { c[i]=s.charAt(i); } return c; }
 */