public class Room {
	private int nroom, eroom, sroom, wroom;
	private String name, desc;
	
	public Room() {
		this.nroom = -1;
		this.eroom = -1;
		this.sroom = -1;
		this.wroom = -1;
		this.name = "";
		this.desc = "";
	}
	
	/**
	 * Constructor with full parameters, for a room you already know everything about.
	 * 
	 * @param nroom
	 * @param eroom
	 * @param sroom
	 * @param wroom
	 * @param name
	 * @param desc
	 */
	public Room(int nroom, int eroom, int sroom, int wroom, String name, String desc) {
		this.nroom = nroom;
		this.eroom = eroom;
		this.sroom = sroom;
		this.wroom = wroom;
		this.name = name;
		this.desc = desc;
	}

	public int getNroom() {
		return nroom;
	}

	public int getEroom() {
		return eroom;
	}

	public int getSroom() {
		return sroom;
	}

	public int getWroom() {
		return wroom;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public void setNroom(int nroom) {
		this.nroom = nroom;
	}

	public void setEroom(int eroom) {
		this.eroom = eroom;
	}

	public void setSroom(int sroom) {
		this.sroom = sroom;
	}

	public void setWroom(int wroom) {
		this.wroom = wroom;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}