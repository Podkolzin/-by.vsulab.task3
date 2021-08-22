package domain;

public class Certificate {
    private int number;
    private String date;
    private String nameOrganization;

    public Certificate(int number, String date, String nameOrganization) {
        this.number = number;
        this.date = date;
        this.nameOrganization = nameOrganization;
    }

    public Certificate() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "number=" + number +
                ", date='" + date + '\'' +
                ", nameOrganization='" + nameOrganization + '\'' +
                '}';
    }
}
