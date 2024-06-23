package rubixCube;

import java.util.ArrayList;
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
		checkAll12Parts();
		
	}

	private static void checkAll12Parts() {
		System.out.println("sloveingg");
		ArrayList top=getTopWhite();
		for(int i=0;i<top.size();i++) {
			String color=(String) top.get(i);
			System.out.println(top.get(i));
			if(color.charAt(1)=='w') {
				System.out.println("already at possion");
				continue;
			}
			if(color.charAt(1)=='r') {
				//keep not filled on 3rd possion 
				f();
				print();
				
				while(checkWVlaisWhie(1,2)) {
					System.out.println(checkWVlaisWhie(1,2));
					//u operaion should be performed
					u();
				//	print();
				}
				System.out.println("at w 1,2 there is not white");
							}
			
		}
		
	}

	private static void u() {
		// u operation should be performed
		System.out.println("u opration performed");
		char g[]=green[0];
		green[0]=red[0];
		char o[]=orange[0];
		orange[0]=g;
		char b[]=blue[0];
		blue[0]=o;
		red[0]=b;
		
		 char[] r0=white[0],r1=white[1],r2=white[2];
		 for(int i=0;i<3;i++) {
			 char c[]= {r2[i],r1[i],r0[i]};
			 white[i]= c;
		 }
		
	}

	private static boolean checkWVlaisWhie(int i, int j) {
		return white[i][j]=='w'?true:false;
		
	}

	private static void f() {
		System.out.println("f operation is performing");
		char[] w=white[2];
		char[]b=new char[3];
		for(int i=0;i<3;i++) {
			b[2-i]=blue[i][0];
			blue[i][0]=w[i];
		}
		 char[] y=yellow[0];
		 yellow[0]=b;
		 char[] g=new char[3];
		 for(int i=0;i<3;i++) {
			 g[2-i]=green[i][2];
			 green[i][2]=y[i];
		 }
		 white[2]=g;
		 System.out.println("f operation perfomred");
		 //now red should be swaped
		 char[] r0=red[0],r1=red[1],r2=red[2];
		 for(int i=0;i<3;i++) {
			 char c[]= {r2[i],r1[i],r0[i]};
			 red[i]= c;
		 }
	}

	private static ArrayList<String> getTopWhite() {
		ArrayList<String>whiteC=new ArrayList<String>();
		//w01
		if(white[0][1]=='w') {
			whiteC.add("0w1");
		}
		else if(orange[0][1]=='w') {
			whiteC.add("0o1");
		}
		////System.out.println(whiteC);
		//w11
		if(white[1][1]=='w') {
			whiteC.add("1w1");
		}
		else if(green[0][1]=='w') {
			whiteC.add("0g1");
		}
		//System.out.println(whiteC);
		//w12
		if(white[1][2]=='w') {
			whiteC.add("1w2");
		}
		else if(green[0][1]=='w') {
			whiteC.add("0b1");
		}
		//System.out.println(whiteC);
		//w21
		if(white[2][1]=='w') {
			whiteC.add("2w1");
		}
		else if(red[0][1]=='w') {
			whiteC.add("0r1");
		}
		//System.out.println(whiteC);
		return whiteC;
		
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


