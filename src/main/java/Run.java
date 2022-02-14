

import java.time.Duration;
import java.time.Instant;


public class Run {

    public static void main(String[] args) throws InterruptedException {
        int temp = 100;
        int maxNodes = 201;
        int maxParallelism = 6;
        int iterations = 25000;
        for (int nodes = 410; nodes < maxNodes; nodes += 100) {
            for (int i = 1; i < maxParallelism; i++) {
                equation calculations = new equation(i);
                double[][] TInit = Matrix.getRandomMatrix(temp, nodes, nodes);
                System.out.println("Number of nodes:" + nodes);
                System.out.println("Number of threads:" + i);
                Instant start = Instant.now();
                calculations.consider(TInit, nodes, nodes, iterations);
                Instant finish = Instant.now();
                System.out.printf("Working time = %d milliseconds%n", Duration.between(start, finish).toMillis());
            }
        }
    }


}