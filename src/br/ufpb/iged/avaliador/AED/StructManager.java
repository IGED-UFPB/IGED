<<<<<<< HEAD
package br.ufpb.iged.avaliador.AED;

import br.ufpb.iged.IGEDConst;

public class StructManager {
    StructManagerInstance original;
    StructManagerInstance replica;
    private int mode;
    private StructFactory factory;

    public StructManager() {
        original = new StructManagerInstance();
        replica = new StructManagerInstance();
        factory = StructFactory.getInstance();
        mode = IGEDConst.MODE_BOTH;
    }

    public boolean removeStruct(String id) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                return this.replica.removeStruct(id);
            case IGEDConst.MODE_BOTH:
                this.original.removeStruct(id);
                return this.replica.removeStruct(id);
            case IGEDConst.MODE_STUDENT:
                return this.original.removeStruct(id);
            default:
                return false;
        }
    }

    public void setMode(int m) {
        if (m == IGEDConst.MODE_BOTH || m == IGEDConst.MODE_STUDENT || m == IGEDConst.MODE_PROFESSOR) {
            this.mode = m;
        }
    }

    public void set_LengthStruct(int lengthStruct) {
        this.factory.setLengthStruct(lengthStruct);
    }

    public void createStruct(int type) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.createStruct(type);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.createStruct(type);
                this.replica.createStruct(type);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.createStruct(type);
                break;
            default:
                break;
        }
    }

    public void createReference(String id, int type) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.createReference(id, type);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.createReference(id, type);
                this.replica.createReference(id, type);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.createReference(id, type);
                break;
            default:
                break;
        }
    }

    public void readReference(String id) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.readReference(id);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.readReference(id);
                this.replica.readReference(id);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.readReference(id);
                break;
            default:
                break;
        }
    }

    public void writeReference() {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.writeReference();
                break;
            case IGEDConst.MODE_BOTH:
                this.original.writeReference();
                this.replica.writeReference();
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.writeReference();
                break;
            default:
                break;
        }   
    }

    public void readReferenceField(int field) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.readReferenceField(field);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.readReferenceField(field);
                this.replica.readReferenceField(field);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.readReferenceField(field);
                break;
            default:
                break;
        }       
    }

    public void writeReferenceField(int field) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.writeReferenceField(field);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.writeReferenceField(field);
                this.replica.writeReferenceField(field);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.writeReferenceField(field);
                break;
            default:
                break;
        }
    }

    public void writeReferenceFieldNull(int field) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.writeReferenceFieldNull(field);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.writeReferenceFieldNull(field);
                this.replica.writeReferenceFieldNull(field);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.writeReferenceFieldNull(field);
                break;
            default:
                break;
        }
    }

    public int readInfo() {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                return this.replica.readInfo();
            case IGEDConst.MODE_BOTH:
                this.replica.readInfo();
                return this.original.readInfo();
            case IGEDConst.MODE_STUDENT:
                return this.original.readInfo();
   
            default:
                return Integer.MIN_VALUE;
        }
    }

    public void writeInfo(int value) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.writeInfo(value);
                break;
            case IGEDConst.MODE_BOTH:
                this.replica.writeInfo(value);
                this.original.writeInfo(value);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.writeInfo(value);
                break;
            default:
                break;
        }
    }

    public void setPosVector(int pos) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.setPosVector(pos);
                break;
            case IGEDConst.MODE_BOTH:
                this.replica.setPosVector(pos);
                this.original.setPosVector(pos);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.setPosVector(pos);
                break;
            default:
                break;
        }
    }

    public void insertStruct(String id, Struct s) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.insertStruct(id, s);
                break;
            case IGEDConst.MODE_BOTH:
                this.replica.insertStruct(id, s);
                this.original.insertStruct(id, s);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.insertStruct(id, s);
                break;
            default:
                break;
        }
    }

     public void endCommand() {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.endCommand();
                break;
            case IGEDConst.MODE_BOTH:
                this.replica.endCommand();
                this.original.endCommand();
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.endCommand();
                break;
            default:
                break;
        }
    }
    
    public void clear(){
        original.clear();
        replica.clear();
    }
}
=======
package br.ufpb.iged.avaliador.AED;

