public class Tweets {
    public static void main(String[] args) {
        double sent, read, retweet, contest, hashtag, totalSent, perRetweet, perHashtag;

        System.out.println("TYPES OF TWEETER USERS\n");
        System.out.print("How many tweets have you sent? ");
        sent = Double.parseDouble(System.console().readLine());
        System.out.print("How many tweets have you read? ");
        read = Double.parseDouble(System.console().readLine());
        System.out.print("How many retweets have you sent? ");
        retweet = Double.parseDouble(System.console().readLine());
        System.out.print("How many tweets have you sent for contests or promotions? ");
        contest = Double.parseDouble(System.console().readLine());
        System.out.print("How many hashtags have you used in sent tweets? ");
        hashtag = Double.parseDouble(System.console().readLine());

        totalSent = (sent + retweet + contest + hashtag);
        //Percentage of retweets
        perRetweet = (retweet * 100) / totalSent;
        //Percentage with hashtags
        perHashtag = (hashtag * 100) / totalSent;

        System.out.println("\nYour type of user is:");

        if (totalSent == 0 | read == 0){
            System.out.println("Egg");
        }
        if (read > 0 && totalSent == 0){
            System.out.println("Marauder");
        }
        if (contest >= (sent + retweet + hashtag)){
            System.out.println("Contestant");
        }
        if (perRetweet >= 50){
            System.out.println("Follower");
        }
        if (perHashtag >= 50){
            System.out.println("Explorer");
        }
    }
}