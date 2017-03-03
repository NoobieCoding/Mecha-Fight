import java.util.ArrayList;

public class Mecha {
	private double weight, speed, energy;
	ArrayList<Weapon> arms = new ArrayList<Weapon>();
	private String name, code;
	private boolean isDefence = false;

	public Mecha() {
		weight = 0;
		speed = 0;
		energy = 0;
		name = "";
		code = "";
	}

	public Mecha(String code, String name, double weight, double speed, double energy, Weapon[] weaponList) {
		this.name = name;
		this.code = code;
		this.weight = weight;
		this.speed = speed;
		this.energy = energy;
		for (int i = 0; i < weaponList.length; i++) {
			arms.add(weaponList[i]);
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getEnergy() {
		return energy;
	}

	public ArrayList<Weapon> getArms() {
		return arms;
	}

	public void setArms(ArrayList<Weapon> arms) {
		this.arms = arms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setEnergy(double newEnergy) {
		energy = newEnergy;
	}

	public boolean getIsDefence() {
		return isDefence;
	}

	public void attack(String weaponName, Mecha target) {
		double reDamage = 0;
		boolean isFirst = true;
		for (int i = 0; i < arms.size(); i++) {
			if (arms.get(i).getName().equals(weaponName)) {
				reDamage = (arms.get(i)).getDamage();
				if (isFirst) {
					energy -= arms.get(i).getEnergy();
					isFirst = false;
				}
			}
		}
		if (target.getIsDefence()) {
			reDamage /= 2;
		}
		target.setEnergy(target.getEnergy() - reDamage);
		if (target.getEnergy() < 0)
			target.setEnergy(0);
		if (this.energy < 0)
			this.energy = 0;

	}

	public void charge() {
		energy += 300;
	}

	public void defenceEnd() {
		isDefence = false;
	}

	public void defence() {
		isDefence = true;
	}
}