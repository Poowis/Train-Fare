import json
fileName = "arl"

with open('realTran_new.json') as json_file:
    data = json.load(json_file)


def tran(text):
    for i in data:
        if i["ENG"].lower() == text.lower():
            return i["station"]


f = open(fileName+".txt", "r", encoding="utf8")
temp = []
for x in f:
    tmp = {}
    l = json.loads(x.strip())
    tmp["start"] = tran(l[0])
    tmp["destination"] = tran(l[1])
    tmp["normal"] = int(l[2].replace(' Baht', ''))
    tmp["time"] = int(l[3].replace(' Minute', ''))
    tmp["remark"] = ""
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

