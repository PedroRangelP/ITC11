public class Demo {
    public static void main(String[] args) {
        MoralPerson mp = new MoralPerson();
        mp.setBirthDate("29/11/2012");
        mp.setCompanyName("Instituto Tecnológico Estudios Superiores Monterrey");
        String mRFC = mp.calculateRFC();
        System.out.println("--Moral Person--\nRFC: " + mRFC);

        PhysicalPerson pp = new PhysicalPerson();
        pp.setBirthDate("05/10/1999");
        pp.getData("Pedro", "Rangel", "Palacios", "DF", "H");
        String pRFC = pp.calculateRFC();
        System.out.println("--Physical Person--\nRFC: " + pRFC);
        String pCURP = pp.calculateCURP();
        System.out.println("CURP: " + pCURP);
    }
}