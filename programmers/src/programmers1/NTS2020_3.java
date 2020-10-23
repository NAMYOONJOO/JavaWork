package programmers1;

public class NTS2020_3 {

	public static void main(String[] args) {
		
		System.out.println("hello line");
	}

	public static int solution(int[] histogram) {
        int answer = 12;
        for (int i = 0; i < histogram.length-1; i++) {
			for (int j = i+1; j < histogram.length; j++) {
				int width = j-i-1;
				int height;
				if(histogram[i]>histogram[j]) {
					height = histogram[j];
				}else {
					height = histogram[i];
				}
				
				int result = width*height;
				
				if(result>answer) {
					answer = result;
				}
			}
		}
        return answer;
    }





	

}
