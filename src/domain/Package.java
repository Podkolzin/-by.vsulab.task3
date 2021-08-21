package domain;

public class Package {
    private String typePackage;
    private int countMedication;
    private int price;

    public Package(String typePackage, int countMedication, int price) {
        this.typePackage = typePackage;
        this.countMedication = countMedication;
        this.price = price;
    }

    public String getTypePackage() {
        return typePackage;
    }

    public void setTypePackage(String typePackage) {
        this.typePackage = typePackage;
    }

    public int getCountMedication() {
        return countMedication;
    }

    public void setCountMedication(int countMedication) {
        this.countMedication = countMedication;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Package{" +
                "typePackage='" + typePackage + '\'' +
                ", countMedication=" + countMedication +
                ", price=" + price +
                '}';
    }
}
