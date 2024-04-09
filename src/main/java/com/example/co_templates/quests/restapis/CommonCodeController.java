// - List(/commonCode/list/{1}) -> json list
// - view(/commonCode/view/{pk_id}/{fk_id}/{name}) -> json hashmap
// - 컬럼 갯수 3개 : PK_ID, FK_ID, NAME

package com.example.co_templates.quests.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CommonCodeController {
    @GetMapping("/commonCode/view/{pk_id}/{fk_id}/{name}")
    public ResponseEntity<Object> commonCode(@PathVariable String pk_id, @PathVariable String fk_id, @PathVariable String name) {
        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        return ResponseEntity.ok().body(arrayList);
    }
    
}
