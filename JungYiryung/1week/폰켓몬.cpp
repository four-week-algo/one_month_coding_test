// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// 26.09.15

// 내가 푼 것 
#include <vector>
#include <unordered_set>
using namespace std;

 void m (int insert, int n,vector<int> nums ,int recursiveCount, int* countP){
  
        unordered_set<int> s;
        for(int i = insert; i<n ; i++){
            s.insert(nums[i]);
            recursiveCount--;
            insert++;
            if(recursiveCount>0 && insert < n){
                m(insert,n,  nums, recursiveCount, countP);
            }
            if(*countP < s.size()){
                *countP = s.size();
            }
            s.clear();
        }
    }

int solution(vector<int> nums)
{
    int n = nums.size() / 2;
   
    int recursiveCount = n;
    int count = 0;
    m(0,n, nums, recursiveCount, &count);
   
    return count;
}

// 다시 푼 것
 
int solution2(vector<int> nums)
{
    int n = nums.size() / 2;
    unordered_set<int> s;

    for(int i = 0; i<nums.size() ; i++){
        s.insert(nums[i]);
    }

    if(n < s.size()){
        return n;
    }else{
        return s.size();
    }

}

// N=10000 인데 조합탐색 시도 -> 코드짜기 전에 제한사항 확인하여 알고리즘 정하기 
// 답이 개수만 요구함 -> 답이 무엇으로 결정되는지 보기