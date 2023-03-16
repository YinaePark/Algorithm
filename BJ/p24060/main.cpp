#include <iostream>
#include <vector>

using namespace std;

int cnt = 0;
int kthNum = -1;

void merge(int *arr, int left, int right, int *tmp, int k){
    int i, j, t, mid;
    i = left;
    mid = (left + right) / 2;
    j = mid + 1;
    t = 0;

    while(i <= mid && j <= right){
        if(arr[i] <= arr[j]){
            tmp[t++] = arr[i++];
        }
        else {
            tmp[t++] = arr[j++];
        }
    }
    while(i <= mid){
        tmp[t++] = arr[i++];
    }
    while(j <= right){
        tmp[t++] = arr[j++];
    }
    i = left;
    t = 0;
    while(i <= right){
        arr[i++] = tmp[t++];
        cnt++;
        if(cnt == k){
            kthNum = arr[i-1];
            return;
        } 
    }
}

void mergeSort(int *arr, int left, int right, int *tmp, int k){

    if(left == right){
        return;
    } 
    int mid = (left + right) / 2;
    mergeSort(arr, left, mid, tmp, k);
    mergeSort(arr, mid+1, right, tmp, k);
    merge(arr, left, right, tmp, k);
    
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL); 

    int n, k;
    cin >> n >> k;
    
    int *arr = new int[n];
    int *tmp = new int[n];

    for(int i=0; i<n; i++){
        int num;
        cin >> num;
        arr[i] = num;
    }

    mergeSort(arr, 0, n-1, tmp, k);

    cout << kthNum << endl;

    delete[] arr;
    delete[] tmp;


}
