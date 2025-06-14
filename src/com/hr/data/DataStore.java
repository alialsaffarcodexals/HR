package com.hr.data;

import com.hr.model.Company;

import java.io.*;

/**
 * Handles loading and saving of company data.
 */
public class DataStore {
    private static final String DATA_FILE = "company.ser";
    private static final String STARTUP_FILE = "startup.txt";

    public static Company load() {
        File f = new File(DATA_FILE);
        if(f.exists()) {
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                return (Company) ois.readObject();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        Company company = new Company();
        loadStartup(company);
        return company;
    }

    private static void loadStartup(Company company) {
        File f = new File(STARTUP_FILE);
        if(!f.exists()) return;
        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            int depCount = Integer.parseInt(br.readLine().trim());
            for(int i=0;i<depCount;i++) {
                String name = br.readLine();
                String location = br.readLine();
                int empCount = Integer.parseInt(br.readLine().trim());
                var d = company.createDepartment(name, location);
                for(int j=0;j<empCount;j++) {
                    String first = br.readLine();
                    String last = br.readLine();
                    char gender = br.readLine().trim().charAt(0);
                    String addr = br.readLine();
                    int scale = Integer.parseInt(br.readLine().trim());
                    var e = company.createEmployee(first, last, gender, addr, scale);
                    d.addEmployee(e);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(Company company) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(company);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
