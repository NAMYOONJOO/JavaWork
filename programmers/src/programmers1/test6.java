package programmers1;

import java.util.Arrays;

public class test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 깊이/너비 우선 탐색(DFS/BFS)
		// lv.3
		System.out.println("Hello programmers");

		
		int [][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n = 3;
		int result = solution(n, computers);
		System.out.println("답 : "+result);
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		int[] visit = new int[n];
		Arrays.fill(visit, 0);// 미방문 : 0 , 방문 : 1
		
		
		for (int i = 0; i < n; i++) {
			if(visit[i]==0) {
				search(i, n, computers, visit);
				answer++;
			}
		}
		return answer;
	}

	public static void search(int i, int n, int[][] computers, int[] visit) {
		int[] visited = new int[n];
		visited = visit;
		visited[i] = 1;
		
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1 && visited[j] == 0&&i!=j) { // TODO
					search(j, n, computers, visited);
				}
			}
			
	}

}
