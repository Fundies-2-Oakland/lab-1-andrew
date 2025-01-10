/**
 * Lab 1
 * Vector3D.java
 * get vectored bruh hehehehehehe
 * @author Andrew Chen
 * @since 1/9/25 
 */
 
public class Vector3D {
	
	private double x, y, z; //instance variables
	
	//constructor
	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static void main(String[] args) {
		Vector3D v1 = new Vector3D(1.323,2.569,3.425);
		Vector3D v2 = new Vector3D(4.142,5.322,6.999);
		
		System.out.println("Constructor/toString() method test:");
		System.out.println("Vector 1: " + v1);
		System.out.println("Vector 2: " + v2);
		
		System.out.println("\nx/y/z getter method test:");
		System.out.println("Vector 1 coordinates - " + "x: " + v1.getX() + " y: " + v1.getY() + " z: " + v1.getZ());
		System.out.println("Vector 2 coordinates - " + "x: " + v1.getX() + " y: " + v1.getY() + " z: " + v1.getZ());
	}
	
	//toString method
	public String toString() {
		return "(" + String.format("%.2f",getX()) + ", " + String.format("%.2f",getY()) + 
		", " + String.format("%.2f",getZ()) + ")";
	}
	
	/**
	 * Finds the magnitude of this vector
	 * @return the magnitude of this vector
	 */
	public double getMagnitude(Vector3D vector) {
		return Math.sqrt(Math.pow(vector.x,2) + Math.pow(vector.y,2) + Math.pow(vector.z,2));
	}
	
	/**
	 * Finds the sum of this vector added to another vector
	 * @param otherVector the other vector
	 * @return a new vector consisting of this vector added to another vector
	 */
	public Vector3D add(Vector3D otherVector) {
		return new Vector3D(this.x + otherVector.x, this.y + otherVector.y, this.z + otherVector.z);
	}
	
	/**
	 * Normalizes this vector
	 * @return a new vector representing this vector normalized 
	 */
	public Vector3D normalize() {
		double mag = getMagnitude(this);
		if(Double.compare(mag,0.0) == 0) {
			throw new IllegalStateException("Error: Magnitude cannot equal zero!");
		} else {
			return new Vector3D(this.x / mag, this.y / mag, this.z / mag);
		}
	}
	
	/**
	 * Multiplies this vector by a constant value
	 * @param constant a value to multiply the x/y/z coordinates of the vector by
	 * @return a new vector representing the multiplication
	 */
	public Vector3D multiply(double constant) {
		return new Vector3D(this.x * constant, this.y * constant, this.z * constant);
	}
	
	/**
	 * Finds the dot product between this vector and another vector
	 * @param otherVector the other vector 
	 * @return the dot product between this vector and otherVector
	 */
	public double dotProduct(Vector3D otherVector) {
		return this.x * otherVector.x + this.y * otherVector.y + this.z * otherVector.z;
	}
	
	/**
	 * Finds the angle between this vector and another vector
	 * @param otherVector the other vector 
	 * @return the angle between this vector and otherVector
	 */
	public double angleBetween(Vector3D otherVector) {
		double dotProduct = dotProduct(otherVector);
		double mag1 = getMagnitude(otherVector);
		double mag2 = getMagnitude(otherVector);
		double magProduct = mag1 * mag2;
		
		if(Double.compare(magProduct,0.0) == 0) {
			throw new IllegalStateException("Error: Product of the vectors' magnitudes cannot equal zero!");
		} else {
			return Math.acos(dotProduct / magProduct);
		}
	}
	
	/**
	 * Finds the cross product between this vector and another vector
	 * @param otherVector the other vector 
	 * @return a new vector of the cross product between this vector and otherVector
	 */
	public Vector3D crossProduct(Vector3D otherVector) { 
		/*
		 * uv  { i, j, k} -> unit vector
		 * a = {x1,y1,z1} -> this vector
		 * b = {x2,y2,z2} -> other vector
		 * 
		 * det1 = y1,z1,y2,z2
		 * det2 = x1,z1,x2,z2
		 * det3 = x1,y1,x2,y2
		 * i * det1 - j * det2 + k * det3
		 */	
		double det1 = getDeterminant(this.y, this.z, otherVector.y, otherVector.z);
		double det2 = getDeterminant(this.x, this.z, otherVector.x, otherVector.z);
		double det3 = getDeterminant(this.x, this.y, otherVector.x, otherVector.y);
		
		return new Vector3D(det1, -det2, det3);
	}
	
	//helper method for crossProduct method
	//returns the determinant of a 2x2 matrix
	public double getDeterminant(double a, double b, double c, double d) {
		return (a * d) - (b * c);
	}
	
	//getter methods for x/y/z coordinates of the vector
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	public double getZ() { return this.z; }
}

