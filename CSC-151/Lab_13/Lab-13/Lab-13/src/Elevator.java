class Elevator extends Room {

	int currentFloor;

	public Elevator(int area) {
		super(area);
	}

	public void up(int up) {
		currentFloor += up;
	}

	public void down(int down) {
		if (down >= currentFloor)
			currentFloor = 1;
		else currentFloor -= down;
	}

	@Override
	public String toString() {
		return super.toString() + " currentFloor=" + currentFloor;
	}

}