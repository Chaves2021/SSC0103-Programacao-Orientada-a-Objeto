public class Circulo
{
	private float radius;
	private final float pi = 3.14;

	public Circulo(float radius)
	{
		this.radius = radius;
	}

	public float getRadius() { return this.radius; }
	public void setRadius(float r) { this.radius = r; }


	public void calculateArea()
	{
		float area = pi * this.radius;
		setArea(area);
	}

	public void calculatePerimeter()
	{
		float perimeter = 2 * pi * this.radius;
		setPerimeter(perimeter);
	}
}
