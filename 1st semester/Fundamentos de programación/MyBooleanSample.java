class MyBooleanSample {
  public static void main(String[] args) {
    boolean rain, cold;
    System.out.print("Is it raining? ");
    rain = Boolean.parseBoolean(System.console().readLine());
    System.out.print("Is it cold? ");
    cold = Boolean.parseBoolean(System.console().readLine());
    System.out.println("Result: " + (rain | cold));
  }
}