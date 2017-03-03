
public class Weapon {
	String name;
	double damage, energy;

	public Weapon(String name, double damage, double energy) {
		this.name = name;
		this.damage = damage;
		this.energy = energy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

}
