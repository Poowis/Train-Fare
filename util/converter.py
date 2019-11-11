#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json
fileName = "Airlink"
f = open("tran.txt", "r", encoding="utf8")
tran = {}
for x in f:
    tmp = x.split()
    key = tmp[-1]
    value = "_".join(tmp[:-1]).lower()
    tran[key] = value

# read file
with open(fileName+'.json', 'r', encoding="utf8") as myfile:
    data = myfile.read()

# parse file
obj = json.loads(data)


out = []
for k, v in obj.items():
    tmp = {}
    tmp["start"] = tran[k]
    for i, j in v.items():
        tmp[tran[i]] = j
    out.append(tmp)

with open(fileName+'_new.json', 'w') as outfile:
    json.dump(out, outfile)
