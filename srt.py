import os,time,re
path='./The-Chainsmokers-and-Coldplay-Something-Just-Like-This-(Lyric).srt'
#path='Eminem-Rap-God-(Explicit).srt'
srt_file=open(path,'r')
lines=srt_file.readlines()
i=0
timeregex=re.compile(r'(\d\d):(\d\d):(\d\d),(\d\d\d) --> (\d\d):(\d\d):(\d\d),(\d\d\d)')
	
inn=timeregex.search(lines[1])
print(int(inn.group(1))*60*60+int(inn.group(2))*60+int(inn.group(3))+int(inn.group(4))*0.001)
time.sleep(int(inn.group(1))*60*60+int(inn.group(2))*60+int(inn.group(3))+int(inn.group(4))*0.001)
t=0
s=0
k=0
##print(lines[0:10])
while(True):
	if(i>=len(lines)):
		break
	lines[i]=lines[i][0:lines[i].find("\r\n")]
	f=timeregex.search(lines[i])
	#inn=timeregex.search(lines[i+1])

	if(not(f==None)):
		t=(int(f.group(5))-int(f.group(1)))*60*60+(int(f.group(6))-int(f.group(2)))*60+(int(f.group(7))-int(f.group(3)))+(int(f.group(8))-int(f.group(4)))*0.001	
		time_end_of_i=int(f.group(5))*60*60+int(f.group(6))*60+int(f.group(7))+int(f.group(8))*0.001
		time_start_of_i=int(f.group(1))*60*60+int(f.group(2))*60+int(f.group(3))+int(f.group(4))*0.001
		time.sleep(time_start_of_i-k)
		k=time_end_of_i

		
		
	if(not((lines[i]).isnumeric()) and ((f==None) and lines[i]is not "" )):
		print(lines[i],t)
		s=s+t
		
		time.sleep(t)
		os.system('clear')
		t=0
	i+=1

	

print(s)

