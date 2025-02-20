public class YerbaMate extends Tea {

    private int numPasses;

    public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses) {
        super(name, ounces, price, brewTemp);
        this.numPasses = numPasses;
    }

    public int getNumPasses() {
        return numPasses;
    }

    public void passMate() {
        numPasses++;
        System.out.println("The yerba was passed, it has been passed " + numPasses + " times.");
    }

    public void refill(int ouncesToRefill) {
        setOunces(getOunces() + ouncesToRefill);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        YerbaMate that = (YerbaMate) o;
        return this.getOunces() == that.getOunces() &&
                this.getBrewTemp() == that.getBrewTemp() &&
                this.getNumPasses() == that.getNumPasses() &&
                Double.compare(this.getPrice(), that.getPrice()) == 0 &&
                this.getName().equals(that.getName());
    }

    @Override
    public String toString() {
        return "YerbaMate: " + this.getName() + ", " + this.getOunces() + ", brewed at " + this.getBrewTemp() + ", $" + getPrice() + ", " + this.getNumPasses() + " passes so far.";
    }
}
