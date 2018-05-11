package co.uk.lingzone.datasource.perlin.dto;

public class DataValues {
    private Double xVal = 0.00;
    private Double yVal = 0.00;
    private Double zVal = 0.00;

    public DataValues(double x, double y, double z) {
        xVal = x;
        yVal = y;
        zVal = z;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x:").append(xVal).append(", ");
        sb.append("y:").append(yVal).append(", ");
        sb.append("z:").append(zVal).append("\n");

        return sb.toString();
    }

    public Double getxVal() {
        return xVal;
    }

    public void setxVal(Double xVal) {
        this.xVal = xVal;
    }

    public Double getyVal() {
        return yVal;
    }

    public void setyVal(Double yVal) {
        this.yVal = yVal;
    }

    public Double getzVal() {
        return zVal;
    }

    public void setzVal(Double zVal) {
        this.zVal = zVal;
    }

}
