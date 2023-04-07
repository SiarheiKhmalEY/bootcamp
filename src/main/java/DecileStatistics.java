import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DecileStatistics {
    private static final Logger logger = LoggerFactory.getLogger(DecileStatistics.class);

    public static void main(String[] args) {
        logger.warn("Application started");

        DecileStatistics decileStatistics = new DecileStatistics();
        Map<List<Integer>, Integer> inputData = decileStatistics.getData();
        List<Decile> deciles = decileStatistics.calculate6thAnd3rdDeciles(inputData);
        decileStatistics.showResult(deciles);

        logger.warn("Application finished");
    }

    Map<List<Integer>, Integer> getData() {
        logger.warn("Method getData started");
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        Map<List<Integer>, Integer> data = new HashMap<>();
        int count = 0;

        while (scanner.hasNextInt() && count < 1000) {
            int num = scanner.nextInt();
            if (num < 1 || num > 1000) {
               logger.error("Invalid input: number must be between 1 and 1000");
                continue;
            }
            nums.add(num);
            count++;
        }
        data.put(nums, count);
        logger.warn("Method getData finished");
        return data;
    }

    List<Decile> calculate6thAnd3rdDeciles(Map<List<Integer>, Integer> input) {
        logger.warn("Method calculate6thAnd3rdDeciles started");
        ThirdDecile thirdDecile = new ThirdDecile();
        SixthDecile sixthDecile = new SixthDecile();
        List<Decile> resultList = new ArrayList<>();

        for (var element : input.entrySet()) {
            int count = element.getValue();
            List<Integer> data = element.getKey();
            Collections.sort(data);
            int decile3 = data.get(count * 3 / 10);
            int decile6 = data.get(count * 6 / 10);
            int count3 = 0;
            int count6 = 0;

            for (int i = 0; i < count; i++) {
                if (data.get(i) <= decile3) {
                    count3++;
                }
                if (data.get(i) <= decile6) {
                    count6++;
                }
            }
            thirdDecile.setValue(decile3);
            thirdDecile.setStatistics(count3);

            sixthDecile.setValue(decile6);
            sixthDecile.setStatistics(count6);

            resultList.add(thirdDecile);
            resultList.add(sixthDecile);
        }
        logger.warn("Method calculate6thAnd3rdDeciles finished");
        return resultList;
    }

    void showResult(List<Decile> resultList) {
        logger.warn("Method showResult started");
        for (var decile : resultList
        ) {
            logger.info(decile.toString());
        }
        logger.warn("Method showResult finished");
    }

    private abstract class Decile {
        private int value;
        private int statistics;

        public void setValue(int value) {
            this.value = value;
        }

        public void setStatistics(int statistics) {
            this.statistics = statistics;
        }
    }

    private class ThirdDecile extends Decile {
        @Override
        public String toString() {
            return "Third Decile: " + super.value + ", number of values at or below 3rd decile: " + super.statistics;
        }
    }

    private class SixthDecile extends Decile {
        @Override
        public String toString() {
            return "Sixth Decile: " + super.value + ", number of values at or below 6th decile: " + super.statistics;
        }
    }
}