class Stack():
    def __init__(self, l=[]):
    	l.reverse()
    	self.l = l
    def push(self, elem):
        self.l.append(elem)
    def pop(self):
    	return self.l.pop()
    def peek(self):
    	return self.l[-1]
    def __len__(self):
    	return len(self.l)
    def __str__(self):
    	tmp = list(self.l)
    	tmp.reverse()
    	return str(tmp)

def num_palindrome(i):
	j = i
	stack = Stack()
	while j != 0:
		stack.push(j%10)
		j/=10
	while len(stack)>0:
		if stack.pop() != i%10:
			return False
		i/=10
	return True

def valid_expr(s):
	stack = Stack()
	for c in s:
		if len(stack) == 0 or c == '(':
			stack.push(c)
		elif c == ')' and stack.peek() == '(':
			stack.pop()
		else:
			stack.push(c)

def is_pop_sequence(s1, s2):
	s3 = Stack()
	while len(s1) > 0:
		s3.push(s1.pop())
		while len(s3) > 0 and s3.peek() == s2.peek():
			s3.pop()
			s2.pop()
	return len(s3) == 0

def sorted_stack_lst(stack):
	arrList = []
	while len(stack) > 0:
		elem = stack.pop()
		i = 0
		while i < len(arrList) and elem >= arrList[i]:
			i+=1
		arrList.insert(i, elem)
	return arrList

def sorted_stack(stack):
	sorted_stack = Stack()
	while len(stack) > 0:
		print sorted_stack
		var = stack.pop()
		while len(sorted_stack) > 0 and sorted_stack.peek() < var:
			stack.push(sorted_stack.pop())
		sorted_stack.push(var)
	return sorted_stack
