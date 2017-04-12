public class NBody {
	public static void main (String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double rads = readRadius(filename);
		Planet[] planet = readPlanets(filename);

		StdDraw.setXscale(-rads, rads);
		StdDraw.setYscale(-rads, rads);
		StdDraw.picture(0, 0, "/images/starfield.jpg");

		//draw planets respectively
		for (int i = 0; i < planet.length; i++) {
			planet[i].draw();
		}
		double time = 0;
		StdAudio.play("/Users/zheyingchen/learn_java/winechen9/proj0/audio/2001.mid");
		while (time != T) {
			double[] xForces = new double[planet.length];
			double[] yForces = new double[planet.length];
			for (int i = 0; i < planet.length; i ++) {
				xForces[i] = planet[i].calcNetForceExertedByX(planet);
				yForces[i] = planet[i].calcNetForceExertedByY(planet);
			}
			for (int j =0;j < planet.length; j++ ) {
				planet[j].update(dt, xForces[j], yForces[j]);
			}
			StdDraw.picture(0,0, "/images/starfield.jpg");
			for (int k = 0; k < planet.length ;k++ ) {
				planet[k].draw();
				}
			StdDraw.show(10);
			time += dt;

			}

		StdOut.printf("%d\n", planet.length);
		StdOut.printf("%.2e\n", rads);
		for (int i = 0; i < planet.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   				planet[i].xxPos, planet[i].yyPos, planet[i].xxVel, planet[i].yyVel, 
   				planet[i].mass, planet[i].imgFileName);	
			}		
			
		}


	


	public static double readRadius(String u) {
		 In in = new In(u);
		 double radius = in.readDouble();
		 radius = in.readDouble();
		 return radius;
	}
	public static Planet[] readPlanets(String u) {
		In in = new In(u);
		int number_of_planets;
		number_of_planets = in.readInt();
		Planet[] planets = new Planet[number_of_planets];
		double radius = in.readDouble();
		for (int i = 0; i < number_of_planets; i++) {
			planets[i] = new Planet(in.readDouble(),in.readDouble(), in.readDouble(), in.readDouble(),
				in.readDouble(), in.readString());

		}
		return planets;
	}

}
