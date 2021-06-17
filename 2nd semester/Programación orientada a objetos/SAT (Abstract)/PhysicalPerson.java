public class PhysicalPerson extends Person implements IKey {
    private String name;
    private String paternalLastName;
    private String maternalLastName;
    private String cityCode;
    private String gender;
    private String rfc;

    public void getData(String name, String paternalLastName, String maternalLastName, String cityCode, String gender) {
        this.name = name;
        this.paternalLastName = paternalLastName;
        this.maternalLastName = maternalLastName;
        this.cityCode = cityCode;
        this.gender = gender;
    }

    public String calculateRFC() {
        String rfc = "";
        //Fisrt two letters of the paternal surname
        rfc += paternalLastName.toUpperCase().substring(0, 2);
        //First letter of the maternal surname
        rfc += maternalLastName.charAt(0);
        //Fisrt letter of the first name
        rfc += name.charAt(0);
        //Last two digits of the year of registration
        rfc += year.substring(2);
        //Two digits of the month of registration
        rfc += month;
        //Two digits registration day
        rfc += day;

        this.rfc = rfc;

        return rfc;
    }

    public String calculateCURP() {
        String curp = "";
        char paternalConsonant = ' ', maternalChar = ' ';
        String maternalConsonants = "";
        String randomDigits = "";
        int i, random;
        //RFC without virification  code
        curp += rfc;
        //Gender
        curp += gender;
        //Two-letter code of the state
        curp += cityCode;
        //Next consonant of the paternal surname
        for (i=1; i<paternalLastName.length(); i++) {
            paternalConsonant = paternalLastName.toUpperCase().charAt(i);
            if (isConsonat(paternalConsonant))
                break;
        }
        curp += paternalConsonant;
        //Two consonants of the maternal surname
        for (i = 1; i < maternalLastName.length(); i++) {
            maternalChar = maternalLastName.toUpperCase().charAt(i);
            if (isConsonat(maternalChar))
                maternalConsonants += maternalChar;
            if (maternalConsonants.length() == 2)
                break;
        }
        curp += maternalConsonants;
        //Two random digits
        while (randomDigits.length() < 2) {
            random = (int) (Math.random() * 10 + 1);
            randomDigits += random;
        }
        curp += randomDigits;
        
        return curp;
    }

    public boolean isConsonat(char l) {
        if (l=='A' || l=='E' || l=='I' || l== 'O' || l=='U')
            return false;
        else
            return true;
    }
}