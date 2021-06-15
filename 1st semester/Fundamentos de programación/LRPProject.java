/*
*A01650943 Ricardo Juárez Tepos
*A01650939 Pedro Rangel Palacios
*A01651153 Eduardo Herrera Juárez
*/


//javac -cp twitter4j-core-4.0.7.jar;. RPEProject.java
//java -cp twitter4j-core-4.0.7.jar;. RPEProject
import twitter4j.*;
import twitter4j.auth.*;
import java.util.Scanner;
import java.io.*;

public class RPEProject{
    public static void main(String[] args)throws Exception{
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("htrF7t0ZPMrOa5eaAvQSrryhk", "dpAAo4x6itUymbolNBjQAAkobwI9sM9jjIGc9JMg2gTnYxWNPc");
		AccessToken accessToken = new AccessToken("4813745316-l1kzew716QVYE24tLDnjfZFqXAEAK4mpD7azl2b",  "D82An2mek0qhJLyGfeJBGwNFCc6NexeYdZEFBHJZPJlcA");
        twitter.setOAuthAccessToken(accessToken);

        String toSearch, newClassification, newKeyword;
        String[] classifiedMessage;

        System.out.print("Word to search: ");
        toSearch = System.console().readLine();
		Query query = new Query(toSearch);
        QueryResult result = twitter.search(query);
        
		for (Status status : result.getTweets()){
            classifiedMessage = classifyMessage(status.getText()).split(" ");
            
            String noKeyword = classifiedMessage.length > 1 ? classifiedMessage[1] : "none";
            
            if (classifiedMessage[0].equals("unknown")){
                System.out.println("\n----- UNCLASSIFIED TWEET -----");
                System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
                System.out.println("Classification: " + classifiedMessage[0]);
                System.out.println("Keyword(s): " + noKeyword);
                System.out.println("----- Press ENTER to skip -----");
                System.out.print("Enter a classification [positive, negative, neutral]: ");
                newClassification = System.console().readLine();
                System.out.print("Enter keyword(s) separated by space: ");
                newKeyword = System.console().readLine();
                storeKeyword(newClassification, newKeyword);
                System.out.println();
            }else{
                System.out.println("\n@" + status.getUser().getScreenName() + ": " + status.getText());
                System.out.println("Classification: " + classifiedMessage[0]);
                System.out.print("Keyword(s):");
                for (int i=1; i<classifiedMessage.length; i++){
                    System.out.print(" " + classifiedMessage[i]);
                }
                System.out.println("\n");
            }
		}
    }

    public static String classifyMessage(String message) throws Exception{
        String category = "";
        String keywordsPositive = "", keywordsNegative = "", keywordsNeutral = "";
        String[] separate = message.toLowerCase().split(" ");
        String[] positive; String[] negative; String[] neutral;
        int countPositive=0, countNegative=0, countNeutral=0;

        Scanner sc1 = new Scanner(new File("positive.txt"));
		Scanner sc2 = new Scanner(new File("negative.txt"));
		Scanner sc3 = new Scanner(new File("neutral.txt"));

        String positiveContent = ""; String negativeContent = ""; String neutralContent = ""; 

        while (sc1.hasNext()) {
			positiveContent += sc1.nextLine() + "\n";
        }
        while (sc2.hasNext()) {
			negativeContent += sc2.nextLine() + "\n";
        }
        while (sc3.hasNext()) {
			neutralContent += sc3.nextLine() + "\n";
        }

        positive = positiveContent.split("\n");
        negative = negativeContent.split("\n");
        neutral = neutralContent.split("\n");

        for (int i=0; i < separate.length; i++){
            for (int j=0; j<positive.length; j++){
                if (separate[i].equals(positive[j])){
                    keywordsPositive += " " + positive[j];
                    countPositive++;
                }
            }
            for (int j=0; j<negative.length; j++){
                if (separate[i].equals(negative[j])){
                    keywordsNegative += " " + negative[j];
                    countNegative++;
                }
            }
            for (int j=0; j<neutral.length; j++){
                if (separate[i].equals(neutral[j])){
                    keywordsNeutral += " " + neutral[j];
                    countNeutral++;
                }
            }
        }

        if (countPositive>countNegative && countPositive>countNeutral){
			category = "positive" + keywordsPositive;
		}else if (countNegative>countPositive && countNegative>countNeutral){
			category = "negative" + keywordsNegative;
		}else if (countNeutral>countPositive && countNeutral>countNegative){
			category = "neutral" + keywordsNeutral;
		}else if (countPositive==0 && countNegative==0 && countNeutral==0){
			category = "unknown";
		}else{
			category = "neutral" + keywordsPositive + keywordsNegative;
		}

        sc1.close();
        sc2.close();
        sc3.close();
        return category;
    }

    public static void storeKeyword(String classification, String keyword) throws Exception{
        Scanner scKeywords = new Scanner(keyword);
		Scanner scClassification = new Scanner(classification);

		while (scKeywords.hasNext() && scClassification.hasNext()) {
            String[] keywordSplit = keyword.toLowerCase().split(" ");
            Scanner sc1 = new Scanner(new File(classification + ".txt"));
            String content = "";
            String[] newContent;
        
            while (sc1.hasNext()){
                content += sc1.nextLine() + "\n";
            }
            for(String addKeywords: keywordSplit){
                content += addKeywords + "\n";
            }

            newContent = content.split("\n");

            FileWriter fw = new FileWriter(new File(classification + ".txt"));
            for(String x : newContent){
                fw.write(x + "\n");
            }

            sc1.close();
            fw.close();
            break;
        }            
    }
}