package com.example.co_templates.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class CommonCodeService {
    public HashMap<String, Object> mixed(Integer pageNumber, Integer pkid){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", this.list(pageNumber));
        resultMap.put("view", this.view(pkid));
        return resultMap;
    }

    public ArrayList<HashMap<String, Object>> list(Integer pageNumber){
        ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
 
        HashMap<String, Object> item = new HashMap<>();
        item.put("PK_ID", 1);
        item.put("FK_ID", 10);
        item.put("NAME", "Excalibur");
        itemList.add(item);
    
        item = new HashMap<>();
        item.put("PK_ID", 2);
        item.put("FK_ID", 20);
        item.put("NAME", "Dragon Sword");
        itemList.add(item);

        return itemList;
    }

    public HashMap<String, Object> view(Integer pkId){
        HashMap<String, Object> itemDetails = new HashMap<>();

        String fkId = "FK_0382";
        String name = "Commons";
        itemDetails.put("PK_ID", pkId);
        itemDetails.put("FK_ID", fkId);
        itemDetails.put("NAME", name);

        return itemDetails;
    }
}