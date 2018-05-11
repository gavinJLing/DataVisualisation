package co.uk.lingzone.datasource.perlin.dto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

public class Data3D {
	
    @Autowired
	private DataHeader header;
	
    private ArrayList<DataValues> values =new ArrayList<DataValues>();
    
    
  
    public void add(double x, double y , double z){
        values.add(new DataValues(x, y, z));
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
