package geom.shape;

/**
 * Geometry Simulation Environment (GSE)
 * November 2017
 * 
 * 
 * @author Pascal Gadient (gadient@inf.unibe.ch) 
 * 
 * SCG University of Bern, Concurrency Course
 * 
 */
public interface Shape {
		
		public int getX();
		public int getY();
		public int getWidth();
		public int getHeight();
		
		public void setRectangle(int x, int y, int width, int height);
	
        public void changePosition();
        
        public void changeDimension();
        
        public void changePositionAndDimension();
}

