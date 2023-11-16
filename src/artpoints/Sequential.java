package artpoints;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Sequential {
    public static void main(String[] args) {
//        int[][] edges = {
//                {0, 1, 1, 0, 0, 0},
//                {1, 0, 1, 0, 0, 0},
//                {1, 1, 0, 1, 0, 0},
//                {0, 0, 1, 0, 1, 1},
//                {0, 0, 0, 1, 0, 1},
//                {0, 0, 0, 1, 1, 0}
//        };
        int[][] edges = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0}
        };
        System.out.println(findArticulationPoints(edges));
    }

    public static int findArticulationPoints(int[][] edges) {
        int articulationPoints = 0;
        // Try removing each vertex i
        for (int target = 0; target < edges.length; target++) {
            Deque<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            queue.addLast((target + 1) % edges.length);
            visited.add((target + 1) % edges.length);

            while (!queue.isEmpty()) {
                int vertex = queue.removeFirst();
                for (int neighbor = 0; neighbor < edges.length; neighbor++) {
                    if (neighbor != target && edges[vertex][neighbor] > 0 && !visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.addLast(neighbor);
                    }
                }
            }

            if (visited.size() != edges.length - 1) {
                articulationPoints++;
            }
        }
        return articulationPoints;
    }
}
