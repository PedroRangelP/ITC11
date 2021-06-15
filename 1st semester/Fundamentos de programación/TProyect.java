public class TProyect{
	public static void main(String[] args){
		String[] keywords = pruebaArray();
		for (int i=0; i<keywords.length; i++) {
			System.out.println(keywords[i]);
		}	
	}

	public static String[] pruebaArray() {
		String[] arrayRetorno = {"a", "b", "c"};
		return arrayRetorno;
	}
}

