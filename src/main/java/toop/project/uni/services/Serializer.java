package toop.project.uni.services;

import toop.project.uni.models.University;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    private String fileName;
    private String newUniName;

    public Serializer(String fileName, String newUniName) {
        this.fileName = fileName;
        this.newUniName = newUniName;
    }

    public UniBase getBase() {
        UniBase base;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            base = (UniBase) ois.readObject();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            base = new UniBase(new Authentication(), new University(newUniName));
        }
        return base;
    }

    public boolean serializeData(UniBase obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
            oos.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
}
