package sklad;

public abstract class Contact {
	private String name;

	public Contact(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}
}
