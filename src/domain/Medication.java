package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Medication implements Comparator<Medication> {



    private String identity;
    private String name;
    private String pharm;
    private MedicationGroup medicationGroup;
    private List<String> analogs = new ArrayList<>();
    private Versions versions;
    private Certificate certificate;
    private Package aPackage;
    private int dosage;
    private int frequencyOfUse;

    public Medication(String identity, String name, String pharm, MedicationGroup medicationGroup, List<String> analogs, Versions versions, Certificate certificate, Package aPackage, int dosage, int frequencyOfUse) {
        this.identity = identity;
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

    public Medication() {
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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

    public List<String> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(List<String> analogs) {
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

    public Integer getFrequencyOfUse() {
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

    public boolean equals (Medication medication){
        return (this == medication);
    }

        public int compare(Medication o1, Medication o2) {
            return o1.getFrequencyOfUse().compareTo(o2.getFrequencyOfUse());
        }




}
