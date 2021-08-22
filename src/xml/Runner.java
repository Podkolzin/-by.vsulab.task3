package xml;


import domain.Medication;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException, XMLStreamException {
        MedicationsXmlValidator medicationsXmlValidator = new MedicationsXmlValidator("medications.xml");
        if (medicationsXmlValidator.vadidate()){
            MedicationsXmlReader medicationsXmlReader = new MedicationsXmlReader();
            List<Medication> medications = medicationsXmlReader.read("medications.xml");
            for (Medication medication: medications){
                System.out.println(medication);
            }

            MedicationsXmlWriter writer = new MedicationsXmlWriter();
            writer.write(medications, "medications-new.xml");
            System.out.println("OK");

        } else {
            System.out.println(medicationsXmlValidator.getError());
        }

    }
}
