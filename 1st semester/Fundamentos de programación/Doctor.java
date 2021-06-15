public class Doctor{
    public static void main (String[] args){
        int i, j, people;
        String answers;
        int[] totalPoints;

        System.out.print("Number of people to analyze: ");
        people = Integer.parseInt(System.console().readLine());

        String[] classifiedPerson = new String[people];

        System.out.println("ENTER ANSWERS FOR EACH PERSON SEPARATED BY SPACES");
        for (i=0; i<people; i++){
            System.out.printf("PERSON %d: \n", i+1);
            answers = System.console().readLine();
            totalPoints = readAnswers(answers);
            classifiedPerson[i] = supportType(totalPoints);
        }

        System.out.println("\nSUPPORT TYPE FOR EACH PERSON:");
        for (i=0; i<people; i++){
            System.out.printf("Person %d: ", i+1);
            System.out.println(classifiedPerson[i]);
        }
    }

    public static int[] readAnswers(String answer){
        int i;
        int[] total = {0, 0, 0};
        String[] separate = answer.split(" ");

        for (i=0; i<separate.length; i++){
            total[2]+=Integer.parseInt(separate[i]);
        }

        total[0] = Integer.parseInt(separate[1])+Integer.parseInt(separate[2])+Integer.parseInt(separate[4])+Integer.parseInt(separate[8])+Integer.parseInt(separate[10]);
        total[1] = Integer.parseInt(separate[0])+Integer.parseInt(separate[3])+Integer.parseInt(separate[5])+Integer.parseInt(separate[6])+Integer.parseInt(separate[7])+Integer.parseInt(separate[9]);

        return total;
    }

    public static String supportType(int[] points){
        String types = "";
        if (points[0]>=15){
            types += "Confidential ";
        }
        if (points[1]>=18){
            types += "Affective ";
        }
        if (points[2]>=32){
            types += "Social";
        }

        return types;
    }
    
}