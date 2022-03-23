package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class commonMethods {

    public Map<String,Object> parseYanlToMap(String yamlFilePath){
        Map<String,Object> yamlAsMap = new HashMap<>();
        Yaml yaml = new Yaml();
        try{
            yamlAsMap= yaml.load(new FileInputStream(yamlFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  yamlAsMap;
    }
}

