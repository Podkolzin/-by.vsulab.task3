package xml;

import domain.Medication;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class MedicationsXmlWriter {
    public void write(List<Medication> medications, String fileName) throws FileNotFoundException, XMLStreamException {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
            writer = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("medications");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.example.org/medications");
            writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/medications medications.xsd");
            for (Medication medication : medications) {
                writer.writeStartElement("medication");
                writer.writeAttribute("id", medication.getIdentity());
                writer.writeStartElement("name");
                writer.writeCharacters(medication.getName());
                writer.writeEndElement();
                writer.writeStartElement("pharm");
                writer.writeCharacters(medication.getPharm());
                writer.writeEndElement();
                writer.writeStartElement("medicationGroup");
                writer.writeCharacters(medication.getMedicationGroup().toString());
                writer.writeEndElement();
                writer.writeStartElement("analogs");
                for (String analog : medication.getAnalogs()) {
                    writer.writeCharacters(analog.toString());
                }
                writer.writeEndElement();
                writer.writeStartElement("versions");
                writer.writeCharacters(medication.getVersions().toString());
                writer.writeEndElement();


                writer.writeStartElement("certificate");
                writer.writeStartElement("number");
                writer.writeCharacters(Integer.toString(medication.getCertificate().getNumber()));
                writer.writeEndElement();
                writer.writeStartElement("date");
                writer.writeCharacters(medication.getCertificate().getDate());
                writer.writeEndElement();
                writer.writeStartElement("nameOrganization");
                writer.writeCharacters(medication.getCertificate().getNameOrganization());
                writer.writeEndElement();
                writer.writeEndElement();

                writer.writeStartElement("aPackage");
                writer.writeStartElement("typePackage");
                writer.writeCharacters(medication.getaPackage().getTypePackage());
                writer.writeEndElement();
                writer.writeStartElement("countMedication");
                writer.writeCharacters(Integer.toString(medication.getaPackage().getCountMedication()));
                writer.writeEndElement();
                writer.writeStartElement("price");
                writer.writeCharacters(Integer.toString(medication.getaPackage().getPrice()));
                writer.writeEndElement();
                writer.writeEndElement();


                writer.writeStartElement("dosage");
                writer.writeCharacters(Integer.toString(medication.getDosage()));
                writer.writeEndElement();
                writer.writeStartElement("frequencyOfUse");
                writer.writeCharacters(Integer.toString(medication.getFrequencyOfUse()));
                writer.writeEndElement();
                writer.writeEndElement();


            }
            writer.writeEndElement();
            writer.writeEndDocument();

        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}