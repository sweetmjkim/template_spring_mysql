// - mixed(/q/r/board/list/{1}/{pk_id})
// - return json
// { delete : ...
// , insert : ...
// , view : ...
// , list : ...
// , requestParams : ...}

// 진행중

package com.example.co_templates.quests.restapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.co_templates.quests.services.QuestBoardService;

import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class QuestBoardController_pk_id {

    @Autowired QuestBoardService boardService;

    @GetMapping("/q/r/pk_id/mixed/{pageNumber}/{pk_id}")
    public ResponseEntity<HashMap<String, Object>> mixed(@PathVariable("pageNumber") Integer pageNumber,
            @PathVariable("pk_id") Integer pkId) {
        // call service
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap = boardService.mixed(pageNumber, pkId);

        // add request params
        HashMap<String, Object> requestParams = new HashMap<>();
        requestParams.put("pageNumber", pageNumber);
        requestParams.put("pk_id", pkId);
        resultMap.put("requestParams", requestParams);
        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/q/r/pk_id/list/{pageNumber}")
    public ResponseEntity<List<HashMap<String, Object>>> list(@PathVariable Integer pageNumber) {
        List<HashMap<String, Object>> itemList = boardService.list(pageNumber);
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping("/q/r/pk_id/view/{pk_id}")
    public ResponseEntity<HashMap<String, Object>> view(@PathVariable("pk_id") Integer pkId) {
        HashMap<String, Object> itemDetails = boardService.view(pkId);
        return ResponseEntity.ok().body(itemDetails);
    }

    @DeleteMapping("/q/r/pk_id/delete/{pk_id}")
    public ResponseEntity<Integer> delete(@PathVariable("pk_id") Integer pkId) {
        int result = boardService.delete(pkId);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/q/r/pk_id/insert/{title}/{contents}")
    public ResponseEntity<Integer> insert(@PathVariable("title") String title,
            @PathVariable("contents") String contents) {
        int result = boardService.insert(title, contents);
        return ResponseEntity.ok().body(result);
    }

}