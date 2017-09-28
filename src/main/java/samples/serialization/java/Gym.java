package samples.serialization.java;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * We need to implement {@link Serializable} if we want to use
 * {@link ObjectInputStream} and {@link ObjectOutputStream}.
 * It's just a little marker that those classes require; it does nothing, actually.
 */
public class Gym implements Serializable {

	private String name;
	private boolean visible;
	private double price;

	public Gym(String name, double price) {
		this.name = name;
		this.price = price;
		this.visible = true;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
