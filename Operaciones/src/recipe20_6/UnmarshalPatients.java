package recipe20_6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import recipe20_1.Patient;
import recipe20_5.Patients;

/**
 *
 * @author John O'Conner (john@joconner.com)
 */
public class UnmarshalPatients {
    public void run(String xmlFile, String context) throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance(context);
        Unmarshaller u = jc.createUnmarshaller();
    
        FileInputStream fis = new FileInputStream(xmlFile);
        Patients patients = (Patients)u.unmarshal(fis);
        for (Patient p: patients.getPatient()) {
            System.out.printf("ID: %s\n", p.getId());
            System.out.printf("NAME: %s\n", p.getName());
            System.out.printf("DIAGNOSIS: %s\n\n", p.getDiagnosis());
        }
        
        
    }
    
    public static void main(String[] args) {
        if (args.length != 2 ) {
            System.out.printf("Usage: java org.java8recipes.chapter20.recipe20_6.UnmarshalPatients <xmlfile> <context>\n");
            System.exit(1);
        }
        UnmarshalPatients app = new UnmarshalPatients();
        try {
            app.run(args[0], args[1]);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
