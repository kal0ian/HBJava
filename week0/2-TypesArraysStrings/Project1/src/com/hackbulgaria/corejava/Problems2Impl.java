package com.hackbulgaria.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
    	return number%2==1 || number%2==-1;
    }

    @Override
    public boolean isPrime(int number) {
        // TODO Auto-generated method stub
    	for(int i=2;i<number;i++){
			if(number%i==0) return false;
		}
		return true;
    }

    @Override
    public int min(int... array) {
        // TODO Auto-generated method stub
    	int min=array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]<min) min=array[i];
		}
		return min;
    }

    @Override
    public int kthMin(int k, int[] array) {
        // TODO Auto-generated method stub
    	Arrays.sort(array);
		return array[k-1];
    }

    @Override
    public float getAverage(int[] array) {
        // TODO Auto-generated method stub
    	float sum=0;
		for(int i=0;i<array.length;i++){
			sum+=array[i];
		}
		return sum/array.length;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        // TODO Auto-generated method stub
        int count =0,answer=0;
    	while(count!=upperBound){
    		answer++;
        	for(int i=1;i<=upperBound;i++){
        		if(answer%i==0){
        			count++;
        		}
        		else{
        			count=0;
        			break;
        		}
        	}
        	
   
        }
    	return answer;
    }
    
    public boolean is_palindrome(List<Long> x){
          int first = 0;                        // index of first letter
          int last = x.size()-1;      // index of last letter
          while (first < last) {             // we haven’t reached the middle
                if (x.get(first)!=x.get(last)) return false;
                ++first;                      // move forward
                --last;                        // move backward
          }
          return true;
    }
    @Override
    public  long getLargestPalindrome(long N) {
        // TODO Auto-generated method stub
    	long answer = 0;
    	while(N>0){
    		N=N-1;
    		String str = Long.toString(N);
        	System.out.println(str);
    		if(isPalindrome(str)){
    			return N;
    		}
        }
		return answer;
    }

    @Override
    public int[] histogram(short[][] image) {
        // TODO Auto-generated method stub
        int[] arr;
        arr = new int[255];
        for(int i=0;i<255;i++){
        	arr[i]=0;
        }
    	for(int i=0;i<image.length;i++){
        	for(int j=0;j<image[0].length;j++){
        		arr[image[i][j]]+=1;
        	}
        }
    	return arr;
    }

    @Override
    public long doubleFac(int n) {
        // TODO Auto-generated method stub
    	int fact=1;
		for(int i=n;i>=1;i--){
			fact*=i;
		}
		n=fact;
		for(int i=n-1;i>=1;i--){
			fact*=i;
		}
		return fact;
    }

    @Override
    public long kthFac(int k, int n) {
        // TODO Auto-generated method stub
    	int fact=1;
    	for(int i=n;i>1;i-=k){
    		fact*=i;
    	}
    	return fact;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        // TODO Auto-generated method stub
        
    	Arrays.sort(array);
    	int temp=array[0],count=1;
    	for(int i=1;i<array.length;i++){
    		if(array[i]==temp){
    			temp=array[i];
    			count++;
    		}
    		if(array[i]!=temp && count%2==1) return temp;
    		if(array[i]!=temp && count%2==0) {temp= array[i];count=1;}
    	}
    	return temp;
    }

    @Override
    public long pow(int a, int b) {
        // TODO Auto-generated method stub
        
    	if (b == 0) return 1;
        long temp = pow(a, b/2);
        if (b % 2 == 0)
            return temp * temp; 
        else
            return (a * temp * temp);
    	
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        // TODO Auto-generated method stub
        Arrays.sort(a);
        Arrays.sort(b);
        int result=0;
        for(int i=0;i<a.length;i++){
        	result+=a[i]*b[i];
        }
        return result;
    }

    @Override
    public int maxSpan(int[] array) {
        // TODO Auto-generated method stub
        int max=0;
        for(int i=0;i<array.length;i++){
        	for(int j=array.length-1;j>=0;j--){
            	if(array[i]==array[j]){
            		if(max<j-i){
            			max=j-i+1;
            		}
            	}
            }
        }
    	return max;
    }

    public int sum(int[] array,int i,int j){
    	int sum=0;
    	for(int k=i;k<=j;k++){
    		sum+=array[k];
    	}
    	return sum;
    }
    @Override
    public boolean canBalance(int[] array) {
        // TODO Auto-generated method stub
        for(int i=0;i<array.length-1;i++){
        	if(sum(array,0,i)==sum(array,i+1,array.length-1)) return true;
        }
        return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String reverseMe(String argument) {
        // TODO Auto-generated method stub
        String str = new String();
        for(int i=argument.length()-1;i>=0;i--){
        	str=str+argument.charAt(i);
        }
        return str;
        
    }

    @Override
    public String copyEveryChar(String input, int k) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String reverseEveryWord(String arg) {
        // TODO Auto-generated method stub
        String [] words = arg.split(" ");
        String result=new String();
        for( String word : words){
        	result+= reverseMe(word)+" ";
        }
        result = result.substring(0, result.length()-1);
    	return result;
    }

    @Override
    public boolean isPalindrome(String argument) {
        // TODO Auto-generated method stub
    	int first = 0;                        // index of first letter
        int last = argument.length()-1;      // index of last letter
        while (first < last) {             // we haven’t reached the middle
              if (argument.charAt(first)!=argument.charAt(last)) return false;
              ++first;                      // move forward
              --last;                        // move backward
        }
        return true;
    }

    @Override
    public boolean isPalindrome(int number) {
        // TODO Auto-generated method stub
    	List<Long> x = new ArrayList<Long>();
    	while(number!=0){
    		x.add((long) (number%10));
    		number=number/10;
    	}
    	return is_palindrome(x);
    	
    }

    @Override
    public int getPalindromeLength(String input) {
        // TODO Auto-generated method stub
        int i=0;
    	while(input.charAt(i)!='*'){
        	i++;
        }
    	int count=0;
    	int j=1;
    	while(i-j!=-1 && i+j!=input.length()+1){
    		if(input.charAt(i+j)==input.charAt(i-j)){
    			count++;
    		}
    		j++;
    	}
    	return count;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        // TODO Auto-generated method stub
    	return (haystack.split(needle).length - 1);
    }

    @Override
    public String decodeURL(String input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int sumOfNumbers(String input) {
        // TODO Auto-generated method stub
    	input=input.replaceAll("[\\D]"," ");
    	String[] numbers=input.split(" ");
    	int sum = 0;
    	for(int i=0;i<numbers.length;i++){
    	       sum+=Integer.parseInt(numbers[i]);
    	}
    	return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        // TODO Auto-generated method stub
        String [] a = A.split("");
        String [] b = B.split("");
        Arrays.sort(a);Arrays.sort(b);
        for(int i=0;i<a.length;i++){
        	if(a[i].compareTo(b[i])!=0) return false;
        }
    	return true;
    }
    
    @Override
    public boolean hasAnagramOf(String string, String string2) {
        // TODO Auto-generated method stub
        int i=0;
    	while(i!=string.length()){
    		if(string2.indexOf(string.charAt(i))!=-1){
    			i++;
    		}
    		else{return false;}
    		
    	}
    	return true;
    }

}
