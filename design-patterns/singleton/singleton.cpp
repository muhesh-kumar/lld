#include <bits/stdc++.h>
using namespace std;

class TVset {
  static TVset* tv_set_instance;
  
  TVset() {
    cout << "New TV set created\n";
  }

public:
  // shouldn't be cloneable
  TVset(const TVset &other) = delete;
  // shouldn't be assignable
  void operator=(const TVset &other) = delete;

  static TVset* GetInstance() {
    return !tv_set_instance ? tv_set_instance = new TVset() : tv_set_instance;
  }
};

TVset* TVset::tv_set_instance = nullptr;

int32_t main() {

  TVset* tv_set = TVset::GetInstance();
  TVset* tv_set2 = TVset::GetInstance();

  return 0;
}
