public class Retangulo extends Forma
{
	private float side0;
	private float side1;

	public Retangulo(float side0, float side1)
	{
		this.side0 = side0;
		this.side1 = side1;
	}

	public float getSide0() { return this.side0 }
	public void setSide0(float s0) { this.side0 = s0; }

	public float getSide1() { return this.side1 }
	public void setSide0(float s1) { this.side1 = s1; }


	public void calculateArea()
	{
		float area = this.side0 * this.side1;
		setArea(area);
	}

	public void calculatePerimeter()
	{
		float perimeter = 2 * this.side0 + 2 * this.side1;
		setPerimeter(perimeter);
	}
}
