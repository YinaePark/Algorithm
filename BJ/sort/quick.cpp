#include <iostream>

using namespace std;

void swap(int *arr, int a, int b){
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
}

void quickSort(int *arr, int start, int end){

    // if(start >= end) return;

    
    int pivot = start;
    int left = start+1;
    int right = end;

    while(left <= right){
        
        while(arr[left] < arr[pivot]){ left++; }
        while(arr[right] > arr[pivot]) { right--; }
        
        if(left <= right){
            swap(arr, left, right);
        }
        
    }
    if(start < end){
        swap(arr, right, pivot);
        quickSort(arr, start, right-1);
        quickSort(arr, right+1, end);
    }

    return;

}

int main() {
    int arr[10] = {3,4,2,6,7,0,1,9,8,5};


    quickSort(arr, 0, 9);
    for(int i=0; i<10; i++){
        cout << arr[i] << " ";
    }
    cout << endl;

}

/*
g++ -o quick quick.cpp
./quick
*/