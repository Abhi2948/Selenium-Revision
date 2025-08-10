
public class CoreJavaBrushUp_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5;
		String str = "Abhishek Pateriya";
		char ch = 'a';
		double dec = 19.94;
		float ft = (float) 9.9;
		boolean b = true;
		System.out.println(num + " " + str + " " + ch + " " + dec + " " + ft + " " + b);
		int[] arr = new int[5];
		arr[0] = 9;
		arr[1] = 8;
		arr[2] = 7;
		arr[3] = 6;
		arr[4] = 5;
		int[] arr2 = { 11, 22, 33, 44, 55 };
		System.out.println("array[4] = " + arr[4] + " & array2[4] = " + arr2[3]);
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("array["+i+"] = "+arr2[i]);
		}
	}

}
