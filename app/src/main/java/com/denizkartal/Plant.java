
public class Plant{
    private int plantID;
    private String plantName;

    Plant(int plantID, String plantName){
        this.plantID = plantID;
        this.plantName = plantName;
    }

    public int getPlantID(){
        return this.plantID;
    }
    public String getPlantName(){
        return this.plantName;
    }
    // addPlant() adds this plant into database
    public void addPlant(){
        // call the addToDB() from DatabaseManager class
    }
    // deletePlant() deletes this plant from the DatabaseManager class
    public void deletePlant(){
        // call the deleteFromDB() from DatabaseManager class
    }
}