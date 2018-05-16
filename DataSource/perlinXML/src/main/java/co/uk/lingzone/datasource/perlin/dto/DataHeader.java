package co.uk.lingzone.datasource.perlin.dto;

public class DataHeader {
	private String format;
	
	private double xOffset;
	private int    xCount;
	private double xStep;
	
	private double yOffset;
	private int    yCount;
	private double yStep;
	
	private double zOffset;
	private int    zCount;
	private double zStep;
	
	
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("X ").append(xOffset).append(" -> (").append(xCount).append(" x ").append(xStep).append(" ,");
	    sb.append("Y ").append(yOffset).append(" -> (").append(yCount).append(" x ").append(yStep).append(" ,");
	    sb.append("Z ").append(zOffset).append(" -> (").append(zCount).append(" x ").append(zStep).append("\n");
	    
        
	    return sb.toString();
	}



    public String getFormat() {
        return format;
    }



    public void setFormat(String format) {
        this.format = format;
    }



    public double getxOffset() {
        return xOffset;
    }



    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }



    public int getxCount() {
        return xCount;
    }



    public void setxCount(int xCount) {
        this.xCount = xCount;
    }



    public double getxStep() {
        return xStep;
    }



    public void setxStep(double xStep) {
        this.xStep = xStep;
    }



    public double getyOffset() {
        return yOffset;
    }



    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }



    public int getyCount() {
        return yCount;
    }



    public void setyCount(int yCount) {
        this.yCount = yCount;
    }



    public double getyStep() {
        return yStep;
    }



    public void setyStep(double yStep) {
        this.yStep = yStep;
    }



    public double getzOffset() {
        return zOffset;
    }



    public void setzOffset(double zOffset) {
        this.zOffset = zOffset;
    }



    public int getzCount() {
        return zCount;
    }



    public void setzCount(int zCount) {
        this.zCount = zCount;
    }



    public double getzStep() {
        return zStep;
    }



    public void setzStep(double zStep) {
        this.zStep = zStep;
    }
	
	

	
	
	
	
}
