#include<iostream>
#include<fstream>
#include<pthread.h>

using namespace std;

void quick(int [],int,int);
int partition(int [],int,int);
void*tid (void*);


int main()
{
  int a[10],n;
cout<<"How many elts";
cin>>n;
 
  for(int i=0; i<10; i++)
 {
    a[i]=0;
}


ifstream file;

file.open("test.xml");

for(int m=0; m<10; m++)
{
  file >> a[m];
}

file.close();

quick(a,0,n-1);
cout<<"the sorted array is:";
for(int z=0; z<n; z++)
{
   cout<<a[z];
}

return 0;
}

 
void quick(int a[],int l,int u)
{int j;
   
  if(l<u)
{
  j=partition(a,l,u);
  quick(a,l,j-1);
  quick(a,j+1,u);
}
}

int partition(int a[],int l,int u)
{int v,j,i,temp;
 
 v=a[l];
i=l;
j=u+1;


do
{
   do
     i++;
   while(a[i]<v && i<=u);

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

a[j]=a[j];
a[j]=v;
return(j);
}
      
