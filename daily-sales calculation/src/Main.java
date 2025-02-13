import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Abstract class representing a Sellable item
abstract class Phonesold {
    protected String itemName;
    protected double price;

    public Phonesold(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public abstract double calculateTotal();

    public String getItemName() {
        return itemName;
    }
}

// Concrete class for selling phones
class PhoneSale extends Phonesold {
    private int quantity;

    public PhoneSale(double price, int quantity) {
        super("Phone", price);
        this.quantity = quantity;
    }

    @Override
    public double calculateTotal() {
        return price * quantity;
    }
}

// Concrete class for repair services
class RepairService extends Phonesold {
    private int hours;

    public RepairService(double pricePerHour, int hours) {
        super("Repair", pricePerHour);
        this.hours = hours;
    }

    @Override
    public double calculateTotal() {
        return price * hours;
    }
}
// test