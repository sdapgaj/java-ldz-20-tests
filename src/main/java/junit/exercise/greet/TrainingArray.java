package junit.exercise.greet;

public class TrainingArray {
    public static void main(String[] args) {

        String [] table = new String[2];
        table [0] = "Jurek";
        table [1] = "Andrzej";

        prinstTable(table);
        prinstTable("Darek", "Sebastian");

        prinstTableClassic(table);
   //     prinstTableClassic("Darek", "Sebastian");


    }

    public static void prinstTable(String ...strings){
        for (int i=0; i <strings.length; i++){
            System.out.println(strings[i]);
        }
    }
    public static void prinstTableClassic(String [] strings){
        for (int i=0; i <strings.length; i++){
            System.out.println(strings[i]);
        }
    }
}
