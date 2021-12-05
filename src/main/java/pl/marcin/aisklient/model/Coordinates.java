package pl.marcin.aisklient.model;

public class Coordinates {

        private String name;
        private double latitudeMIN;
        private double latitudeMAX;
        private double longitudeMIN;
        private double longitudeMAX;


        public Coordinates(){
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates(double latitudeMIN, double latitudeMAX, double longitudeMIN, double longitudeMAX) {
            this.latitudeMIN = latitudeMIN;
            this.latitudeMAX = latitudeMAX;
            this.longitudeMIN = longitudeMIN;
            this.longitudeMAX = longitudeMAX;
        }

        public double getLatitudeMAX() {
            return latitudeMAX;
        }

        public void setLatitudeMAX(double latitudeMAX) {
            this.latitudeMAX = latitudeMAX;
        }

        public double getLongitudeMIN() {
            return longitudeMIN;
        }

        public void setLongitudeMIN(double longitudeMIN) {
            this.longitudeMIN = longitudeMIN;
        }

        public double getLongitudeMAX() {
            return longitudeMAX;
        }

        public void setLongitudeMAX(double longitudeMAX) {
            this.longitudeMAX = longitudeMAX;
        }

        public double getLatitudeMIN() {
            return latitudeMIN;
        }

        public void setLatitudeMIN(double latitudeMIN) {
            this.latitudeMIN = latitudeMIN;
        }
}
