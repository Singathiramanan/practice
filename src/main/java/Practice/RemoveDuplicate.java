package Practice;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicate {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String s=sc.next();
		String[] arr=s.split("");
		HashSet<String> set=new HashSet<String>();
		for(int i=0;i<arr.length;i++){
			set.add(arr[i]);
		}
		for(String ch:set){
			System.out.print(ch);
		}

	}

}
