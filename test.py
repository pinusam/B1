http://www.dropboxwiki.com/tips-and-tricks/using-the-official-dropbox-command-line-interface-cli

https://www.digitalocean.com/community/tutorials/how-to-install-dropbox-client-as-a-service-on-ubuntu-14-04  

http://linuxg.net/install-dropbox-on-linux-systems-ubuntu-debian-fedora-and-others/  

cd ~
    curl -Lo dropbox-linux-x86_64.tar.gz https://www.dropbox.com/download?plat=lnx.x86_64

sudo apt-get install curl

sudo mkdir -p /dropbox
sudo tar xzfv dropbox-linux-x86_64.tar.gz --strip 1 -C /dropbox

OR
https://www.dropbox.com/install-linux

cd ~ && wget -O - "https://www.dropbox.com/download?plat=lnx.x86_64" | tar xzf -D

~/.dropbox-dist/dropboxd

cd dropbox
start dropbox
password Pinakini






#Group B: C4 
#!/usr/bin/python

import Tkinter
#import urllib
import os
import sys


def sap2():
        print("Deletting Dir")
        name = raw_input('Enter name of new Directory :')
        os.system("rmdir "+name+"")
        print("Operation Successfully Completed")

def sap3():
        print("Create Directory : ")
        name = raw_input('Enter name of new Directory :')
        os.system("mkdir "+name+"")
        print("Operation Successfully Completed")

def sap5():
        print("Directories are :  : ")
        
        os.system("ls")
        print("Operation Successfully Completed")
        

def sap6():
        print("Directories are :  : ")
        
        os.system("upload /home/dbsl/a.txt /")
        print("Operation Successfully Completed")
        
        

def sap7():
        print("Directories are :  : ")
        
        os.system("download /a.txt /home/dbsl/4316")

        print("Operation Successfully Completed")
	os.system("cat /home/dbsl/4316/a.txt")        

        
def sap4():
        exit(0)

class simpleapp_tk(Tkinter.Tk):
      def __init__(self,parent):
        Tkinter.Tk.__init__(self,parent)
        self.parent = parent
        self.initialize()

      def initialize(self):
        self.grid()
       
        
        button = Tkinter.Button(self,text="Delete",command=sap2)
        button.grid(column=1,row=2)

        button = Tkinter.Button(self,text="Create Directory",command=sap3)
        button.grid(column=1,row=4)
        
        button = Tkinter.Button(self,text="List Directories",command=sap5)
        button.grid(column=1,row=6)
        
        button = Tkinter.Button(self,text="Exit",command=sap4)
        button.grid(column=1,row=8)

	button = Tkinter.Button(self,text="Upload",command=sap6)
        button.grid(column=1,row=10) 
        
        button = Tkinter.Button(self,text="view",command=sap7)
        button.grid(column=1,row=12) 
        
                  
if __name__ == "__main__":
   app = simpleapp_tk(None)
   app.title('CLOUD COMMANDS')
   app.mainloop()










