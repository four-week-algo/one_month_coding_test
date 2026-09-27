
// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// 26.09.19

// 기존 풀이
#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>
using namespace std;


vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    // today : "YYYY.MM.DD" 
    // terms: "약관종류 유효기간"
    // privacies: 수집일자 약관종류
    
    // 파기할 개인정보 번호 오름차순 1차원 배열
    unordered_map<string, int> termMap;
    unordered_map<string, vector<int>> privaciesMap;
    unordered_map<string, int> privaciesIndex;
   
    vector<int> td;
   
    
    string key;
    string value;
    int v;
    int pos;
    for (string t : terms) {
        pos = t.find(" ");
        key = t.substr(0,pos);
        value = t.substr(pos);
        pos = value.find("달");
        v = stoi(value.substr(0,pos)); 
        termMap[key] = v;
    }
    
    string date;
    vector<int> pd;
    int count = 1;
    for (string p : privacies) {
        int pos = p.find(" ");
        date = p.substr(0,pos);
        for(int i = 0; i<3;i++){
            int pos = date.find(".");
            pd.push_back(stoi(today.substr(0,pos)));
            today.erase(0, pos + 1);  
        }
        key = p.substr(pos);
        privaciesMap[key] = pd;
        privaciesIndex[key] = count;
        count++;
    }
    
    
    for(int i = 0; i<3;i++){
        int pos = today.find(".");
        td.push_back(stoi(today.substr(0,pos)));
        today.erase(0, pos + 1);  
    }
        
    for(auto& [key, value] : privaciesMap ){
        int term = termMap[key];
        value[1] += term;
        value[2] -= 1;
          if(value[2] <= 0){
            value[2] = 28;
            value[1] -= 1;
          }
        if(value[1]>12){
            value[0]++;
            value[1] -=12;
        }
        
     
        if((td[0] == value[0] && td[1] == value[1] && td[2] < value[2]) ||
        (td[0] == value[0] && td[1] < value[1]) ||
        (td[0] < value[0] ) 
        )
        {
            answer.push_back(privaciesIndex[key]);
        }
   
    }
    
    (answer.begin(), answer.end());
    
    return answer;
}

// 아마도 여기서 키포인트는 일수로의 변환이었던 듯. 
// 정답 코드

// 날짜 문자열("YYYY.MM.DD")을 총 일(day)수로 변환하는 함수
int dateToDays(string date) {
    int year = stoi(date.substr(0, 4));
    int month = stoi(date.substr(5, 2));
    int day = stoi(date.substr(8, 2));
    
    // 모든 달은 28일까지 있다고 가정
    return (year * 12 * 28) + (month * 28) + day;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    unordered_map<char, int> termMap;
    
    // 약관 유효기간을 맵에 저장 (예: 'A' -> 6개월)
    for (string t : terms) {
        char name = t[0];
        int month = stoi(t.substr(2));
        termMap[name] = month;
    }
    
    int todayDays = dateToDays(today);
    
    // 각 개인정보의 유효기간 확인
    for (int i = 0; i < privacies.size(); i++) {
        string date = privacies[i].substr(0, 10);
        char termType = privacies[i][11];
        
        // 수집일의 일 수 + (유효기간 달 * 28일)
        int expireDays = dateToDays(date) + (termMap[termType] * 28);
        
        // 오늘 날짜가 유효기간을 지났거나 같다면 파기 대상
        if (expireDays <= todayDays) {
            answer.push_back(i + 1);
        }
    }
    
    return answer;
}