package com.earthquakeviewer.earthquakes.api;
import org.geojson.*;

import java.net.URL;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ReadJSONFIle {
    ObjectMapper om = new ObjectMapper();

    public void mapToObject(String url) throws Exception{
        Map<String, Object> resultMap = om.readValue(new URL(earthquake-url), new TypeReference<Map<String, Object>>(){
            
        });
        List<Feature> features = om.convertValue(resultMap.get("features"), new TypeReference<List<Feature>>(){
        });

        for(Feature f: features){
            System.out.println(om.writeValueAsString(f));
            Map<String, Object> properties = f.getProperties();
            GeoJsonObject geometry= f.getGeometry();
            if(geometry instanceof Point){
                Point p = (Point) geometry;
                //do something with point
            }else if(geometry instanceof LineString){
                LineString mls = (LineString) geometry;
            }
        } else if(geometry instanceof MultiLineString) {
            MultiLineString mls = (MultiLineString) geometry;
            // ...
        } else if(geometry instanceof MultiPoint) {
            MultiPoint mp = (MultiPoint) geometry;
            // ...
        } else if(geometry instanceof Polygon) {
            Polygon pl = (Polygon) geometry;
            // ...
        } else if(geometry != null) {
            throw new RuntimeException("Unhandled geometry type: " + geometry.getClass().getName());
        }
    }


public static void main(String[] args) throws Exception {
    ReadJSONFIle rjf = new ReadJSONFIle();
    rjf.mapToObject("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
}
}        