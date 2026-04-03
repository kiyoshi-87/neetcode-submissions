static class Singleton {
    private static Singleton thisInstance = null;
    private String value;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (thisInstance == null) {
            thisInstance = new Singleton();
        }

        return thisInstance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
