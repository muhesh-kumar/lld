/*
Compile and Run this code: 
g++ -std=c++11 -pthread thread-safe-singleton.cpp 
./a.out
*/

#include <bits/stdc++.h>
using namespace std;

class TVset {
  static TVset* tv_set_instance_;
  static std::mutex mutex_;
  
  TVset() {
    cout << "New TV set created\n";
  }

public:
  // shouldn't be cloneable
  TVset(const TVset &other) = delete;
  // shouldn't be assignable
  void operator=(const TVset &other) = delete;

  static TVset* GetInstance() {
    if (tv_set_instance_ == nullptr) {
      lock_guard<mutex> lock(mutex_);
      if (tv_set_instance_ == nullptr) {
        tv_set_instance_ = new TVset();
      }
    }
    
    return tv_set_instance_;
  }
};

TVset* TVset::tv_set_instance_ = nullptr;
mutex TVset::mutex_;

void thread_function() {
  TVset* tv_set = TVset::GetInstance();
}

int32_t main() {
  vector<thread> threads;
  for (int i = 0; i < 10; i++) {
    threads.emplace_back(thread_function);
  }
  
  for (auto &thread: threads) {
    thread.join();
  }

  return 0;
}
