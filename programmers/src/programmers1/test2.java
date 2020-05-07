package programmers1;
import java.util.Arrays;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []test = {1,2,3,2,3};
		int []result = solution(test);
		for(int i = 0;i<5;i++) {
		System.out.println(result[i]);
		}
	}
	public static int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        
        for(int i = 0; i<prices.length;i++){   
            int sec = 0;
            for(int j=i+1; j<prices.length ; j++){
               if(prices[i]<=prices[j]){
                   sec=sec+1;
               }else{
                   break;
               }
            }
            answer[i] = sec;
        }
       
        return  answer;
    }

}

    