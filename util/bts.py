import json
fileName = "bts"

index = []
f = open(fileName+"-test.txt", "r", encoding="utf8")
for x in f:
    index.append(x.strip())

normal = []
f = open("bts-normal copy.txt", "r", encoding="utf8")
for x in f:
    normal.append(json.loads("["+x.strip().replace(" ", ", ")+"]"))

f = open(fileName+".txt", "r", encoding="utf8")
temp = []
for x in f:
    tmp = {}
    l = json.loads(x.strip())
    del l[2:4]
    tmp["start"] = l[0].split()[0][1:-1]
    tmp["destination"] = l[1].split()[0][1:-1]
    tmp["normal"] = int(l[2].replace(' บาท', ''))
    tmp["rabbit-normal"] = int(l[3].replace(' บาท', ''))
    tmp["rabbit-student"] = int(l[4].replace(' บาท', ''))
    tmp["rabbit-elder"] = int(l[5].replace(' บาท', ''))
    tmp["time"] = int(l[6].replace(' นาที', '')[1:])
    tmp["remark"] = ""

    if ((tmp["start"][0] in "WS" and tmp["destination"][0] in "EN") or (tmp["start"][0] in "EN" and tmp["destination"][0] in "WS")):
        tmp["remark"] = "need to change station at CEN"
    temp.append(tmp)
    if tmp["normal"] != normal[index.index(tmp["start"])][index.index(tmp["destination"])]:
        print(tmp)

with open(fileName+'_new.json', 'w') as outfile:
    json.dump(temp, outfile, indent=2)
