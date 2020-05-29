public class Quadrado extends Forma
{
	private float side;

	public Quadrado(float side)
	{
		this.side = side;
	}

	public float getSide() { return this.side }
	public void setSide(float s) { this.side = s; }

	public void calculateArea()
	{
		float area = this.side * this.side;
		setArea(area);
	}

	public void calculatePerimeter()
	{
		float perimeter = 4 * this.side;
		setPerimeter(perimeter);
	}
}
