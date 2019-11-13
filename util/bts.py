import json
fileName = "bts"

f = open(fileName+".txt", "r", encoding="utf8")
temp = []
for x in f:
    tmp = {}
    l = json.loads(x.strip())
    del l[2:4]
    tmp["start"] = l[0].split()[0][1:-1]
    tmp["destination"] = l[1].split()[0][1:-1]
    tmp["price"] = int(l[2].replace(' บาท', ''))
    tmp["time"] = int(l[3].replace(' นาที', '')[1:])
    tmp["remark"] = ""

    if ((tmp["start"][0] in "WS" and tmp["destination"][0] in "EN") or (tmp["start"][0] in "EN" and tmp["destination"][0] in "WS")):
        tmp["remark"] = "need to change station at CEN"
    temp.append(tmp)
#     if (l[2] == price and l[3] == time):
#         print(tmp)
#         print(x)
#         print("________________________________")
#         count += 1
#     tmp = x
#     price = l[2]
#     time = l[3]
# print(count)

with open(fileName+'_new.json', 'w') as outfile:
    json.dump(temp, outfile, indent=2)

