// - mixed(/q/r/board/list/{1}/{pk_id})
// - return json
// { delete : ...
// , insert : ...
// , view : ...
// , list : ...
// , requestParams : ...}

// 진행중

package com.example.co_templates.quests.services;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuestBoardService_pk_id {
    
    public HashMap<String, Object> mixed(Integer pageNumber, Integer pkid, String title, String contents) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", this.list(pageNumber));
        resultMap.put("view", this.view(pkid));
        resultMap.put("delete", this.delete(pkid));
        int insertResult = insert(title, contents);
        resultMap.put("insert", insertResult);
        return resultMap;
    }

    final AtomicInteger pkIdCounter = new AtomicInteger();
    final List<HashMap<String, Object>> boardItems = new CopyOnWriteArrayList<>();

    public QuestBoardService_pk_id() {
        insert("HTML", "웹사이트의 모습을 기술하기 위한 마크업 언어.");
        insert("Python", "컴퓨터 언어의 일종으로 간결하고 생산성 높은 프로그래밍 언어.");
        insert("JAVA", "썬 마이크로시스템즈에서 1995년에 개발한 객체 지향 프로그래밍 언어.");
    }

    public List<HashMap<String, Object>> list(Integer pageNumber) {
        return boardItems;
    }

    public HashMap<String, Object> view(Integer pkId) {
        for (HashMap<String, Object> item : boardItems) {
            if (item.get("PK_ID").equals(pkId)) {
                return item;
            }
        }
        return null;
    }

    public int delete(Integer pkId) {
        for (HashMap<String, Object> item : boardItems) {
            if (item.get("PK_ID").equals(pkId)) {
                boardItems.remove(item);
                return 1;
            }
        }
        return 0;
    }

    public int insert(String title, String contents) {
        int newPkId = pkIdCounter.incrementAndGet();
        HashMap<String, Object> newItem = new HashMap<>();
        newItem.put("PK_ID", newPkId);
        newItem.put("TITLE", title);
        newItem.put("CONTENTS", contents);
        boardItems.add(newItem);
        return newPkId;
    }
}