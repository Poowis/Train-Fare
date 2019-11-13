
import json
fileName = "mrt"

n = 4
f = open(fileName+".txt", "r", encoding="utf8")
for line in f:
    words = [line[i:i+n] for i in range(0, len(line), n)]
    # words[0] = "\u"+words[0]

    print(words)

print("\u22dc")