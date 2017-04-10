#include <iostream>
#include<pthread.h>
#include <fstream>
using namespace std;
 void* tid(void*);
void quick_sort(int[],int,int);
int partition(int[],int,int);
 
int main()
{
    int a[50],n,i;
for(int m=0; m<=50; m++)
{
a[m]=0;
}
    cout<<"How many elements?";
    cin>>n;
    //cout<<"\nEnter array elements:";
    
    //for(i=0;i<n;i++)
      //  cin>>a[i];
        
	 ifstream File;
    File.open("test.xml");
    for (int i=0; i<=10; i++)
    {
        File >> a[i];
       
    }
for(int k=0; k<=10; k++)
{
cout<<a[k];
}
    File.close();
       pthread_t id=pthread_self();
pthread_t id2=pthread_self();
        pthread_t thread[2];
    quick_sort(a,0,n-1);
pthread_create(&thread[0],NULL,&tid,NULL);
pthread_create(&thread[1],NULL,&tid,NULL);
pthread_join(thread[0],NULL);
    cout<<"thread1: "<<id<<endl;
   cout<<"thread2:" <<id2;
    cout<<"\nArray after sorting:";
    
    for(int j=0;j<n;j++)

       { cout<<a[j]<<" ";
          
        
    }
    return 0;        
}
 
void* tid(void* t)
{
cout<<t;
}

void quick_sort(int a[],int l,int u)
{  
    int j;
    if(l<u)
    { 
        j=partition(a,l,u);
        quick_sort(a,l,j-1);
        quick_sort(a,j+1,u);

    }
}
 
int partition(int a[],int l,int u)
{
    int v,i,j,temp;
    v=a[l];
    i=l;
    j=u+1;
    
    do
    {
        do
            i++;
            
        while(a[i]<v&&i<=u);
        
        do
            j--;
        while(v<a[j]);
        
        if(i<j)
        {
            temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }while(i<j);
    
    a[l]=a[j];
    a[j]=v;
    
    return(j);
}
