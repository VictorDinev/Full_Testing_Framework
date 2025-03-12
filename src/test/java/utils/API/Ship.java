package utils.API;

import java.util.List;

public class Ship {

    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    private String cargoCapacity;
    private String consumables;
    private String hyperdriveRating;
    private String MGLT;
    private String starshipClass;
    private List pilots;
    private List films;

    //Private constructor to prevent from using it instead of builder
    private Ship(ShipsBuilder builder){
        this.name = builder.name;
        this.model = builder.model;
        this.manufacturer = builder.manufacturer;
        this.costInCredits = builder.costInCredits;
        this.length = builder.length;
        this.maxAtmospheringSpeed = builder.maxAtmospheringSpeed;
        this.crew = builder.crew;
        this.passengers = builder.passengers;
        this.cargoCapacity = builder.cargoCapacity;
        this.consumables = builder.consumables;
        this.hyperdriveRating = builder.hyperdriveRating;
        this.MGLT = builder.MGLT;
        this.starshipClass = builder.starshipClass;
        this.pilots = builder.pilots;
        this.films = builder.films;
    }

    // Getters (if needed)

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public String getLength() {
        return length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public String getMGLT() {
        return MGLT;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public List getPilots() {
        return pilots;
    }

    public List getFilms() {
        return films;
    }

    // Static inner Builder class
    public static class ShipsBuilder{

        private String name;
        private String model;
        private String manufacturer;
        private String costInCredits;
        private String length;
        private String maxAtmospheringSpeed;
        private String crew;
        private String passengers;
        private String cargoCapacity;
        private String consumables;
        private String hyperdriveRating;
        private String MGLT;
        private String starshipClass;
        private List pilots;
        private List films;

        public ShipsBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ShipsBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public ShipsBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public ShipsBuilder setCostInCredits(String costInCredits) {
            this.costInCredits = costInCredits;
            return this;
        }

        public ShipsBuilder setLength(String length) {
            this.length = length;
            return this;
        }

        public ShipsBuilder setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
            this.maxAtmospheringSpeed = maxAtmospheringSpeed;
            return this;
        }

        public ShipsBuilder setCrew(String crew) {
            this.crew = crew;
            return this;
        }

        public ShipsBuilder setCargoCapacity(String cargoCapacity) {
            this.cargoCapacity = cargoCapacity;
            return this;
        }

        public ShipsBuilder setPassengers(String passengers) {
            this.passengers = passengers;
            return this;
        }

        public ShipsBuilder setConsumables(String consumables) {
            this.consumables = consumables;
            return this;
        }

        public ShipsBuilder setHyperdriveRating(String hyperdriveRating) {
            this.hyperdriveRating = hyperdriveRating;
            return this;
        }

        public ShipsBuilder setMGLT(String MGLT) {
            this.MGLT = MGLT;
            return this;
        }

        public ShipsBuilder setStarshipClass(String starshipClass) {
            this.starshipClass = starshipClass;
            return this;
        }

        public ShipsBuilder setPilots(List pilots) {
            this.pilots = pilots;
            return this;
        }

        public ShipsBuilder setFilms(List films) {
            this.films = films;
            return this;
        }

        public Ship build(){
            return new Ship(this);
        }
    }
}
