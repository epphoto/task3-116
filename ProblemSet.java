package ratings;
import java.util.ArrayList;
import java.util.HashMap;
public class ProblemSet {
    //average method
    public static double average(ArrayList<Double> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }
        double x = 0.0;

        for (double num : numbers) {
            x += num;
        }
        double avg = x / numbers.size();
        return avg;
    }
    // sumOfDigits
    public static int sumOfDigits(int num) {
        num = Math.abs(num);
        int result=0;
        while(num>0) {
            result += (num % 10);
            num /= 10;
        }
        return result;
    }
    //bestKey
    public static String bestKey(HashMap<String,Integer> input){
        int maxvalue=Integer.MIN_VALUE;
        for(int y:input.values()){
            if (y>maxvalue) {
                maxvalue = y;
            }
        }
        for(String delta:input.keySet()){
            if(input.get(delta) == maxvalue){
                return delta;
            }
        }
        return "";

    }
}
// if multiple keys have the same value, any of them need to be returned