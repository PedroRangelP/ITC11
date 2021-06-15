public class Stories{
    public static void main(String[] args) {
       String[] Situations = {"sitting on the toilet", "taking a test", "shopping on Walmart", "walking in the park", "sleeping in the library", "waiting in queue"};
       String[] Descriptors = {"an antisocial", "a jobless", "a blind", "a rich", "a curious"};
       String[] Nationality = {"Scottish", "Mexican", "English", "Chinese", "French", "Indian", "Italian", "Nigerian", "Russian", "Spanish"};
       String[] Character = {"man", "dog", "student", "girl", "president", "old man", "doctor", "cow"};
       String[] Funny = {"a robot", "a superhero", "a whale", "a zombie", "Donald Trump", "a clown", "Mickey Mouse", "a banana", "Homer Simpson"};
       String[] Interaction = {"do good deeds for", "kick", "dance for", "sing loudly for", "kiss", "throw eggs to", "give money to"};

       int s = (int) (Math.random() * 5);
       int d = (int) (Math.random() * 4);
       int n = (int) (Math.random() * 9);
       int c = (int) (Math.random() * 7);
       int f = (int) (Math.random() * 8);
       int i = (int) (Math.random() * 6);
       System.out.println("While "+Situations[s]+", "+Descriptors[d]+" "+Nationality[n]+" "+Character[c]+" had an idea: Why not dress as "+Funny[f]+" and "+Interaction[i]+" people?");
    }
}