package co.uk.lingzone.datasource.perlin.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class DataValues {
//    @JacksonXmlProperty(localName="x")
    private Double xVal = 0.00D;
//    @JacksonXmlProperty(localName="y")
    private Double yVal = 0.00D;
//    @JacksonXmlProperty(localName="z")
    private Double zVal = 0.00D;
    @JacksonXmlProperty(isAttribute= true)
    private Double noiseVal = 0.00D;

    public DataValues(double x, double y, double z, double noise) {
        xVal = x;
        yVal = y;
        zVal = z;
        noiseVal = noise;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x:").append(xVal).append(", ");
        sb.append("y:").append(yVal).append(", ");
        sb.append("z:").append(zVal).append(", ");
        sb.append("n:").append(noiseVal).append("\n");
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

    public Double getNoiseVal() {
        return noiseVal;
    }

    public void setNoiseVal(Double noiseVal) {
        this.noiseVal = noiseVal;
    }

}
