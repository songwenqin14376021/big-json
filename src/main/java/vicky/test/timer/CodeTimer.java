package vicky.test.timer;

import java.util.LinkedHashMap;
import java.util.Map;

public class CodeTimer {
    private static String lastMark = "start";
    private static long lastTime = System.nanoTime();
    private static final Map<String, Long> timeMap = new LinkedHashMap<String, Long>();
    private static final Map<String, Long> timeHappenCount = new LinkedHashMap<String, Long>();

    public static void set(int mark) {
        set("" + mark);
    }

    ;

    public static void set(String mark) {
        long thisTime = System.nanoTime();
        String key = "[" + lastMark + "]->[" + mark + "]";
        Long lastSummary = timeMap.get(key);
        if (lastSummary == null)
            lastSummary = 0L;

        timeMap.put(key, System.nanoTime() - lastTime + lastSummary);
        Long lastCount = timeHappenCount.get(key);
        if (lastCount == null)
            lastCount = 0L;

        timeHappenCount.put(key, ++lastCount);
        lastTime = thisTime;
        lastMark = mark;
    }

    ;

    public static void print() {
        Integer a = 0;
        System.out.println(
                String.format("%25s %18s %18s %18s",
                        "PROCESS", "TOTAL_TIME", "REPEAT_TIMES", "AVG_TIME"));
        for (Map.Entry<String, Long> entry : timeMap.entrySet()) {
            System.out.println(
                    String.format("%25s %18s %18s %18s", entry.getKey(),
                            String.format("%,d", entry.getValue()), timeHappenCount.get(entry.getKey()),
                            String.format("%,d", entry.getValue() / timeHappenCount.get(entry.getKey()))));
        }
    }
}