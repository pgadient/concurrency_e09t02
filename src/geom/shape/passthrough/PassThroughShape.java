package geom.shape.passthrough;

import geom.shape.Shape;

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
public class PassThroughShape implements Shape {
        private Position position;
        private Dimension dimension;
        
        public PassThroughShape() {
        	this.position = new Position();
        	this.dimension = new Dimension();
        }
        
        public void changeDimension() {
        }
        
        public void changePosition() {
    		// TODO: Apply "Pass Through" concept here
        }
        
        public void changePositionAndDimension() {
        	// TODO: Apply "Pass Through" concept here
        }
        
        @Override
		public int getX() {
			return position.x();
		}

		@Override
		public int getY() {
			return position.y();
		}

		@Override
		public int getWidth() {
			return dimension.width();
		}

		@Override
		public int getHeight() {
			return dimension.height();
		}

		@Override
		public void setRectangle(int newX, int newY, int newWidth, int newHeight) {
			this.position.x(newX);
			this.position.y(newY);
			this.dimension.width(newWidth);
			this.dimension.height(newHeight);
		}
}
