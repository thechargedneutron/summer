import os,time,re
path='./The-Chainsmokers-and-Coldplay-Something-Just-Like-This-(Lyric).srt'
path='Eminem-Rap-God-(Explicit).srt'
srt_file=open(path,'r')              #reading file line by line in a list
lines=srt_file.readlines()
i=0
timeregex=re.compile(r'(\d\d):(\d\d):(\d\d),(\d\d\d) --> (\d\d):(\d\d):(\d\d),(\d\d\d)')  #making the regex to find the time stamp
t=0       #t stores diff btw start and end time  
str=""
k=0 #k stores diff btw end time of ith and start of i+1th

while(i<len(lines)): #loop upto end of list
	lines[i]=lines[i][0:lines[i].find("\n")]
	f=timeregex.search(lines[i])
	if(not(f==None)):          #on finding time stamp line
		
		t=(int(f.group(5))-int(f.group(1)))*60*60+(int(f.group(6))-int(f.group(2)))*60+(int(f.group(7))-int(f.group(3)))+(int(f.group(8))-int(f.group(4)))*0.001	
		time_end_of_i=int(f.group(5))*60*60+int(f.group(6))*60+int(f.group(7))+int(f.group(8))*0.001
		time_start_of_i=int(f.group(1))*60*60+int(f.group(2))*60+int(f.group(3))+int(f.group(4))*0.001
		time.sleep(time_start_of_i-k)
		k=time_end_of_i
				
	if(not((lines[i]).isnumeric()) and ((f==None) and lines[i]is not "" )):     #on finding subtitle it stores all the lines
		str+=lines[i]+" "
		
	if(lines[i]==""):       #prints the subtitle 
		os.system('clear')
		print(str)	
		time.sleep(t)
		str=""
			
	i=i+1
	
	


