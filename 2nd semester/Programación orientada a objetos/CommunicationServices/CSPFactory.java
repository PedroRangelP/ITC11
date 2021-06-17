public class CSPFactory { 
    public CSP createATT(double usedMb, int channels) {
        CSP att = new CSP();
        att.name = "AT&T";
    
        InternetConnection ic = new InternetConnection();
        ic.basePrice = 40;
        ic.baseMb = 50;
        ic.costPerMb = 2;
        ic.usedMb = usedMb;
        att.addService(ic);
    
        PaidTV tv = new PaidTV();
        tv.basePrice = 40;
        tv.costPerChannel = 10;
        tv.channels = channels;
        att.addService(tv);
        
        TelephoneFixedCost tel = new TelephoneFixedCost();
        tel.basePrice = 20;
        att.addService(tel);
        return att;
    }

    public CSP createAxtel(String media, double usedMb) {
        CSP axtel = new CSP();
        axtel.name = "Axtel";
    
        InternetConnection ic = new InternetConnection();
        if (media.toLowerCase().equals("optic fiber")) {
            ic.basePrice = 350;
            ic.baseMb = 20;
            ic.costPerMb = 1;
            ic.usedMb = usedMb;
            axtel.addService(ic);
        }else if (media.toLowerCase().equals("satellite")){
            ic.basePrice = 5000;
            ic.baseMb = 10;
            ic.costPerMb = 10;
            ic.usedMb = usedMb;
            axtel.addService(ic);
        }
        
        TelephoneFixedCost tel = new TelephoneFixedCost();
        tel.basePrice = 20;
        axtel.addService(tel);
        return axtel;   
    }

    public CSP createInfinitum(int calls, double usedMb, int cellMins) {
        CSP infinitum = new CSP();
        infinitum.name = "Infinitum";
    
        InternetConnection ic = new InternetConnection();
        ic.basePrice = 200;
        ic.baseMb = 10;
        ic.costPerMb = 10;
        ic.usedMb = usedMb;
        infinitum.addService(ic);
        
        CellTelephoneCall cel = new CellTelephoneCall();
        cel.costPerMinute = 1;
        cel.minutes = cellMins;
        infinitum.addService(cel);

        TelephonePerCall tel = new TelephonePerCall();
        tel.costPerCall = 1;
        tel.calls = calls;
        infinitum.addService(tel);
        return infinitum;
    }
}