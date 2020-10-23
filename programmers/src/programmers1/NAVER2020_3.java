package programmers1;

import java.util.Arrays;

public class NAVER2020_3 {

	public static void main(String[] args) {
		System.out.println("hello naver");
		int [][]edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}, {4, 10}, {4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}};
		dfs(edges,0,0);
	}

	public static int solution(int n, int[][] edges) {
		int answer = 0;
		int[] visit = new int[n];
		Arrays.fill(visit, 0);// 미방문 : 0 , 방문 : 1

		return answer;
	}
	
	public static void dfs(int[][] edges, int node ,int step){//0부터시작
		for (int i = 0; i < edges.length; i++) {
			if(edges[i][0]==node) {
				System.out.println(node+"->"+edges[i][1]+"step :"+step);
				dfs(edges,edges[i][1], step+1);
			}
		}
		
	}
}