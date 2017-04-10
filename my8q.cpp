#include<iostream>
#include<fstream>
#include<vector>
#include<string>
#include<algorithm>


using namespace std;
int ct=0;
class queen
{
public:
int n;

void accept()
{
cout<<"Enter grid no";
cin>>n;
}

bool place(int x[10],int k)
{
for(int i=0;i<k;i++)
{
 if(x[i]==x[k]||i+x[i]==k+x[k]||i-x[i]==k-x[k])
{ return false;
}
}
return true;
}

void nqueen()
{
int x[10];
int k=1;
x[k]=0;

while(k!=0)
{ x[k]++;
  while(!place(x,k) && (x[k]<=n))
 x[k]++;

if(x[k]<=n)
{
  if(k==n)
  {
     ct++;
      cout<<ct<<endl;
      print(x);
      cout<<endl;
   }
  else
   {
     k++;
     x[k]=0;
   }
}
else
  k--;
}
}

void print(int x[])
{char c[10][10];
 for(int i=1; i<=n; i++)
{ 
   for(int j=1; j<=n; j++)
   {
     c[i][j]='_';
}
}

for(int i=1; i<=n; i++)
{
  c[i][x[i]]='Q';
}

for(int i=1; i<=n; i++)
{
 for(int j=1; j<=n; j++)
 {
   cout<<c[i][j]<<"\t";
 }
}
}
};

int main()
{
  queen q;
  q.accept();
  q.nqueen();
  return 0;
}
