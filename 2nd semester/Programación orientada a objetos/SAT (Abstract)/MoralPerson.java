public class MoralPerson extends Person {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String calculateRFC() {
        String rfc = "";
        //Fisrt letter of each of the fisrt 3 words of its social domination
        String[] words = companyName.split(" ");
        for (int i=0; i<3 && i<words.length; i++)
            rfc += words[i].charAt(0);

        //Last two digits of the year of registration
        rfc += year.substring(2);
        //Two digits of the month of registration
        rfc += month;
        //Two digits registration day
        rfc += day;

        return rfc;
    }
}