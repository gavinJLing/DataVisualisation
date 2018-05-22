package co.uk.lingzone.datasource.perlin.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="feed", namespace="http://foo")
public class Data3D {

    @JacksonXmlProperty(localName="metaData", namespace="http://header")
	private DataHeader header = new DataHeader();


	@JacksonXmlElementWrapper(localName = "dataItems", useWrapping=true)
    private ArrayList<DataValues> data =new ArrayList<DataValues>();


    public void add(double x, double y , double z, double noise){
        data.add(new DataValues(x, y, z, noise));
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getHeader().toString());
        for(DataValues valueTupal : data){
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



    public ArrayList<DataValues> getData() {
        return data;
    }



    public void setData(ArrayList<DataValues> data) {
        this.data = data;
    }



}
