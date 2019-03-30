package comp401sushi;

abstract public class PlateImpl implements Plate {

	private Plate.Color _color;
	private Sushi _contents;
	private double _price;
	
	protected PlateImpl(Sushi contents, double price, Plate.Color color) throws PlatePriceException {
		if ((contents != null) && (contents.getCost() > price)) {
			throw new PlatePriceException();
		}
		_contents = contents;
		_price = price;
		_color = color;
	}

	@Override
	public Sushi getContents() {
		return _contents;
	}

	@Override
	public Sushi removeContents() {
		Sushi prior_contents = _contents;
		_contents = null;
		return prior_contents;
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException("sushi is null");
		}
		if (s.getCost() >= getPrice()) {
			throw new PlatePriceException();
		}
		
		_contents = s;
	}

	@Override
	public boolean hasContents() {
		return _contents != null;
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public Color getColor() {
		return _color;
	}

}
