#include <iostream>
using namespace std;

int main(){
    int n, a, b, c;
    cin >> n >> n;
    cout << "digraph{" << endl;
    cout << "\trankdir=LR;" << endl;
    for(int i=0;i<n;i++){
        cin >> a >> b >> c;
        cout << "\t" << a << " -> " << b <<  "\t[label=\"" << c << "\" dir=none]"<<  endl;
    }
    cout << "}" << endl;
    return 0;
}