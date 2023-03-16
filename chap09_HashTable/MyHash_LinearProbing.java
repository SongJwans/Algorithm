package chap09_HashTable;

public class MyHash_LinearProbing {
    public Slot[] hashTable;

    public MyHash_LinearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress].key != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currAdress = address + 1;
                while (this.hashTable[currAdress] != null) {
                    if (this.hashTable[currAdress].key == key) {
                        return this.hashTable[currAdress].value;
                    } else {
                        currAdress++;
                        if (currAdress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash_LinearProbing mh = new MyHash_LinearProbing(20);
        mh.saveData("DaveLee", "01022223333");
        mh.saveData("fun- coding", "01033334444");
        mh.saveData("David", "01044445555");
        mh.saveData("Dave", "01055556666");
        System.out.println(mh.getData("David"));
    }

}
