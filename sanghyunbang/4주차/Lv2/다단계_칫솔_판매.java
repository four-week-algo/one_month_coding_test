// https://school.programmers.co.kr/learn/courses/30/lessons/77486
import java.util.*;

class Solution {
    class Node {
        int id;
        int earning;
        int parentId = -1;
        
        Node (int id, int earning, int parentId) {
            this.id = id;
            this.earning = earning;
            this.parentId = parentId;
        }
        
        // parent가 없는 경우
        Node (int id, int earning) {
            this.id = id;
            this.earning = earning;
        }
        
        // 내가 돈을 버는 경우
        public void earn(int val) {
            earning += val;
        }
        
        public int getTot() {
            return earning;
        }
        
    }
    
    public Map<String, Integer> nameAndIds = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int n = enroll.length;
        
        // 1. nameAndIds 채우기
        for (int i = 0; i < n; i++) {
            nameAndIds.put(enroll[i], i);
        }
        
        // 2. Node 만들어서 담아놓기 : 순서는 enroll순서대로 담음
        List<Node> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            int id = i;
            int earning = 0; 
            if (referral[i].equals("-")) {
                Node node = new Node(id, earning);
                list.add(node);
            } else {
                int parentId = nameAndIds.get(referral[i]);
                Node node = new Node(id, earning, parentId);
                list.add(node);
            }
        }
        
        // 2. seller에 따라서 나의 earning 및 dividend 전파하기
        int m = seller.length;
        for (int i = 0; i < m; i++) {
            String name = seller[i];
            int meId = nameAndIds.get(name);
            Node me = list.get(meId);
            
            int base = amount[i] * 100;
            int toParent = 1; // 시작을 위해 0보다 큰 1 넣기
            
            while(toParent > 0) {
                // 부모한테 줄 몫 계산
                toParent = (int) (base * 0.1);
                
                // 내 몫은 부모한테 줄 몫 - 내 몫
                int earning = base - toParent;
                me.earn(earning);
                
                // 만약 센터가 부모면 부모한테 내고 끝
                if (me.parentId == -1) {
                    // 만일 내가 루트면 부모는 센터
                    break;
                } 
                // me도 부모로 올라감
                me = list.get(me.parentId);

                // 이제 base가 toParent로 업데이트
                base = toParent;
            }
        }
        
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            Node node = list.get(i);
            answer[i] = node.getTot();
        }
        
        return answer;
    }
    
}
