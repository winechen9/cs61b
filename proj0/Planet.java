public class Planet {
	public static final double g = 6.67E-11;
	String path="/images/";
	double netforce_x;
	double netforce_y;
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
//first constructor
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = path + img;
			
		}

//second constructor
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
//methods to calc the force between two planets and returns F_x, F_y
	public double calcDistance(Planet p) {
		double dist;
		dist = Math.sqrt(Math.pow((p.xxPos - this.xxPos), 2) + Math.pow((p.yyPos- this.yyPos),2));
		return dist;
	}
	public double calcForceExertedBy(Planet p) {
		double force;
		force = (g * this.mass * p.mass) / (calcDistance(p) * calcDistance(p));
		return force;
	}

	public double calcForceExertedByX(Planet p) {
		double force_x;
		force_x = calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
		return force_x;
	}
 	public double calcForceExertedByY(Planet p) {
 		double force_y;
 		force_y = calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
 		return force_y;
 	}
	public double calcNetForceExertedByX (Planet[] p) {
		double netforce_x = 0;
		for (int i= 0; i < p.length; i++) {
			if (this.equals(p[i]))
				{continue;} else {
				netforce_x = netforce_x + this.calcForceExertedByX(p[i]);	
				}	
		}
		
		return netforce_x;
	}
	public double calcNetForceExertedByY (Planet[] p) {
		double netforce_y = 0;
		for (int i= 0; i < p.length; i++) {
			if (this.equals(p[i]))
				{continue;} else {
				netforce_y = netforce_y + this.calcForceExertedByY(p[i]);
			}
		}
		return netforce_y;
	}
	public void update(double dt,double fX,double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel += dt * aX;
		this.yyVel += dt * aY;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, imgFileName);
	}
}




