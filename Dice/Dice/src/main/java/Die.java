import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Die extends Exception {
    int sides;
    int value;
    int[] probabilities;
    int[] Results;

    public Die(){}
    public Die(int sides, int[] probabilities) throws Exception {

        this.sides = sides;
        this.probabilities = probabilities;
        setProbabilities(this.probabilities);
        if(this.probabilities.length != sides){
            System.out.println("this won't work");
        }
    }
    public Die(int sides){
        this.sides = sides;
    }

    public void setSides(int sides){
        this.sides = sides;
    }
    public int getSides(){
        return sides;
    }

    public int roll(){
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("please a maximum number to generate a number from 1 to max");
        int putRand = 0;
        int maxRand = scan.nextInt();
        int minRand = 1;
        putRand = rand.nextInt((maxRand - minRand) + 1) + minRand;
        value = putRand;
        Die die = new Die(maxRand);
        //System.out.println(putRand);

        return this.value;
    }

    public static void setProbabilities(int[] arr) throws Exception {

        int sum = 0;

        for(int i=0; i<arr.length;i++){

            sum += arr[i];

            try {
                if (arr[i] < 0) {
                    throw new Exception("negative probabilities not allowed " + arr[i]);
                }else if (arr[i] >= 65){ throw new Exception("only integer values allowed");}

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        try{ if (sum <= 0){ throw new Exception("probability sum must be greater than 0"); }
        }catch (Exception e){ System.out.println(e.getMessage());}

    }

    public void update(int sides){
        setSides(sides);
        System.out.println("lll");
        System.out.println(getSides());
        for(int i=1; i<= getSides(); i++){
            System.out.println("nsh");
            for(int b =0; b< this.probabilities[i - 1]; b++){
                System.out.println("kkkkk");
                this.Results[i] += b;
                System.out.println(this.Results[i]);
                System.out.println("hey");
            }
        }
    }

//    update() {
//
//        for (var index = 1; index <= this.sides; index++) {
//            for (let b = 0; b < this.probability[index - 1]; b++) {
//                this.list.push(index);
//            }
//        }
//
//
//        let see = this.list[this.roll()];
//        this.value = see;
//
//
//    }

    public static void main(String[] args) throws Exception {
        Die die = new Die();
        int[] newarr = {1,1,1,1,1,1};
        //Die die1 = new Die(6, new int[]{1, 1, 1, 1, 1, 1});
        Die die1 = new Die(6, new int[]{1, 1, 1, 1, 1, 2});
        die1.update(6);
        //die.roll();
        //die.update();
        System.out.println(die.value);
    }
}
