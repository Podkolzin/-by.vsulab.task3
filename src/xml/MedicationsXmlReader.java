package xml;

import domain.Package;
import domain.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MedicationsXmlReader {
    public List<Medication> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try {
            List<Medication> medicationList = new ArrayList<>();
            Medication medication = null;
            Certificate certificate = null;
            Package aPackage = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("medication".equals(tagName)) {
                            medication = new Medication();
                            certificate = new Certificate();
                            aPackage = new Package();
                            medication.setIdentity(reader.getAttributeValue(null, "id"));
                        } else if ("name".equals(tagName)) {
                            medication.setName(reader.getElementText());
                        } else if ("pharm".equals(tagName)) {
                            medication.setPharm(reader.getElementText());
                        } else if ("medicationGroup".equals(tagName)) {
                            medication.setMedicationGroup(MedicationGroup.valueOf(reader.getElementText()));
                        } else if ("analogs".equals(tagName)) {
                            List<String> analogs = new ArrayList<>();
                            analogs.add(reader.getElementText());
                            medication.setAnalogs(analogs);
                        } else if ("versions".equals(tagName)) {
                            medication.setVersions(Versions.valueOf(reader.getElementText()));
                        } else if ("certificate".equals(tagName)) {

                        } else if ("number".equals(tagName)) {
                            certificate.setNumber(Integer.parseInt(reader.getElementText()));
                        } else if ("date".equals(tagName)) {
                            certificate.setDate(reader.getElementText());
                        } else if ("nameOrganization".equals(tagName)) {
                            certificate.setNameOrganization(reader.getElementText());
                            medication.setCertificate(certificate);
                        } else if ("typePackage".equals(tagName)) {
                            aPackage.setTypePackage(reader.getElementText());
                        } else if ("countMedication".equals(tagName)) {
                            aPackage.setCountMedication(Integer.parseInt(reader.getElementText()));
                        } else if ("price".equals(tagName)) {
                            aPackage.setPrice(Integer.parseInt(reader.getElementText()));
                            medication.setaPackage(aPackage);
                        }

//                             if ("number".equals(tagName)) {
//                                certificate.setNumber(Integer.parseInt(reader.getElementText()));
//                            } else if ("date".equals(tagName)) {
//                                certificate.setDate(reader.getElementText());
//                            } else if ("nameOrganization".equals(tagName)) {
//                                certificate.setNameOrganization(reader.getElementText());
//                            }
//                            medication.setCertificate(certificate);
//                        } else if ("aPackage".equals(tagName)) {
//                            Package aPackage = new Package();
//                            if ("typePackage".equals(tagName)) {
//                                aPackage.setTypePackage(reader.getElementText());
//                            } else if ("countMedication".equals(tagName)) {
//                                aPackage.setPrice(Integer.parseInt(reader.getElementText()));
//                            } else if ("price".equals(tagName)) {
//                                aPackage.setPrice(Integer.parseInt(reader.getElementText()));
//                            }
//                            medication.setaPackage(aPackage);
                        else if ("dosage".equals(tagName)) {
                            medication.setDosage(Integer.parseInt(reader.getElementText()));
                        } else if ("frequencyOfUse".equals(tagName)) {
                            medication.setFrequencyOfUse(Integer.parseInt(reader.getElementText()));
                        }
                        break;
                    }

                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("medication".equals(tagName)) {
                            medicationList.add(medication);
                        }
                        break;
                    }
                }
            }
            return medicationList;
        } catch (XMLStreamException e) {
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }
}
