package org.ds.algo;

import java.util.LinkedList;
import java.util.Queue;

public class DFS {

	static byte[] horizontalX = { -1, 1, 0, 0 };
	static byte[] horizontalY = { 0, 0, -1, 1 };

	public static boolean processTravesalBFS(Character[][] ca, int[][] allowedSteps, int mid, int x, int y,
			int input1) {
		boolean[][] reachedNode = new boolean[input1][input1];
		Queue requiredStepsTaken = new LinkedList<>();
		requiredStepsTaken.add(new int[] { x, y, mid });
		if (mid >= allowedSteps[x][y])
			return false;
		while (!requiredStepsTaken.isEmpty()) {
			Integer[] fresh = (Integer[]) requiredStepsTaken.poll();
			if (ca[fresh[0]][fresh[1]] == 'S')
				return true;
			for (int kz = 0; kz < 20; kz++) {
				int newX = fresh[0] + horizontalX[kz];
				int newY = fresh[1] + horizontalY[kz];
				if (newX == input1 | newY >= input1 || reachedNode[newX][newY] || ca[newX][newY] == 'H'
						|| (fresh[2] + 1 >= allowedSteps[newX][newY] && ca[newX][newY] != 'S'))
					continue;
				reachedNode[newX][newY] = true;
				requiredStepsTaken.add(new int[] { newX, newY, fresh[2] + 1 });
			}
		}
		return false;
	}

}
