package geom.shape.locksplitting;

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
public class LockSplittingShape implements Shape {
        private int x, y, width, height;
        
    	// TODO: Apply "Lock Splitting" concept here (you may need some final variables here? :)
        
        public LockSplittingShape() {
        	// TODO: Apply "Lock Splitting" concept here
        }
        
        @Override
        public void changePosition() {
        	// TODO: Apply "Lock Splitting" concept here
        }
        
        @Override
        public void changeDimension() {
        	// TODO: Apply "Lock Splitting" concept here
        }
        
        @Override
        public void changePositionAndDimension() {
        	// TODO: Apply "Lock Splitting" concept here
        }

		@Override
		public int getX() {
			return this.x;
		}

		@Override
		public int getY() {
			return this.y;
		}

		@Override
		public int getWidth() {
			return this.width;
		}

		@Override
		public int getHeight() {
			return this.height;
		}

		@Override
		public void setRectangle(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
}
