import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	private static VertexNode vertexArray[];
	private static int[] visited = new int[10];;

	static class VertexNode {
		int data;
		VertexNode next;

		public VertexNode() {
			this.data = (Integer) null;
			this.next = null;
		}

		public VertexNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		readGraph();
		//dfs(0);
		//dfsNonRecursive(0);
		bfs(0);

	}
	
	/** Algorithm for BFS Traversals */
	private static void bfs(int vertex) {
		VertexNode node;
		Queue queue = new LinkedList<Integer>();
		queue.add(vertex);
		System.out.println(vertex);
		visited[vertex] = 1;
		while (!queue.isEmpty()) {
			node = vertexArray[(int) queue.remove()];
			while (node != null) {
				int p = node.data;
				if (visited[p] == 0) {
				queue.add(p);
				visited[p] = 1;
				System.out.println(p);
				}
				node = node.next;
			}
		}
		
	}

	/** Recursive DFS traversals */
	private static void dfs(int i) {
		VertexNode p = vertexArray[i];
		System.out.println(i);
		visited[i] = 1;
		while (p != null) {
			i = p.data;
			if (visited[i] == 0)
				dfs(i);
			p = p.next;
		}
	}

	/** Non recursive DFS traversals */
	private static void dfsNonRecursive(int i) {
		Stack s = new Stack<Integer>();
		s.push(i);
		while (!s.isEmpty()) {
			i = (int) s.pop();
			if (visited[i] == 0) {
				VertexNode p = vertexArray[i];
				while (p != null) {
					s.push(p.data);
					p = p.next;
				}

				visited[i] = 1;
				System.out.println(i);

			}
		}

	}

	private static void readGraph() {
		int vi, vj;
		vertexArray = new VertexNode[10];
		System.out.println("Enter the no of vertex in graph - ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			vertexArray[i] = null;
			System.out.println(" Enter the no of edges linked to vertex " + i);
			int edges = sc.nextInt();
			for (int j = 0; j < edges; j++) {
				System.out.println("Enter a vertex connected to " + i);
				vi = sc.nextInt();
				System.out.println("Edge entered is " + "(" + i + "," + vi + ")");
				insert(i, vi);
			}
		}
		System.out.println("Total vertex entered is ");
		for (int i = 0; i < n; i++) {
			System.out.print("{");
			System.out.print(" " + i + " ");
			System.out.print("}");
		}
		System.out.println();

	}

	private static void insert(int i, int vi) {
		VertexNode node = new VertexNode(vi);
		VertexNode p = null;
		if (vertexArray[i] == null) {
			vertexArray[i] = node;
		} else {
			p = vertexArray[i];
			while (p.next != null) {
				p = p.next;
			}
			p.next = node;
		}
	}

}
