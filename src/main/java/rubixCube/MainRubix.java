package rubixCube;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainRubix {
	static char white[][] = new char[3][];
	static char red[][] = new char[3][];
	static char blue[][] = new char[3][];
	static char orange[][] = new char[3][];
	static char green[][] = new char[3][];
	static char yellow[][] = new char[3][];
	static int itr = 0;
	

	private static void fillCollors() {
		String w = "worbwbyyb";
		String r = "rrwyrgoog";
		String b = "rrgwbrwyy";
		String o = "ybogowowo";
		String g = "gwbrgoyyw";
		String y = "gobbygrgb";

		white = fill(w);
		red = fill(r);
		blue = fill(b);
		orange = fill(o);
		green = fill(g);
		yellow = fill(y);
		printAll();

	}

//f f' l l' u u' r r' b b' d d'
	// f front blue side
	// l white left to red side
	// r red [0][1] to white side
	// b back form blue to white
	// d blue to red
	public static void main(String[] args) {
		fillCollors();
		// d_();
		slove();
		printAll();
	}

	private static void slove() {
		sloveFirstLayer();
		printAll();
//		sloveSecondLayer();
//		printAll();
//		sloveThirdLayer();
	}

	private static void sloveThirdLayer() {
		slovePlusOnYellow();
		sloveMiddlesOfYellow();
		sloveToKeepCornersOfYellowAtPosstion();
		sloveCornersOfYellow();

	}

	private static void sloveCornersOfYellow() {
		System.out.println("Sloving the corners of the Yellow");
		for(int i=0;i<4;i++) {
			while(!isYellowOnTopCorner()) {
				serCorner();
			}
			yu();
		}
		
	}

	private static void serCorner() {
		System.out.println("********");
		yl();
		yd();
		yl_();
		yd_();
		
	}

	private static boolean isYellowOnTopCorner() {
		// TODO Auto-generated method stub
		System.out.println(yellow[2][2]);
		if(yellow[2][2]=='y')
			return true;
		else 
			return false;
		
	}

	private static void sloveToKeepCornersOfYellowAtPosstion() {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------");
		//setting the red 
		setRedCornerAtPosstion();

		
		
		////////////////////////////////////////
		
		int  p = getTheColorPossitonOnYellowCorner('r','b');
		if(p==0) {
			System.out.println("some error in the inputs");
			return;
		}
		if(p==2) {
			System.out.println("all colours at the possiton ");
			return;
		}
		else {
			System.out.println("setting blue color at the posstion");
			cornerRoteteFromRight();
			if(p==4) {
				cornerRoteteFromRight();
			}
		}
		
		
		System.out.println("blue color is set at possiton so all colores are at posstion");

	}

	private static void setRedCornerAtPosstion() {
		System.out.println("setting red and green");
		int p = getTheColorPossitonOnYellowCorner('r','g');
		if(p==0) {
			System.out.println("some input error check");
			return;
		}
		if(p==1) {
			System.out.println("red and green is already at the possition");
			return;
		}
		else {
			if(p==2) {
				System.out.println("red and green possiton is at "+p);
				cornerRoteteFromRight();
				cornerRoteteFromLeft();	
			}
			else if(p==3) {
				cornerRoteteFromLeft();	
				cornerRoteteFromLeft();	
			}
			else if (p==4) {
				cornerRoteteFromLeft();	
			}
			
		}
		System.out.println(" red and green set at possition");
	}

	private static void cornerRoteteFromLeft() {
		System.out.println("corner rotate form left");
		yu_();
		yr();
		yu();
		yl_();
		yu_();
		yr_();
		yu();
		yl();
		
	}

	private static void cornerRoteteFromRight() {
		System.out.println("corner rotate form right");
		yu();
		yl_();
		yu_();
		yr();
		yu();
		yl();
		yu_();
		yr_();
		
		
	}

	private static int getTheColorPossitonOnYellowCorner(char c, char d) {
		

		if ((yellow[2][2] == c || red[2][0] == c || green[2][2] == c)&&(yellow[2][2] == d || red[2][0] == d || green[2][2] == d)) {
			return 1;
		}
		if ((yellow[2][0] == c || red[2][2] == c || blue[2][0] == c)&&(yellow[2][0] == d|| red[2][2] == d || blue[2][0] == d)) {
			return 2;
		}
		if ((yellow[0][0] == c || orange[2][0] == c || blue[2][2] == c)&&(yellow[0][0] == d || orange[2][0] == d || blue[2][2] == d)) {
			return 3;
		}
		if((yellow[0][2] == c || orange[2][2] == c || green[2][0] == c)&& (yellow[0][2] == d|| orange[2][2] == d|| green[2][0] ==d )){
			return 4;
		}

		return 0;
	}

	private static void sloveMiddlesOfYellow() {
		setRedAtPossition();
		setBlueAtPossition();
		// setting remaing 2 colors

		int p = getThePositionOFColorYellow('g');
		if (p == 4) {
			System.out.println("all middles set can go further");
		} else if (p == 3) {
			// perofmr action
			yu();
			yu();
			yelloMiddleSide();
		} else {
			System.out.println("some issue with your input give valid input");
		}
		setRedAtPossition();
		System.out.println("All middles of Yellow are set now need to set the corners");
	}

	private static void setBlueAtPossition() {
		int p = getThePositionOFColorYellow('b');
		if (p == 2) {
			System.out.println("red is alredy at possiton");
		} else {
			int itr = 4 - 2;
			while (itr > 0) {
				itr--;
				yelloMiddleSide();
			}
		}

	}

	private static void setRedAtPossition() {
		int p = getThePositionOFColorYellow('r');
		if (p == 0) {
			return;
		}
		if (p == 1) {
			System.out.println("red is alredy at possiton");
		} else {
			for (int i = 1; i < p; i++) {
				yu_();
			}
		}

	}

	private static void yelloMiddleSide() {
		System.out.println("----------");
		yl_();
		yu();
		yl();
		yu();
		yl_();
		yu();
		yu();
		yl();

	}

	private static int getThePositionOFColorYellow(char c) {

		if (red[2][1] == c)
			return 1;
		else if (blue[2][1] == c)
			return 2;
		else if (orange[2][1] == c)
			return 3;
		else if (green[2][1] == c)
			return 4;

		System.out.println("invalid given inputs");
		return 0;
	}

	private static void slovePlusOnYellow() {
		System.out.println("inside method");
		printAll();
		ArrayList<Integer> v = getAllYellowsONtop();
		System.out.println("size is 266 is "+ v);
		if (v.size() == 0) {
			System.out.println("perofom reverser L operation");
			reverseL();
		}
		int r = checkLPosstion();
		System.out.println("size is 272 is "+ v);
		while (r > 0) {
			r--;
			yu();
		}
		v = getAllYellowsONtop();
		while (v.size() != 4) {

			reverseL();
			v = getAllYellowsONtop();
			System.out.println(v.size());
		}

	}

	private static int checkLPosstion() {
		ArrayList<Integer> v = getAllYellowsONtop();
		//System.out.println(v);
		if (v.contains(1) && v.contains(4))
			return 0;
		if (v.contains(1) && v.contains(2))
			return 3;
		if (v.contains(2) && v.contains(3))
			return 2;
		if (v.contains(3) && v.contains(4))
			return 1;
		if (v.contains(1) && v.contains(3))
			return 1;
		if (v.contains(2) && v.contains(4))
			return 0;

		return 0;

	}

	private static void reverseL() {
		yf();
		yl_();
		yu();
		yl();
		yu_();
		yf_();

	}

	private static ArrayList<Integer> getAllYellowsONtop() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		if (yellow[0][1] == 'y')
			a.add(1);
		if (yellow[1][2] == 'y')
			a.add(2);
		if (yellow[2][1] == 'y')
			a.add(3);
		if (yellow[1][0] == 'y')
			a.add(4);
		return a;
	}

	private static void yb_() {
		b_();

	}

	private static void yb() {
		b();

	}

	private static void yd_() {
		u();

	}

	private static void yd() {
		u_();

	}

	private static void yu_() {
		d();

	}

	private static void yu() {
		d_();

	}

	private static void yr() {
		l();

	}

	private static void yr_() {
		l_();

	}

	private static void yl_() {
		r_();

	}

	private static void yl() {
		r();

	}

	private static void yf_() {
		f_();

	}

	private static void yf() {
		f();

	}

	private static void sloveSecondLayer() {
		redAndGreenMiddle();
		redAndBlueMiddle();
		orangeAndBlue();
		orangeAndGreen();

	}

	private static void orangeAndGreen() {
		System.out.println("=========");
		int p = findPossitionOf("og");
		System.out.println(p);
		if (p == 0) {
			System.out.println("something went wrong check the colour inputs");
			return;
		}
		if (p == 4) {
			if (orange[1][2] == 'o') {
				System.out.println("orange and green is alreday at possition");
				return;
			} else {
				m4Down();
			}
		}
		p = findPossitionOf("og");
		System.out.println("og" + p);
		int truns = (7 - p);
		boolean entered = false;
		while (truns > 0) {
			entered = true;
			d_();
			truns--;
		}
		if (!entered) {
			truns = Math.abs(truns);
			while (truns > 0) {
				entered = true;
				d();
				truns--;
			}
		}
		System.out.println("orange and green is at down seta the  down -------");
		if (orange[2][1] == 'o') {
			System.out.println("orange is on top green down");
			m3Down();
		} else {
			System.out.println("green is on top orange down");
			d();
			d();
			b();
			d();
			b_();
			d();
			r();
			d_();
			r_();
		}

	}

	private static void orangeAndBlue() {
		System.out.println("=========");
		int p = findPossitionOf("ob");
		System.out.println(p);
		if (p == 0) {
			System.out.println("something went wrong check the colour inputs");
			return;
		}
		if (p == 3) {
			if (orange[1][0] == 'o') {
				System.out.println("orange and blue is already  at the possiton");
				return;
			} else {
				m3Down();
			}
		} else if (p == 4) {
			m4Down();
		}

		p = findPossitionOf("ob");
		System.out.println("ob" + p);
		int truns = (7 - p);
		boolean entered = false;
		while (truns > 0) {
			entered = true;
			d_();
			truns--;
		}
		if (!entered) {
			truns = Math.abs(truns);
			while (truns > 0) {
				entered = true;
				d();
				truns--;
			}
		}
		System.out.println("orange and blue is at down seta the  down -------");
		if (orange[2][1] == 'o') {
			System.out.println("orange is on top blue down");
			m3Down();
		} else {
			System.out.println("blue is on top orange is down");
			d();
			d();
			b_();
			d_();
			b();
			d_();
			l_();
			d();
			l();
		}

	}

	private static void redAndBlueMiddle() {
		System.out.println("========= sloving red and blue");
		System.out.println(orange[1][0] );
		System.out.println(blue[1][2] );
		printAll();
		int p = findPossitionOf("rb");
		System.out.println(p);
		if (p == 0) {
			System.out.println("something went wrong check the colour inputs"+5/0);
			return;
		}
		if (p <= 4) {
			if (p == 2) {
				if (red[1][2] == 'r') {
					System.out.println("red and blue alreday at place ");
					return;
				} else {
					// m2 to down
					m2Down();

				}
			} else if (p == 3) {
				// m3 down
				m3Down();
			} else if (p == 4) {
				m4Down();
			}
		}
		p = findPossitionOf("rb");
		System.out.println("rb " + p);
		int truns = p - 5;

		while (truns > 0) {
			d();
			truns--;
		}
		System.out.println("red and blue is at down seta the  down -------");
		if (red[2][1] == 'r') {
			System.out.println("red is on top blue down");
			m2Down();
		} else {
			System.out.println("blue is on top red is down");
			d();
			d();
			f();
			d();
			f_();
			d();
			l();
			d_();
			l_();
		}

	}

	private static void redAndGreenMiddle() {
		printAll();
		System.out.println("=========");
		int p = findPossitionOf("rg");
		System.out.println(p);
		if (p == 0) {
			System.out.println("something went wrong check the colour inputs");
			return;
		}
		if (p <= 4) {
			if (p == 1) {
				if (red[1][0] == 'r') {
					System.out.println("red and green alreday at place ");
					return;
				} else {
					// m1 to down
					m1Down();

				}
			} else if (p == 2) {
				// m2 to down
				m2Down();
			} else if (p == 3) {
				// m3 down
				m3Down();
			} else if (p == 4) {
				m4Down();
			}
		}
		p = findPossitionOf("rg");
		System.out.println("rg " + p);
		int truns = p - 5;

		while (truns > 0) {
			d();
			truns--;
		}
		System.out.println("set at the down -------");
		if (red[2][1] == 'r') {
			// red at possition
			System.out.println("red is on the middle top");
			m1Down();
		} else {
			// green is on top
			System.out.println("green is on to middle top");
			d();
			d();
			f_();
			d_();
			f();
			d_();
			r_();
			d();
			r();
			
		}
		System.out.println("==========");
		System.out.println(orange[1][0] );
		System.out.println(blue[1][2] );
		System.out.println("==========");

	}

	private static void m4Down() {
		d_();
		b();
		d();
		b_();
		d();
		r();
		d_();
		r_();
	}

	private static void m3Down() {
		d();
		b_();
		d_();
		b();
		d_();
		l_();
		d();
		l();

	}

	private static void m2Down() {
		d();
		l();
		d_();
		l_();
		d_();
		f();
		d();
		f_();

	}

	private static void m1Down() {
		d_();
		r_();
		d();
		r();
		d();
		f_();
		d_();
		f();

	}

	private static int findPossitionOf(String s) {
//		char c=s.charAt(0);
//		char d=s.charAt(1);
		System.out.println(orange[1][0] );
		System.out.println(blue[1][2] );
		if (s.contains(red[1][0] + "") && s.contains(green[1][2] + ""))
			return 1;
		else if (s.contains(red[1][2] + "") && s.contains(blue[1][0] + ""))
			return 2;
		else if (s.contains(orange[1][0] + "") && s.contains(blue[1][2] + "")) {
			
			return 3;
		}
		else if (s.contains(orange[1][2] + "") && s.contains(green[1][2] + ""))
			return 4;
		/// now yellow
		else if (s.contains(yellow[2][1] + "") && s.contains(red[2][1] + ""))
			return 5;
		else if (s.contains(yellow[1][1] + "") && s.contains(blue[2][1] + ""))
			return 6;
		else if (s.contains(yellow[0][1] + "") && s.contains(orange[2][1] + ""))
			return 7;
		else if (s.contains(yellow[1][2] + "") && s.contains(green[2][1] + ""))
			return 8;

		return 0;

	}

	private static void sloveFirstLayer() {
		makeAPlusWithWhite();
		// till here working fine
	//	arrangeWhitesAtExacte();
		System.out.println("arrangin at exact place =============================");
	//	setTheCorners();

	}

	private static void setTheCorners() {
		// firest set rwb
		printAll();
		setRWB();
		printAll();
		setRWG();
		setWGO();
		setWBO();
	}

	private static void setWBO() {
		System.out.println("===========================");
		int possiton = getPossitonOf("wbo");
		System.out.println("possition of WBO is " + possiton);
		if (possiton == 1) {
			// no chance to present thre
		} else if (possiton == 2) {
			// at possition no need to change
		} else if (possiton == 3) {
			// no chance to present thre
		} else if (possiton == 4) {
			// no chance to present thre
		} else if (possiton == 5) {
			d();
			d();
		} else if (possiton == 6) {
			d_();
		} else if (possiton == 7) {
			d();
		} else if (possiton == 8) {
			// no meed to do anythine
		}
		while (!(white[0][2] == 'w' && blue[0][2] == 'b' && orange[0][0] == 'o')) {
			l_();
			d_();
			l();
			d();

		}
	}

	private static void setWGO() {
		System.out.println("===========================");
		int possiton = getPossitonOf("wgo");
		System.out.println("possition of WGO is " + possiton);
		if (possiton == 1) {
			// no need to do anything
		} else if (possiton == 2) {
			b_();
			d();
			b();
			d();
			d();
		} else if (possiton == 3) {
			// no change at 3
		} else if (possiton == 4) {
			// no chance at 4 already set the value
		} else if (possiton == 5) {
			d();
		} else if (possiton == 6) {
			d();
			d();
		} else if (possiton == 7) {
			// mp meed pt dp anything
		} else if (possiton == 8) {
			d_();
		}
		while (!(white[0][0] == 'w' && green[0][0] == 'g' && orange[0][2] == 'o')) {
			r();
			d();
			r_();
			d_();
		}
	}

	private static void setRWG() {
		System.out.println("===========================");
		int possiton = getPossitonOf("wrg");
		System.out.println("possition of WRG is " + possiton);
		if (possiton == 1) {
			b();
			d_();
			b_();
		} else if (possiton == 2) {
			b_();
			d();
			d();
			b();
		} else if (possiton == 3) {
			// no need to do anything
		} else if (possiton == 4) {
			// no chance to present at 4
		} else if (possiton == 5) {
			// no need to do anythine
		} else if (possiton == 6) {
			d();
		} else if (possiton == 7) {
			d_();
		} else if (possiton == 8) {
			d();
			d();
		}

		while (!(white[2][0] == 'w' && red[0][0] == 'r' && green[0][2] == 'g')) {
			r_();
			d_();
			r();
			d();
		}

	}

	private static void setRWB() {
		int possiton = getPossitonOf("wrb");
		System.out.println("possition of wrb is " + possiton);
		if (possiton == 1) {
			b();
			d_();
			b_();
			d();
			
		} else if (possiton == 2) {
			b_();
			d();
			b();
		} else if (possiton == 3) {
			r_();
			d_();
			r();
		} else if (possiton == 4) {
			// no need to perform any action already at possion
		} else if (possiton == 5) {
			d_();
		} else if (possiton == 6) {// no need to perform any action already at possion

		} else if (possiton == 7) {
			d();
			d();
		} else if (possiton == 8) {
			d();
		}
		System.out.println("possiton of white red blue is"+getPossitonOf("wrb"));
		printAll();
		int itr=2;
		while (++itr<=1&&!(white[2][2] == 'w' && red[0][2] == 'r' && blue[0][0] == 'b')) {
			l();
			d();
			l_();
			d_();
			printAll();
		}
		
	}

	private static Integer getPossitonOf(String c) {
		HashMap<Integer, String> val = getAllColorAtCorner();
		Integer i = -1;
		for (Map.Entry<Integer, String> v : val.entrySet()) {
			System.out.println(v.getKey() + " : " + v.getValue());
			String s = v.getValue();
			if (s.contains(c.charAt(0) + "") && s.contains(c.charAt(1) + "") && s.contains(c.charAt(2) + "")) {
				// return v.getKey();// uncomment work fined
				i = v.getKey();
			}
		}
		//
		return i;

	}

	private static HashMap<Integer, String> getAllColorAtCorner() {
		HashMap<Integer, String> val = new HashMap<Integer, String>();
		String s = "" + white[0][0] + green[0][0] + orange[0][2];
		val.put(1, s);
		s = "" + white[0][2] + blue[0][2] + orange[0][0];
		val.put(2, s);
		s = "" + white[2][0] + green[0][2] + red[0][0];
		val.put(3, s);
		s = "" + white[2][2] + blue[0][0] + red[0][2];
		val.put(4, s);
		///////////
		s = "" + yellow[2][2] + green[2][2] + red[2][0];
		val.put(5, s);
		s = "" + yellow[2][0] + blue[2][0] + red[2][2];
		val.put(6, s);
		s = "" + yellow[0][2] + green[2][0] + orange[2][2];
		val.put(7, s);
		s = "" + yellow[0][0] + blue[2][2] + orange[2][0];
		val.put(8, s);
		return val;

	}

	private static void arrangeWhitesAtExacte() {
		HashMap<Integer, Character> v = getLocationsOfOthersColorsWithPluesMiddles();
		System.out.println("v values is "+v);
		if (v.get(1) != 'o') {
			System.out.println("its not equral to orange need ot change");
			int n = getIndexOfColor('o', v);
			if (n == 2) {
				r();
				r();
				d();
				b();
				b();
				d_();
				r();
				r();
			}
			if (n == 3) {
				l();
				l();
				d_();
				b();
				b();
				d();
				l();
				l();
			}
			if (n == 4) {
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
		if (v.get(2) != 'g') {
			System.out.println("its not equral to green need ot change");
			int n = getIndexOfColor('g', v);
			if (n == 1) {
				b();
				b();
				d_();
				r();
				r();
				d();
				b();
			} else if (n == 3) {
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

			} else if (n == 4) {
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
		if (v.get(3) != 'b') {
			System.out.println("its not equral to blue need ot change");
			int n = getIndexOfColor('b', v);
			if (n == 1) {
				b();
				b();
				d();
				l();
				l();
				d_();
				b();
				b();
				v.put(1, v.get(3));
			} else if (n == 2) {
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
			} else if (n == 4) {
				f();
				f();
				d_();
				l();
				l();
				d();
				f();
				f();
				v.put(4, v.get(3));
			}
			v = getLocationsOfOthersColorsWithPluesMiddles();
		}
		if (v.get(4) != 'r') {
			System.out.println("its not equral to red need ot change");
			int n = getIndexOfColor('r', v);
			if (n == 1) {
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
				v.put(1, v.get(4));
			} else if (n == 2) {
				r();
				r();
				d_();
				f();
				f();
				d();
				r();
				r();
				v.put(2, v.get(4));
			} else if (n == 3) {
				l();
				l();
				d();
				f();
				f();
				d_();
				l();
				l();
				v.put(3, v.get(4));
			}
			v = getLocationsOfOthersColorsWithPluesMiddles();
		}

	}

	private static int getIndexOfColor(char c, HashMap<Integer, Character> v) {
		if (v.get(1) == c) {
			return 1;
		}
		if (v.get(2) == c) {
			return 2;
		}
		if (v.get(3) == c) {
			return 3;
		}
		if (v.get(4) == c) {
			return 4;
		}
		return c;

	}

	private static HashMap<Integer, Character> getLocationsOfOthersColorsWithPluesMiddles() {
		HashMap<Integer, Character> val = new HashMap<Integer, Character>();
		char c[] = new char[4];
		c[0] = orange[0][1];

		val.put(1, orange[0][1]);
		val.put(2, green[0][1]);
		val.put(3, blue[0][1]);
		val.put(4, red[0][1]);
		return val;

	}

	private static void makeAPlusWithWhite() {
		// firest need to move all white to top
		ArrayList<String> v = findAllWhites();
		
		int itr=0;
		while (true) {
			v = findAllWhites();
			ArrayList<String> comp = new ArrayList<String>();
			for(int i=0;i<4;i++) {
				if (v.get(i).contains("w")) {
					comp.add(v.get(i));
				}		
			}
			v.removeAll(comp);
			System.out.println(v);
			String s = v.get(0);
			if (s.contains("w")) {
				comp.add(s);
				v.remove(s);
				System.out.println("already present");
				
			} else if (s.contains("r")) {
				comp.add(s);
				System.out.println("values are " + v);
				sloveMiddleWhiteAtRed(s);
			} else if (s.contains("b")) {
				comp.add(s);
				System.out.println("values are " + v);
				sloveMiddleWhiteAtBlue(s);
			} else if (s.contains("o")) {
				comp.add(s);
				System.out.println("values are " + v);
				sloveMiddleWhiteAtOrange(s);
			}
			else if (s.contains("g")) {
				System.out.println("values are " + v);
				sloveMiddleWhiteAtGreen(s);
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
		System.out.println(++itr + " perform l *");
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
		System.out.println(++itr + " perform l ");
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
		System.out.println(++itr + " perform d * down green to red ");
		if(itr>300) {
			System.out.println(5/0);
		}
		char c[] = red[2];
		red[2] = green[2];
		green[2] = orange[2];
		orange[2] = blue[2];
		blue[2] = c;
		spin90F(yellow);

	}

	private static void d() {
		System.out.println(++itr + " perform d down blue to red");
		char c[] = red[2];
		red[2] = blue[2];
		blue[2] = orange[2];
		orange[2] = green[2];
		green[2] = c;
		spin90R(yellow);

	}

	private static void b_() {
		System.out.println(++itr + " perfom b * form green to white");
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
		System.out.println(++itr + " perfom b form blue to white");
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
		System.out.println(++itr + " perform r *");// down
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
		System.out.println(++itr + " perform r");
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
		System.out.println(++itr + " perform u *");
		char c[] = red[0];
		red[0] = green[0];
		green[0] = orange[0];
		orange[0] = blue[0];
		blue[0] = c;
		spin90R(white);

	}

	private static void u() {
		System.out.println(++itr + " perorm u");
		char r[] = red[0];
		red[0] = blue[0];
		blue[0] = orange[0];
		orange[0] = green[0];
		green[0] = r;
		spin90F(white);

	}

	private static void f_() {
		System.out.println(++itr + " perform f *");
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
		System.out.println(++itr + " perform f");
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