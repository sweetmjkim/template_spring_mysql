// - list(/q/r/board/list/{1}) -> json list
// - view(/q/r/board/view/{pk_id}) -> json hashmap
// - delete(/q/r/board/delete/{pk_id}) -> json int
// - insert(/q/r/board/insert/{title}/{contents}) -> json int
// - 컬럼 갯수 3개 : PK_ID, TITLE, CONTENTS

package com.example.co_templates.quests.services;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuestBoardService {

    final AtomicInteger pkIdCounter = new AtomicInteger();
    final List<HashMap<String, Object>> boardItems = new CopyOnWriteArrayList<>();

    public QuestBoardService() {
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

    public HashMap<String, Object> mixed(Integer pageNumber, Integer pkId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mixed'");
    }
}