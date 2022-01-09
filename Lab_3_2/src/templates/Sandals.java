package templates;

abstract public class Sandals implements Shoes, SObject {
    protected int size;
    protected String manufacturer;
    protected String color;
    protected int brandID;
    private boolean openness;//true - сильно

    abstract public void printInfo();
}
