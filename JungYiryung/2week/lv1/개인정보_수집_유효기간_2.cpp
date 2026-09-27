
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

int dateToDay(string date){
    int year = stoi(date.substr(0,4));
    int month = stoi(date.substr(5,7));
    int day = stoi(date.substr(8));

    return (year * 12 * 28) + month * 28 + day;
}


vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    unordered_map<char, int> term;
    for(string t: terms){
        char key = t[0];
        int value = stoi(t.substr(2));
        term[key] = value;
    }

    int intToday = dateToDay(today);
    
    for(int index = 0; index < privacies.size(); index++){
        string p = privacies[index];
        int collectDay = dateToDay(p.substr(0,10));
        char key = p[11];
        int duringDay = term.at(key) * 28;
        // off-by-one 문제, 경계값이 두개인 경우. 작은 숫자로 직접 예시들어 계산해보기
        if(collectDay + duringDay <= intToday){
            answer.push_back(index+1);
        }
    }


    return answer;
}