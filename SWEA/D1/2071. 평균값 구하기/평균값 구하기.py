T = int(input())

for test_case in range(1, T+1):
    arr = list(map(int, input().split()))
    sum = 0
    for i in range(len(arr)):
        sum+=arr[i]
    print("#" + str(test_case) + " " + str(round(sum/10)))