public class CaffeinatedBeverage
{
    private String name;
    private int ounces;
    private double price;

    public CaffeinatedBeverage(String name, int ounces, double price) {
        this.name = name;
        this.ounces = ounces;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOunces() {
        return this.ounces;
    }

    public void setOunces(int ounces) {
        if(validateNumber(ounces, 0)) {
            this.ounces = ounces;
        } else {
            System.out.println("Ounces must be greater than 0.");
        }
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if(validateNumber(price, 0)) {
            this.price = price;
        } else {
            System.out.println("Price must be greater than $0.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        CaffeinatedBeverage that = (CaffeinatedBeverage) o;
        return this.ounces == that.ounces &&
                Double.compare(this.price, that.price) == 0 &&
               this.name.equals(that.name);
    }

    public boolean validateNumber(double valueToCheck, int limit) {
        return valueToCheck >= limit;
    }

    public boolean sip(int ouncesToSip) {
        if(ouncesToSip - ounces >= 0) {
            setOunces(ounces - ouncesToSip);
            return true;
        } else {
            setOunces(0);
            return false;
        }
    }

    public String toString() {
        return "Caffeinated Beverage: " + this.getName() + ", " + this.getOunces() + ", $" + getPrice();
    }
}