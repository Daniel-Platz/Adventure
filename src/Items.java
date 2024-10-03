public class Items {
    private String shortName;
    private String longName;

    public Items(String shortName, String longName){
        this.shortName = shortName;
        this.longName = longName;
    }

    public String getShortName(){
        return shortName;
    }

    public String getLongName(){
        return longName;
    }
}