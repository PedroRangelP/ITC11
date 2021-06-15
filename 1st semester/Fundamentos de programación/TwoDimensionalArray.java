public class TwoDimensionalArray{
	public static void main(String[] args){
        System.out.println("-------------------------");
        final Object [][] matriz = { { "", "PRODUCT", "PRICE" }, { "1", "Chips", "$8" }, { "2", "Chocolate", "$12" }, 
                { "3", "Soda", "$9" }, { "4", "Candies", "$6" }, {"5", "Chewing gum", "$4"} };
        for (final Object[] row : matriz) {
            System.out.format("%-5s%-15s%-15s\n", row);
        }
        System.out.println("-------------------------");

        Object firstColSecRow = matriz[1][2];
        System.out.println(firstColSecRow);

	}
}