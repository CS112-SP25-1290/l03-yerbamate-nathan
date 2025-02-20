public class Tea extends CaffeinatedBeverage {

    private int brewTemp;

    public Tea(String name, int ounces, double price, int brewTemp) {
        super(name, ounces, price);
        this.brewTemp = brewTemp;
    }

    public int getBrewTemp() {
        return brewTemp;
    }

    public void setBrewTemp(int brewTemp) {

        if (super.validateNumber(brewTemp, 0)) {
            this.brewTemp = brewTemp;
        } else {
            System.out.println("Please enter a valid brew temp above 0 degrees celsius.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        Tea that = (Tea) o;
        return this.getOunces() == that.getOunces() &&
                this.getBrewTemp() == that.getBrewTemp() &&
                Double.compare(this.getPrice(), that.getPrice()) == 0 &&
                this.getName().equals(that.getName());
    }

    @Override
    public String toString() {
        return "Tea: " + this.getName() + ", " + this.getOunces() + ", brewed at " + this.getBrewTemp() + ", $" + getPrice();
    }

}
