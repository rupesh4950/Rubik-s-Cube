package rubixCube;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class MainRubix {
	static Object[][] cube=new Object[6][];
	static char[][] white= new char[3][];
	static char[][] red= new char[3][];
	static char[][] blue= new char[3][];
	static char[][] orange= new char[3][];
	static char[][] green= new char[3][];
	static char[][] yellow= new char[3][];
	public static void main(String [] args) {
		fillColours();
		print();
		sloveTop();
		}

	private static void sloveTop() {
		findWhitesAndArrangePlus();
		
	}

	private static void findWhitesAndArrangePlus() {
	
		
	}

	private static void print() {
		print(white,"white");
		print(red,"red");
		print(blue,"blue");
		print(orange,"orange");
		print(green,"green");
		print(yellow,"yellow");
		
	}

	private static void print(char[][] val,String name) {
		System.out.println("===="+name+"=====");
		for(int i=0;i<val[0].length;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(val[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static void fillColours() {
		System.out.println("keep white on top and red in front");
		char y='y',w='w',b='b',r='r',g='g',o='o';
		
		char[]w1= {'y','y','r'},w2= {'w','w','b'},w3= {b,b,o};
		white[0]=w1;
		white[1]=w2;
		white[2]=w3;
		
		char[]r1= {r,w,g},r2= {y,r,g},r3= {b,y,o};
		red[0]=r1;
		red[1]=r2;
		red[2]=r3;
		
		char[]b1= {w,r,w},b2= {r,b,y},b3= {g,g,y};
		blue[0]=b1;
		blue[1]=b2;
		blue[2]=b3;
		
		char[]o1= {g,r,o},o2= {o,o,o},o3= {g,r,r};
		orange[0]=o1;
		orange[1]=o2;
		orange[2]=o3;
		
		char[]g1= {b,o,w},g2= {g,g,b},g3= {b,o,o};
		green[0]=g1;
		green[1]=g2;
		green[2]=g3;
		
		char[]y1= {w,g,y},y2= {b,y,w},y3= {y,w,r};
		yellow[0]=y1;
		yellow[1]=y2;
		yellow[2]=y3;
		
		
		
//		cube[0]=white;
//		cube[1]=red;
//		cube[2]=blue;
//		cube[3]=orange;
//		cube[4]=green;
//		cube[5]=yellow;
		
	}

}


