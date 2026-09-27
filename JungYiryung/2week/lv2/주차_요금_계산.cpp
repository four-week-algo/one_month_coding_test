// 내 풀이 
#include <string>
#include <vector>
#include <cmath>
#include <unordered_map>
using namespace std;

int calMinute(string time){
    int hour = stoi(time.substr(0,2));
    int minute = stoi(time.substr(3));
    
    return hour * 60 + minute;
}

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    
    // 차량번호는 그냥 숫자로 바꾸면 되고
    // 시각도 분 기준으로 바꿈. 
    
    int baseTime = fees[0];
    int baseFee = fees[1];
    int unitTime= fees[2];
    int unitFee = fees[3];
    
    unordered_map<int, vector<int>> content;
    
    for(string r: records){
        int carNum  = stoi(r.substr(6,10));
        
        if(!content.contains(carNum)){
            vector<int> t;
            content[carNum] = t;
        }else{
            vector<int> i = content[carNum];
            i.push_back(calMinute(r.substr(0,5)));
        }
        
    }
    
    unordered_map<int, int> parkingTime;
    
    for(const auto& [key, value] : content){
       int all =0;
        for(int i = 0 ; i<value.size(); i++){
            if(i/2 == 1){
                all += value[i] - value[i-1];
            }
            if(value.size()/2 ==1 && i+1 == value.size()){
                all += calMinute("23:59") - value[i] ;
            }
        }
        
        parkingTime[key] = all;
    }
    
    for(const auto& [key, value] : parkingTime){
        if(value < baseTime){
            answer.push_back(baseFee);
        }else{
            answer.push_back(baseFee + ceil((value - baseTime) / unitTime ) * unitFee);
        }
    }
    
    return answer;
}

// 통과 풀이

#include <string>
#include <vector>
#include <cmath>
#include <unordered_map>
#include <map>
using namespace std;

int calMinute(string time){
    int hour = stoi(time.substr(0,2));
    int minute = stoi(time.substr(3));

    return hour * 60 + minute;
}

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;

    // 차량번호는 그냥 숫자로 바꾸면 되고
    // 시각도 분 기준으로 바꿈. 

    int baseTime = fees[0];
    int baseFee = fees[1];
    int unitTime= fees[2];
    int unitFee = fees[3];

    unordered_map<int, vector<int>> content;

    for(string r: records){
        int carNum  = stoi(r.substr(6,10));

        vector<int>& i = content[carNum];
        i.push_back(calMinute(r.substr(0,5)));
    }

    map<int, int> parkingTime;

    for(const auto& [key, value] : content){
       int all =0;
        for(int i = 0 ; i<value.size(); i++){
            if(i%2 == 1){
                all += value[i] - value[i-1];
            }
            if(value.size()%2 ==1 && i+1 == value.size()){
                all += calMinute("23:59") - value[i] ;
            }
        }

        parkingTime[key] = all;
    }

    for(const auto& [key, value] : parkingTime){
        if(value <= baseTime){
            answer.push_back(baseFee);
        }else{
            answer.push_back(baseFee + ceil((double)(value - baseTime) / unitTime ) * unitFee);
        }
    }

    return answer;
}