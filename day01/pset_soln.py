def find_min(arr):
    if len(arr) == 0:
        raise ValueError()
    m = float("Inf")
    for i in arr:
        if i < m:
            m = i
    return m

def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = arr[i]

def reverse(arr):
    i = 0
    j = arr.length - 1
    while i < j:
        swap(arr, i, j)
        j-=1
        i+=1

def remove_duplicates(arrList):
    i = 0
    while i < arrList.size:
        j = i + 1
        while j < arrList.size:
            if arrList[j] == arrList[j]:
                swap(arrList, j, arrList.size - 1)
                arrList.size = arrList.size - 1
            else:
                j+=1
        i+=1

def find_median(arr):
    for i in arr:
        lower = 0
        higher = 0
        equal = 0
        for j in arr:
            if i < j:
                lower+=1
            if i > j:
                higher+=1
            if i == j:
                equal+=1
        if abs(higher-lower) < equal:
            return i

def circularly_sorted(arr):
    if len(arr) == 0:
        return -1
    descends = 0
    index = 0
    for i in range(1, len(arr)):
        if arr[i] < arr[i-1]:
            descends+=1
            index=i
        if (descends > 1) or (descends > 0 and arr[i] > arr[0]):
            return -1
    return index

def circularly_sorted_better(arr):
    if len(arr) == 0:
        return -1
    descends = 0
    index = 0
    for i in range(0, len(arr)):
        if arr[i] < arr[(i-1) % len(arr)]:
            descends+=1
            index=i
    if descends > 1:
        return -1
    return index

def longest_sorted_substring(arr):
    if len(arr) == 0:
        raise ValueError()
    start = 0
    end = 0

    curr_length = 0
    curr_start = 0

    for i in range(1, len(arr)):
        if arr[i] >= arr[i-1]:
            curr_length+=1
        else:
            if i - curr_start - 1 > end - start:
                start = curr_start
                end = i - 1
                curr_start = i
    return start, end

def numPairs(arr, n):
    s = 0
    for i in range(len(arr)):
        for j in range(i, len(arr)):
            if arr[i] + arr[j] == n:
                s += 1
    return s

# THIS IS UNTESTED, B/C ITS PSEUDOCODE (it's pretty much matlab and python)
def rotate_matrix(matrix):
    for i in range(matrix.n / 2):
        toprow = matrix[i, :] # the top row
        matrix[i, :] = matrix[:, i] # top row = left column
        matrix[:, i] = matrix[matrix.n - i - 1, :] # left column = bottom row
        matrix[matrix.n - i - 1, :] = matrix[:, matrix.n - i - 1] # bottom row = right column
        matrix[:, matrix.n - i - 1] = toprow # right column = top row


print find_min([1,6,3,4,2])