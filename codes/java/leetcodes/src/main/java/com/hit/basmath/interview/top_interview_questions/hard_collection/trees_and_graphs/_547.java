package com.hit.basmath.interview.top_interview_questions.hard_collection.trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. Friend Circles
 * <p>
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * <p>
 * Output: 2
 * <p>
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * <p>
 * Output: 1
 * <p>
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * <p>
 * Note:
 * <p>
 * 1. N is in range [1,200].
 * 2. M[i][i] = 1 for all students.
 * 3. If M[i][j] = 1, then M[j][i] = 1.
 */
public class _547 {
    public int findCircleNum(int[][] M) {
        int count = 0;
        for (int i = 0; i < M.length; i++)
            if (M[i][i] == 1) {
                count++;
                BFS(i, M);
            }
        return count;
    }

    private void BFS(int student, int[][] M) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(student);
        while (queue.size() > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int j = queue.poll();
                M[j][j] = 2; // marks as visited
                for (int k = 0; k < M[0].length; k++)
                    if (M[j][k] == 1 && M[k][k] == 1) queue.add(k);
            }
        }
    }
}
