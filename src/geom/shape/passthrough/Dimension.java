package geom.shape.passthrough;

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
public class Dimension {
        private int width, height;
        
		// TODO: Do we need synchronization for this method?
        public void changeBoth() {
    		// TODO: Apply "Pass Through" concept here
        }
        
		// TODO: Do we need synchronization for this method?
        public void changeOne() {
    		// TODO: Apply "Pass Through" concept here
        }
        
        public int width() {
        	return this.width;
        }
        
        public int height() {
        	return this.height;
        }
        
        public void width(int newValue) {
        	this.width = newValue;
        }
        
        public void height(int newValue) {
        	this.height = newValue;
        }
}
