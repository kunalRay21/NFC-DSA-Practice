/**
 * Problem: Course Schedule (LeetCode 207)
 * Difficulty: Medium
 * Pattern: Topological sort / cycle detection
 *
 * Input Format:
 * Line 1: Two integers numCourses (n) and m (number of prerequisite pairs).
 * Following m lines: Two integers u and v indicating prerequisite relation (v must be taken before u).
 *
 * Output Format:
 * true if it is possible to finish all courses, false otherwise.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) {
            System.out.println(true);
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int numCourses = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int i = 0; i < m; i++) {
            String edgeLine = br.readLine();
            while (edgeLine != null && edgeLine.trim().isEmpty()) {
                edgeLine = br.readLine();
            }
            if (edgeLine == null) break;
            StringTokenizer edgeTokens = new StringTokenizer(edgeLine);
            int course = Integer.parseInt(edgeTokens.nextToken());
            int prereq = Integer.parseInt(edgeTokens.nextToken());

            // Edge from prereq -> course
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completedCourses++;

            for (int nextCourse : adj.get(curr)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        System.out.println(completedCourses == numCourses);
    }
}
