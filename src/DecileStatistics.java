import java.util.*;

public class DecileStatistics {
    public static void main(String[] args) {
        DecileStatistics decileStatistics = new DecileStatistics();
        Map<List<Integer>, Integer> inputData = decileStatistics.getData();
        List<Decile> deciles = decileStatistics.calculate6thAnd3rdDeciles(inputData);
        decileStatistics.showResult(deciles);
    }

    Map<List<Integer>, Integer> getData() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        Map<List<Integer>, Integer> data = new HashMap<>();
        int count = 0;

        while (scanner.hasNextInt() && count < 1000) {
            int num = scanner.nextInt();
            if (num < 1 || num > 1000) {
                System.out.println("Invalid input: number must be between 1 and 1000");
                continue;
            }
            nums.add(num);
            count++;
        }
        data.put(nums, count);
        return data;
    }

    List<Decile> calculate6thAnd3rdDeciles(Map<List<Integer>, Integer> input) {
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
        return resultList;
    }

    void showResult(List<Decile> resultList) {
        for (var decile : resultList
        ) {
            System.out.println(decile.toString());
        }
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