n=input()
for i in n:
    if i >= 'A' and i <= 'Z':
        print(ord(i)-ord('A')+1,end=' ')
    else:
        print(ord(i) - ord('a') + 1, end=' ')
#