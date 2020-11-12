package programmers1;


public class KSTEC2020_3 {



	public static void main(String[] args) {
		
	}
	//[3, 2, 4, 8, 7]
	public static  int solution(int[] prices) {
        int answer = 0;
        
        int minF=prices[0];
        int maxF=prices[0];
        
        for (int i = 1; i < prices.length; i++) {
        	if(prices[i]<minF)minF=prices[i];
        	else if(prices[i]>=prices[i-1]) {
        		maxF=prices[i];
        		if(maxF-minF>answer)answer=maxF-minF;
        	}
        	
		}
        
        return answer;
    }
	

}

