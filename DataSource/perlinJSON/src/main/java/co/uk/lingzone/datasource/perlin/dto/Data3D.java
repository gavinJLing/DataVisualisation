package co.uk.lingzone.datasource.perlin.dto;

import java.util.ArrayList;

public class Data3D {
	

	private DataHeader header = new DataHeader();
	
    private ArrayList<DataValues> values =new ArrayList<DataValues>();
    
    
  
    public void add(double x, double y , double z, double noise){
        values.add(new DataValues(x, y, z, noise));
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(getHeader().toString());
        for(DataValues valueTupal : values){
            sb.append(valueTupal.toString());
        }  
        return sb.toString();
    }



    public DataHeader getHeader() {
        return header;
    }



    public void setHeader(DataHeader header) {
        this.header = header;
    }



    public ArrayList<DataValues> getValues() {
        return values;
    }



    public void setValues(ArrayList<DataValues> values) {
        this.values = values;
    }
    
}
