#include<iostream>
using namespace std;

class BS
{
public:
int a[10],beg,end,key;

void accept(int end)
{
cout<<"Enter the array";
for(int i=0; i<end; i++)
cin>>a[i];
}

void sort(int a[], int end)
{int temp=0;
for(int j=0; j<end; j++)
{
 for(int k=0; k<(end-1); k++)
  {
    if(a[k]>a[k+1])
{
    temp=a[k];
    a[k]=a[k+1];
    a[k+1]=temp;
}
}
}
}

void search(int a[],int beg, int end,int key)
{
if(beg==end)
{
if(key=a[beg])
cout<<"Element found";
 else
        cout<<"Element not present";
}

else
  {
    int mid=(beg+end)/2;
    if(key=a[mid])
      cout<<"Elt found at position"<<mid;
    else if(key<a[mid])
       search(a,beg,mid-1,key);
    else 
        search(a,mid+1,end,key);
    

}

}



void display()
{
cout<<"The sorted list is";
sort(a,end);
for(int m=0; m<end; m++)
cout<<a[m];
}


};


int main()
{
BS b;
int beg=1,key;
cout<<"Enter no. of elements";
cin>>b.end;
b.accept(b.end);
b.sort(b.a,b.end);
cout<<"Enter element to be searched";
cin>>key;
b.search(b.a,beg,b.end,b.key);
b.display();
}
