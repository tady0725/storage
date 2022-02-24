# read && create  dic
f=open("C:\\Users\\CJCU-CC\\Desktop\\單字詞_13053(注音_無聲調).dic","r",encoding="utf-8")
all_phoneme={}
for word in f.readlines():
    word=word.replace("\n", "")
    s=word.split(",")
    if len(s)>1:
        if s[0] not in  all_phoneme:
            all_phoneme[s[0]]=list()
            for i in s[1]:
                all_phoneme[s[0]].append(i)
            
            
print(all_phoneme)
'''
# count phoneme && sort count
count_phoneme={}
f2=open("C:\\Users\\CJCU-CC\\Desktop\\GigaWord_text_lm","r",encoding="utf-8")
for word in f2.readlines():
    for t in word:
        if t=="":
            continue
        else:
            if t in all_phoneme.keys():
                print(t)
    break
            

        
'''    
    
