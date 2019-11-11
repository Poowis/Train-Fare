#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json
fileName = "realTran"

f = open(fileName+".txt", "r", encoding="utf8")
tran = []
for x in f:
    temp = {}
    tmp = x.split()
    temp["TH"] = tmp[-1]
    temp["ENG"] = " ".join(tmp[1:-1])
    temp["station"] = tmp[0]
    if tmp[0][0] == "A":
        temp["line"] = "ARL"
    elif tmp[0][0] == "B":
        temp["line"] = "MRT_BL"
    elif tmp[0][0] == "P":
        temp["line"] = "MRT_PP"
    elif tmp[0][0] == "S" or tmp[0][0] == "W":
        temp["line"] = "BTS_G"
    elif tmp[0][0] == "N" or tmp[0][0] == "E":
        temp["line"] = "BTS_LG"
    elif tmp[0][0] == "C":
        temp["line"] = "BTS_LG"
        tran.append(temp)
        temp["line"] = "BTS_G"


    tran.append(temp)

with open(fileName+'_new.json', 'w') as outfile:
    json.dump(tran, outfile, indent=4, sort_keys=True)
