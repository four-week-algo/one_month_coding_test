
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;

    for(vector<int> turn : commands){
        int i = turn[0]-1; // 1
        int j = turn[1]; // 5
        int k = turn[2]-1; // 2

        vector<int> sliced(array.begin() + i, array.begin() + j);
        sort(sliced.begin(), sliced.end());

        answer.push_back(sliced[k]);
    }

    return answer;
}
