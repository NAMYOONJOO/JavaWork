package practice.wordcount;

import java.util.HashMap;

public class programmers1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(a(new String[]{"classic", "pop", "classic", "classic", "pop"},new int[]{500, 600, 150, 800, 2500}));
		
	}

	public int[] a(String[] genres , int[] plays) {
		int[] answer = {};
		
		HashMap<String, Integer> music = new HashMap(); //장르, 재생
		for(int i = 0;i<genres.length;i++){
			Integer v = music.get(genres[i]);
			if(v==null) {
				music.put(genres[i],plays[i]);
			}else {
				music.put(genres[i],v+plays[i]);
			}
		}      
		
		for (int i = 0; i < music.size(); i++) {
			
		}
		
		return answer;
	}
}
