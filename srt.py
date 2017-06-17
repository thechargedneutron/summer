import os,time,re
path='./The-Chainsmokers-and-Coldplay-Something-Just-Like-This-(Lyric).srt'
srt_file=open(path,'r')
lines=srt_file.readlines()
i=0
timeregex=re.compile(r'(\d\d):(\d\d):(\d\d),(\d\d\d) --> (\d\d):(\d\d):(\d\d),(\d\d\d)')
f=timeregex.search(lines[5])
print(int(f.group(3))-int(f.group(7)))	
#print(f.group())
a=lines[6].find("\r\n")

print(lines[6],a)
#print(f==None)
lines[6]=lines[6][10:lines[6].find("\r\n")]
#print(lines[6],not(lines[6].isalpha()))
print(lines[10])
t=0
s=0

##print(lines[0:10])
while(True):
	if(i>=len(lines)):
		break
	lines[i]=lines[i][0:lines[i].find("\r\n")]
	f=timeregex.search(lines[i])
	if(not(f==None)):
		t=(int(f.group(5))-int(f.group(1)))*60*60+(int(f.group(6))-int(f.group(2)))*60+(int(f.group(7))-int(f.group(3)))+(int(f.group(8))-int(f.group(4)))*0.001	

	if(not((lines[i]).isnumeric()) and ((f==None) and lines[i]is not "" )):
		print(lines[i])
		s=s+t
		
		time.sleep(t)
		os.system('clear')
		t=0
	i+=1

	

print(s)

