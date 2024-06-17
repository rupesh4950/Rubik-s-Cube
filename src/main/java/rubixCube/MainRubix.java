package rubixCube;

import java.util.HashMap;
import java.util.Scanner;

public class MainRubix {
	static char cube[][]=new char[6][9];
	
	public static void main(String [] args) {
	
		setValues();
		//printCube();
		sloveTop();
		
	}
	private static void sloveTop() {
		getMid('w');
		
	}
	private static void getMid(char c) {
		System.out.println("slove top "+ c);
		char[] val=new char[3];
		//to check on top
		for(int i=0;i<6;i++) {
			if(cube[i][1]==c) {
				System.out.println("getMid  "+cube[i][4]+"  "+ '1');
				
			}
			if(cube[i][3]==c) {
				System.out.println(cube[i][4]+"  "+ '3');
				getOppositeColor(cube[i][4],3);
				return;
			}
			if(cube[i][5]==c) {
				System.out.println(cube[i][4]+"  "+ '5');
			}
			if(cube[i][7]==c) {
				System.out.println(cube[i][4]+"  "+ '7');
			}
		}
		
	}
	private static void getOppositeColor(char c, int i) {
		System.out.println("enterd get oppostie");
		String w="ogrb";
		String r="wgyb";
		String b="wryo";
		String o="wbyg";
		String g="woyr";
		String y="obrg";
		HashMap<Character, String> mid=new HashMap<Character, String>();
		mid.put('w',w);
		mid.put('y', y);
		mid.put('r', r);
		mid.put('b',b );
		mid.put('o',o);
		mid.put('g', g);
		
		String act=mid.get(c);
		int oppositeIndexFinedr=-1;
		if(i==1) {
			oppositeIndexFinedr=0;
		}
		else if(i==3)
			oppositeIndexFinedr=1;
		else if(i==5)
			oppositeIndexFinedr=2;
		else 
			oppositeIndexFinedr=3;
		int index=-1;
		if(c=='r') {
			System.out.println("index to rind is "+i);
			Integer[] oppositeColorIndex = getRedSets(i);
			System.out.println("=========");
			System.out.println(oppositeColorIndex[0]+"   "+oppositeColorIndex[1]);
			System.out.println("=========");
			index=oppositeColorIndex[0];
			Integer colorIndex = oppositeColorIndex[1];
			char oppsiteColorTOgivenIndex = cube[colorIndex][index];
			System.out.println(" color to find at is  is "+cube[colorIndex][4]+"  value is "+oppsiteColorTOgivenIndex);
		}
		//char oppC=act.charAt(index);
		//System.out.println("all colors  "+act+"  "+oppC);
		//
		
		getRedSets(i);
		
	}
	private static Integer[] getRedSets(int i) {
		HashMap<Integer,Integer[]>col=new HashMap<Integer, Integer[]>();
		Integer a[]= {7,1}; 
		col.put(1,a);
		Integer b[]= {5,4}; 
		col.put(3,b);
		Integer c[]= {3,2}; 
		col.put(5,c);
		Integer d[]= {1,6}; 
		col.put(7,d);
		System.out.println(i);
		return col.get(i);
		
	}
	private static void printCube() {
		for(int i=0;i<6;i++) {
			System.out.println(getColor(cube[i][4]));
			for(int j=0;j<9;j++) {
				if(j!=0&&j%3==0) {
					System.out.println();
				}
				System.out.print(cube[i][j]+"  ");
					
			}
			System.out.println();
		}
		
	}
	private static String getColor(char c) {
		if(c=='w')
			return "white color ";
		if(c=='b')
			return "blue color ";
		if(c=='g')
			return "green color ";
		if(c=='r')
			return "red color ";
		if(c=='o')
			return "orange color ";
		if(c=='y')
			return "yellow color ";
		
		return "color not found "+ c;
		
	}
	private static void setValues() {
		//wrbogy
		char w[]=getvalues("gggowgobr");
		char r[]=getvalues("brywrybyy");
		char b[]=getvalues("bwrobyory");
		char o[]=getvalues("wywrowbbr");
		char g[]=getvalues("owwbgryow");
		char y[]=getvalues("ooggyggbr");
		cube[0]=w;
		cube[1]=r;
		cube[2]=b;
		cube[3]=o;
		cube[4]=g;
		cube[5]=y;
		
	}

	private static char[] getvalues(String s) {
		char c[]=new char[9];
		for(int i=0;i<9;i++) {
			c[i]=s.charAt(i);
		}
		return c;
	}
	private static void getValuesFromUser() {
		Scanner sc=new Scanner(System.in);
		System.out.println("keep white middle on top and red in front and enter the values of while top");
		getSide();
	}
	private static void getSide() {
//	char side[]=new char[9]; 
//	for(int i=0;i<9;i++) {
//		
//	}
	
		
	}
}
