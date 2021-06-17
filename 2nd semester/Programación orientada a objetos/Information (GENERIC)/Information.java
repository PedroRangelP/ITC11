public class Information<T> {
    private T p;

    public void displayInformation() {
        System.out.println(p);
    }

    public void setData(T p) {
        this.p = p;
    }
}