package rubixCube;

public class checkingMEthods {
	public static void main(String[] args) {
		int o1=10,o2=20;
		char operatior='-';
		int returnValue=performArithmeticOperaitton(o1,o2,operatior);
		System.out.println(returnValue);
		
	}

	private static int performArithmeticOperaitton(int o1 , int o2, char operatior) {
		
		if(operatior=='+') {
			return o1+o2;
		}
		if(operatior=='-') {
			return o1-o2;
		}
		if(operatior=='/') {
			return o1/o2;
		}
		if(operatior=='*') {
			return o1*o2;
		}
		return 0;
	}


}	
