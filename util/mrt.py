
import json
fileName = "mrt"

temp = []
f = open(fileName+".txt", "r", encoding="utf8")
for x in f:
    tmp = {}
    x = " ".join(x.split()[1:])
    l = json.loads(x[1:-1])
    tmp["start"] = l[0][-5:-1]
    tmp["destination"] = l[1][-5:-1]
    tmp["normal"] = int(l[2].replace(' บาท', ''))
    tmp["student"] = int(l[3].replace(' บาท', ''))
    tmp["elder"] = int(l[4].replace(' บาท', ''))
    tmp["kid"] = int(l[5].replace(' บาท', ''))
    tmp["time"] = int(l[6].replace(' นาที', ''))
    tmp["remark"] = ""

    if (tmp["start"][0] == "P" and tmp["destination"][0] == "B"):
        tmp["remark"] = "need to change station at PP16"
    elif (tmp["start"][0] == "B" and tmp["destination"][0] == "P"):
        tmp["remark"] = "need to change station at PP16"
    if (tmp["start"] == tmp["destination"]):
        continue

    if ((tmp["start"] == "BL10" and tmp["destination"] == "PP16") or (tmp["start"] == "PP16" and tmp["destination"] == "BL10")):
        print(tmp)
        continue
    temp.append(tmp)
with open(fileName+'_new.json', 'w') as outfile:
    json.dump(temp, outfile, indent=2)

