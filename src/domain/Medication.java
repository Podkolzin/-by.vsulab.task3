package domain;

import java.util.ArrayList;

public class Medication {
    private String name;
    private String pharm;
    private MedicationGroup medicationGroup;
    private ArrayList<String> analogs = new ArrayList<>();
    private Versions versions;
    private Certificate certificate;
    private Package aPackage;
    private int dosage;
    private int frequencyOfUse;

    public Medication(String name, String pharm, MedicationGroup medicationGroup, ArrayList<String> analogs, Versions versions, Certificate certificate, Package aPackage, int dosage, int frequencyOfUse) {
        this.name = name;
        this.pharm = pharm;
        this.medicationGroup = medicationGroup;
        this.analogs = analogs;
        this.versions = versions;
        this.certificate = certificate;
        this.aPackage = aPackage;
        this.dosage = dosage;
        this.frequencyOfUse = frequencyOfUse;
    }

    public Medication(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public MedicationGroup getMedicationGroup() {
        return medicationGroup;
    }

    public void setMedicationGroup(MedicationGroup medicationGroup) {
        this.medicationGroup = medicationGroup;
    }

    public ArrayList<String> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(ArrayList<String> analogs) {
        this.analogs = analogs;
    }

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public int getFrequencyOfUse() {
        return frequencyOfUse;
    }

    public void setFrequencyOfUse(int frequencyOfUse) {
        this.frequencyOfUse = frequencyOfUse;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(getName()).append('\n');
        builder.append("pharm: ").append(getPharm()).append('\n');
        builder.append("Medication Group: ").append(getMedicationGroup().getName()).append('\n');
        builder.append("Analogs: \n");
        for (String analog : analogs) {
            builder.append('\t').append(analog).append('\n');
        }
        builder.append("Versions: ").append(getVersions().getName()).append('\n');
        builder.append("Certificate: ").append(getCertificate().getNumber()).append(": ").append(getCertificate().getDate()).append(": ").append(getCertificate().getNameOrganization()).append('\n');
        builder.append("Package: ").append(getaPackage().getTypePackage()).append(": ").append(getaPackage().getCountMedication()).append(": ").append(getaPackage().getPrice()).append('\n');
        builder.append("Dosage: ").append(getDosage()).append('\n');
        builder.append("frequencyOfUse: ").append(getFrequencyOfUse()).append('\n');

        return builder.toString();

    }
}
