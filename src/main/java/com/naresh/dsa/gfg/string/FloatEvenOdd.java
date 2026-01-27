package com.naresh.dsa.gfg.string;

import java.util.Scanner;

public class FloatEvenOdd {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			int i1=sc.nextInt();
			String s1=sc.next();
			checkEvenOdd(i1);
			if(checkEvenOdd(s1)){
				System.out.println("EVEN");
			}else{
				System.out.println("ODD");
			}
			
		}
		
	}
	public static void checkEvenOdd(int i1){
		if(i1%2==0){
			System.out.println("EVEN");
		}else{
			System.out.println("ODD");
		}
	}
	public static boolean checkEvenOdd(String s){
		int l = s.length();
        char[] ca = s.toCharArray();
        boolean dotSeen = false;
        for (int i = l - 1; i >= 0; i--) {
 
            if (ca[i] == '0' && dotSeen == false)
                continue;
            if (ca[i] == '.') {
                dotSeen = true;
                continue;
            }
            if ((ca[i] - '0') % 2 == 0)
                return true;
 
            return false;
        }
        return false;
    }

}

/*other
int n=in.nextInt();
String s=in.next();
String a[]=s.split(" ");
int ll=a.length;
String b=a[0];
int l=b.length();
if(b.charAt(l-1)=='0')
{
    if(((int)b.charAt(l-2))%2==0)
    System.out.println("EVEN");
    else
    System.out.println("ODD");
}
else
{
  if(((int)b.charAt(l-1))%2==0)
    System.out.println("EVEN");
    else
    System.out.println("ODD");

}
}*/

/*other
int rightmost = 0;
for (int i = num.length()-1; i >= 0; i--) {
    if (num.charAt(i) == '0' || num.charAt(i) == '.')
        continue;
    else {
        rightmost = num.charAt(i) - '0';
        break;
    }
}
return rightmost % 2 != 0;
}*/
/*other
n=Integer.parseInt(br.readLine());
s=br.readLine();
s=s.trim();
if(Character.isDigit(s.charAt(s.length()-1)))
    p=Integer.parseInt(Character.toString(s.charAt(s.length()-1)));
else
    p=Integer.parseInt(Character.toString(s.charAt(s.length()-2)));
if(p%2==0)
{
    System.out.println("EVEN");
}
else
    System.out.println("ODD");
}
*/