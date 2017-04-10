/* 
Name : Pooja Girish Mulajkar
Class : BE(B) Batch : BB3
RollNo: 4201
Title:  Using divide and conquer strategy design an efficient class for concurrent quick sort and input data is stored data using XML. Use object oriented software design method and modelio or StarUML tool. Perform efficiency comparison with any 2 software design methods. Use necessary use case diagram and justify its use with help mathematical modeling. Implement design Scala/Python/Java/C++. 
*/


//Program:
1) qs.cpp
#include <iostream>
#include <string>
#include <fstream>
#include <stdlib.h>
#include<sched.h>
#include<vector>
#include<pthread.h>
using namespace std;
int n;
struct args
{
int *A;
int f,l;
};
class Quick
{
public:
void Print(int A[],int n);
void swap(int &a,int &b);
int Pivote(int A[],int f,int l);
};
void Quick::Print(int A[],int n) //printing the array
{
for(int i=0;i<n;i++)
cout<<A[i]<<endl;
}
void Quick::swap(int &a,int &b) //swap the elements
{
int temp=a;
a=b;
b=temp;
}
int Quick::Pivote(int A[],int f,int l)
{
int p=f;
int pElement=A[f];
for(int i=f+1;i<=l;i++)
{
if(A[i]<=pElement)
{
p++;
swap(A[i],A[p]);
}
}
swap(A[p],A[f]);
return p;
}
void* QuickSort(void* Arg)
{
Quick Q;
pthread_t id=pthread_self();
pthread_t thread[2];
args *Ar=(args*)Arg;
int piv;
if(Ar->f < Ar->l)
{
piv=Q.Pivote(Ar->A,Ar->f,Ar->l);
cout<<"thread: "<<id<<" core:"<<sched_getcpu()<<"pivote:"<<Ar->A[piv]<<endl;
args A1;
A1.A=new int(n);
A1.A=Ar->A;
A1.f=Ar->f;
A1.l=piv-1;
args *X=&A1;
int success=pthread_create(&thread[0],NULL,&QuickSort,(void*)X);
args A2;
A2.A=new int(n);
A2.A=Ar->A;
A2.l=Ar->l;
A2.f=piv+1;
args *Y=&A2;
int success1=pthread_create(&thread[1],NULL,&QuickSort,(void*)Y);
pthread_join(thread[0],NULL);
pthread_join(thread[1],NULL);
}
}
int main()
{
Quick Q;
int N=0,n=0;
vector <int> arr;
string line;
ifstream in("demo.xml");
bool begin_tag = false;
bool begin_tag1 = false;
string tmp; // strip whitespaces from the beginning
while (getline(in,line))
{
tmp="";
for (int i = 0; i < line.length(); i++)
{
if (line[i] == ' ' && tmp.size() == 0)
{
}
else
{
tmp += line[i];
}
}
if (tmp == "<Number>")
{
begin_tag1 = true;
continue;
}
else if (tmp == "</Number>")
{
begin_tag1 = false;
}
if (begin_tag1)
{
n++;
N=atoi(tmp.c_str());
arr.push_back(N);//cout<<n<<" "<<N<<endl;
}
}
int Arr[n];
for ( int i = 0; i < arr.size(); i++)
{
//cout << arr[i] << "\n";
Arr[i]=arr[i];
}
cout<<"\nBefore Sorting:\n";
Q.Print(Arr,n);
args a;
a.A=new int[n];
a.A=Arr;
a.f=0;
a.l=n-1;
QuickSort(&a);
cout<<endl;
cout<<"\nAfter Sorting:\n";
Q.Print(Arr,n);
return 0;
}








2)demo.xml

<? xml version="1.0" ?>
<QuickSortInput>
<Numbers>
<Number>
74
</Number>
<Number>
10
</Number>
<Number>
43
</Number>
<Number>
00
</Number>
<Number>
25
</Number>
<Number>
25
</Number>
</Numbers>
</QuickSortInput>



/* Output

[root@localhost ~]# g++ qs.cpp -pthread
[root@localhost ~]# ./a.out

Before Sorting:
74
10
43
0
25
25
thread: 139651812935488 core:2pivote:74
thread: 139651812927232 core:3pivote:25
thread: 139651796141824 core:2pivote:25
thread: 139651779356416 core:1pivote:0


After Sorting:
0
10
25
25
43
74
[root@localhost ~]# 


*/

