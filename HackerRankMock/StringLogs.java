import java.util.*;

public class StringLogs {
    public static List<List<String>> extractErrorLogs(List<List<String>> logs) {

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        List<List<String>> logs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> log = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                log.add(sc.nextLine());
            }
            logs.add(log);
        }

        List<List<String>> result = StringLogs.extractErrorLogs(logs);

        for (List<String> row : result) {
            System.out.println(String.join(" ", row));
        }

        sc.close();

    }
}