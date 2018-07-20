package ash.com.graph;

public class PhoneBuilder {
	private String phoneName;
	private String phoneModel;
	private int ram;
	private float processor;
	
	public PhoneBuilder() {}
	
	public PhoneBuilder setPhoneName(String phoneName) {
		this.phoneName = phoneName;
		return this;
	}
	
	public PhoneBuilder setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
		return this;
	}
	
	public PhoneBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}
	
	public PhoneBuilder setProcessor(float processor) {
		this.processor = processor;
		return this;
	}

	public PhoneBuilder(String phoneName, String phoneModel, int ram,
			float processor) {
		this.phoneName = phoneName;
		this.phoneModel = phoneModel;
		this.ram = ram;
		this.processor = processor;
	}
	
	@Override
	public String toString() {
		return "phone name : " + this.phoneName + "\n" +
				"phone model : " + this.phoneModel + "\n" + 
				"ram: " + this.ram + "\n";
	}
}
