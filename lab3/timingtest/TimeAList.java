package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import timingtest.AList;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }
    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> NsList = new AList<>();
        NsList.addLast(1000);
        NsList.addLast(2000);
        NsList.addLast(4000);
        NsList.addLast(8000);
        NsList.addLast(16000);
        NsList.addLast(32000);
        NsList.addLast(64000);
        NsList.addLast(128000);
        AList<Double> TimesList = new AList<>();

        for (int n = 0; n < NsList.size(); n++) {
            Stopwatch timer = new Stopwatch(); // 시간 측정을 시작

            AList<Integer> L = new AList<>();
            for (int i = 0; i < NsList.get(n); i++) {
                L.addLast(i);
            }

            double elapsedTime = timer.elapsedTime(); // 시간 측정을 종료하고 걸린 시간을 얻음
            TimesList.addLast(elapsedTime); // 시간을 리스트에 저장

        }

        printTimingTable(NsList, TimesList, NsList);
    }
}