import br.ufpb.iged.IGEDConst;

public class StructManager {
    StructManagerInstance original;
    StructManagerInstance replica;
    private int mode;
    private StructFactory factory;

    public StructManager() {
        original = new StructManagerInstance();
        replica = new StructManagerInstance();
        factory = StructFactory.getInstance();
        mode = IGEDConst.MODE_BOTH;
    }

    public boolean removeStruct(String id) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                return this.replica.removeStruct(id);
            case IGEDConst.MODE_BOTH:
                this.original.removeStruct(id);
                return this.replica.removeStruct(id);
            case IGEDConst.MODE_STUDENT:
                return this.original.removeStruct(id);
            default:
                return false;
        }
    }

    public void setMode(int m) {
        if (m == IGEDConst.MODE_BOTH || m == IGEDConst.MODE_STUDENT || m == IGEDConst.MODE_PROFESSOR) {
            this.mode = m;
        }
    }

    public void set_LengthStruct(int lengthStruct) {
        this.factory.setLengthStruct(lengthStruct);
    }

    public void createStruct(int type) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.createStruct(type);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.createStruct(type);
                this.replica.createStruct(type);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.createStruct(type);
                break;
            default:
                break;
        }
    }

    public void createReference(String id, int type) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.createReference(id, type);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.createReference(id, type);
                this.replica.createReference(id, type);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.createReference(id, type);
                break;
            default:
                break;
        }
    }

    public void readReference(String id) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.readReference(id);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.readReference(id);
                this.replica.readReference(id);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.readReference(id);
                break;
            default:
                break;
        }
    }

    public void writeReference() {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.writeReference();
                break;
            case IGEDConst.MODE_BOTH:
                this.original.writeReference();
                this.replica.writeReference();
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.writeReference();
                break;
            default:
                break;
        }   
    }

    public void readReferenceField(int field) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.readReferenceField(field);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.readReferenceField(field);
                this.replica.readReferenceField(field);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.readReferenceField(field);
                break;
            default:
                break;
        }       
    }

    public void writeReferenceField(int field) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.writeReferenceField(field);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.writeReferenceField(field);
                this.replica.writeReferenceField(field);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.writeReferenceField(field);
                break;
            default:
                break;
        }
    }

    public void writeReferenceFieldNull(int field) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.writeReferenceFieldNull(field);
                break;
            case IGEDConst.MODE_BOTH:
                this.original.writeReferenceFieldNull(field);
                this.replica.writeReferenceFieldNull(field);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.writeReferenceFieldNull(field);
                break;
            default:
                break;
        }
    }

    public int readInfo() {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                return this.replica.readInfo();
            case IGEDConst.MODE_BOTH:
                this.replica.readInfo();
                return this.original.readInfo();
            case IGEDConst.MODE_STUDENT:
                return this.original.readInfo();
   
            default:
                return Integer.MIN_VALUE;
        }
    }

    public void writeInfo(int value) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.writeInfo(value);
                break;
            case IGEDConst.MODE_BOTH:
                this.replica.writeInfo(value);
                this.original.writeInfo(value);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.writeInfo(value);
                break;
            default:
                break;
        }
    }

    public void setPosVector(int pos) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.setPosVector(pos);
                break;
            case IGEDConst.MODE_BOTH:
                this.replica.setPosVector(pos);
                this.original.setPosVector(pos);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.setPosVector(pos);
                break;
            default:
                break;
        }
    }

    public void insertStruct(String id, Struct s) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.insertStruct(id, s);
                break;
            case IGEDConst.MODE_BOTH:
                this.replica.insertStruct(id, s);
                this.original.insertStruct(id, s);
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.insertStruct(id, s);
                break;
            default:
                break;
        }
    }

     public void endCommand() {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.replica.endCommand();
                break;
            case IGEDConst.MODE_BOTH:
                this.replica.endCommand();
                this.original.endCommand();
                break;
            case IGEDConst.MODE_STUDENT:
                this.original.endCommand();
                break;
            default:
                break;
        }
    }
    
    public void clear(){
        original.clear();
        replica.clear();
    }
}
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
